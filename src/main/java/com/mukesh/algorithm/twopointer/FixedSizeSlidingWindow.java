package com.mukesh.algorithm.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FixedSizeSlidingWindow {

    private static int findLargestSumOfSubArraysOfFixedLength(List<Integer> arr, int length) {
        int windowSum = 0;
        for (int i = 0; i < length; i++) {
            windowSum = windowSum + arr.get(i);
        }
        for (int i = length; i < arr.size() ; i++) {
            int sum = windowSum + arr.get(i) - arr.get(i - length);
            windowSum = Math.max(windowSum, sum);
        }
        return windowSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        int length = Integer.parseInt(scanner.nextLine());
        System.out.println(findLargestSumOfSubArraysOfFixedLength(list, length));
    }
}
