import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
/**
 * @author Austen Schunk
 * @version 1.0
 */
public class HashTests<K,V> {

    HashMap<String, String> hashMap = new HashMap<>();
    String[] keys = {"K1", "K2", "K3", "K4", "K5", "K6", "K7", "K8", "K9", "K10", "K11",
                    "K12", "K13", "K14", "K15", "K16", "K17", "K18", "K19", "K20"};
    String[] vals = {"V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10", "V11",
                    "V12", "V13", "V14", "V15", "V16", "V17", "V18", "V19", "V20"};

    @Test
    public void testCreation() {
        HashMap<String, Integer> hash = new HashMap<>();
        MapEntry<String, Integer>[] table = hash.getTable();
        table[0] = new MapEntry("A", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutException() {
        hashMap.put(null, "A1");
    }

    @Test
    public void testAddAllAndSize() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        assertEquals(keys.length, hashMap.size());
    }

    @Test
    public void testAddElementsResizeGreater() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        MapEntry<String,String>[] table = hashMap.getTable();
        assertEquals(55, table.length);
    }

    @Test
    public void testAddDuplicatesOne() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        assertEquals(keys.length, hashMap.size());
    }

    @Test
    public void testAddDuplicatesTwo() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
            hashMap.put(keys[i], vals[i]);            
        }
        assertEquals(keys.length, hashMap.size());
    }

    @Test
    public void testResizeLess() {
        for (int i = 0; i < 9; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        hashMap.resizeBackingTable(10);
        MapEntry<String,String>[] table = hashMap.getTable();
        assertEquals(10, table.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testResizeTooSmall() {
        for (int i = 0; i < 10; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        hashMap.resizeBackingTable(4);
    }

    @Test
    public void testGetSingle() {
        hashMap.put(keys[0], vals[0]);
        String val = hashMap.get(keys[0]);
        assertEquals(vals[0], val);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNull() {
        hashMap.get(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testElementDoesNotExist() {
        hashMap.get("3452345");
    }

    @Test
    public void testAddAndGet20Elements() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        for (int j = 0; j < keys.length; j++) {
            assertEquals(vals[j], hashMap.get(keys[j]));
        }
    }

    // This occurs when table is resized to the number of elements
    @Test(expected = NoSuchElementException.class)
    public void testFullTableGet() {
        for (int i = 0; i < 10; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        hashMap.resizeBackingTable(10);
        hashMap.get("23452345");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNull() {
        hashMap.remove(null);
    }

    @Test
    public void testAddAndRemoveSingle() {
        hashMap.put(keys[0], vals[0]);
        String val = hashMap.remove(keys[0]);
        assertEquals(vals[0], val);
    }


    @Test
    public void testAddAndRemoveAll() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        for (int i = 0; i < keys.length; i++) {
            String val = hashMap.remove(keys[i]);
            assertEquals(vals[i], val);
        }
        MapEntry<String, String>[] table = hashMap.getTable();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                assertEquals(true, table[i].isRemoved());
            }
        }
    }

    @Test
    public void testClearSize() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        hashMap.clear();
        assertEquals(0, hashMap.size());
    }
    @Test
    public void testClearElements() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        hashMap.clear();
        MapEntry<String, String>[] table = hashMap.getTable();
        for (int i = 0; i < table.length; i++) {
            assertEquals(null, table[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsNull() {
        hashMap.containsKey(null);
    }

    @Test
    public void testContainsAll() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        boolean contain;
        for (int j = 0; j < keys.length; j++) {
            contain = hashMap.containsKey(keys[j]);
            assertTrue(contain);
        }
    }

    @Test
    public void testContainsRemoved() {
        hashMap.put(keys[0], vals[0]);
        hashMap.remove(keys[0]);
        assertFalse(hashMap.containsKey(keys[0]));
    }

    @Test
    public void testContainsAllRemoved() {
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        for (int i = 0; i < keys.length; i++) {
            hashMap.remove(keys[i]);
        }
        boolean contain;
        for (int i = 0; i < keys.length; i++) {
            contain = hashMap.containsKey(keys[i]);
            assertFalse(contain);
        }
    }


    @Test
    public void testKeySetSingle() {
        hashMap.put(keys[0], vals[0]);
        Set<String> actual = hashMap.keySet();
        Set<String> expected = new HashSet<>();
        expected.add(keys[0]);
        assertEquals(expected, actual);
    }

    @Test
    public void testKeySetNull() {
        Set<String> actual = hashMap.keySet();
        Set<String> expected = new HashSet<>();
        assertEquals(expected, actual);
    }

    @Test
    public void testKeySetAll() {
        Set<String> expected = new HashSet<>();
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
            expected.add(keys[i]);
        }
        Set<String> actual = hashMap.keySet();
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testValueSingle() {
        hashMap.put(keys[0], vals[0]);
        List<String> actual = hashMap.values();
        List<String> expected = new ArrayList<>();
        expected.add(vals[0]);
        assertEquals(expected, actual);
    }

    @Test
    public void testValueNull() {
        List<String> actual = hashMap.values();
        List<String> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    public void testValuesAll() {
        List<String> expected = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
            expected.add(vals[i]);
        }
        List<String> actual = hashMap.values();
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testValuesResize() {
        List<String> expected = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
            expected.add(vals[i]);
        }
        hashMap.resizeBackingTable(keys.length);

        List<String> actual = hashMap.values();
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testRemovedDuplicates() {
        // Test adds all keys value pairs, then removes half, finally changes
        // the value of the remaining half of the keys 
        List<String> expected = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], vals[i]);
        }
        int partition = keys.length / 2;
        for (int i = 0; i < partition; i++) {
            hashMap.remove(keys[i]);
        }
        String[] newVals = {"N1", "N2", "N3", "N4", "N5", "N6", "N7", "N8", "N9","N10", "N11",
                            "N12", "N13", "N14", "N15", "N16", "N17", "N18", "N19", "N20"};
        for (int i = partition; i < keys.length; i++) {
            hashMap.put(keys[i], newVals[i]);
            expected.add(newVals[i]);
        }
        List<String> actual = hashMap.values();
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }
}