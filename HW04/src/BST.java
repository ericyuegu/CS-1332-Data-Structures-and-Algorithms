import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Your implementation of a binary search tree.
 *
 * @author Yue Gu
 * @userid ygu65
 * @GTID 903055355
 * @version 1.0
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private BSTNode<T> root;
    private int size;

    /**
     * A no-argument constructor that should initialize an empty BST.
     * DO NOT IMPLEMENT THIS CONSTRUCTOR!
     */
    public BST() {
    }

    /**
     * Initializes the BST with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public BST(Collection<T> data) {
        for (T item : data)    {
            if (item == null)   {
                throw new IllegalArgumentException("Element is null");
            }
            add(item);
        }
    }

    @Override
    public void add(T data) {
        if (data == null)   {
            throw new IllegalArgumentException("Data is null");
        }
        root = addHelper(root, data);
    }
    /**
     * Recursive helper method to traverse tree and add new node
     * @throws IllegalArgumentException if data is null
     * @param curr the current node the method will be traversing
     * @param data the data to search for in the tree.
     * @return the current node in the tree (same as the one passed in),
     * including newly created node if data does not already exist in the tree
     *
     */
    private BSTNode<T> addHelper(BSTNode<T> curr, T data)    {
        if (data == null)   {
            throw new IllegalArgumentException("Data is null");
        }
        if (curr == null)   {
            size++;
            return new BSTNode<T>(data);
        } else if (data.compareTo(curr.getData()) < 0)  {
            curr.setLeft(addHelper(curr.getLeft(), data));
            return curr;
        } else if (data.compareTo(curr.getData()) > 0)  {
            curr.setRight((addHelper(curr.getRight(), data)));
            return curr;
        } else  {
            return curr;
        }
    }

    @Override
    public T remove(T data) {
        if (data == null)   {
            throw new IllegalArgumentException("Data is null");
        }
        BSTNode<T> dummy = new BSTNode<T>(null);
        root = removeHelper(root, data, dummy);
        return dummy.getData();
    }

    /**
     * Recursive helper method to traverse tree and remove node
     * @throws IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException if data not found in tree
     * @param curr the current node the method will be traversing
     * @param data the data to search for in the tree
     * @param dummy stores data from removed node, if found
     * @return current node, may be the original curr's predecessor
     *
     */
    private BSTNode<T> removeHelper(BSTNode<T> curr, T data,
                                    BSTNode<T> dummy)  {
        if (data == null)   {
            throw new IllegalArgumentException("Data is null");
        }
        if (curr == null)   {
            throw new java.util.NoSuchElementException("Data not found");
        }
        if (data.compareTo(curr.getData()) < 0)  {
            curr.setLeft(removeHelper(curr.getLeft(), data, dummy));
        } else if (data.compareTo(curr.getData()) > 0)  {
            curr.setRight((removeHelper(curr.getRight(), data, dummy)));
        } else  {
            size--;
            dummy.setData(curr.getData());
            if (curr.getLeft() == null && curr.getRight() == null)  {
                return null;
            } else if (curr.getLeft() == null && curr.getRight() != null)   {
                return curr.getRight();
            } else if (curr.getLeft() != null && curr.getRight() == null)   {
                return curr.getLeft();
            } else  {
                BSTNode<T> predecessor = new BSTNode<T>(null);
                curr.setLeft(findRemoveMax(curr.getLeft(), predecessor));
                curr.setData(predecessor.getData());
            }
        }
        return curr;
    }

    /**
     * Helper method for finding + removing predecessor of node w/ 2 children
     * @param curr the current node the method will be traversing
     * @param predecessor dummy node to store data of predecessor
     * @return removes and returns data from the largest child
     */
    private BSTNode<T> findRemoveMax(BSTNode<T> curr, BSTNode<T> predecessor) {
        if (curr.getRight() == null)   {
            predecessor.setData(curr.getData());
            return curr.getLeft();
        } else  {
            curr.setRight(findRemoveMax(curr.getRight(), predecessor));
        }
        return curr;
    }

    @Override
    public T get(T data) {
        if (data == null)   {
            throw new IllegalArgumentException("Data is null");
        }
        if (size == 0)  {
            throw new java.util.NoSuchElementException("Data not found");
        }
        BSTNode<T> dummy = getHelper(root, data);
        return dummy.getData();
    }

    /**
     * Helper method for finding and getting the node that contains data
     * @throws IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException if data not found in tree
     * @param curr the current node the method will be traversing
     * @param data the data to search for in the tree
     * @return the node containing the desired data
     */
    private BSTNode<T> getHelper(BSTNode<T> curr, T data)    {
        if (data == null)   {
            throw new IllegalArgumentException("Data is null");
        }
        if (curr == null)   {
            throw new java.util.NoSuchElementException("Data not found");
        } else if (data.compareTo(curr.getData()) < 0)  {
            return getHelper(curr.getLeft(), data);
        } else if (data.compareTo(curr.getData()) > 0)  {
            return getHelper(curr.getRight(), data);
        } else  {
            return curr;
        }
    }

    @Override
    public boolean contains(T data) {
        if (data == null)   {
            throw new IllegalArgumentException("Data is null");
        }
        return (containsHelper(root, data) != null);
    }

    /**
     * Helper method for finding and getting the node that contains data
     * @param curr the current node the method will be traversing
     * @param data the data to search for in the tree
     * @return the desired data, or null if not found
     */
    private T containsHelper(BSTNode<T> curr, T data)    {
        if (curr == null)   {
            return null;
        } else if (data.compareTo(curr.getData()) < 0)  {
            return containsHelper(curr.getLeft(), data);
        } else if (data.compareTo(curr.getData()) > 0)  {
            return containsHelper(curr.getRight(), data);
        } else  {
            return curr.getData();
        }
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD
        return size;
    }

    @Override
    public List<T> preorder() {
        ArrayList<T> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    /**
     * Helper method for preorder traversal
     * @param curr the current node the method will be traversing
     * @param result the list elements will be stored in
     */
    private void preorderHelper(BSTNode<T> curr, ArrayList<T> result) {
        if (curr != null)   {
            result.add(curr.getData());
            preorderHelper(curr.getLeft(), result);
            preorderHelper(curr.getRight(), result);
        }
    }

    @Override
    public List<T> postorder() {
        ArrayList<T> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    /**
     * Helper method for postorder traversal
     * @param curr the current node the method will be traversing
     * @param result the list elements will be stored in
     */
    private void postorderHelper(BSTNode<T> curr, ArrayList<T> result) {
        if (curr != null)   {
            postorderHelper(curr.getLeft(), result);
            postorderHelper(curr.getRight(), result);
            result.add(curr.getData());
        }
    }

    @Override
    public List<T> inorder() {
        ArrayList<T> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    /**
     * Helper method for inorder traversal
     * @param curr the current node the method will be traversing
     * @param result the list elements will be stored in
     */
    private void inorderHelper(BSTNode<T> curr, ArrayList<T> result) {
        if (curr != null)   {
            inorderHelper(curr.getLeft(), result);
            result.add(curr.getData());
            inorderHelper(curr.getRight(), result);
        }
    }

    @Override
    public List<T> levelorder() {
        List<T> result = new ArrayList<T>();
        Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode<T> temp = queue.remove();
            result.add(temp.getData());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return result;
    }

    @Override
    public List<T> listLeavesDescending() {
        ArrayList<T> result = new ArrayList<>();
        descendingHelper(root, result);
        return result;
    }

    /**
     * Helper method for listLeavesDescending, much like reverse
     * inorder traversal but only for leaf nodes
     * @param curr the current node the method will be traversing
     * @param result the list elements will be stored in
     */
    private void descendingHelper(BSTNode<T> curr, ArrayList<T> result) {
        if (curr != null)   {
            descendingHelper(curr.getLeft(), result);
            if (curr.getLeft() == null && curr.getRight() == null)  {
                result.add(0, curr.getData());
            }
            descendingHelper(curr.getRight(), result);
        }
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int height() {
        return heightHelper(root);
    }

    /**
     * Helper method for calculating tree height from root
     * @param curr the current node the method will be traversing
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    private int heightHelper(BSTNode<T> curr)  {
        if (curr == null) {
            return -1;
        } else {
            return (Math.max(heightHelper(curr.getLeft()),
                    heightHelper(curr.getRight())) + 1);
        }
    }

    @Override
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }
}