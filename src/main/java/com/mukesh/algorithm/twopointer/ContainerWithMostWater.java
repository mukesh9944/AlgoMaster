package com.mukesh.algorithm.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContainerWithMostWater {

    private static int containerWithMostWater(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(arr.get(left), arr.get(right)) * (right-left);
            maxArea = Math.max(maxArea, area);
            if(arr.get(left) < arr.get(right)){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        System.out.println(containerWithMostWater(arr));
    }
}
