package my.util;

public final class Heapq<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n = 0;   // is index of last key;

    public Heapq() {
        pq = (Key[]) new Comparable[1];
    }

    public Heapq(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
    }

    public Heapq(Key[] arr) {
        pq = (Key[]) new Comparable[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            this.push(arr[i]);
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        // Number of non-null values
        return n+1;
    }

    /**
     * Add node at end, then swim it up.
     * Cost. At most 1 + lg(n) compares.
     */
    public void push(Key x) {
        if (n == pq.length -1) {
            reSize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
    }

    /**
     * Exchange root with node at end, then sink it down.
     * Cost. At most 2 lg(n) compares
     */

    public Key pop() {
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;
        if (n >= 0 && n == pq.length / 4 -1) {
            reSize(pq.length / 2);
        }
        return max;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 1; i < n; i++) {
            s.append(pq[i]).append(", ");
        }
        s.append(pq[n]).append("]\n");
        return s.toString();
    }

    /**
     * Exchange key in child with key in parent.
     * Repeat until heap order restored.
     */
    private void swim(int k) {

        //Parent of node at k is k/2
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k /2;
        }
    }

    /**
     * Exchange key in parent with key in larger child
     * Repeat until heap order restored
     */
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;

            //children of node at K are 2*k and 2*k+1
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void reSize(int max) {
        Key[] copy = (Key[]) new Comparable[max];
        for (int i = 0; i <= n; i++) {
            copy[i] = pq[i];
        }
        pq = copy;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
