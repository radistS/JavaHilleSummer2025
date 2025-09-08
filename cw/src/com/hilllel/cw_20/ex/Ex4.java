package com.hilllel.cw_20.ex;

public class Ex4 {
    public static void main(String[] args) {
//        String str = "BEVERAGEGREEFTE" ;
        String str = "BEVERAGE " ;
        String [] arr = str.split( "E", 3);
//        String [] arr = str.split( "E");
        System. out .println(String. join ( "." , arr));
    }
}

