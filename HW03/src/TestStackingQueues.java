/**
 * @author LUKA DERADO
 *
 *      These basic tests should meet all requirements.
 *
 */

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class TestStackingQueues {

    StackInterface stack;
    QueueInterface queue;
    public static final int TIMEOUT = 200;

    //  1) LINKED STACK
    @Test(timeout = TIMEOUT)
    public void testLinkedStackCreate(){
        stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(0,stack.size());
    }
    @Test(timeout = TIMEOUT)
    public void testLinkedStackPushPop(){
        stack = new LinkedStack<Integer>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(5,stack.size());
        assertEquals(4,stack.pop());
        assertEquals(4,stack.size());
        assertEquals(3,stack.pop());
        assertEquals(3,stack.size());
        assertEquals(2,stack.pop());
        assertEquals(2,stack.size());
        assertEquals(1,stack.pop());
        assertEquals(1,stack.size());
        assertEquals(0,stack.pop());
        assertEquals(0,stack.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLinkedStackPushNull(){
        stack = new LinkedStack<Integer>();
        stack.push(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testLinkedStackPopEmpty(){
        stack = new LinkedStack<Integer>();
        stack.pop();
    }

    //  2) ARRAY STACK
    @Test(timeout = TIMEOUT)
    public void testArrayStackCreate(){
        stack = new ArrayStack();
        assertTrue(stack.isEmpty());
        assertEquals(0,stack.size());
    }
    @Test(timeout = TIMEOUT)
    public void testArrayStackPushPop(){
        stack = new ArrayStack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(5,stack.size());
        assertEquals(4,stack.pop());
        assertEquals(4,stack.size());
        assertEquals(3,stack.pop());
        assertEquals(3,stack.size());
        assertEquals(2,stack.pop());
        assertEquals(2,stack.size());
        assertEquals(1,stack.pop());
        assertEquals(1,stack.size());
        assertEquals(0,stack.pop());
        assertEquals(0,stack.size());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayStackResizing(){
        stack = new ArrayStack();
        for(int i = 0; i < 40;i++){
            stack.push(i);
        }
        assertEquals(40, stack.size());
        for(int i = 39; i > 0; i--){
            assertEquals(i,stack.pop());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayStackPushNull(){
        stack = new ArrayStack();
        stack.push(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testArrayStackPopEmpty(){
        stack = new ArrayStack();
        stack.pop();
    }

    //  3) LINKED QUEUE
    @Test(timeout = TIMEOUT)
    public void testLinkedQueueCreate(){
        queue = new LinkedQueue<>();
        assertTrue(queue.isEmpty());
        assertEquals(0,queue.size());
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueueOnAndOff(){
        queue = new LinkedQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(5,queue.size());
        assertEquals(1,queue.dequeue());
        assertEquals(4,queue.size());
        assertEquals(2,queue.dequeue());
        assertEquals(3,queue.size());
        assertEquals(3,queue.dequeue());
        assertEquals(2,queue.size());
        assertEquals(4,queue.dequeue());
        assertEquals(1,queue.size());
        assertEquals(5,queue.dequeue());
        assertEquals(0,queue.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLinkedQueueEnqueueNull(){
        queue = new LinkedQueue<Integer>();
        queue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testLinkedQueueDequeueEmpty(){
        queue = new LinkedQueue<Integer>();
        queue.dequeue();
    }
    //  4) ARRAY QUEUE
    @Test(timeout = TIMEOUT)
    public void testArrayQueueCreate(){
        queue = new ArrayQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0,queue.size());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueueOnAndOff(){
        queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(5,queue.size());
        assertEquals(1,queue.dequeue());
        assertEquals(4,queue.size());
        assertEquals(2,queue.dequeue());
        assertEquals(3,queue.size());
        assertEquals(3,queue.dequeue());
        assertEquals(2,queue.size());
        assertEquals(4,queue.dequeue());
        assertEquals(1,queue.size());
        assertEquals(5,queue.dequeue());
        assertEquals(0,queue.size());
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueueResizing(){
        queue = new ArrayQueue();
        for(int i = 0; i < 40;i++){
            queue.enqueue(i);
        }
        assertEquals(40, queue.size());
        for(int i = 0; i < 40; i++){
            assertEquals(i,queue.dequeue());
        }
    }

    //It's a O(N^2) test, but it should be fine.
    @Test(timeout = TIMEOUT)
    public void testArrayQueueCrawling(){
        queue = new ArrayQueue();
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                queue.enqueue(i);
            }
            assertEquals(7, queue.size());
            for (int j = 0; j < 7; j++) {
                assertEquals(i, queue.dequeue());
            }
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void testArrayQueueEnqueueNull(){
        queue = new ArrayQueue();
        queue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testArrayQueueDequeueEmpty(){
        queue = new ArrayQueue();
        queue.dequeue();
    }
}
