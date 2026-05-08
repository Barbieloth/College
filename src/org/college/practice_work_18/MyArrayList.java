package org.college.practice_work_18;

public class MyArrayList {
    private static final int BLOCK_SIZE = 5;


    public static class Node {
        String[] elements = new String[BLOCK_SIZE];
        int count = 0;
        Node next;

        Node() {}
    }
    private Node head;
    private int totalSize;

    public MyArrayList() {
        head = new Node();
        totalSize = 0;
    }

    public void add(String element) {
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        if (current.count == BLOCK_SIZE) {
            current.next = new Node();
            current = current.next;
        }

        current.elements[current.count++] = element;
        totalSize++;
    }

    public void add(int index, String element) {
        if (index < 0 || index > totalSize) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == totalSize) {
            add(element);
            return;
        }
        Node current = head;
        int remaining = index;
        while (remaining > current.count) {
            remaining -= current.count;
            current = current.next;
        }

        if (current.count < BLOCK_SIZE) {
            System.arraycopy(current.elements, remaining, current.elements, remaining + 1, current.count - remaining);
            current.elements[remaining] = element;
            current.count++;
        } else {
            Node newNode = new Node();
            newNode.next = current.next;
            current.next = newNode;

            int mid = BLOCK_SIZE / 2;
            System.arraycopy(current.elements, mid, newNode.elements, 0, BLOCK_SIZE - mid);
            newNode.count = BLOCK_SIZE - mid;
            current.count = mid;

            add(index, element);
            totalSize--;
        }
        totalSize++;
    }

    public String remove(int index) {
        if (index < 0 || index >= totalSize) throw new IndexOutOfBoundsException("Індекс: " + index);

        Node current = head;
        int remaining = index;
        while (remaining >= current.count) {
            remaining -= current.count;
            current = current.next;
        }

        String removedValue = current.elements[remaining];

        int numMoved = current.count - remaining - 1;
        if (numMoved > 0) {
            System.arraycopy(current.elements, remaining + 1, current.elements, remaining, numMoved);
        }
        current.elements[--current.count] = null;
        totalSize--;

        return removedValue;
    }

    public String get(int index) {
        if (index < 0 || index >= totalSize) throw new IndexOutOfBoundsException("Індекс: " + index);

        Node current = head;
        int remaining = index;
        while (remaining >= current.count) {
            remaining -= current.count;
            current = current.next;
        }
        return current.elements[remaining];
    }

    public int size() {
        return totalSize;
    }

    public int capacity() {
        int nodeCounter = 0;
        Node current = head;
        while (current != null) {
            nodeCounter++;
            current = current.next;
        }
        return nodeCounter * BLOCK_SIZE;
    }

    public String[] getAllElements() {
        String[] all = new String[totalSize];
        int pointer = 0;
        Node current = head;
        while (current != null) {
            for (int i = 0; i < current.count; i++) {
                all[pointer++] = current.elements[i];
            }
            current = current.next;
        }
        return all;
    }
}
