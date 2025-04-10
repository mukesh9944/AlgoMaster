package com.mukesh.algorithm.binarysearch;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.mukesh.util.AlgorithmUtil.splitWords;

public class FindTheFirstTrueInSortedBooleanArray {

    private static int findFirstTrueInSortedBooleanArray(List<Boolean> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int resultIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid)){
                right = mid - 1;
                resultIndex = mid;
            } else {
                left = mid + 1;
            }
        }

        return resultIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Boolean> arr = splitWords(scanner.nextLine()).stream().map(Boolean::parseBoolean).collect(Collectors.toList());
        scanner.close();
        System.out.println(findFirstTrueInSortedBooleanArray(arr));
    }

}
