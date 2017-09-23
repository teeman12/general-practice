
/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package cc.medium;

import java.util.Scanner;

/**
 * Knuth Morris Pratt pattern serach algorithm. This is not from CC but just adding
 * as i saw a similar problem
 * @author teeman12
 */
public class KMPAlgo {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String pattern = sc.nextLine();

        System.out.println(" Text is " + text);
        System.out.println(" Pattern is "+ pattern);

        int n = text.length();
        int m = pattern.length();

        int[] lep = preProcessLps(pattern, m);

        for(int k=0; k<m ; k++){
            System.out.print(" " + lep[k]);
        }
        int i = 0 ;
        int j = 0 ;
        while(i<n){

            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                if(j==m-1){
                    System.out.println(" Pattern found at index " + (i-m));
                    j= lep[j];

                }
                else {
                    j++;
                }
            }
            else{
                if(j == 0){
                    i++;
                }
                else{
                    j = lep[j];

                }
            }
        }

    }

    private static int[] preProcessLps(String pattern, int m){
        int i =1;
        int lep[] = new int[m];

        lep[0]= 0;
        int len = 0;
        while(i < m){

            if(pattern.charAt(i)==pattern.charAt(lep[len])){
                lep[i]= lep[len]+1;
                len = i;
                i++;

            }
            else if(len>0){
                len = len -1;
            }
            else {
                lep[i]=0;
                i++;
            }

        }

        return lep;

    }
}
