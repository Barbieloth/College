package org.college.practice_work_17;

public class MyList {
    public static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    private int size;

    public MyList() {
        this.head = null;
        this.size = 0;
    }

    public void add(String element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(element);
        }
        size++;
    }

    public void add(int index, String element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if(index == 0) {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = findNodeByIndex(index - 1);
            Node newNode = new Node(element);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public String remove(int index) {
        checkIndex(index);
        String removedValue;

        if(index == 0) {
            removedValue = head.data;
            head = head.next;
        } else  {
            Node prev = findNodeByIndex(index - 1);
            removedValue = prev.next.data;
            prev.next = prev.next.next;
        }
        size--;
        return removedValue;
    }

    public String get(int index) {
        checkIndex(index);
        return findNodeByIndex(index).data;
    }

    public int size() {
        return size;
    }

    private Node findNodeByIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
