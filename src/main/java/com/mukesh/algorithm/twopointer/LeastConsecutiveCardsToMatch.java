package com.mukesh.algorithm.twopointer;

import java.util.*;

public class LeastConsecutiveCardsToMatch {

    private static int leastConsecutiveCardsToMatch(List<Integer> arr) {
        int left = 0;
        int result = arr.size()+1;
        Map<Integer, Integer> window = new HashMap<>();
        for (int right = 0; right < arr.size(); right++) {
            window.put(arr.get(right), window.getOrDefault(arr.get(right), 0) + 1);
            while (window.get(arr.get(right)) > 1) {
                result = Math.min(result, right-left+1);
                window.put(arr.get(left), window.get(arr.get(left))-1);
                left++;
            }
        }
        return result != arr.size()+1 ? result : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        System.out.println(leastConsecutiveCardsToMatch(list));
    }
}
