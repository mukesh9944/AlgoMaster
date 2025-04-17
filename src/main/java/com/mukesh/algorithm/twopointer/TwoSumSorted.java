package com.mukesh.algorithm.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TwoSumSorted {

    private static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size()-1;
        while (left <= right) {
            int sum = arr.get(left) + arr.get(right);
            if( sum == target) {
                return List.of(left,right);
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return List.of();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(twoSumSorted(arr, target).stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
