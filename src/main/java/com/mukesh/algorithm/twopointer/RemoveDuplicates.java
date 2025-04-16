package com.mukesh.algorithm.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    private static int removeDuplicates(List<Integer> arr) {
        int slow = 0;
        for (int fast = 1; fast < arr.size(); fast++) {
            if(!arr.get(slow).equals(arr.get(fast))){
                slow++;
                arr.set(slow, arr.get(fast));
            }
        }
        System.out.println(arr);
        return slow+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(removeDuplicates(arr));
    }
}
