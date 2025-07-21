package com.hilllel.cw_09.alCustom;

import java.util.Arrays;

public class CollectionImpl implements Collection{
    private String[] arr;

    public CollectionImpl() {
        arr = new String[0];
    }

    @Override
    public boolean add(String value) {
        return add(arr.length, value);
    }

    @Override
    public boolean add(int index, String value) {
        if (index > arr.length || index < 0) return false;

        String[] newArr = new String[arr.length + 1];
        for (int i = 0, j=0; i < newArr.length; ++i, ++j) {
            if (i == index) {
                newArr[i] = value;
                --j;
                continue;
            }
            newArr[i] = arr[j];
        }
        arr = newArr;
        return true;
    }

    public boolean delete(int index) {
        if (index >= arr.length || index<0) return false;

        String[] newArr = new String[arr.length - 1];
        for (int i = 0, j=0; i < newArr.length; ++i, ++j) {
            if (i == index) {
                ++j;
            }
            newArr[i] = arr[j];
        }
        arr = newArr;

        return true;
    }

    @Override
    public boolean delete(String value) {
        for (int i = 0; i < arr.length; ++i) {
            if(arr[i].equals(value)) {
                return delete(i);
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
        if (index >= arr.length || index<0) return "-1";
        return arr[index];
    }

    @Override
    public boolean contain(String o) {
        for (String s : arr) {
            if (s.equals(o)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        if(arr.length != str.size()) return false;
        for (int i = 0; i < arr.length; ++i) {
            if (!arr[i].equals(str.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean clear() {
        arr = new String[0];
        return true;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public String toString() {
        return "arr=" + Arrays.toString(arr);
    }
}
