package com.hilllel.cw_16.ex;
public class Ex4 {
    public static void main(String[] args) {
        String javaworld = "JavaWorld";
        String java = "Java"; // string poll
        String world = "World"; // String poll
        java += world; // new Object
//        java = java.intern(); // -> to string pool

        System.out.println(java == javaworld);
        System.out.println(java.equals(javaworld));
    }
}
