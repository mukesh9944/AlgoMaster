package com.mukesh.algorithm.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SlidingWindowShortest {

    private static int subarraySumShortest(List<Integer> arr, int target) {
        int left = 0;
        int smallest = arr.size();
        int sum = 0;
        for (int right = 0; right < arr.size(); right++) {
            sum += arr.get(right);
            while(sum >= target){
                smallest = Math.min(smallest, right-left+1);
                sum -= arr.get(left);
                left++;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        int target = Integer.parseInt(scanner.nextLine());
        System.out.println(subarraySumShortest(list, target));
    }
}
