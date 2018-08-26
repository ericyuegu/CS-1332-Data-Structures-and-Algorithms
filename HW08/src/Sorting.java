import java.util.Comparator;
import java.util.Random;
import java.util.LinkedList;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author Yue Gu
 * @userid ygu65
 * @GTID 903055355
 * @version 1.0
 */
public class Sorting {

    /**
     * Implement cocktail sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable).
     *
     * See the PDF for more info on this sort.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null)  {
            throw new IllegalArgumentException("Array and comparator must "
                    + "not be null");
        }

        boolean swapped;
        int firstswap = -1;
        int lastswap = arr.length - 1;

        do {
            swapped = false;
            lastswap--;
            firstswap++;
            for (int i = firstswap; i < lastswap; i++)    {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped)    {
                for (int i = lastswap; i >= firstswap; i--)    {
                    if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                        T temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        swapped = true;
                    }
                }
            }
        } while (swapped);
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable).
     *
     * See the PDF for more info on this sort.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null)  {
            throw new IllegalArgumentException("Array and comparator must "
                    + "not be null");
        }

        int i = 1;
        while (i < arr.length)  {
            int j = i;
            while (j > 0 && comparator.compare(arr[j - 1], arr[j]) > 0)    {
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
            i++;
        }
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n^2)
     *
     * Note that there may be duplicates in the array, but they may not
     * necessarily stay in the same relative order.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null)  {
            throw new IllegalArgumentException("Array and comparator must "
                    + "not be null");
        }

        for (int i = 0; i < arr.length; i++)    {
            int min = i;

            for (int j = i; j < arr.length - 1; j++)    {
                if (comparator.compare(arr[j], arr[min]) < 0)   {
                    min = j;
                }
            }

            T temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        for (int i = 0; i < arr.length; i++)    {
            System.out.println(arr[i]);
        }
    }

    /**
     * Implement quick sort.
     *
     * Use the provided random object to select your pivots.
     * For example if you need a pivot between a (inclusive)
     * and b (exclusive) where b > a, use the following code:
     *
     * int pivotIndex = r.nextInt(b - a) + a;
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * Note that there may be duplicates in the array.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not use the one we have taught you!
     *
     * @throws IllegalArgumentException if the array or comparator or rand is
     * null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator,
                                     Random rand) {
        if (arr == null || comparator == null || rand == null)  {
            throw new IllegalArgumentException("Array and comparator and "
                    + "rand must not be null");
        }

        quickSort(arr, comparator, rand, 0, arr.length);
    }

    /**
     * Private helper method for quick sort.
     *
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     * @param left the left boundary of the sub-array in each recursive call
     * @param right the right boundary of the sub-array in each recursive call
     */
    private static <T> void quickSort(T[] arr, Comparator<T> comparator,
                                      Random rand, int left, int right) {
        if (left >= right)  {
            return;
        }

        int pivotIndex = rand.nextInt(right - left) + left;
        T pivot = arr[pivotIndex];
        T temp = arr[left];
        arr[left] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        //pivot stored in arr['left']
        int leftIndex = left + 1;
        int rightIndex = right - 1;

        while (leftIndex <= rightIndex)  {
            while (leftIndex <= rightIndex && comparator.compare(
                    arr[leftIndex], pivot) <= 0)    {
                leftIndex++;
            }
            while (leftIndex <= rightIndex && comparator.compare(
                    arr[rightIndex], pivot) >= 0)    {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                T temp2 = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp2;
                leftIndex++;
                rightIndex--;
            }
        }

        //swap right index with pivot
        T temp3 = arr[left];
        arr[left] = arr[rightIndex];
        arr[rightIndex] = temp3;

        /*
        System.out.println("~~~");
        System.out.println(pivotIndex);
        System.out.println("Left: " + left);
        System.out.println("Right: " + right);
        */
        for (int i = 0; i < arr.length; i++)    {
            System.out.println(arr[i]);
        }
        quickSort(arr, comparator, rand, left, rightIndex);
        quickSort(arr, comparator, rand, rightIndex + 1, right);

    }

    /**
     * Implement merge sort.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(n log n)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * You can create more arrays to run mergesort, but at the end,
     * everything should be merged back into the original T[]
     * which was passed in.
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null)  {
            throw new IllegalArgumentException("Array and comparator must "
                    + "not be null");
        }

        //Split array into left and right
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        int midIndex = length / 2;
        T[] left = (T[]) new Object[midIndex];
        T[] right = (T[]) new Object[length - midIndex];
        for (int i = 0; i < midIndex; i++)  {
            left[i] = arr[i];
        }
        for (int i = midIndex; i < length; i++) {
            right[i - midIndex] = arr[i];
        }

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = 0;
        while (leftIndex < midIndex && rightIndex < length - midIndex)    {
            if (comparator.compare(left[leftIndex], right[rightIndex]) < 0) {
                arr[currentIndex] = left[leftIndex++];
            } else  {
                arr[currentIndex] = right[rightIndex++];
            }
            currentIndex++;
        }
        while (leftIndex < midIndex)    {
            arr[currentIndex++] = left[leftIndex++];
        }
        while (rightIndex < length - midIndex)    {
            arr[currentIndex++] = right[rightIndex++];
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(kn)
     *
     * And a best case running time of:
     *  O(kn)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable)
     *
     * Do NOT use {@code Math.pow()} in your sort.
     *
     * You may use {@code java.util.ArrayList} or {@code java.util.LinkedList}
     * if you wish, but it may only be used inside radix sort and any radix sort
     * helpers. Do NOT use these classes with other sorts.
     *
     * @throws IllegalArgumentException if the array is null
     * @param arr the array to be sorted
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null)  {
            throw new IllegalArgumentException("Array must not be null");
        }

        if (arr.length <= 1)    {
            return;
        }

        LinkedList<Integer>[] buckets = new LinkedList[19];
        int max = arr[0];
        int min = arr[0];
        int exp = 1;
        for (int i = 0; i < arr.length; i++)    {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min)   {
                min = arr[i];
            }
        }
        int iterations = 0;
        while (max != 0 || min != 0)   {
            max = max / 10;
            min = min / 10;
            iterations++;
        }
        int length = arr.length;

        for (int i = 1; i <= iterations; i++)    {
            for (int j = 0; j <= length - 1; j++)    {
                int bucket = (arr[j] / exp) % 10;
                bucket += 9;
                if (buckets[bucket] == null)    {
                    buckets[bucket] = new LinkedList<Integer>();
                }
                buckets[bucket].add(arr[j]);
            }
            int index = 0;
            for (int bucket = 0; bucket < 19; bucket++)    {
                if (buckets[bucket] == null)    {
                    buckets[bucket] = new LinkedList<Integer>();
                }
                while (!buckets[bucket].isEmpty())  {
                    arr[index] = buckets[bucket].removeFirst();
                    index++;
                }
            }
            exp *= 10;
        }
    }
}
