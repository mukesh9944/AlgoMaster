package com.mukesh.algorithm.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LargestSubArraySum {

    private static int  findLargestSubArraySum(List<Integer> arr, int target) {
        int left = 0;
        int longestWindow = 0;
        int windowSum = 0;
        for (int right = 0; right < arr.size(); right++) {
            windowSum = windowSum + arr.get(right);
            if(windowSum > target) {
                windowSum = windowSum - arr.get(left);
                left++;
            }
            longestWindow = Math.max(longestWindow, right-left+1);
        }

        return longestWindow;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        int target = Integer.parseInt(scanner.nextLine());
        System.out.println(findLargestSubArraySum(list, target));
    }
}
