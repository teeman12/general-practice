/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.cc.medium;

import java.util.Scanner;

public class PouringWater {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i=0 ; i< t ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            int b = sc.nextInt();
            sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();

            if(c>a && c>b){
                System.out.println(-1);
            }
            else {
                System.out.println(pour(a,b,c));

            }

        }

    }

    private static int pour(int a, int b , int c){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }

        if(a ==c || b ==c ){
            return 1;
        }
        if(c%b==0){
            return 2 * c/b;
        }

        int aRemaining = a;
        int times =0;
        while(aRemaining > c){
            aRemaining = aRemaining-b;
            times++;
        }

        if(aRemaining==c){
            return 2*times;
        }


        return -1;
    }
}
