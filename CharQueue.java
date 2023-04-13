/*
    Name: Christian Guerra
    PID:  A17660168
 */

import java.util.NoSuchElementException;

/**
 * dsc30sp23-pa2
 *
 * @author chguerra
 * @since April 11th, 2023
 */

public class CharQueue {
    /* instance variables, feel free to add more if you need */
    private char[] circularArray;
    private int length;
    private int front;
    private int rear;
    private int size;

    public CharQueue() {
        this(5);
    }

    public CharQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        this.length = capacity;
        this.circularArray = new char[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (rear >= front) {
            size =  rear - front + 1;
            return size;
        } else {
            size = length - front + rear + 1;
            return size;
        }
    }

    public void clear() {
        rear = -1;
        front = 0;
    }

    public void enqueue(char elem) {
        if (size() >= length) {
            char[] newCircularArray = new char[length * 2];
            if (front <= rear) {
                System.arraycopy(circularArray, front, newCircularArray, 0, rear - front + 1);
            } else {
                System.arraycopy(circularArray, front, newCircularArray, 0, length - front);
                System.arraycopy(circularArray, 0, newCircularArray, length - front, rear + 1);
            }
            circularArray = newCircularArray;
            front = 0;
            rear = length - 1;
        }
        rear = (rear + 1) % length;
        circularArray[rear] = elem;
    }

    public char peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return circularArray[front];
    }

    public char dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else {
            char element = circularArray[front];
            front = (front + 1) % length;
            size--;
            return element;
        }

    }
}