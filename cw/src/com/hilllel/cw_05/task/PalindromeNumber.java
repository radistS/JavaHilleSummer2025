package com.hilllel.cw_05.task;
//        Given an integer x, return true if x is a palindrome, and false otherwise.
//
//        Example 1:
//        Input: x = 121
//        Output: true
//        Explanation: 121 reads as 121 from left to right and from right to left.

//        Example 2:
//        Input: x = -121
//        Output: false
//        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

//        Example 3:
//        Input: x = 10
//        Output: false
//        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(112211231));

    }

    private static boolean isPalindrome(int number){
        if (number < 0 || (number % 10 == 0 && number != 0)) {
            return false;
        }

        int reverseNumber = 0;
        int tmp = number;
        while (tmp > 0) {
            reverseNumber = reverseNumber * 10 + tmp % 10;
            tmp /= 10;
        }
        System.out.println(reverseNumber);
        return number == reverseNumber;
    }
}
