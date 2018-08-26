import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * HashMapStudentTests
 *
 * @author Aadarsh Padiyath
 * @version 1.0
 */
public class HashMapAadarshTests {

    private HashMap<Integer, String> directory;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        directory = new HashMap<>();
    }

    @Test(timeout = TIMEOUT)
    public void testConstructor() {
        assertEquals(directory.getTable().length, 13);
        assertEquals(directory.size(), 0);
    }

    @Test(timeout = TIMEOUT)
    public void testConstructor2() {
        directory = new HashMap<>(1);
        assertEquals(directory.getTable().length, 1);
        assertEquals(directory.size(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutException() {
        directory.put(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutException2() {
        directory.put(123, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutException3() {
        directory.put(null, "Taylor Swift");
    }

    @Test(timeout = TIMEOUT)
    public void testResizeInPut() {
        directory = new HashMap<>(2);
        directory.put(1, "Beyonce");
        assertEquals(directory.size(), 1);
        assertEquals(directory.getTable().length, 2);
        directory.put(2, "Onika");
        assertEquals(directory.size(), 2);
        assertEquals(directory.getTable().length, 5);
        directory.put(1, "Queen Bey");
        directory.put(2, "Queen of Rap");
        directory.put(3, "World Stop");
        assertEquals(directory.size(), 3);
        directory.put(4, "Carry On");
        assertEquals(directory.size(), 4);
        assertEquals(directory.getTable().length, 11);

    }

    @Test(timeout = TIMEOUT)
    public void testPut() {
        assertEquals(null, directory.put(new Integer(10), "10"));
        assertEquals(1, directory.size());
    }

    @Test(timeout = TIMEOUT)
    public void testPutForRemoved() {
        directory = new HashMap<>(10);
        assertEquals(null, directory.put(1, "Tinky-Winky"));
        assertEquals(null, directory.put(2, "Dipsy"));
        assertEquals(null, directory.put(11, "Laa-Laa"));
        assertEquals(null, directory.put(12, "Po"));
        assertEquals(4, directory.size());
        assertEquals("Dipsy", directory.remove(2));
        assertEquals(true, directory.getTable()[2].isRemoved());
        assertEquals(3, directory.size());
        assertEquals(null, directory.put(2, "Tipsy"));
        assertEquals(false, directory.getTable()[2].isRemoved());
        assertEquals(4, directory.size());
    }

    @Test(timeout = TIMEOUT)
    public void testNegativeHashcode() {
        HashMap<Double, String> negHash = new HashMap<>(1);
        assertEquals(null,
                negHash.put(2147483647.0, "Make sure your hashcode allows for negative hashcodes"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemove() {
        directory = new HashMap<>(10);
        assertEquals(null, directory.put(0, "I'm out in the club"));
        assertEquals(null, directory.put(10, "And I'm sippin' that bub"));
        assertEquals(null, directory.put(20, "And you're not going to reach my telephone!"));
        assertEquals(null, directory.put(30, "We're sorry"));
        assertEquals(null, directory.put(40, "The number you have reached is not in service at this time"));
        assertEquals(null, directory.put(50, "Please check the number or try the call again."));
        assertEquals(6, directory.size());
        assertEquals("We're sorry", directory.remove(30));
        assertTrue(directory.getTable()[3].isRemoved());
        assertEquals("I'm out in the club", directory.remove(0));
        assertTrue(directory.getTable()[0].isRemoved());
        directory.remove(30);
    }

    @Test(timeout = TIMEOUT)
    public void testUpdatePut() {
        directory = new HashMap<>(10);
        assertEquals(null, directory.put(11, "covfefe"));
        assertEquals("covfefe", directory.put(11, "Bish wtf"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGet() {
        directory = new HashMap<>(5);
        assertEquals(null, directory.put(0, "Swish Swish Bish"));
        assertEquals("Swish Swish Bish", directory.get(0));
        directory.get(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetException() {
        directory.get(420);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetException2() {
        assertEquals(null, directory.put(420, "heheheh"));
        assertEquals("heheheh", directory.remove(420));
        directory.get(420);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsKey() {
        directory.put(new Integer(666), "The devil's number, or Taylor Swift's phone number");
        assertTrue(directory.containsKey(new Integer(666)));
        assertFalse(directory.containsKey(69));
        directory.containsKey(null);
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        directory = new HashMap<>(10);
        assertEquals(null, directory.put(1, "Spice"));
        assertEquals(null, directory.put(2, "Posh"));
        assertEquals(null, directory.put(11, "Baby"));
        assertEquals(null, directory.put(12, "Scary"));
        assertEquals(null, directory.put(0, "Vannila?"));
        assertEquals(5, directory.size());
        directory.clear();
        assertEquals(0, directory.size());
        assertEquals(13, directory.getTable().length);
    }

    @Test(timeout = TIMEOUT)
    public void testKeySet() {
        assertEquals(null, directory.put(1, "Blah"));
        assertEquals(null, directory.put(2, "Blah-di-blah"));
        assertEquals(null, directory.put(3, "Blah-di-blah-di-blah"));
        assertEquals(null, directory.put(4, "Bobert"));
        assertEquals("Bobert", directory.remove(4));
        assertEquals(3, directory.size());
        HashSet<Integer> blahs = new HashSet<>(3);
        blahs.add(1);
        blahs.add(2);
        blahs.add(3);
        assertEquals(blahs, directory.keySet());
    }

    @Test(timeout = TIMEOUT)
    public void testValues() {
        assertEquals(null, directory.put(1, "Blah"));
        assertEquals(null, directory.put(2, "Blah-di-blah"));
        assertEquals(null, directory.put(3, "Blah-di-blah-di-blah"));
        assertEquals(null, directory.put(4, "Bobert"));
        assertEquals("Bobert", directory.remove(4));
        assertEquals(3, directory.size());
        ArrayList<String> blahs = new ArrayList<>(3);
        blahs.add("Blah");
        blahs.add("Blah-di-blah");
        blahs.add("Blah-di-blah-di-blah");
        assertEquals(blahs, directory.values());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testResizeTable() {
        directory = new HashMap<>(4);
        assertEquals(null, directory.put(1, "Sure"));
        assertEquals(null, directory.put(2, "Piggy"));
        assertEquals(2, directory.size());
        assertEquals(4, directory.getTable().length);
        assertEquals(null, directory.put(3, "Babsolutely"));
        assertEquals(9, directory.getTable().length);
        directory.resizeBackingTable(3);
        assertEquals(3, directory.getTable().length);
        assertEquals(3, directory.size());
        directory.resizeBackingTable(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testResizeTableException() {
        directory = new HashMap<>(4);
        directory.resizeBackingTable(-69); //Comment "Potatoe" on Piazza if you get this far :P
    }
}