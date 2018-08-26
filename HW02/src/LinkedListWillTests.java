import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListWillTests {
    private LinkedListInterface<String> list;

    public static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testAddStrings() {
        assertEquals(0, list.size());
        assertNull(list.getHead());

        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a
        list.addAtIndex(3, "3a"); //0a 1a 2a 3a

        assertEquals(4, list.size());

        LinkedListNode<String> current = list.getHead();
        assertNotNull(current);
        assertEquals("0a", current.getData());
        assertNull(current.getPrevious());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("1a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("2a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("3a", current.getData());
        assertSame(current, list.getTail());

        assertNull(current.getNext());
    }

    @Test(timeout = TIMEOUT)
    public void testAddStringsFront() {
        assertEquals(0, list.size());

        list.addToFront("0a");
        list.addToFront("1a");
        list.addToFront("2a");
        list.addToFront("3a");
        list.addToFront("4a");
        list.addToFront("5a"); //5a 4a 3a 2a 1a 0a

        assertEquals(6, list.size());

        LinkedListNode<String> current = list.getHead();
        assertNotNull(current);
        assertEquals("5a", current.getData());
        assertNull(current.getPrevious());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("4a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("3a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("2a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("1a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("0a", current.getData());
        assertSame(current, list.getTail());

        assertNull(current.getNext());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveStrings() {
        assertEquals(0, list.size());

        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");
        list.addAtIndex(5, "5a"); //0a 1a 2a 3a 4a 5a

        assertEquals(6, list.size());

        assertEquals("2a", list.removeAtIndex(2)); //0a 1a 3a 4a 5a

        assertEquals(5, list.size());

        LinkedListNode<String> current = list.getHead();
        assertNotNull(current);
        assertEquals("0a", current.getData());
        assertNull(current.getPrevious());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("1a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("3a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("4a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("5a", current.getData());
        assertSame(current, list.getTail());

        assertNull(current.getNext());
    }

    @Test(timeout = TIMEOUT)
    public void testGetGeneral() {
        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a"); //0a 1a 2a 3a 4a

        assertEquals("0a", list.get(0));
        assertEquals("1a", list.get(1));
        assertEquals("2a", list.get(2));
        assertEquals("3a", list.get(3));
        assertEquals("4a", list.get(4));
    }

    @Test(timeout = TIMEOUT)
    public void testToArray() {
        String[] expectedItems = new String[10];

        for (int x = 0; x < expectedItems.length; x++) {
            expectedItems[x] = "a" + x;
            list.addToBack(expectedItems[x]);
        }

        Object[] array = list.toArray();
        assertArrayEquals(expectedItems, array);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void removeFirstOccurrenceNullItemPassed() {
        list.removeFirstOccurrence(null);
    }

    @Test(timeout = TIMEOUT)
    public void testAddToMiddle() {
        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a"); //0a 1a 2a 3a 4a

        list.addAtIndex(2, "2b"); //0a 1a 2b 2a 3a 4a

        LinkedListNode<String> current = list.getHead();
        assertNotNull(current);
        assertEquals("0a", current.getData());
        assertNull(current.getPrevious());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("1a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("2b", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("2a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("3a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("4a", current.getData());
        assertSame(current, list.getTail());

        assertNull(current.getNext());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAll() {
        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a
        list.addAtIndex(3, "3a"); //0a 1a 2a 3a

        assertEquals(4, list.size());

        list.removeAtIndex(0);
        list.removeAtIndex(0);
        list.removeAtIndex(0);

        assertSame(list.getHead(), list.getTail());
        assertNotNull(list.getHead());
        assertEquals(list.removeAtIndex(0), "3a");

        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());

        list.addAtIndex(0, "0b");

        assertEquals("0b", list.get(0));

        assertSame(list.getHead(), list.getTail());
        assertNotNull(list.getHead());
        assertEquals("0b", list.removeFromFront());

        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());

        list.addAtIndex(0, "0c");

        assertSame(list.getHead(), list.getTail());
        assertNotNull(list.getHead());
        assertEquals("0c", list.removeFromBack());

        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFirstOccurrence() {
        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "1a");
        list.addAtIndex(4, "4a"); //0a 1a 2a 1a 4a

        assertEquals(5, list.size());

        assertTrue(list.removeFirstOccurrence("1a"));
        assertArrayEquals(new String[] {"0a", "2a", "1a", "4a"}, list.toArray());
        assertEquals(4, list.size());

        assertTrue(list.removeFirstOccurrence("1a"));
        assertArrayEquals(new String[] {"0a", "2a", "4a"}, list.toArray());
        assertEquals(3, list.size());

        assertFalse(list.removeFirstOccurrence("1a"));
        assertArrayEquals(new String[] {"0a", "2a", "4a"}, list.toArray());
        assertEquals(3, list.size());
    }

    @Test(timeout = TIMEOUT)
    public void testPreviousPointers() {
        list.addAtIndex(0, "0a"); //0a
        list.addAtIndex(1, "1a"); //0a 1a
        list.addAtIndex(2, "2a"); //0a 1a 2a

        //Introduce as many sources of error as possible

        assertEquals(3, list.size());

        list.removeAtIndex(0);
        list.removeAtIndex(0);
        list.removeAtIndex(0);

        assertEquals(0, list.size());

        list.addAtIndex(0, "0b"); //0a
        list.addAtIndex(1, "2b"); //0b 2b

        list.addAtIndex(1, "1b"); //0b 1b 2b

        list.addToBack("3b"); //0b 1b 2b 3b
        list.addToFront("-1b"); //-1b 0b 1b 2b 3b

        assertEquals("1b", list.removeAtIndex(2));

        list.removeFromBack();
        list.removeFromFront(); //0b 2b

        list.addToBack("3c");
        list.addToBack("4c");//0b 2b 3c 4c

        LinkedListNode<String> current = list.getTail();
        assertEquals("4c", current.getData());
        assertNull(current.getNext());

        current = current.getPrevious();
        assertEquals("3c", current.getData());

        current = current.getPrevious();
        assertEquals("2b", current.getData());

        current = current.getPrevious();
        assertEquals("0b", current.getData());
        assertSame(current, list.getHead());
        assertNull(current.getPrevious());

    }
    
    @Test(timeout = TIMEOUT * 10)
    public void testGetTraverseBackwardsWhenEfficient() {
        for (int i = 0; i < 5000; i++) {
            list.addToBack("fooData " + i);
        }

        long t1 = 0;
        long t2 = 0;
        for (int count = 0; count < 25; count++) {

            long start = System.nanoTime();
            assertEquals("fooData 100", list.get(100));
            long stop = System.nanoTime();
            t1 += stop - start;

            start = System.nanoTime();
            assertEquals("fooData 4900", list.get(4900));
            stop = System.nanoTime();
            t2 += stop - start;
        }

        System.out.println(String.format(
                "Remove at index 100 took %d total microseconds",
                t1 / 1000));

        System.out.println(String.format(
                "Remove at index end - 100 took %d total microseconds\n",
                t2 / 1000));

        long diff = Math.abs(t2 - t1);

        assertTrue(Math.abs( diff / Math.min(t2, t1) ) < 3);
    }

    @Test(timeout = TIMEOUT * 10)
    public void testRemoveTraverseBackwardsWhenEfficient() {

        for (int i = 0; i < 5000; i++) {
            list.addToBack("fooData " + i);
        }
        long t1 = 0;
        long t2 = 0;
        for (int count = 0; count < 25; count++) {

            String expected = String.format("fooData %d", 100 + count);
            long start = System.nanoTime();
            assertEquals(expected, list.removeAtIndex(100));
            long stop = System.nanoTime();
            t1 += stop - start;

            expected = String.format("fooData %d", 4900 - count + 1);
            start = System.nanoTime();
            assertEquals(expected, list.removeAtIndex(4900 - 2 * count));
            stop = System.nanoTime();
            t2 += stop - start;
            
        }

        System.out.println(String.format(
                "Remove at index 100 took %d total microseconds",
                t1 / 1000));

        System.out.println(String.format(
                "Remove at index end - 100 took %d total microseconds",
                t2 / 1000));

        long diff = Math.abs(t2 - t1);

        assertTrue(Math.abs( diff / Math.min(t2, t1) ) < 3);
    }
    
    @Test(timeout = TIMEOUT * 10)
    public void testAddTraverseBackwardsWhenEfficient() {

        for (int i = 0; i < 5000; i++) {
            list.addToBack("fooData " + i);
        }
        long t1 = 0;
        long t2 = 0;
        for (int count = 0; count < 25; count++) {

            long start = System.nanoTime();
            list.addAtIndex(100, "Hello world!");
            long stop = System.nanoTime();
            t1 += stop - start;

            start = System.nanoTime();
            list.addAtIndex(4900 + 2 * count, "Hello world!");
            stop = System.nanoTime();
            t2 += stop - start;

        }

        System.out.println(String.format(
                "Add at index 100 took %d total microseconds",
                t1 / 1000));

        System.out.println(String.format(
                "Add at index end - 100 took %d total microseconds",
                t2 / 1000));

        long diff = Math.abs(t2 - t1);

        assertTrue(Math.abs( diff / Math.min(t2, t1) ) < 3);
    }

}
