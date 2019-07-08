package io.algorithm.secondweek;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author lvlvforever
 * @createTime 2019-02-02 23:58
 * @description
 */
public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;

    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.err.println(deque.size);
        System.err.println(deque.removeFirst());
        System.err.println(deque.removeFirst());
        System.err.println(deque.removeLast());
        System.err.println(deque.removeLast());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node cur = new Node();
        cur.item = item;
        if (size == 0) {
            head = cur;
            tail = cur;
        } else {

            Node oldFirst = head;
            head = cur;
            cur.next = oldFirst;
            oldFirst.pre = cur;
        }

        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node cur = new Node();
        cur.item = item;
        if (size == 0) {
            head = cur;
            tail = cur;
        } else {

            Node oldLast = tail;
            tail = cur;
            cur.pre = oldLast;
            oldLast.next = cur;
        }
        size++;
    }

    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node first = head;
        head = head.next;
        first.next = null;
        if (size == 1) {
            tail = null;
        }
        size--;
        return first.item;

    }

    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node last = tail;
        tail = tail.pre;
        last.pre = null;
        if (size == 1) {
            head = null;
        }
        size--;
        return last.item;

    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
        Node pre;
    }

    private class ListIterator implements Iterator<Item> {
        private Node cur = head;

        @Override
        public boolean hasNext() {

            return cur != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = cur.item;
            cur = cur.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}
