/**
 * Your implementation of a DoublyLinkedList
 *
 * @author Yue Gu
 * @userid ygu65
 * @GTID 903055355
 * @version 1.0
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T> {
    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    @Override
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size)  {
            throw new IndexOutOfBoundsException("Index cannot be negative "
                    + "or greater than ArrayList size.");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        }
        if (size == 0)  {
            addToFront(data);
            tail = head;
            return;
        }
        if (index == 0) {
            addToFront(data);
            return;
        }

        // traversing to the node preceding the insertion location
        LinkedListNode<T> tracer;
        if (index < (size / 2))    {
            tracer = head;
            for (int i = 0; i < index - 1; i++) {
                tracer = tracer.getNext();
            }
        } else  {
            tracer = tail;
            for (int i = size - 1; i > index - 1; i--) {
                tracer = tracer.getPrevious();
            }
        }

        // insertion logic
        LinkedListNode<T> newNode = new LinkedListNode(data, tracer,
                tracer.getNext());
        if (newNode.getNext() != null) {
            newNode.getNext().setPrevious(newNode);
        } else  {
            tail = newNode;
        }
        tracer.setNext(newNode);
        size++;
    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        }
        LinkedListNode<T> newNode = new LinkedListNode(data, null, head);
        if (head != null) {
            head.setPrevious(newNode);
        } else  {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        }
        LinkedListNode<T> newNode = new LinkedListNode<T>(data, tail, null);
        if (tail != null)   {
            tail.setNext(newNode);
        } else  {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size)  {
            throw new IndexOutOfBoundsException("Index cannot be negative "
                    + "or greater than the last element's index.");
        }
        if (index == 0) {
            return removeFromFront();
        } else if (index == (size - 1)) {
            return removeFromBack();
        }

        // traversing to the node preceding the insertion location
        LinkedListNode<T> tracer;
        if (index < (size / 2))    {
            tracer = head;
            for (int i = 0; i < index; i++) {
                tracer = tracer.getNext();
            }
        } else  {
            tracer = tail;
            for (int i = size - 1; i > index; i--) {
                tracer = tracer.getPrevious();
            }
        }

        // removal logic
        tracer.getPrevious().setNext(tracer.getNext());
        tracer.getNext().setPrevious(tracer.getPrevious());
        size--;

        return tracer.getData();
    }

    @Override
    public T removeFromFront()  {
        T frontdata = head.getData();
        head = head.getNext();
        if (head != null)   {
            head.setPrevious(null);
        }
        size--;
        if (size == 0)  {
            tail = null;
        }
        return frontdata;
    }

    @Override
    public T removeFromBack()   {
        T backdata = tail.getData();
        tail = tail.getPrevious();
        if (tail != null)   {
            tail.setNext(null);
        }
        size--;
        if (size == 0)  {
            head = null;
        }
        return backdata;
    }

    @Override
    public boolean removeFirstOccurrence(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        }
        LinkedListNode<T> tracer = head;
        for (int i = 0; i < size; i++) {
            if (tracer.getData().equals(data))   {
                tracer.getPrevious().setNext(tracer.getNext());
                tracer.getNext().setPrevious(tracer.getPrevious());
                size--;
                return true;
            }
            tracer = tracer.getNext();
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index == 0) {
            return head.getData();
        }
        if (index == (size - 1)) {
            return tail.getData();
        }

        // traversing to the node preceding the insertion location
        LinkedListNode<T> tracer;
        if (index < (size / 2))    {
            tracer = head;
            for (int i = 0; i < index; i++) {
                tracer = tracer.getNext();
            }
        } else  {
            tracer = tail;
            for (int i = size - 1; i > index; i--) {
                tracer = tracer.getPrevious();
            }
        }
        return tracer.getData();
    }

    @Override
    public Object[] toArray()   {
        Object[] array = new Object[size];
        LinkedListNode<T> tracer = head;
        for (int i = 0; i < size; i++)  {
            array[i] = tracer.getData();
            tracer = tracer.getNext();
        }
        return array;
    }

    @Override
    public boolean isEmpty()    {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    @Override
    public LinkedListNode<T> getTail() {
        // DO NOT MODIFY!
        return tail;
    }
}
