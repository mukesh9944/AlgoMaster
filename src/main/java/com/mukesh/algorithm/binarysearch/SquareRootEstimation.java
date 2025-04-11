package com.mukesh.algorithm.binarysearch;

import java.util.Scanner;

public class SquareRootEstimation {

    private static int findSquareRoot(int num) {
        int left = 0;
        int right = num/2 + 1;
        int result =-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(mid * mid == num) {
                result = mid;
                right = right -1;
            } else if(mid * mid < num) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(findSquareRoot(num));
    }
}
