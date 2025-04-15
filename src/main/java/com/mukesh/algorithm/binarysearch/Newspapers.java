package com.mukesh.algorithm.binarysearch;

import java.util.*;
import java.util.stream.Collectors;

public class Newspapers {

    private static int newspapersSplit(List<Integer> newsPaperReadTimes, int numCoworkers) {
        int low = Collections.max(newsPaperReadTimes);
        int high = newsPaperReadTimes.stream().mapToInt(Integer::intValue).sum();
        int result = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(feasible(newsPaperReadTimes, numCoworkers, mid)){
                result = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean feasible(List<Integer> newsPaperReadTimes, int numCoworkers, int limit) {
        int numWorkers = 0;
        int time = 0;
        for (Integer readTime:newsPaperReadTimes) {
            if(time + readTime > limit) {
                time = 0;
                numWorkers++;
            }
            time = time + readTime;
        }

        if(time != 0){
            numWorkers++;
        }
        return numWorkers <= numCoworkers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> newsPaperReadTimes = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int numCoworkers = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(newspapersSplit(newsPaperReadTimes, numCoworkers));
    }
}
