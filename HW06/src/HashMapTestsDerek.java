import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * HashMapTestsDerek
 *
 * Some edge cases
 *
 * @author Derek
 * @version 1.0
 */
public class HashMapTestsDerek {

    private HashMap<String, String> directory;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        directory = new HashMap<>();
    }

    /**
     * Tests that the load factor is being checked properly
     */
    @Test(timeout = TIMEOUT)
    public void testLoadFactor() {
        directory = new HashMap<>(100);
        for (int i = 0; i < 66; i++) {
            String key = "Key: " + i;
            directory.put(key, "Val: " + i);
            assertEquals(i+1, directory.size());
        }
        assertEquals(100, directory.getTable().length);
        directory.put("67", "(greater than, not greater than or equal to)");
        assertEquals(100, directory.getTable().length);
    }

    /**
     * Tests the put method to make sure it is replacing the right (removed)
     * key
     */
    @Test(timeout = TIMEOUT)
    public void testPutEdgeCase(){
        HashMap<Integer, Integer> intMap = new HashMap<>();
        // collisions at index = 7
        intMap.put(20, 7);
        intMap.put(33, 8);
        intMap.put(46, 9);
        intMap.put(47, 10);
        intMap.put(59, 11);
        assertEquals(5, intMap.size());
        assertEquals((Integer) 8, intMap.remove(33));
        assertEquals((Integer) 9, intMap.remove(46));
        //put closest to intial hashed index
        intMap.put(46, 8);
        MapEntry<Integer, Integer>[] exp = new MapEntry[13];
        exp[7] = new MapEntry<>(20, 7);
        exp[8] = new MapEntry<>(46, 8);
        MapEntry<Integer, Integer> removed = new MapEntry<>(46,9);
        removed.setRemoved(true);
        exp[9] = removed;
        exp[10] = new MapEntry<>(47, 10);
        exp[11] = new MapEntry<>(59, 11);
        assertArrayEquals(exp, intMap.getTable());
    }

    /**
     * Tests the edge case that the array contains no null elements and that
     * the remove will still fail. (makes sure your loop termination is strong)
     */
    @Test(timeout = TIMEOUT, expected = java.util.NoSuchElementException.class)
    public void testRemoveEdge() {
        directory = new HashMap<>(20);
        for (int i = 0; i < 20; i++) {
            String key = "Key: " + i;
            directory.put(key, "Val: " + i);
            assertEquals(i+1, directory.size());
        }
        assertEquals(41, directory.getTable().length);
        directory.resizeBackingTable(20);
        assertEquals(20, directory.getTable().length);
        directory.remove("THIS KEY DOES NOT EXIST");
    }
}
