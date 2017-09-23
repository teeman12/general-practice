/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package cc.medium;

import java.util.Arrays;
import java.util.Scanner;

public class BitSubSetPairs {
    //no. of bits in 10^6 the max number
    final static int bitSize = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dp;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            dp = new int[1 << bitSize];
            int maxNum = -1;
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                dp[a]++;
                if (maxNum < a) {
                    maxNum++;
                }
            }

            int total = calculate(dp, maxNum);
            System.out.println(total);

        }

    }

    private static int calculate(int[] dp, int maxNum) {
        maxNum = 1 << bitSize;
        int[] numCount = Arrays.copyOf(dp, maxNum);
        for (int i = 0; i < bitSize; i++) {
            for (int j = 0; j < maxNum; j++) {
                if ((j & 1 << i) > 0) {
                    dp[j] += dp[j ^ 1 << i];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < maxNum; i++) {
            dp[i] -= numCount[i];

            sum += numCount[i] * (2 * dp[i] + numCount[i] - 1) / 2;
        }
        return sum;


    }
}
