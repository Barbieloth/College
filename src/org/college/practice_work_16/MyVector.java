package org.college.practice_work_16;

public class MyVector {
    private String[] elements;
    private int size;
    private static final int default_capacity = 10;

    public MyVector() {
        elements = new String[default_capacity];
        size = 0;
    }

    public void add(String element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public void add(int index, String element) {
        checkIndexForAdd(index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public String remove(int index) {
        checkIndex(index);
        String removed = elements[index];
        int numMoved = size - index - 1;
        if (numMoved>0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removed;
    }

    public String get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return elements.length;
    }

    public void ensureCapacity() {
        if (size == elements.length) {
            int new_capacity = (int) (default_capacity * 2);
            String[] newData = new  String[new_capacity];
            System.arraycopy(elements, 0, newData, 0, size);
            elements = newData;
            System.out.println("\nБуфер переповнено. Нова ємність: " + new_capacity);
        }

    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Помилка! Індекс: " + index + ", а розмір вектора: " + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неможливо додати за індексом " + index + " при розмірі " + size);
        }
    }
}
