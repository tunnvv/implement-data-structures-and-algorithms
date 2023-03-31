package my.util;

public final class LList<E> {
    private Node head;
    private Node tail;
    private int size = 0;
    public LList(){}

    public LList(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.append(arr[i]);
        }
    }

    /**************************************************************************
     *
     *                                         Node newNode = new Node(value);
     *  # head = new Node(value, head)  ===    newNode.next = head
     *                                        head = newNode
     *
     *   cho ngắn nhé :3
     *   code shorter!!
     ***************************************************************************/

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // O(1)
    public void append(E value) {
        if (head == null) {
            head = new Node(value, head);
            tail = head;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    // O(n)
    public void insert(int index, E element) {
        if (index >= 0 && index <= size) {
            size++;
            if (index == 0) {
                head = new Node(element, head);
                return;
            }
            Node run = head;
            while (--index > 0) {
                run = run.next;
            }

            Node newNode = new Node(element, run.next);
            run.next = newNode;
        }
        return;
    }

    public void remove(E item) {
        Node temp;
        if (head.item == item) {
            temp = head;
            head = head.next;
            temp.next = null;
            return;
        }
        Node run = head;
        while (run.next != null) {
            if (run.next.item == item) {
                temp = run.next;
                temp.next = null;
                run.next = run.next.next;
                return;
            }
            run = run.next;
        }

    }

    public void reverse() {
        Node prev = null;
        Node current = null;
        tail = head;
        while (head != null) {
            current = head;
            head = head.next;
            current.next = prev;
            prev = current;
        }
        head = current;
    }

    public int count(E item) {
        int count = 0;
        Node run = head;
        while (run != null) {
            if (run.item == item) {
                count++;
            }
            run = run.next;
        }
        return count;
    }

    public LList copy() {
        LList copy = new LList();
        Node run = head;
        while (run != null) {
            copy.append(run.item);
            run = run.next;
        }
        return copy;
    }

    private class Node<E> {
        private E item;
        private Node next;

        public Node(E item) {
            this.item = item;
            this.next = null;
        }

        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{LinkedList}:[");
        Node run = head;
        while (run != null) {
            str.append(run.item).append(", ");
            run = run.next;
        }
        str.replace(str.length() - 2, str.length(), "]");
        return str.toString();
    }
}