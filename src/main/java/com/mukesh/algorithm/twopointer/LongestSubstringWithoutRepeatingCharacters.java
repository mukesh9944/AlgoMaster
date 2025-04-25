package com.mukesh.algorithm.twopointer;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {

    private static int longestSubstringWithoutRepeatingCharacters(String str) {
        int left = 0;
        int longestString = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            window.put(str.charAt(right), window.getOrDefault(str.charAt(right), 0) + 1);
            while (window.get(str.charAt(right)) > 1) {
                window.put(str.charAt(left), window.get(str.charAt(left)) - 1);
                left++;
            }
            longestString = Math.max(longestString, right-left + 1);
        }
        return longestString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(longestSubstringWithoutRepeatingCharacters(scanner.nextLine()));
    }

}
