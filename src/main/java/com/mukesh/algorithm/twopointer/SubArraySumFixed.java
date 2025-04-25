package com.mukesh.algorithm.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubArraySumFixed {

    private static int findLargestSubArraysSum(List<Integer> arr, int length) {
        int result = 0;
        for (int right = 0; right < length; right++) {
            result += arr.get(right);
        }
        for (int right = length; right < arr.size(); right++) {
            int windowSum = result + arr.get(right) - arr.get(right - length);
            result = Math.max(result, windowSum);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        int length = Integer.parseInt(scanner.nextLine());
        System.out.println(findLargestSubArraysSum(list, length));
    }
}
