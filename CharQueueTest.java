import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CharQueueTest {
    CharQueue testing = new CharQueue(5);
    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertEquals(true, testing.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0, testing.size());
    }


    @org.junit.jupiter.api.Test
    void clear() {
        testing.enqueue('a');
        testing.clear();
        assertEquals(true, testing.isEmpty());
        assertEquals(0, testing.size());
    }

    @org.junit.jupiter.api.Test
    void enqueue() {
        testing.enqueue('z');
        testing.enqueue('a');
        testing.enqueue('b');
        assertEquals(3, testing.size());
        assertEquals('z', testing.peek());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        testing.enqueue('C');
        testing.enqueue('M');
        assertEquals(2, testing.size());
        assertEquals('C', testing.peek());
    }

    @org.junit.jupiter.api.Test
    void dequeue() {
        testing.enqueue('a');
        testing.enqueue('b');
        char removed = testing.dequeue();
        assertEquals('a', removed);
        assertEquals(1, testing.size());
        testing.enqueue('z');
        testing.enqueue('h');
        assertEquals(3, testing.size());
    }

    @org.junit.jupiter.api.Test
    void testCharQueue(){
        assertThrows(IllegalArgumentException.class, () -> {
            CharQueue queue = new CharQueue(-1);
            CharQueue queue2 = new CharQueue(0);
        });
    }
    @org.junit.jupiter.api.Test
    void testPeek(){
        assertThrows(NoSuchElementException.class, () -> {
            CharQueue testing2 = new CharQueue(1);
            testing2.peek();
            CharQueue testing3 = new CharQueue(0);
            testing3.peek();
            CharQueue testing4 = new CharQueue(2);
            testing4.enqueue('a');
            testing4.dequeue();
            testing4.peek();
        });
    }
        /*assertThrows(NoSuchElementException.class, () -> {
            CharQueue testing2 = new CharQueue(1);
            testing2.enqueue('c');
            testing2.dequeue();
            testing2.peek();
        });
    }*/

    @org.junit.jupiter.api.Test
    void testDequeue(){
        assertThrows(NoSuchElementException.class, ()->{
           CharQueue testing = new CharQueue(1);
           testing.dequeue();
        });
    }


}