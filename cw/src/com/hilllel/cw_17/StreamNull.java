package com.hilllel.cw_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StreamNull {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(null);
        list.add("d");

        List<Pair> pairs = list.stream()
                .filter(Objects::nonNull)
                .map(w -> new Pair(w, w.toUpperCase()))
                .toList();

        System.out.println(pairs);
    }

}

class Pair {
    private String lCase;
    private String uCase;

    public Pair(String lCase, String uCase) {
        this.lCase = lCase;
        this.uCase = uCase;
    }

    public String getlCase() {
        return lCase;
    }

    public void setlCase(String lCase) {
        this.lCase = lCase;
    }

    public String getuCase() {
        return uCase;
    }

    public void setuCase(String uCase) {
        this.uCase = uCase;
    }

    @Override
    public String toString() {
        return lCase + " : " + uCase;
    }
}
