package com.mukesh.algorithm.binarysearch;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.mukesh.util.AlgorithmUtil.splitWords;

public class FirstElementNotSmallerThanTarget {

    private static int firstElementNotSmallerThanTarget(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid) >= target) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(firstElementNotSmallerThanTarget(arr, target));
    }
}
