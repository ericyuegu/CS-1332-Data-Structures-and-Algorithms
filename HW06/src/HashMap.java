import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * Your implementation of HashMap.
 * 
 * @author Yue Gu
 * @userid ygu65
 * @GTID 903055355
 * @version 1.0
 */
public class HashMap<K, V> implements HashMapInterface<K, V> {

    // Do not make any new instance variables.
    private MapEntry<K, V>[] table;
    private int size;

    /**
     * Create a hash map with no entries. The backing array has an initial
     * capacity of {@code INITIAL_CAPACITY}.
     *
     * Do not use magic numbers!
     *
     * Use constructor chaining.
     */
    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Create a hash map with no entries. The backing array has an initial
     * capacity of {@code initialCapacity}.
     *
     * You may assume {@code initialCapacity} will always be positive.
     *
     * @param initialCapacity initial capacity of the backing array
     */
    public HashMap(int initialCapacity) {
        table = new MapEntry[initialCapacity];
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        V result = null;

        if (key == null || value == null)   {
            throw new IllegalArgumentException("Cannot insert null data");
        } else if (((double) size + 1) / table.length > MAX_LOAD_FACTOR)    {
            this.regrow();
            result = put(key, value);
        } else  {
            int index = Math.abs(key.hashCode()) % table.length;
            if (table[index] != null)   {
                //if map exists at index in table and key matches
                if (table[index].getKey().equals(key))  {
                    result = table[index].getValue();
                    table[index].setValue(value);
                    if (table[index].isRemoved())   {
                        result = null;
                        table[index].setRemoved(false);
                        size++;
                    }
                //if map exists at index in table but key doesn't match
                } else  {
                    int probe = index + 1;
                    probe = probe % table.length;
                    int firstRemoved = -1;
                    while (table[probe] != null && probe != index)   {
                        if (table[probe].getKey().equals(key))  {
                            result = table[probe].getValue();
                            table[probe].setValue(value);
                            if (table[probe].isRemoved())   {
                                result = null;
                                table[probe].setRemoved(false);
                                size++;
                            }
                            return result;
                        }
                        if (table[probe].isRemoved()) {
                            if (firstRemoved < 0) {
                                firstRemoved = probe;
                            }
                        }
                        probe++;
                        probe = probe % table.length;
                    }
                    MapEntry<K, V> newEntry = new MapEntry<>(key, value);
                    if (firstRemoved >= 0)   {
                        table[firstRemoved] = newEntry;
                    } else  {
                        table[probe] = newEntry;
                    }
                    size++;
                }
            //if map doesn't exist at index, create new MapEntry
            } else  {
                MapEntry<K, V> newEntry = new MapEntry<>(key, value);
                table[index] = newEntry;
                size++;
            }
        }

        return result;
    }

    /**
     * Regrows the backing array to 2 * length + 1 and remaps the keys
     */
    private void regrow()   {
        MapEntry<K, V>[] oldArray = table;
        size = 0;
        table = new MapEntry[2 * oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != null) {
                put(oldArray[i].getKey(), oldArray[i].getValue());
            }
        }
    }

    @Override
    public V remove(K key) {
        V result;
        if (key == null)    {
            throw new IllegalArgumentException("Cannot remove null key");
        }

        int index = Math.abs(key.hashCode()) % table.length;
        if (table[index] != null)   {
            int probe = index;
            do  {
                if (table[probe].getKey().equals(key))  {
                    if (!table[probe].isRemoved()) {
                        result = table[probe].getValue();
                        table[probe].setRemoved(true);
                        size--;
                        return result;
                    } else  {
                        throw new java.util.NoSuchElementException("Key does "
                                + "not exist");
                    }
                }
                probe++;
                probe = probe % table.length;
            } while ((table[probe] != null) && probe != index);
            throw new java.util.NoSuchElementException("Key does not exist");
        } else  {
            throw new java.util.NoSuchElementException("Key does not exist");
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Cannot get null key.");
        } else if (this.containsKey(key))   {
            Set<MapEntry<K, V>> entrySet = this.entrySet();
            for (MapEntry<K, V> entry : entrySet) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        } else  {
            throw new java.util.NoSuchElementException("Key not found.");
        }
        return null;
    }

    /**
     * Helper method that converts map to a set with each entry
     * @return the set containing each entry
     */
    private Set<MapEntry<K, V>> entrySet()  {
        Set<MapEntry<K, V>> entrySet = new HashSet<MapEntry<K, V>>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (!table[i].isRemoved())  {
                    MapEntry<K, V> curr = table[i];
                    entrySet.add(curr);
                }
            }
        }
        return entrySet;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null)    {
            throw new IllegalArgumentException("Cannot search for null key");
        }
        boolean result = false;
        Set<K> keySet = this.keySet();
        if (keySet.contains(key)) {
            result = true;
        }
        return result;
    }

    @Override
    public void clear() {
        table = new MapEntry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<K>();
        Set<MapEntry<K, V>> entrySet = this.entrySet();
        for (MapEntry<K, V> entry : entrySet) {
            keySet.add(entry.getKey());
        }
        return keySet;
    }

    @Override
    public List<V> values() {
        ArrayList<V> valueList = new ArrayList<V>();
        Set<MapEntry<K, V>> entrySet = this.entrySet();
        for (MapEntry<K, V> entry : entrySet) {
            valueList.add(entry.getValue());
        }
        return valueList;
    }

    @Override
    public void resizeBackingTable(int length) {
        if (length < 0 || length < size)    {
            throw new IllegalArgumentException("Length cannot be negative "
                    + "or less than the number of items in the hash map");
        }
        MapEntry<K, V>[] oldTable = table;
        table = new MapEntry[length];
        for (int i = 0; i < oldTable.length; i++)  {
            if (oldTable[i] != null)   {
                if (!oldTable[i].isRemoved())   {
                    resizeHelper(table, oldTable[i].getKey(),
                            oldTable[i].getValue());
                }
            }
        }
    }

    /**
     * Helper method adds key-value pair to target table without array
     * length checks
     * @param table target table to add entry
     * @param key entry key
     * @param value entry value
     */
    private void resizeHelper(MapEntry<K, V>[] table, K key, V value) {
        int index = Math.abs(key.hashCode()) % table.length;
        if (table[index] != null)   {
            //if map exists at index in table and key matches
            if (table[index].getKey().equals(key))  {
                table[index].setValue(value);
            //if map exists at index in table but key doesn't match
            } else  {
                int probe = index + 1;
                probe = probe % table.length;
                while ((table[probe] != null)
                        && probe != index)   {
                    if (table[probe].getKey().equals(key))  {
                        table[probe].setValue(value);
                    }
                    probe++;
                    probe = probe % table.length;
                }
                MapEntry<K, V> newEntry = new MapEntry<>(key, value);
                table[probe] = newEntry;
            }
            //if map doesn't exist at index, create new MapEntry
        } else  {
            MapEntry<K, V> newEntry = new MapEntry<>(key, value);
            table[index] = newEntry;
        }
    }
    
    @Override
    public MapEntry<K, V>[] getTable() {
        // DO NOT EDIT THIS METHOD!
        return table;
    }

}
