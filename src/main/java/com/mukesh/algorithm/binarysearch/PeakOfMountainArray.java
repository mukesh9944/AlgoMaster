package com.mukesh.algorithm.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PeakOfMountainArray {

    private static int peakOfMountainArray(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(mid < arr.size() && arr.get(mid) > arr.get(mid+1)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //List<Integer> arr = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(arr);
        System.out.println(peakOfMountainArray(arr));
    }
}

