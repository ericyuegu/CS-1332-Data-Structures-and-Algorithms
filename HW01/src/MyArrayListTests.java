import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * My simple Array List tests for each method implemented and for the expanding
 * Mostly adapted from what the TAs had to include more edge cases
 *
 * @author Andrew Wittenmyer
 */
public class MyArrayListTests {

	private ArrayListInterface<String> list;

	public static final int TIMEOUT = 200;

	@Before
	public void setUp() {
		list = new ArrayList<String>();
	}

	@Test(timeout = TIMEOUT)
	public void testConstructor() {
		assertEquals(0, list.size());
		assertEquals(list.getBackingArray().length, ArrayListInterface.INITIAL_CAPACITY);
	}

	@Test(timeout = TIMEOUT)
	public void testAddAtIndex() {
		list.addAtIndex(0, "1a"); // 1a
		list.addAtIndex(1, "2a"); // 1a 2a
		list.addAtIndex(2, "3a"); // 1a 2a 3a
		list.addAtIndex(3, "6a"); // 1a 2a 3a 6a
		list.addAtIndex(3, "5a"); // 1a 2a 3a 5a 6a
		list.addAtIndex(3, "4a"); // 1a 2a 3a 4a 5a 6a
		list.addAtIndex(0, "0a"); // 0a 1a 2a 3a 4a 5a 6a

		assertEquals(7, list.size());

		Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "0a";
		expected[1] = "1a";
		expected[2] = "2a";
		expected[3] = "3a";
		expected[4] = "4a";
		expected[5] = "5a";
		expected[6] = "6a";
		assertArrayEquals(expected, list.getBackingArray());

		// test index out of bounds above
		try {
			list.addAtIndex(10, "10a");
			fail();
		} catch (Exception e) {
			assertEquals(java.lang.IndexOutOfBoundsException.class, e.getClass());
		}

		// test index out of bounds below
		try {
			list.addAtIndex(-1, "-1a");
			fail();
		} catch (Exception e) {
			assertEquals(java.lang.IndexOutOfBoundsException.class, e.getClass());
		}

		// test inserting null
		try {
			list.addAtIndex(4, null);
			fail();
		} catch (Exception e) {
			assertEquals(java.lang.IllegalArgumentException.class, e.getClass());
		}
	}

	@Test(timeout = TIMEOUT)
	public void testExpanding() {
		//
		// smaller than initial capacity of 10
		list.addToFront("10a");
		list.addToFront("9a");
		list.addToFront("8a");
		list.addToFront("7a");
		list.addToFront("6a");
		list.addToFront("5a");
		list.addToFront("4a");
		list.addToFront("3a");
		list.addToFront("2a");
		list.addToFront("1a");

		assertEquals(10, list.size());

		Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "1a";
		expected[1] = "2a";
		expected[2] = "3a";
		expected[3] = "4a";
		expected[4] = "5a";
		expected[5] = "6a";
		expected[6] = "7a";
		expected[7] = "8a";
		expected[8] = "9a";
		expected[9] = "10a";
		assertArrayEquals(expected, list.getBackingArray());

		//
		// grow past initial capacity
		//
		list.addToFront("0a");

		assertEquals(11, list.size());

		expected = new Object[2 * ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "0a";
		expected[1] = "1a";
		expected[2] = "2a";
		expected[3] = "3a";
		expected[4] = "4a";
		expected[5] = "5a";
		expected[6] = "6a";
		expected[7] = "7a";
		expected[8] = "8a";
		expected[9] = "9a";
		expected[10] = "10a";
		assertArrayEquals(expected, list.getBackingArray());

		//
		// continue past initial capacity
		//
		list.addToBack("11a");
		list.addToBack("12a");
		list.addToBack("13a");
		list.addToBack("14a");
		list.addToBack("15a");
		list.addToBack("16a");
		list.addToBack("17a");
		list.addToBack("18a");
		list.addToBack("19a");

		assertEquals(20, list.size());

		expected[11] = "11a";
		expected[12] = "12a";
		expected[13] = "13a";
		expected[14] = "14a";
		expected[15] = "15a";
		expected[16] = "16a";
		expected[17] = "17a";
		expected[18] = "18a";
		expected[19] = "19a";

		assertArrayEquals(expected, list.getBackingArray());
	}

	@Test(timeout = TIMEOUT)
	public void testAddToFront() {
		list.addToFront("0a");
		list.addToFront("1a");
		list.addToFront("2a");
		list.addToFront("3a");
		list.addToFront("4a"); // 4a 3a 2a 1a 0a

		assertEquals(5, list.size());

		Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "4a";
		expected[1] = "3a";
		expected[2] = "2a";
		expected[3] = "1a";
		expected[4] = "0a";
		assertArrayEquals(expected, list.getBackingArray());
	}

	@Test(timeout = TIMEOUT)
	public void testAddToBack() {
		list.addToBack("0a");
		list.addToBack("1a");
		list.addToBack("2a");
		list.addToBack("3a");
		list.addToBack("4a");

		assertEquals(5, list.size());

		Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "0a";
		expected[1] = "1a";
		expected[2] = "2a";
		expected[3] = "3a";
		expected[4] = "4a";
		assertArrayEquals(expected, list.getBackingArray());
	}

	@Test(timeout = TIMEOUT)
	public void testRemoveAtIndex() {
		list.addToBack("0a");
		list.addToBack("1a");
		list.addToBack("2a");
		list.addToBack("3a");
		list.addToBack("4a");
		assertEquals(5, list.size());

		// remove middle
		assertEquals("2a", list.removeAtIndex(2)); // 0a 1a 3a 4a
		assertEquals(4, list.size());
		
		Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "0a";
		expected[1] = "1a";
		expected[2] = "3a";
		expected[3] = "4a";
		assertArrayEquals(expected, list.getBackingArray());

		// remove first
		assertEquals("0a", list.removeAtIndex(0)); // 1a 3a 4a
		assertEquals(3, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "1a";
		expected[1] = "3a";
		expected[2] = "4a";
		assertArrayEquals(expected, list.getBackingArray());

		// remove last
		assertEquals("4a", list.removeAtIndex(2)); // 1a 3a
		assertEquals(2, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "1a";
		expected[1] = "3a";
		assertArrayEquals(expected, list.getBackingArray());

		// remove last again
		assertEquals("3a", list.removeAtIndex(1)); // 1a
		assertEquals(1, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "1a";
		assertArrayEquals(expected, list.getBackingArray());

		// remove only
		assertEquals("1a", list.removeAtIndex(0)); // empty
		assertEquals(0, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		assertArrayEquals(expected, list.getBackingArray());

		// remove empty
		try {
			list.removeAtIndex(0);
			fail();
		} catch (Exception e) {
			assertEquals(java.lang.IndexOutOfBoundsException.class, e.getClass());
		}
	}

	@Test(timeout = TIMEOUT)
	public void testRemoveFromFront() {
		list.addToBack("0a");
		list.addToBack("1a");
		list.addToBack("2a");
		assertEquals(3, list.size());

		// remove once
		assertEquals("0a", list.removeFromFront()); // 1a 2a
		assertEquals(2, list.size());
		
		Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "1a";
		expected[1] = "2a";
		assertArrayEquals(expected, list.getBackingArray());

		// remove next
		assertEquals("1a", list.removeFromFront()); // 2a
		assertEquals(1, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "2a";
		assertArrayEquals(expected, list.getBackingArray());

		// remove last
		assertEquals("2a", list.removeFromFront()); // empty
		assertEquals(0, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		assertArrayEquals(expected, list.getBackingArray());

		// remove from empty
		assertEquals(null, list.removeFromFront()); // empty
		assertEquals(0, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		assertArrayEquals(expected, list.getBackingArray());
	}

	@Test(timeout = TIMEOUT)
	public void testRemoveFromBack() {
		list.addToBack("0a");
		list.addToBack("1a");
		list.addToBack("2a");
		assertEquals(3, list.size());

		// remove once
		assertEquals("2a", list.removeFromBack()); // 0a 1a
		assertEquals(2, list.size());
		
		Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "0a";
		expected[1] = "1a";
		assertArrayEquals(expected, list.getBackingArray());

		// remove next
		assertEquals("1a", list.removeFromBack()); // 0a
		assertEquals(1, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		expected[0] = "0a";
		assertArrayEquals(expected, list.getBackingArray());

		// remove last
		assertEquals("0a", list.removeFromBack()); // empty
		assertEquals(0, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		assertArrayEquals(expected, list.getBackingArray());

		// remove from empty
		assertEquals(null, list.removeFromBack()); // empty
		assertEquals(0, list.size());
		
		expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		assertArrayEquals(expected, list.getBackingArray());
	}

	@Test(timeout = TIMEOUT)
	public void testGet() {
		list.addAtIndex(0, "0a");
		list.addAtIndex(1, "1a");
		list.addAtIndex(2, "2a");
		list.addAtIndex(3, "3a");
		list.addAtIndex(4, "4a"); // 0a 1a 2a 3a 4a

		assertEquals("0a", list.get(0));
		assertEquals("1a", list.get(1));
		assertEquals("2a", list.get(2));
		assertEquals("3a", list.get(3));
		assertEquals("4a", list.get(4));

		// test index out of bounds above
		try {
			list.get(5);
			fail();
		} catch (Exception e) {
			assertEquals(java.lang.IndexOutOfBoundsException.class, e.getClass());
		}

		// test index out of bounds below
		try {
			list.get(-1);
			fail();
		} catch (Exception e) {
			assertEquals(java.lang.IndexOutOfBoundsException.class, e.getClass());
		}
	}

	@Test(timeout = TIMEOUT)
	public void testIsEmpty() {
		assertEquals(true, list.isEmpty());
		
		list.addAtIndex(0, "0a");
		assertEquals(false, list.isEmpty());
		
		list.removeAtIndex(0);
		assertEquals(true, list.isEmpty());
		
		list.addAtIndex(0, "0a");
		list.addAtIndex(1, "1a");
		assertEquals(false, list.isEmpty());
		
		list.clear();
		assertEquals(true, list.isEmpty());
	}

	@Test(timeout = TIMEOUT)
	public void testClear() {
		list.addAtIndex(0, "0a");
		list.addAtIndex(1, "1a");
		list.addAtIndex(2, "2a");
		list.addAtIndex(3, "3a");
		list.addAtIndex(4, "4a");
		list.addAtIndex(5, "5a"); // 0a 1a 2a 3a 4a 5a

		assertEquals(6, list.size());
		
		list.clear();

		Object[] expected = new Object[ArrayListInterface.INITIAL_CAPACITY];
		assertArrayEquals(expected, list.getBackingArray());
		assertEquals(0, list.size());
	}
}
