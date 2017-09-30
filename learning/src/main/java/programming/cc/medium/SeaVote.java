/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.cc.medium;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SeaVote {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        for(int i = 0 ; i< t ; i++){
            int n = sc.nextInt();
            int nt = n;

            sc.nextLine();
            int bSum = 0;
            for(int j = 0; j< n ; j++){
                int b = sc.nextInt();
                if(b==0){
                    nt= nt-1;
                }
                bSum+=b;
            }

            int diff = bSum-100;
            if(diff < nt && diff >= 0)
                System.out.println("YES");
            else
                System.out.println("NO");


        }
    }
}
