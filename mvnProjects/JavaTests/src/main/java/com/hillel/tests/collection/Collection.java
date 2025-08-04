package com.hillel.tests.collection;

public class Collection {

    private String[] array;
    private int size;

    public Collection() {
        this.array = new String[10];
        this.size = 0;
    }

    public boolean add(String o) {
        if (size == array.length) {
            increaseArraySize();
        }
        array[size] = o;
        size++;
        return true;
    }

    public boolean add(int index, String o) {
        if (index > size || index < 0) {
            return false;
        }
        if (size == array.length) {
            increaseArraySize();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = o;
        size++;
        return true;
    }

    public boolean delete(String o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[--size] = null;
                return true;
            }
        }
        return false;
    }

    public String get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    public boolean contain(String o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Collection collection) {
        if (collection == null) {
            return false;
        }
        if (!(collection instanceof Collection)) {
            return false;
        }
        Collection other = (Collection) collection;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (!this.array[i].equals(other.array[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean clear() {
        size = 0;
        return true;
    }

    public int size() {
        int count = 0;
        for (String element : array) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }

    private void increaseArraySize() {
        String[] newArray = new String[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
