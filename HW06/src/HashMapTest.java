import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * HashMapTest
 *
 * @author TAs + someone
 * @version 1.0
 */
public class HashMapTest {

    private HashMap<String, String> directory;
    private HashMap<String, Integer> directory2;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        directory = new HashMap<>();
        directory2 = new HashMap<>();
    }

    @Test(timeout = TIMEOUT)
    public void testPut() {
        directory.put(new String("Jonathan"), "Former TA: 1332");
        assertEquals(1, directory.size());

        //changing the value but keeping the same key should change the value
        directory.put(new String("Jonathan"), "Former TA: 1331");
        assertEquals(1, directory.size());
        assertEquals("Former TA: 1331", directory.get("Jonathan"));

        //trying to add the same key and value
        directory.put(new String("Jonathan"), "Former TA: 1331");
        assertEquals(1, directory.size());
        assertEquals("Former TA: 1331", directory.get("Jonathan"));
    }

    @Test(timeout = TIMEOUT)
    public void testPutResize() {
        assertEquals(13, directory.getTable().length);
        putStuff2();
        assertEquals(27, directory.getTable().length);
    }

    @Test(timeout = TIMEOUT)
    public void testPutOther() {
        putStuff();
        //Set keys = directory.keySet();
        //displays the keys
        //System.out.println(keys);
        //displays the hashcode of the key
        //for (Object s: keys) {
        //  System.out.print(Math.abs(s.hashCode()) % directory.getTable().length + ", ");
        //}
        //System.out.println();
        //displays the hashcode of new string
        //System.out.print(Math.abs(new String("tesu").hashCode()) % 13 + "\n");
        directory.put(new String("tesu"), "HELLO");
        //displays the table
        //System.out.println(Arrays.toString(directory.getTable()));
        //removes jonathan (has the same key location as tesu)
        directory.remove("Jonathan");
        String testOutput = "[null, Mary: Professor: 1332, null, null, null, Monica: Professor: 2050, null, " +
                "null, Raymond: TA: 1332, Ashley: TA: 1332, null, Jonathan: TA: 4400, tesu: HELLO]";
        assertEquals(testOutput, Arrays.toString(directory.getTable()));
        //adds tesu to test to see if duplicates will add or not
        directory.put(new String("tesu"), "THE TEST");

        String testOutput2 = "[null, Mary: Professor: 1332, null, null, null, Monica: Professor: 2050, " +
                "null, null, Raymond: TA: 1332, Ashley: TA: 1332, null, Jonathan: TA: 4400, tesu: THE TEST]";
        assertEquals(testOutput2, Arrays.toString(directory.getTable()));
        //System.out.println(Arrays.toString(directory.getTable()));
        assertFalse(directory.containsKey("Jonathan"));

    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {
        putStuff();
        assertEquals("TA: 4400", directory.remove(new String("Jonathan")));
        assertFalse(directory.containsKey(new String("Jonathan")));
        assertEquals(4, directory.size());
        assertEquals("TA: 1332", directory.remove(new String("Raymond")));
        assertEquals("TA: 1332", directory.remove(new String("Ashley")));
        assertEquals("Professor: 1332", directory.remove(new String("Mary")));
        assertEquals("Professor: 2050", directory.remove(new String("Monica")));
        assertFalse(directory.containsKey(new String("Raymond")));
        assertFalse(directory.containsKey(new String("Ashley")));
        assertFalse(directory.containsKey(new String("Mary")));
        assertFalse(directory.containsKey(new String("Monica")));
        assertEquals(0, directory.size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullInput() {
        directory.remove(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetNullInput() {
        directory.get(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testContainsNullInput() {
        directory.containsKey(null);
    }
    @Test(expected = NoSuchElementException.class)
    public void testRemoveException() {
        directory.remove("");
    }

    @Test(expected = NoSuchElementException.class)
    public void testGet2() {
        directory.get("");
    }

    @Test(timeout = TIMEOUT)
    public void testNoKey() {
        assertFalse(directory.containsKey(""));
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        putStuff();
        assertEquals("TA: 1332", directory.get(new String("Ashley")));
    }

    @Test(timeout = TIMEOUT)
    public void testContainsKey() {
        directory.put(new String("Chad"), "TA: 1332");
        assertTrue(directory.containsKey(new String("Chad")));
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        putStuff();
        directory.clear();
        assertEquals(0, directory.size());
    }

    //these 2 tests printed out the list and set of 10 elements
    @Test (timeout = TIMEOUT)
    public void testKeySet() {
        putStuff2();
        //should print out every key (every name)
        //System.out.println(directory.keySet() + "Should have everything");
        String output = "[Raymond, Bee, Jonathan, Chris, Eric, Ashley, Dave, Frank, Mary, Monica]";
        assertTrue(directory.keySet().toString().equals(output));
    	removeStuff();
    	String output2 = "[Bee, Chris, Eric, Dave, Frank]";
        assertTrue(directory.keySet().toString().equals(output2));
    	//System.out.println(directory.keySet() + "Should only have student");

    }

    @Test (timeout = TIMEOUT)
    public void testList() {
        putStuff2();
        //should print out all the values (ta/professor/student... all of those in the array)
        //System.out.println(directory.values()+ "Everything");
        String output1 = "[Student, Student, Professor: 1332, TA: 1332, Student, " +
                "TA: 1332, TA: 4400, Student, Professor: 2050, Student]";
        assertTrue(directory.values().toString().equals(output1));
    	removeStuff();
    	//System.out.println(directory.values() + " Only the values that are students");
    	String output = "[Student, Student, Student, Student, Student]";
    	assertTrue(directory.values().toString().equals(output));
    }

    @Test (timeout = TIMEOUT)
    public void testResize() {
        //puts 5 elements into array
        putStuff();
        //resizes it to 5 elements so this should be fine
        directory.resizeBackingTable(5);
        assertEquals(5, directory.size());

    }

    @Test (timeout = TIMEOUT)
    public void testResizeWRemove() {
        putStuff2();
        directory.remove("Raymond");
        directory.remove("Jonathan");
        assertEquals(8, directory.size());
        directory.resizeBackingTable(8);
        //System.out.println(Arrays.toString(directory.getTable()));
        //this is to resize the backing array to 8
        //there should only be 8 elements
        assertEquals(8, directory.getTable().length);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testResizeSmallerLength() {
        putStuff2();
        directory.resizeBackingTable(2);
    }
    /**
     * Put a baseline of items to the hash map.
     */
    private void putStuff() {
        directory.put(new String("Raymond"), "TA: 1332");
        directory.put(new String("Jonathan"), "TA: 4400");
        directory.put(new String("Ashley"), "TA: 1332");
        directory.put(new String("Mary"), "Professor: 1332");
        directory.put(new String("Monica"), "Professor: 2050");
    }

    /**
     * adding more elements to hashmap to test resize of loadfactor of initial capactiy.
     */
    private void putStuff2() {
        putStuff();
        directory.put(new String("Bee"), "Student");
        directory.put(new String("Chris"), "Student");
        directory.put(new String("Dave"), "Student");
        directory.put(new String("Eric"), "Student");
        directory.put(new String("Frank"), "Student");
    }

    private void removeStuff() {
        directory.remove("Raymond");
        directory.remove("Jonathan");
        directory.remove("Mary");
        directory.remove("Ashley");
        directory.remove("Monica");
    }
}
