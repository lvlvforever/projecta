package io.algorithm.secondweek;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author lvlvforever
 * @createTime 2019-02-03 00:33
 * @description
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] buf;
    private int size;

    public RandomizedQueue() {
        buf = (Item[]) new Object[1];
        size = 0;
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            System.err.println(it.next());

        }


    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Item[] resize(int n) {
        Item[] tmp = (Item[]) new Object[n];
        for (int i = 0; i < size; i++) {
            tmp[i] = buf[i];
        }
        return tmp;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (buf.length == size) {
            buf = resize(size * 2);
        }
        buf[size++] = item;

    }

    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int removed = new Random().nextInt(size);
        Item item = buf[removed];
        for (int i = removed + 1; i < size; i++) {
            buf[i - 1] = buf[i];
        }
        size--;
        if (size > 0 && buf.length == 4 * size) {
            buf = resize(buf.length / 2);
        }
        return item;

    }

    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int rand = new Random().nextInt(size);
        return buf[rand];
    }

    @Override
    public Iterator<Item> iterator() {


        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int index = 0;
        private int[] order;

        public ArrayIterator() {
            int n = size;
            int[] index = new int[n];
            for (int i = 0; i < n; i++) {
                index[i] = i;
            }
            order = new int[n];

            for (int i = 0; i < size; i++) {
                int removed = new Random().nextInt(n);
                order[i] = index[removed];
                for (int j = removed + 1; j < n; j++) {
                    index[j - 1] = index[j];
                }
                n--;

            }


        }

        @Override
        public boolean hasNext() {

            return index < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return buf[order[index++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
