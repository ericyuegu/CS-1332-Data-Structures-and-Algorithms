/**
 * Your implementation of a linked stack.
 *
 * @author Yue Gu
 * @userid ygu65
 * @GTID 903055355
 * @version 1.0
 */
public class LinkedStack<T> implements StackInterface<T> {

    // Do not add new instance variables.
    private LinkedNode<T> head;
    private int size;

    @Override
    public T pop() {
        if (size == 0)  {
            throw new java.util.NoSuchElementException("Stack is empty");
        }

        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    @Override
    public void push(T data) {
        if (data == null)   {
            throw new IllegalArgumentException("Cannot push null");
        }

        LinkedNode<T> newNode = new LinkedNode(data, head);
        head = newNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return size == 0;
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns the head of this stack.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the head node
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }
}