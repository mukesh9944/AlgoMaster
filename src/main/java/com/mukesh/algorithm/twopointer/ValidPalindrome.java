package com.mukesh.algorithm.twopointer;

import java.util.List;
import java.util.Scanner;

public class ValidPalindrome {

    private static boolean isValidPalindrome(String str) {
        List<Character> list = str.codePoints().mapToObj(c -> Character.toLowerCase((char) c)).filter(Character::isLetterOrDigit).toList();
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if(list.get(left) != list.get(right)){
                return false;
            }
            left++;
            right--;
        }


        return true;
        /*char[] charArray = str.toLowerCase().toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            while(left < right && !Character.isLetterOrDigit(charArray[left])){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(charArray[right])){
                right--;
            }
            if(charArray[left] != charArray[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;*/
     }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isValidPalindrome(scanner.nextLine()));
    }
}
