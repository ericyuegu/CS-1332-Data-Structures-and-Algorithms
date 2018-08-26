import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BonBSTTests {
    private BSTInterface<Integer> bst;
    private static final int TIMEOUT = 200;

    @Before
    public void setup() {
        bst = new BST<>();
    }

    //Fixed this
    @Test
    public void testRemoveAndLevelOrder() {
        Integer inputs[] = {7, 2, 18, 1, 3, 16, 15, 17, 24, 26, 25, 27, 19, 22};
        List<Integer> inputList = Arrays.asList(inputs);
        bst = new BST<Integer>(inputList);

        Integer expected[] = {7, 2, 18, 1, 3, 16, 24, 15, 17, 19, 26, 22, 25, 27};
        List<Integer> expectedList = Arrays.asList(expected);
        assertEquals(expectedList, bst.levelorder());

        assertSame(bst.remove(18), 18);

        expected = new Integer[]{7, 2, 17, 1, 3, 16, 24, 15, 19, 26, 22, 25, 27};
        expectedList = Arrays.asList(expected);
        assertEquals(expectedList, bst.levelorder());
    }

    @Test
    public void testPreorder() {
        Integer inputs[] = {7, 2, 18, 1, 3, 16, 15, 17, 20};
        List<Integer> inputList = Arrays.asList(inputs);
        bst = new BST<Integer>(inputList);

        Integer expected[] = {7, 2, 1, 3, 18, 16, 15, 17, 20};
        List<Integer> expectedList = Arrays.asList(expected);

        assertEquals(expectedList, bst.preorder());
    }

    @Test
    public void testInorder() {
        Integer inputs[] = {7, 2, 18, 1, 3, 16, 15, 17, 20};
        List<Integer> inputList = Arrays.asList(inputs);
        bst = new BST<>(inputList);

        Integer expected[] = {1, 2, 3, 7, 15, 16, 17, 18, 20};
        List<Integer> expectedList = Arrays.asList(expected);

        assertEquals(expectedList, bst.inorder());
    }

    //Fixed this
    @Test
    public void testLeavesDescendingOrder() {
        Integer inputs[] = {7, 2, 18, 1, 3, 16, 15, 17, 20};
        List<Integer> inputList = Arrays.asList(inputs);
        bst = new BST<>(inputList);

        Integer expected[] = {20, 17, 15, 3, 1};
        List<Integer> expectedList = Arrays.asList(expected);

        assertEquals(expectedList, bst.listLeavesDescending());
    }

    @Test
    public void testPostorder() {
        Integer inputs[] = {7, 2, 18, 1, 3, 16, 15, 17, 20};
        List<Integer> inputList = Arrays.asList(inputs);
        bst = new BST<Integer>(inputList);

        Integer expected[] = {1, 3, 2, 15, 17, 16, 20, 18, 7};
        List<Integer> expectedList = Arrays.asList(expected);

        assertEquals(expectedList, bst.postorder());
    }

    @Test
    public void testHeight() {
        Integer inputs[] = {7, 2, 18, 1, 3, 16, 15, 17, 20};
        List<Integer> inputList = Arrays.asList(inputs);
        bst = new BST<>(inputList);

        assertEquals(3, bst.height());

        bst = new BST<>();
        assertEquals(-1, bst.height());
    }

    @Test
    public void testLevelorder() {
        Integer inputs[] = {7, 2, 18, 1, 3, 16, 15, 17, 20};
        List<Integer> inputList = Arrays.asList(inputs);
        bst = new BST<Integer>(inputList);

        Integer expected[] = {7, 2, 18, 1, 3, 16, 20, 15, 17};
        List<Integer> expectedList = Arrays.asList(expected);

        assertEquals(expectedList, bst.levelorder());
    }
}
