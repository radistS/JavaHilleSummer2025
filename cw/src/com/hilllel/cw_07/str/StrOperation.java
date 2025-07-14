package com.hilllel.cw_07.str;

public class StrOperation {

    public static void main(String[] args) {
        String str = "qwerty";
        String qwerty = "Qwerty";
//        System.out.println(str.length());
//        System.out.println(qwerty.length());

//        System.out.println(str + str);
//        System.out.println(str.concat(str));
//
//        System.out.println(qwerty.equals(str));
//        System.out.println(qwerty == str);
//        System.out.println(qwerty.equalsIgnoreCase(str));
//
//        System.out.println(qwerty.compareTo(str));
//        System.out.println(str.compareTo(qwerty));
//        System.out.println(str.compareTo(str));
//
//        System.out.println(String.join("---", str, qwerty, str, qwerty));
//
//        System.out.println(str.charAt(str.length() - 1));
//
//        String asdsa = "asdsa";
//        System.out.println(asdsa.indexOf("a"));
//        System.out.println(asdsa.lastIndexOf("a"));
//
//        System.out.println(str.indexOf("a"));
//        System.out.println(str.lastIndexOf("a"));
//
//        System.out.println(str.indexOf("e"));
//        System.out.println(str.lastIndexOf("e"));

        String[] strs = str.split("");

        for (String s : strs) {
            System.out.print(s + " ");
        }

        System.out.println();

        System.out.println(str.startsWith("q"));
        System.out.println(str.startsWith("Q"));

        System.out.println(qwerty.startsWith("q"));
        System.out.println(qwerty.startsWith("Q"));

        System.out.println(str.endsWith("y"));
        System.out.println(qwerty.endsWith("y"));

        System.out.println(str.toUpperCase());
        System.out.println(qwerty.toLowerCase());


        System.out.println(qwerty.toLowerCase().startsWith("q"));

        System.out.println(str.replace("er", "ER"));

        String s = "    aaa   ";
        System.out.println("----------------");
        System.out.println(s.length());
        System.out.println(s.hashCode());
        s = s.trim();
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.hashCode());
//
        // qwerty 2, 3  [ .. )
        System.out.println(str.substring(2, 4));
//
        System.out.println(str.concat(qwerty).substring(4, 9));
    }

}
