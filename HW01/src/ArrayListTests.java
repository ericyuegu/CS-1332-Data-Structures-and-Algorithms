import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Some additional JUnit tests for Homework 1.
 * I included the tests initially provided by the TAs and added some of my own
 * to test edge cases.
 * @author Armand Raynor
 * @version 1
 */
public class ArrayListTests {

    private ArrayListInterface<String> stringList;
    private ArrayListInterface<Integer> intList;

    public static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        stringList = new ArrayList<String>();
        intList = new ArrayList<Integer>();
    }

    /*
        ############################ IndexOutOfBoundsException Tests ############################
     */

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testGetNegativeIndexOutOfBounds() {
        intList.get(-1);
        intList.addAtIndex(-1, 100);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testGetPositiveIndexOutOfBounds() {
        intList.addAtIndex(0, 1);
        intList.addAtIndex(1, 2);
        intList.addAtIndex(2, 3);
        intList.addAtIndex(3, 4);
        intList.get(4);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveNegativeIndexOutOfBounds() {
        intList.removeAtIndex(-1);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemovePositiveIndexOutOfBounds() {
        intList.addAtIndex(0, 1);
        intList.addAtIndex(1, 2);
        intList.addAtIndex(2, 3);
        intList.addAtIndex(3, 4);
        intList.removeAtIndex(4);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testAddNegativeIndexOutOfBounds() {
        intList.addAtIndex(-1, 100);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testAddPositiveIndexOutOfBounds() {
        intList.addAtIndex(0, 1);
        intList.addAtIndex(1, 2);
        intList.addAtIndex(2, 3);
        intList.addAtIndex(3, 4);
        intList.addAtIndex(10, 5);
    }

    /*
        ############################ IllegalArgumentException Tests ############################
     */

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddToFrontIllegalArgumentException() {
        intList.addToFront(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddToBackIllegalArgumentException() {
        intList.addToBack(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddAtIndexIllegalArgumentException() {
        intList.addAtIndex(0, null);
    }

    /*
        ################################### Add Method Tests ####################################
     */

    @Test(timeout = TIMEOUT)
    public void testAddToBack() {
        intList.addToBack(1);
        intList.addToBack(2);
        intList.addToBack(3);
        intList.addToBack(4);

        assertEquals(4, intList.size());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        expected[0] = 1;
        expected[1] = 2;
        expected[2] = 3;
        expected[3] = 4;

        assertArrayEquals(expected, intList.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFront() {
        intList.addToFront(1); // 1
        intList.addToFront(2); // 2 1
        intList.addToFront(3); // 3 2 1
        intList.addToFront(4); // 4 3 2 1

        assertEquals(4, intList.size());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        expected[0] = 4;
        expected[1] = 3;
        expected[2] = 2;
        expected[3] = 1;

        assertArrayEquals(expected, intList.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndex() {
        intList.addAtIndex(0, 1); // 1
        intList.addAtIndex(1, 4); // 1 4
        intList.addAtIndex(1, 2); // 1 2 4
        intList.addAtIndex(2, 3); // 1 2 3 4

        assertEquals(4, intList.size());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        expected[0] = 1;
        expected[1] = 2;
        expected[2] = 3;
        expected[3] = 4;

        assertArrayEquals(expected, intList.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddStrings() {
        assertEquals(0,stringList.size());

        stringList.addAtIndex(0, "0a"); //0a
        stringList.addAtIndex(1, "1a"); //0a 1a
        stringList.addAtIndex(2, "2a"); //0a 1a 2a
        stringList.addAtIndex(3, "3a"); //0a 1a 2a 3a

        assertEquals(4,stringList.size());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        expected[0] = "0a";
        expected[1] = "1a";
        expected[2] = "2a";
        expected[3] = "3a";
        assertArrayEquals(expected,stringList.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddStringsFront() {
        assertEquals(0, stringList.size());

        stringList.addToFront("0a");
        stringList.addToFront("1a");
        stringList.addToFront("2a");
        stringList.addToFront("3a");
        stringList.addToFront("4a"); //4a 3a 2a 1a 0a

        assertEquals(5,stringList.size());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        expected[0] = "4a";
        expected[1] = "3a";
        expected[2] = "2a";
        expected[3] = "1a";
        expected[4] = "0a";
        assertArrayEquals(expected,stringList.getBackingArray());
    }

    /*
        ################################## Remove Method Tests ####################################
     */

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBack() {
        intList.addToBack(1);
        intList.addToBack(2);
        intList.addToBack(3);
        intList.addToBack(4);

        intList.removeFromBack();
        intList.removeFromBack();

        assertEquals(2, intList.size());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        expected[0] = 1;
        expected[1] = 2;

        assertArrayEquals(expected, intList.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFront() {
        intList.addToFront(4);
        intList.addToFront(3);
        intList.addToFront(2);
        intList.addToFront(1);

        intList.removeFromFront();
        intList.removeFromFront();

        assertEquals(2, intList.size());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        expected[0] = 3;
        expected[1] = 4;

        assertArrayEquals(expected, intList.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromIndex() {
        intList.addToBack(1);
        intList.addToBack(2);
        intList.addToBack(3);
        intList.addToBack(4);

        intList.removeAtIndex(1);
        intList.removeAtIndex(1);

        assertEquals(2, intList.size());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        expected[0] = 1;
        expected[1] = 4;

        assertArrayEquals(expected, intList.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveStrings() {
        assertEquals(0,stringList.size());
        stringList.addAtIndex(0, "0a"); //0a
        stringList.addAtIndex(1, "1a"); //0a 1a
        stringList.addAtIndex(2, "2a"); //0a 1a 2a
        stringList.addAtIndex(3, "3a"); //0a 1a 2a 3a
        stringList.addAtIndex(4, "4a"); //0a 1a 2a 3a 4a
        stringList.addAtIndex(5, "5a"); //0a 1a 2a 3a 4a 5a

        assertEquals(6, stringList.size());

        assertEquals("2a", stringList.removeAtIndex(2)); //0a 1a 3a 4a 5a

        assertEquals(5,stringList.size());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        expected[0] = "0a";
        expected[1] = "1a";
        expected[2] = "3a";
        expected[3] = "4a";
        expected[4] = "5a";
        assertArrayEquals(expected,stringList.getBackingArray());
    }

    /*
        ################################### Miscellaneous Tests #####################################
     */

    @Test(timeout = TIMEOUT)
    public void testDoesGrow() {
        for(int i = 1; i < 12; i++) {
            intList.addToBack(i);
        }

        assertEquals(ArrayListInterface.INITIAL_CAPACITY * 2, intList.getBackingArray().length);

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY * 2];

        for(int i = 0; i < 11; i++) {
            expected[i] = i + 1;
        }

        assertArrayEquals(expected, intList.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        for(int i = 1; i < 200; i++) {
            intList.addToBack(i);
        }
        intList.clear();

        assertEquals(ArrayListInterface.INITIAL_CAPACITY, intList.getBackingArray().length);
        assertTrue(intList.isEmpty());

        Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
        assertArrayEquals(expected, intList.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testGetGeneral() {
        stringList.addAtIndex(0, "0a"); //0a
        stringList.addAtIndex(1, "1a"); //1a
        stringList.addAtIndex(2, "2a"); //2a
        stringList.addAtIndex(3, "3a"); //3a
        stringList.addAtIndex(4, "4a"); //4a

        assertEquals("0a",stringList.get(0));
        assertEquals("1a",stringList.get(1));
        assertEquals("2a",stringList.get(2));
        assertEquals("3a",stringList.get(3));
        assertEquals("4a",stringList.get(4));
    }
}