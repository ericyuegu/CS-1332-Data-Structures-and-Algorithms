import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test cases for BST.
 *
 * @version 1.0
 * @author Derek Weiler
 */
public class DerekBSTTests {
    private BSTInterface<Integer> bst;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        bst = new BST<>();
    }

    @Test (timeout = TIMEOUT)
    public void testAdd() {
        assertEquals(0, bst.size());

        bst.add(12);
        bst.add(6);
        bst.add(3);
        bst.add(18);
        bst.add(21);
        bst.add(15);
        bst.add(9);

        assertEquals(7, bst.size());
        assertEquals((Integer) 12, bst.getRoot().getData());
        assertEquals((Integer) 6, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 3, bst.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 9, bst.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 18, bst.getRoot().getRight().getData());
        assertEquals((Integer) 15, bst.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 21, bst.getRoot().getRight().getRight().getData());

        //adding duplicates

        bst.add(12);
        bst.add(6);
        bst.add(3);
        bst.add(18);
        bst.add(21);
        bst.add(15);
        bst.add(9);

        assertEquals(7, bst.size());
        assertEquals((Integer) 12, bst.getRoot().getData());
        assertEquals((Integer) 6, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 3, bst.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 9, bst.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 18, bst.getRoot().getRight().getData());
        assertEquals((Integer) 15, bst.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 21, bst.getRoot().getRight().getRight().getData());
    }

    @Test (timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddNull() {
        bst.add(null);
    }

    @Test (timeout = TIMEOUT)
    public void testCreateFromCollection() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21};
        bst= new BST<>(Arrays.asList(collection));

        assertEquals(7, bst.size());
        assertEquals((Integer) 12, bst.getRoot().getData());
        assertEquals((Integer) 6, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 3, bst.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 9, bst.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 18, bst.getRoot().getRight().getData());
        assertEquals((Integer) 15, bst.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 21, bst.getRoot().getRight().getRight().getData());
    }

    @Test (timeout = TIMEOUT)
    public void testRemove() {
        assertEquals(0, bst.size());

        //balanced
        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));

        assertEquals(15, bst.size());
        Integer[] expLevelOrder = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        assertEquals(Arrays.asList(expLevelOrder), bst.levelorder());

        //no children
        assertEquals((Integer) 2, bst.remove(2));
        assertEquals(14, bst.size());
        Integer[] expLevelOrder2 = {12, 6, 18, 3, 9, 15, 21, 4, 8, 10, 14, 16, 20, 22};
        assertEquals(Arrays.asList(expLevelOrder2), bst.levelorder());

        //one child (from right)
        assertEquals((Integer) 3, bst.remove(3));
        assertEquals(13, bst.size());
        Integer[] expLevelOrder3 = {12, 6, 18, 4, 9, 15, 21, 8, 10, 14, 16, 20, 22};
        assertEquals(Arrays.asList(expLevelOrder3), bst.levelorder());

        //two children (from left)
        assertEquals((Integer) 15, bst.remove(15));
        assertEquals(12, bst.size());
        Integer[] expLevelOrder4 = {12, 6, 18, 4, 9, 14, 21, 8, 10, 16, 20, 22};
        assertEquals(Arrays.asList(expLevelOrder4), bst.levelorder());

        //two+ children
        assertEquals((Integer) 18, bst.remove(18));
        assertEquals(11, bst.size());
        Integer[] expLevelOrder5 = {12, 6, 16, 4, 9, 14, 21, 8, 10, 20, 22};
        assertEquals(Arrays.asList(expLevelOrder5), bst.levelorder());

        //root
        assertEquals((Integer) 12, bst.remove(12));
        assertEquals(10, bst.size());
        Integer[] expLevelOrder6 = {10, 6, 16, 4, 9, 14, 21, 8, 20, 22};
        assertEquals(Arrays.asList(expLevelOrder6), bst.levelorder());


        //unbalanced
        Integer[] collection2 = {9, 10, 8, 3, 2, 4, 11, 1, 0, 7, 6, 5, 13, 12, 14};
        bst= new BST<>(Arrays.asList(collection2));

        assertEquals(15, bst.size());
        Integer[] exp2LevelOrder = {9, 8, 10, 3, 11, 2, 4, 13, 1, 7, 12, 14, 0, 6, 5};
        assertEquals(Arrays.asList(exp2LevelOrder), bst.levelorder());

        //no child (from left)
        assertEquals((Integer) 0, bst.remove(0));
        assertEquals(14, bst.size());
        Integer[] exp2LevelOrder2 = {9, 8, 10, 3, 11, 2, 4, 13, 1, 7, 12, 14, 6, 5};
        assertEquals(Arrays.asList(exp2LevelOrder2), bst.levelorder());

        //one child (from left)
        assertEquals((Integer) 2, bst.remove(2));
        assertEquals(13, bst.size());
        Integer[] exp2LevelOrder3 = {9, 8, 10, 3, 11, 1, 4, 13, 7, 12, 14, 6, 5};
        assertEquals(Arrays.asList(exp2LevelOrder3), bst.levelorder());

        //two children (from right)
        assertEquals((Integer) 13, bst.remove(13));
        assertEquals(12, bst.size());
        Integer[] exp2LevelOrder4 = {9, 8, 10, 3, 11, 1, 4, 12, 7, 14, 6, 5};
        assertEquals(Arrays.asList(exp2LevelOrder4), bst.levelorder());

        //root that has predecessor with left child
        assertEquals((Integer) 9, bst.remove(9));
        assertEquals(11, bst.size());
        Integer[] exp2LevelOrder5 = {8, 3, 10, 1, 4, 11, 7, 12, 6, 14, 5};
        assertEquals(Arrays.asList(exp2LevelOrder5), bst.levelorder());

        //root that has deeper predecessor with left child
        assertEquals((Integer) 8, bst.remove(8));
        assertEquals(10, bst.size());
        Integer[] exp2LevelOrder6 = {7, 3, 10, 1, 4, 11, 6, 12, 5, 14};
        assertEquals(Arrays.asList(exp2LevelOrder6), bst.levelorder());
    }

    @Test (timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveNull() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        bst.remove(null);
    }

    @Test (timeout = TIMEOUT, expected = java.util.NoSuchElementException.class)
    public void testRemoveUnknown() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        bst.remove(99);
    }

    @Test (timeout = TIMEOUT)
    public void testGet() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        for (Integer i: collection) {
            assertEquals(i, bst.get(i));
        }
    }

    @Test (timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testGetNull() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        bst.get(null);
    }

    @Test (timeout = TIMEOUT, expected = java.util.NoSuchElementException.class)
    public void testGetUnknown() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        bst.get(99);
    }

    @Test (timeout = TIMEOUT)
    public void testContains() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        for (Integer i: collection) {
            assertEquals(true, bst.contains(i));
        }
        assertEquals(false, bst.contains(0));
        assertEquals(false, bst.contains(100));
        assertEquals(false, bst.contains(-1));
        assertEquals(false, bst.contains(-6));
    }

    @Test (timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testContainsNull() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        bst.contains(null);
    }

    @Test (timeout = TIMEOUT)
    public void testPreorder() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        Integer[] expected = {12, 6, 3, 2, 4, 9, 8, 10, 18, 15, 14, 16, 21, 20, 22};
        assertEquals(Arrays.asList(expected), bst.preorder());
    }

    @Test (timeout = TIMEOUT)
    public void testPostorder() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        Integer[] expected = {2, 4, 3, 8, 10, 9, 6, 14, 16, 15, 20, 22, 21, 18, 12};
        assertEquals(Arrays.asList(expected), bst.postorder());
    }

    @Test (timeout = TIMEOUT)
    public void testInorder() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        Integer[] expected = {2, 3, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22};
        assertEquals(Arrays.asList(expected), bst.inorder());
    }

    @Test (timeout = TIMEOUT)
    public void testLevelorder() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 18, 6, 3, 9, 21, 15, 2, 8, 4, 14, 10, 16, 22, 20};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        Integer[] expected = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        assertEquals(Arrays.asList(expected), bst.levelorder());
    }

    @Test (timeout = TIMEOUT)
    public void testListLeavesDescending() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        Integer[] expected = {22, 20, 16, 14, 10, 8, 4, 2};
        assertEquals(Arrays.asList(expected), bst.listLeavesDescending());
    }

    @Test (timeout = TIMEOUT)
    public void testClear() {
        assertEquals(0, bst.size());

        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());

        bst.clear();
        assertEquals(null, bst.getRoot());
        assertEquals(0, bst.size());
    }

    @Test (timeout = TIMEOUT)
    public void testHeight() {
        assertEquals(0, bst.size());

        //equal height
        Integer[] collection = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection));
        assertEquals(15, bst.size());
        assertEquals(3, bst.height());

        //right higher
        Integer[] collection2 = {12, 6, 18, 3, 9, 15, 21, 14, 16, 20, 22};
        bst= new BST<>(Arrays.asList(collection2));
        assertEquals(11, bst.size());
        assertEquals(3, bst.height());

        //left higher
        Integer[] collection3 = {12, 6, 18, 3, 9, 15, 21, 2, 4, 8, 10};
        bst= new BST<>(Arrays.asList(collection3));
        assertEquals(11, bst.size());
        assertEquals(3, bst.height());

        //no height
        Integer[] collection4 = {};
        bst= new BST<>(Arrays.asList(collection4));
        assertEquals(0, bst.size());
        assertEquals(-1, bst.height());

        //just root
        Integer[] collection5 = {1};
        bst= new BST<>(Arrays.asList(collection5));
        assertEquals(1, bst.size());
        assertEquals(0, bst.height());

        //height difference greater than 1
        Integer[] collection6 = {12, 6, 18, 20, 22};
        bst= new BST<>(Arrays.asList(collection6));
        assertEquals(5, bst.size());
        assertEquals(3, bst.height());
    }
}
