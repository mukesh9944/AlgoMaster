package com.mukesh.algorithm.twopointer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MoveZeros {

    private static void moveZeros(List<Integer> nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.size(); fast++) {
            if(nums.get(fast) != 0){
                nums.set(slow, nums.get(fast));
                if(slow != fast) {
                    nums.set(fast, 0);
                }
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        moveZeros(numbers);
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
