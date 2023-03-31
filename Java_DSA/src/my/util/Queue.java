package my.util;

import java.util.NoSuchElementException;

public class Queue<E> {
    private Node head;
    private Node tail;
    private int size = 0;

    public Queue() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(E element) {
        if (head == null) {
            head = new Node(element);
            tail = head;
        }
        else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size ++;
    }

    public E dequeue() {
        if (head == null) throw new NoSuchElementException("Queue underflow");
        size --;
        if (head == tail) {
            E e = (E) head.element;
            head = tail = null;
            return e;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return (E) temp.element;
    }

    private class Node<E>{
        E element;
        Node next;

        protected Node(E element) {
            this.element = element;
            this.next = null;
        }

        protected Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

    }
}
