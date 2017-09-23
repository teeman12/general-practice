/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package cc.medium;

import java.util.Scanner;

public class ShiftTheString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String pattern = sc.nextLine();
        String text = sc.nextLine();


        int[] lep = preProcssedLep(pattern, n);
     /*   for(int k=0; k< n ; k++){
            System.out.print(" " + lep[k]);
        }
*/
        int i=0;

        int im= 0;
        int j =0;
        int maxLen = 0;
        int maxI= 0;
        while(!(im >= n && j==0) && im < (2 *n -1)){
            if(text.charAt(i) == pattern.charAt(j)){
                if(j+1 > maxLen){
                    maxLen = j+1;
                    maxI = i;
                }
                i = (i+1)%n;
                im++;
                if(j+1==n){
                    //System.out.println((i+1)%n);
                    j = lep[j];
                }
                else{
                    j= j+1;
                }

            }
            else{
                if(j==0){
                    i = (i+1)%n;
                    im++;
                }
                else{
                    j = lep[j];
                }
            }


        }
        maxI= maxI +1;
        if(maxLen == 0){
            System.out.println(0);
        }
        else if(maxI >= maxLen){
            System.out.println(maxI-maxLen);
        }
        else {
            System.out.println(n- (maxLen-maxI));
        }

    }

    private static int[] preProcssedLep(String pattern, int n) {
        int[] lep = new int[n];
        lep[0] = 0;
        int i = 1;
        int len = 0;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(lep[len])) {
                lep[i] = lep[len] + 1;
                len=i;
                i++;
            } else {
                if (len > 0) {
                    len = len - 1;
                } else {
                    lep[i] = 0;
                    i++;
                }

            }
        }

        return lep;
    }

}
