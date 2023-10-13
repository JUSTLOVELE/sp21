package deque;

/**
 * @author yangzl 2023/10/11
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class LinkedListDeque<T> implements Deque<T> {

    class Node {

        private Node() {

        }

        private Node(T value) {
            this.value = value;
        }

        private Node prev;
        private Node next;
        private T value;
        private String v;
    }

    private int size = 0;
    private Node sentinel;

    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.v = "sentinel";
    }

    /**
     * Same as get, but uses recursion.
     * @param index
     * @return
     */
    public T getRecursive(int index) {

        if (index < 0 || index > size - 1) {
            return null;
        }

        Node n = recurive(sentinel, index);
        return n.value;
    }

    private Node recurive(Node n, int index) {

        if (index < 0) {
            return n;
        }

        return recurive(n.next, index - 1);
    }

    /**
     * Adds an item of type T to the front of the deque
     * @param item
     */
    public void addFirst(T item) {

        Node firstItemNode = new Node(item);
        Node next = sentinel.next;

        if (next != null) {
            next.prev = firstItemNode;
        }

        sentinel.next = firstItemNode;
        firstItemNode.next = next;
        size++;

        if(sentinel.prev == null) {
            sentinel.prev = firstItemNode;
        }
    }

    /**
     * Adds an item of type T to the back of the deque
     * @param item
     */
    public void addLast(T item) {

        Node lastItemNode = new Node(item);
        Node n = sentinel.prev;

        if(n != null) {
            n.next = lastItemNode;
            lastItemNode.prev = n;
            sentinel.prev = lastItemNode;

        }else {
            //第一次插入
            sentinel.prev = lastItemNode;
            sentinel.next = lastItemNode;
        }

        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
//    public boolean isEmpty() {
//
//        if (size == 0) {
//            return true;
//        }
//
//        return false;
//    }

    /**
     * Returns the number of items in the deque.
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {

        Node n = sentinel;
        int index = size;

        while (index > 0) {
            System.out.println(n.next.value + " ");
            n = n.next;
            index--;
        }

        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        Node firstNode = sentinel.next;
        size--;

        if (firstNode.next != null) {

            Node secondNode = firstNode.next;
            sentinel.next = secondNode;
            secondNode.prev = null;

        } else {
            sentinel.next = null;
            sentinel.prev = null;
        }

        return firstNode.value;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        Node lastNode = sentinel.prev;
        Node lastSecondNode = lastNode.prev;

        if(lastSecondNode == null) {
            sentinel.prev = null;
            sentinel.next = null;
        }else{
            sentinel.prev = lastSecondNode;
            lastNode.prev = null;
            lastSecondNode.next = null;
        }

        size--;

        return lastNode.value;
    }

    /**
     *  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    public T get(int index) {

        if (index < 0 || index > size - 1) {
            return null;
        }

        Node lastNode = sentinel.next;

        while (index > 0) {
            lastNode = lastNode.next;
            index--;
        }

        return lastNode.value;
    }
}
