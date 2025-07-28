package com.hilllel.cw_10.ex;

public class EX5 {
    public static void main(String[] args) {
        String o = "-";

        System.out.println("FRED".substring(1, 4)); // [ .. )

        switch ("FRED".toLowerCase().substring(1, 4)) { // [ .. )
            case "yellow":
                o += "y";
            case "red":
                o += "f";
            case "green":
                o += "g";
        }
        System.out.println(o);
    }
}
