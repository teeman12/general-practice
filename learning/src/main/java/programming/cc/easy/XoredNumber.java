/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.cc.easy;

import java.util.Scanner;

public class XoredNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            if(n==1){
                System.out.println(2);
            }
            else {
                int op = n & (n + 1);

                if (op == 0) {
                    System.out.println(n >> 1);
                } else {
                    System.out.println(-1);
                }
            }

        }
    }
}