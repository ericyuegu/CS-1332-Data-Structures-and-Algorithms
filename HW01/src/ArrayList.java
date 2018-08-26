/**
 * Your implementation of an ArrayList.
 *
 * @author Yue Gu
 * @userid ygu65
 * @GTID 903055355
 * @version 1
 */
public class ArrayList<T> implements ArrayListInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayList.
     *
     * You may add statements to this method.
     */
    public ArrayList() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size)  {
            throw new IndexOutOfBoundsException("Index cannot be negative "
                    + "or greater than ArrayList size.");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        }
        if (size >= backingArray.length)    {
            regrow();
        }
        for (int i = size - 1; i >= index; i--)  {
            backingArray[i + 1] = backingArray[i];
        }
        backingArray[index] = data;
        size++;
    }

    @Override
    public void addToFront(T data) {
        addAtIndex(0, data);
    }

    @Override
    public void addToBack(T data) {
        addAtIndex(size, data);
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index cannot be negative "
                    + "or greater than ArrayList size.");
        }
        T removed = backingArray[index];
        for (int i = index; i < size; i++)  {
            backingArray[i] = backingArray[i + 1];
        }
        backingArray[size] = null;
        size--;
        return removed;
    }

    @Override
    public T removeFromFront() {
        if (size == 0)  {
            return null;
        }
        return removeAtIndex(0);
    }

    @Override
    public T removeFromBack() {
        if (size == 0)  {
            return null;
        }
        return removeAtIndex(size - 1);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index cannot be negative "
                    + "or greater than ArrayList size.");
        }
        return backingArray[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Resizes backingArray by 1.5x, used if data size is equal to array.length
     */
    private void regrow() {
        T[] newArray = (T[]) new Object[backingArray.length * 2];
        for (int i = 0; i < size; i++)  {
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
    }

    @Override
    public Object[] getBackingArray() {
        // DO NOT MODIFY.
        return backingArray;
    }
}
