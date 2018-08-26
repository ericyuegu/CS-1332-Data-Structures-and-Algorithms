/**
 * Your implementation of a min heap.
 *
 * @author Yue Gu
 * @userid ygu65
 * @GTID 903055355
 * @version 1.0
 */
public class MinHeap<T extends Comparable<? super T>>
    implements HeapInterface<T> {

    private T[] backingArray;
    private int size;
    // Do not add any more instance variables. Do not change the declaration
    // of the instance variables above.

    /**
     * Creates a Heap with an initial capacity of {@code INITIAL_CAPACITY}
     * for the backing array.
     *
     * Use the constant field in the interface. Do not use magic numbers!
     */
    public MinHeap() {
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T item) {
        if (item == null)   {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (size >= backingArray.length - 1)    {
            resizeHelper();
        }

        int index = size + 1;
        backingArray[index] = item;
        int parentindex = index / 2;
        while (parentindex > 0 && (backingArray[parentindex].
                compareTo(backingArray[index]) > 0))    {
            T temp = backingArray[parentindex];
            backingArray[parentindex] = backingArray[index];
            backingArray[index] = temp;

            index = parentindex;
            parentindex = parentindex / 2;
        }
        size++;
    }

    /**
     * Doubles the capacity of the backing array
     */
    private void resizeHelper() {
        T[] newbackingArray = (T[]) new Comparable[backingArray.length * 2];
        for (int i = 0; i < backingArray.length; i++)   {
            newbackingArray[i] = backingArray[i];
        }
        backingArray = newbackingArray;
    }

    @Override
    public T remove() {
        if (size == 0 || backingArray[1] == null)  {
            throw new java.util.NoSuchElementException("Heap is empty");
        }
        int index = size;
        T data = backingArray[1];
        backingArray[1] = backingArray[index];
        backingArray[index] = null;
        index = 1;
        size--;

        //backingArray[index] has a child
        while (index <= size / 2) {
            if (index < size / 2) {
                //compare with both children without need for null check
                if ((backingArray[2 * index].compareTo(
                        backingArray[2 * index + 1]) < 0)
                        && (backingArray[2 * index].compareTo(
                                backingArray[index]) < 0)) {
                    swapHelper(index, 2 * index);
                    index = 2 * index;

                //right child is < parent
                } else if (backingArray[2 * index + 1].compareTo(
                        backingArray[index]) < 0)   {
                    swapHelper(index, 2 * index + 1);
                    index = 2 * index + 1;

                } else  {
                    return data;
                }
            } else {
                //both children exist
                if (backingArray[2 * index] != null
                        && backingArray[2 * index + 1] != null)   {
                    //if left child is < both right and parent
                    if ((backingArray[2 * index].compareTo(
                            backingArray[2 * index + 1]) < 0)
                            && (backingArray[2 * index].compareTo(
                            backingArray[index]) < 0)) {
                        swapHelper(index, 2 * index);
                        index = 2 * index;
                    //right child is < parent
                    } else if (backingArray[2 * index + 1].compareTo(
                            backingArray[index]) < 0)   {
                        swapHelper(index, 2 * index + 1);
                        index = 2 * index + 1;
                    } else  {
                        return data;
                    }

                //only left child exists
                } else if (backingArray[2 * index] != null)    {
                    if (backingArray[2 * index].compareTo(
                            backingArray[index]) < 0)   {
                        swapHelper(index, 2 * index);
                        index = 2 * index;
                    } else  {
                        return data;
                    }
                }
            }
        }

        return data;
    }

    /**
     * Swaps the elements of backingArray at the given indices.
     * Performs no exception handling.
     * @param parent the "parent" node; the order is irrelevant
     * @param child the "child" node
     */
    private void swapHelper(int parent, int child)  {
        T temp = backingArray[parent];
        backingArray[parent] = backingArray[child];
        backingArray[child] = temp;
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

    @Override
    public void clear() {
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public Comparable[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

}
