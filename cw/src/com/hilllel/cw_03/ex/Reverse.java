package com.hilllel.cw_03.ex;


// reverse number 111112344 - 443211111
public class Reverse {
    public static void main(String[] args) {

        System.out.println(reverse(123456));
        System.out.println(reverseX2(123456));
    }

    private static int reverse(int value){
        String str = String.valueOf(value);
        char[] chars = str.toCharArray();
        char[] reversedChars = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            reversedChars[reversedChars.length - i - 1] = chars[i];
        }
        return Integer.valueOf(String.valueOf(reversedChars));
    }

    private static int reverseX2(int value){
        String str = String.valueOf(value);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = chars[i];
            chars[i] = temp;
        }
        return Integer.valueOf(String.valueOf(chars));
    }
}


// [0] [1] [2] [3] [4] [5]

/*

1-->  [0] [1] [2] [3] [4] [5]

      [5] [0] [0] [0] [0] [0]
      [5] [4] [0] [0] [0] [0]
        ...
      [5] [4] [3] [2] [1] [0]            // 6 steps

2-->  [0] [1] [2] [3] [4] [5]

      [5] [1] [2] [3] [4] [0] 0 <-> 5
      [5] [4] [2] [3] [1] [0] 1 <-> 4
      [5] [4] [3] [2] [1] [0] 2 <-> 3    // 3 steps

 */
