import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Simple test cases for heaps and priority queues.
 *
 *
 * @author Ruixuan Sun
 * @version 1.0
 */
public class RuixuanHeapPQTest {

    private static final int TIMEOUT = 200;
    private HeapInterface<Integer> minHeap;
    private PriorityQueueInterface<Integer> minPriorityQueue;

    @Before
    public void setUp() {
        minHeap = new MinHeap<>();
        minPriorityQueue = new MinPriorityQueue<>();
    }

    @Test(timeout = TIMEOUT)
    public void testHeapSpecial() {
        minHeap.add(9);

        Integer[] expected = new Integer[HeapInterface.INITIAL_CAPACITY];
        expected[1] = 9;

        assertArrayEquals(expected,
                ((MinHeap<Integer>) minHeap).getBackingArray());

        assertEquals(new Integer(9), minHeap.remove());
        assertTrue(minHeap.isEmpty());
        Integer[] finalExpected = new Integer[HeapInterface.INITIAL_CAPACITY];
        assertArrayEquals(finalExpected,
                ((MinHeap<Integer>) minHeap).getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testHeapNormal() {
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(15);
        minHeap.add(10);
        minHeap.add(12);
        minHeap.add(17);


        Integer[] expected = new Integer[HeapInterface.INITIAL_CAPACITY];
        expected[1] = 6;
        expected[2] = 7;
        expected[3] = 15;
        expected[4] = 10;
        expected[5] = 12;
        expected[6] = 17;

        assertArrayEquals(expected,
                ((MinHeap<Integer>) minHeap).getBackingArray());

        assertEquals(new Integer(6), minHeap.remove());
        assertEquals(new Integer(7), minHeap.remove());
        assertEquals(4, minHeap.size());
        assertFalse(minHeap.isEmpty());
        assertEquals(new Integer(10), minHeap.remove());
        assertEquals(new Integer(12), minHeap.remove());
        assertEquals(new Integer(15), minHeap.remove());
        assertEquals(new Integer(17), minHeap.remove());

        assertTrue(minHeap.isEmpty());
        Integer[] finalExpected = new Integer[HeapInterface.INITIAL_CAPACITY];
        assertArrayEquals(finalExpected,
                ((MinHeap<Integer>) minHeap).getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testHeapResize() {
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(15);
        minHeap.add(10);
        minHeap.add(12);
        minHeap.add(17);
        minHeap.add(28);
        minHeap.add(33);
        minHeap.add(16);
        minHeap.add(5);
        minHeap.add(69);
        minHeap.add(44);
        minHeap.add(22);
        minHeap.add(29);
        minHeap.add(0);
        minHeap.add(98);
        minHeap.add(66);
        minHeap.add(47);


        Integer[] expected = new Integer[HeapInterface.INITIAL_CAPACITY * 2];
        expected[1] = 0;
        expected[2] = 6;
        expected[3] = 5;
        expected[4] = 10;
        expected[5] = 7;
        expected[6] = 17;
        expected[7] = 15;
        expected[8] = 33;
        expected[9] = 16;
        expected[10] = 12;
        expected[11] = 69;
        expected[12] = 44;
        expected[13] = 22;
        expected[14] = 29;
        expected[15] = 28;
        expected[16] = 98;
        expected[17] = 66;
        expected[18] = 47;

        assertArrayEquals(expected,
                ((MinHeap<Integer>) minHeap).getBackingArray());

        assertEquals(new Integer(0), minHeap.remove());
        assertEquals(new Integer(5), minHeap.remove());
        assertEquals(16, minHeap.size());
        assertFalse(minHeap.isEmpty());
        assertEquals(new Integer(6), minHeap.remove());
        assertEquals(new Integer(7), minHeap.remove());
        assertEquals(new Integer(10), minHeap.remove());
        assertEquals(new Integer(12), minHeap.remove());
        assertEquals(12, minHeap.size());

        assertFalse(minHeap.isEmpty());
        Integer[] finalExpected = new Integer[HeapInterface.INITIAL_CAPACITY * 2];
        finalExpected[0] = null;
        finalExpected[1] = 15;
        finalExpected[2] = 16;
        finalExpected[3] = 17;
        finalExpected[4] = 29;
        finalExpected[5] = 47;
        finalExpected[6] = 22;
        finalExpected[7] = 28;
        finalExpected[8] = 33;
        finalExpected[9] = 98;
        finalExpected[10] = 66;
        finalExpected[11] = 69;
        finalExpected[12] = 44;

        assertArrayEquals(finalExpected,
                ((MinHeap<Integer>) minHeap).getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testPriorityQueue() {
        minPriorityQueue.enqueue(66);
        minPriorityQueue.enqueue(48);
        minPriorityQueue.enqueue(0);
        minPriorityQueue.enqueue(30);
        minPriorityQueue.enqueue(21);

        assertEquals(new Integer(0), minPriorityQueue.dequeue());
        assertEquals(new Integer(21), minPriorityQueue.dequeue());
        assertEquals(3, minPriorityQueue.size());
        assertFalse(minPriorityQueue.isEmpty());
        assertEquals(new Integer(30), minPriorityQueue.dequeue());
        assertEquals(new Integer(48), minPriorityQueue.dequeue());
        assertEquals(new Integer(66), minPriorityQueue.dequeue());
        assertTrue(minPriorityQueue.isEmpty());
    }


    @Test(timeout = TIMEOUT)
    public void testResize() {
        for (int i = 0; i < (HeapInterface.INITIAL_CAPACITY - 1) * 2; i++) {
            minHeap.add(i * i * i - 188);
        }

        assertEquals((HeapInterface.INITIAL_CAPACITY - 1) * 2, minHeap.size());
        assertEquals(HeapInterface.INITIAL_CAPACITY * 2, ((MinHeap<Integer>) minHeap).getBackingArray().length);

        minHeap.add(9 * 9 * (HeapInterface.INITIAL_CAPACITY - 1) - 188);
        minHeap.add(9 * 9 * (HeapInterface.INITIAL_CAPACITY - 1) - 188);

        assertEquals(HeapInterface.INITIAL_CAPACITY * 2, minHeap.size());
        assertEquals(HeapInterface.INITIAL_CAPACITY * 4, ((MinHeap<Integer>) minHeap).getBackingArray().length);
    }
}

