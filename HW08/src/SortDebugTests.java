import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 *      JUnit Tests created by Luka Derado:
 *
 *      Note: Class Teaching Assistant and Comparator plus
 *      were ripped from Given JUnits.
 */
public class SortDebugTests {
    private TeachingAssistant[] tas;
    private TeachingAssistant[] tasByName;
    private TeachingAssistant[] empty;
    private TeachingAssistant[] single;
    private TeachingAssistant[] couple;
    private TeachingAssistant[] swap;
    private TeachingAssistant[] swapGood;
    private ComparatorPlus<TeachingAssistant> comp;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        tas = new TeachingAssistant[10];
        tas[0] = new TeachingAssistant("Alok");
        tas[1] = new TeachingAssistant("Chad");
        tas[2] = new TeachingAssistant("Grayson");
        tas[3] = new TeachingAssistant("Neil");
        tas[4] = new TeachingAssistant("Ashley");
        tas[5] = new TeachingAssistant("Scott");
        tas[6] = new TeachingAssistant("Tim");
        tas[7] = new TeachingAssistant("Jackie");
        tas[8] = new TeachingAssistant("Raymond");
        tas[9] = new TeachingAssistant("Bartosz");
        tasByName = new TeachingAssistant[10];
        tasByName[0] = tas[0];
        tasByName[1] = tas[4];
        tasByName[2] = tas[9];
        tasByName[3] = tas[1];
        tasByName[4] = tas[2];
        tasByName[5] = tas[7];
        tasByName[6] = tas[3];
        tasByName[7] = tas[8];
        tasByName[8] = tas[5];
        tasByName[9] = tas[6];

        empty = new TeachingAssistant[0];

        single = new TeachingAssistant[1];
        single[0] = new TeachingAssistant("Me");

        couple = new TeachingAssistant[2];
        couple[0] = new TeachingAssistant("Chunlok");
        couple[1] = new TeachingAssistant("Tim");

        swap = new TeachingAssistant[2];
        swap[0] = new TeachingAssistant("Zebra");
        swap[1] = new TeachingAssistant("Aardvark");

        swapGood = new TeachingAssistant[2];
        swapGood[0] = swap[1];
        swapGood[1] = swap[0];

        comp = TeachingAssistant.getNameComparator();
    }

    /**
     *      Sets up a uniform array
     *      Should be O(N) for everything.
     *
     *      Note that failure here means a method is not stable.
     */
    private void setUpUniform(){
        tas = new TeachingAssistant[10];
        tas[0] = new TeachingAssistant("We Are Borg");
        tas[1] = new TeachingAssistant("We Are Borg");
        tas[2] = new TeachingAssistant("We Are Borg");
        tas[3] = new TeachingAssistant("We Are Borg");
        tas[4] = new TeachingAssistant("We Are Borg");
        tas[5] = new TeachingAssistant("We Are Borg");
        tas[6] = new TeachingAssistant("We Are Borg");
        tas[7] = new TeachingAssistant("We Are Borg");
        tas[8] = new TeachingAssistant("We Are Borg");
        tas[9] = new TeachingAssistant("We Are Borg");
        tasByName = new TeachingAssistant[10];
        tasByName[0] = tas[0];
        tasByName[1] = tas[1];
        tasByName[2] = tas[2];
        tasByName[3] = tas[3];
        tasByName[4] = tas[4];
        tasByName[5] = tas[5];
        tasByName[6] = tas[6];
        tasByName[7] = tas[7];
        tasByName[8] = tas[8];
        tasByName[9] = tas[9];
    }

    /**
     *      Sets up the array, but backwards.
     *      takes O(N^2) for the O(n) sorts.
     */
    private void setUpBackward(){
        tas = new TeachingAssistant[10];
        tas[9] = new TeachingAssistant("Alok");
        tas[8] = new TeachingAssistant("Ashley");
        tas[7] = new TeachingAssistant("Bartosz");
        tas[6] = new TeachingAssistant("Chad");
        tas[5] = new TeachingAssistant("Grayson");
        tas[4] = new TeachingAssistant("Jackie");
        tas[3] = new TeachingAssistant("Neil");
        tas[2] = new TeachingAssistant("Raymond");
        tas[1] = new TeachingAssistant("Scott");
        tas[0] = new TeachingAssistant("Tim");
        tasByName = new TeachingAssistant[10];
        tasByName[0] = tas[9];
        tasByName[1] = tas[8];
        tasByName[2] = tas[7];
        tasByName[3] = tas[6];
        tasByName[4] = tas[5];
        tasByName[5] = tas[4];
        tasByName[6] = tas[3];
        tasByName[7] = tas[2];
        tasByName[8] = tas[1];
        tasByName[9] = tas[0];
    }

    /**
     *      Almost Sorted Array.
     */
    private void setUpAlmost(){
        tas = new TeachingAssistant[10];
        tas[0] = new TeachingAssistant("Alok");
        tas[1] = new TeachingAssistant("Ashley");
        tas[2] = new TeachingAssistant("Bartosz");
        tas[3] = new TeachingAssistant("Chad");
        tas[4] = new TeachingAssistant("Grayson");
        tas[5] = new TeachingAssistant("Jackie");
        tas[6] = new TeachingAssistant("Neil");
        tas[7] = new TeachingAssistant("Raymond");
        tas[8] = new TeachingAssistant("Tim");
        tas[9] = new TeachingAssistant("Scott");
        tasByName = new TeachingAssistant[10];
        tasByName[0] = tas[0];
        tasByName[1] = tas[1];
        tasByName[2] = tas[2];
        tasByName[3] = tas[3];
        tasByName[4] = tas[4];
        tasByName[5] = tas[5];
        tasByName[6] = tas[6];
        tasByName[7] = tas[7];
        tasByName[8] = tas[9];
        tasByName[9] = tas[8];
    }

    /**
     *      Already Sorted Array.
     */
    private void setUpAlready(){
        tas = new TeachingAssistant[10];
        tas[0] = new TeachingAssistant("Alok");
        tas[1] = new TeachingAssistant("Ashley");
        tas[2] = new TeachingAssistant("Bartosz");
        tas[3] = new TeachingAssistant("Chad");
        tas[4] = new TeachingAssistant("Grayson");
        tas[5] = new TeachingAssistant("Jackie");
        tas[6] = new TeachingAssistant("Neil");
        tas[7] = new TeachingAssistant("Raymond");
        tas[8] = new TeachingAssistant("Scott");
        tas[9] = new TeachingAssistant("Tim");
        tasByName = new TeachingAssistant[10];
        tasByName[0] = tas[0];
        tasByName[1] = tas[1];
        tasByName[2] = tas[2];
        tasByName[3] = tas[3];
        tasByName[4] = tas[4];
        tasByName[5] = tas[5];
        tasByName[6] = tas[6];
        tasByName[7] = tas[7];
        tasByName[8] = tas[8];
        tasByName[9] = tas[9];
    }

    @Test(timeout = TIMEOUT)
    public void testNullComp(){
        int count = 0;
        try {
            Sorting.cocktailSort(tas, null);
        } catch (IllegalArgumentException e){
            count++;
        }
        try {
            Sorting.insertionSort(tas, null);
        } catch (IllegalArgumentException e){
            count++;
        }
        try {
            Sorting.selectionSort(tas, null);
        } catch (IllegalArgumentException e){
            count++;
        }
        try{
            Sorting.mergeSort(tas,null);
        } catch (IllegalArgumentException e){
            count++;
        }
        try{
            Sorting.quickSort(tas,null,new Random(0x600dc0de));
        } catch (IllegalArgumentException e){
            count++;
        }
        assertEquals(5, count);
    }
    @Test(timeout = TIMEOUT)
    public void testNullArray(){
        int count = 0;
        try {
            Sorting.cocktailSort(null, comp);
        } catch (IllegalArgumentException e){
            count++;
        }
        try {
            Sorting.insertionSort(null, comp);
        } catch (IllegalArgumentException e){
            count++;
        }
        try {
            Sorting.selectionSort(null, comp);
        } catch (IllegalArgumentException e){
            count++;
        }
        try{
            Sorting.mergeSort(null, comp);
        } catch (IllegalArgumentException e){
            count++;
        }
        try{
            Sorting.quickSort(null, comp,new Random(0x600dc0de));
        } catch (IllegalArgumentException e){
            count++;
        }
        try{
            Sorting.lsdRadixSort(null);
        }  catch (IllegalArgumentException e){
            count++;
        }
        assertEquals(6, count);
    }

    @Test(timeout = TIMEOUT)
    public void testEmpty(){
        Sorting.cocktailSort(empty,comp);
        Sorting.insertionSort(empty,comp);
        Sorting.selectionSort(empty,comp);
        Sorting.quickSort(empty,comp,new Random(0x600dc0de));
        Sorting.mergeSort(empty,comp);
        int[] empty = new int[0];
        Sorting.lsdRadixSort(empty);

        assertEquals(0,comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testSingle(){
        Sorting.cocktailSort(single,comp);
        Sorting.insertionSort(single,comp);
        Sorting.selectionSort(single,comp);
        Sorting.quickSort(single,comp,new Random(0x600dc0de));
        Sorting.mergeSort(single,comp);
        int[] single = new int[1];
        single[0] = 1;
        Sorting.lsdRadixSort(single);

        assertEquals(0,comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testCouple(){
        Sorting.cocktailSort(couple,comp);
        Sorting.insertionSort(couple,comp);
        Sorting.selectionSort(couple,comp);
        Sorting.quickSort(couple,comp,new Random(0x600dc0de));
        Sorting.mergeSort(couple,comp);
        int[] couple = new int[2];
        couple[0] = 1;
        couple[1] = 2;
        Sorting.lsdRadixSort(couple);

        assertEquals(5,comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testSwap(){
        Sorting.cocktailSort(swap,comp);
        assertArrayEquals(swapGood,swap);
        setUp();

        Sorting.insertionSort(swap,comp);
        assertArrayEquals(swapGood,swap);
        setUp();

        Sorting.selectionSort(swap,comp);
        assertArrayEquals(swapGood,swap);
        setUp();

        Sorting.quickSort(swap,comp,new Random(0x600dc0de));
        assertArrayEquals(swapGood,swap);
        setUp();

        Sorting.mergeSort(swap,comp);
        assertArrayEquals(swapGood,swap);
        setUp();

        int[] swap = new int[] {2,1};
        int[] swapGood = new int[] {1,2};
        Sorting.lsdRadixSort(swap);
        assertArrayEquals(swapGood,swap);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailSortBase() {
        Sorting.cocktailSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Base Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 35 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailSortUniform() {
        setUpUniform();
        Sorting.cocktailSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Uniform case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 9 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailBestSort() {
        setUpAlready();
        Sorting.cocktailSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Best case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 9 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailWorstSort() {
        setUpBackward();
        Sorting.cocktailSort(tas, comp);
        try {
            assertArrayEquals(tasByName, tas);
            assertTrue("Worst case Number of comparisons: " + comp.getCount(),
                    comp.getCount() <= 45 && comp.getCount() != 0);
        } catch (AssertionError e){
            ;
        }
    }

    @Test(timeout = TIMEOUT)
    public void testCocktailAlreadySort() {
        setUpAlready();
        Sorting.cocktailSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Worst case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 9 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSortBase() {
        Sorting.insertionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 30 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSortUniform() {
        setUpUniform();
        Sorting.insertionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Uniform case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 9 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionBestSort() {
        setUpAlready();
        Sorting.insertionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Best case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 9 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionWorstSort() {
        setUpBackward();
        Sorting.insertionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Worst case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testInsertionAlreadySort() {
        setUpAlready();
        Sorting.insertionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Worst case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 9 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionSort() {
        Sorting.selectionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionSortUniform() {
        setUpUniform();
        Sorting.selectionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Uniform case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 50 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionBestSort() {
        setUpAlready();
        Sorting.selectionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Best case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 50 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionWorstSort() {
        setUpBackward();
        Sorting.selectionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Worst case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 50 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionAlreadySort() {
        setUpAlready();
        Sorting.selectionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Already case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 50 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickSort() {
        Sorting.quickSort(tas, comp, new Random(0x600dc0de));
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }
    @Test(timeout = TIMEOUT, expected = AssertionError.class)
    public void testQuickSortUniform() {
        setUpUniform();
        Sorting.quickSort(tas, comp, new Random(0x600dc0de));
        assertArrayEquals(tasByName, tas);
        assertTrue("Uniform case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickBestSort() {
        setUpAlready();
        Sorting.quickSort(tas, comp, new Random(0x600dc0de));
        assertArrayEquals(tasByName, tas);
        assertTrue("Best case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickWorstSort() {
        setUpBackward();
        Sorting.quickSort(tas, comp, new Random(0x600dc0de));
        assertArrayEquals(tasByName, tas);
        assertTrue("Worst case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testQuickAlreadySort() {
        setUpAlready();
        Sorting.quickSort(tas, comp, new Random(0x600dc0de));
        assertArrayEquals(tasByName, tas);
        assertTrue("Worst case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);
    }

    @Test()//timeout = TIMEOUT)
    public void testMergeSort() {
        Sorting.mergeSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 48 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeSortUniform() {
        setUpUniform();
        Sorting.mergeSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Uniform case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 50 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeBestSort() {
        setUpAlready();
        Sorting.mergeSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Best case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 50 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeWorstSort() {
        setUpBackward();
        Sorting.mergeSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Worst case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 50 && comp.getCount() != 0);
    }

    @Test(timeout = TIMEOUT)
    public void testMergeAlreadySort() {
        setUpAlready();
        Sorting.mergeSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Already case Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 50 && comp.getCount() != 0);
    }

    @Test()//timeout = TIMEOUT)
    public void testLsdRadixBaseSort() {
        int[] unsortedArray = new int[] {54, 28, 58, 84, 20, 122, 85, 3};
        int[] sortedArray = new int[] {3, 20, 28, 54, 58, 84, 85, 122};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test()//timeout = TIMEOUT)
    public void testLsdRadixEarlyZerosSort() {
        int[] unsortedArray = new int[] {103, 102, 306, 709, 404, 602, 203, 2};
        int[] sortedArray = new int[] {2, 102, 103, 203, 306, 404, 602, 709};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test()//timeout = TIMEOUT)
    public void testLsdRadixNegativeSort() {
        int[] unsortedArray = new int[]{-54, -28, -58, -84, -20, -122, -85, -3, -9};
        int[] sortedArray = new int[]{-122, -85, -84, -58, -54, -28, -20, -9, -3};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test()//timeout = TIMEOUT)
    public void testLsdRadixMixSort() {
        int[] unsortedArray = new int[] {-54, 28, -58, 84, -20, 122, -85, 3, -9};
        int[] sortedArray = new int[] {-85, -58, -54, -20, -9, 3, 28, 84, 122};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test()//timeout = TIMEOUT)
    public void testLsdRadixExtremeSort() {
        int[] unsortedArray = new int[] {-54, 28, 58, Integer.MIN_VALUE, 84, 20, -122, 85, 3, Integer.MAX_VALUE};
        int[] sortedArray = new int[] {Integer.MIN_VALUE, -122, -54, 3, 20, 28, 58, 84, 85, Integer.MAX_VALUE};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }
    /**
     * Class for testing proper sorting.
     */
    private static class TeachingAssistant {
        private String name;

        /**
         * Create a teaching assistant.
         *
         * @param name name of TA
         */
        public TeachingAssistant(String name) {
            this.name = name;
        }

        /**
         * Get the name of the teaching assistant.
         *
         * @return name of teaching assistant
         */
        public String getName() {
            return name;
        }

        /**
         * Set the name of the teaching assistant.
         *
         * @param name name of the teaching assistant
         */
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name: " + name;
        }

        /**
         * Create a comparator that compares the names of the teaching
         * assistants.
         *
         * @return comparator that compares the names of the teaching assistants
         */
        public static ComparatorPlus<TeachingAssistant> getNameComparator() {
            return new ComparatorPlus<TeachingAssistant>() {
                @Override
                public int compare(TeachingAssistant ta1,
                                   TeachingAssistant ta2) {
                    incrementCount();
                    return ta1.getName().compareTo(ta2.getName());
                }
            };
        }
    }

    /**
     * Inner class that allows counting how many comparisons were made.
     */
    private abstract static class ComparatorPlus<T> implements Comparator<T> {
        private int count;

        /**
         * Get the number of comparisons made.
         * @return number of comparisons made
         */
        public int getCount() {
            return count;
        }

        /**
         * Increment the number of comparisons made by one. Call this method in
         * your compare() implementation.
         */
        public void incrementCount() {
            count++;
        }
    }
}
