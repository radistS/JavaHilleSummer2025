package com.hilllel.cw_08.ex;

public class Ex4 {
    public static void main(String[] args) {
        int numFish = 4;
        String fishType = "tuna";
//        String anotherFish = numFish + 1;
        String anotherFish = numFish + "1";
        int anotherFishI = numFish + 1; // 5
        String str = String.valueOf(numFish + 2);

        System.out.println(anotherFish + " " + fishType);
        System.out.println(anotherFishI + " " + fishType);
        System.out.println(numFish + " " + 1);
        System.out.println(numFish + 1);
        String s = numFish + 1 + "";
        System.out.println(s);
        s = "" + numFish + 1;
        System.out.println(s);
    }
}
