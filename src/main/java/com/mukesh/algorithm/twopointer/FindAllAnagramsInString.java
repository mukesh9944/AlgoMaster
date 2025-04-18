package com.mukesh.algorithm.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindAllAnagramsInString {

    private static List<Integer> findAllAnagramsInString(String original, String check) {
        int originalLength = original.length();
        int checkLength = check.length();
        if(checkLength > originalLength) return List.of();
        List<Integer> result = new ArrayList<>();

        int [] window = new int[26];
        int [] checkWindow = new int[26];

        for (int i = 0; i < checkLength; i++) {
            window[original.charAt(i) - 'a']++;
            checkWindow[check.charAt(i) - 'a']++;
        }
        if(Arrays.equals(window, checkWindow)) {
            result.add(0);
        }

        for (int right = checkLength; right < originalLength; right++) {
            int left = right - checkLength;
            window[original.charAt(right) - 'a']++;
            window[original.charAt(left) - 'a']--;
            if(Arrays.equals(window, checkWindow)) {
                result.add(left+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> allAnagramsInString = findAllAnagramsInString(scanner.nextLine(), scanner.nextLine());
        System.out.println(allAnagramsInString.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
