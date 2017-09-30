/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.cc.easy;

import java.util.Scanner;

public class MarbleCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if (n == 1) {
                System.out.println(1);
            } else {
                System.out.println(combination(n , k));

            }

        }
    }

    private static long combination(int n, int k) {
        long res = 1;
        n= n-1;
        k= k-1;

        if(k > n/2){
            k = n-k;
        }

        for(int i =0; i< k ; i++){
            res = res * (n-i);
            res = res / (i+1);
        }

        return res;
    }


}
