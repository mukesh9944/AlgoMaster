package com.mukesh.algorithm.binarysearch;

import com.mukesh.util.AlgorithmUtil;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindMinimumInRotatedSortedArray {

    private static int findMinimumInRotatedSortedArray(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid-1) > arr.get(mid)) {
                result = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = AlgorithmUtil.splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(findMinimumInRotatedSortedArray(arr));
    }
}
