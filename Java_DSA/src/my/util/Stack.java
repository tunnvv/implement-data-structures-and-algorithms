package my.util;

import java.util.NoSuchElementException;

public class Stack<E> {
    private Object[] arr;
    private int N = 0;

    public Stack(){
        arr = new Object[4];
    }

    public Stack(int capacity) {
        arr = new Object[capacity];
    }

    private void reSize(int max) {
        Object[] aux = new Object[max];
        for (int i = 0; i < N; i++) {
            aux[i] = arr[i];
        }
        arr = aux;
        aux = null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(E element) {
        if (N == arr.length) {
            reSize(2* N);
        }
        arr[N++] = element;
    }

    public E pop() {
        if (N == 0) throw new NoSuchElementException("Stack underflow");
        Object obj = arr[--N];
        arr[N] = null;
        if (N > 0 && N == arr.length / 4) reSize(arr.length/2);
        return (E) obj;
    }

    public E top() {
        if (N == 0) throw new NoSuchElementException("Stack underflow");
        E e = (E) arr[N-1];
        return e;
    }
}
