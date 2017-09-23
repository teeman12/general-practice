/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package cc.medium;

import java.util.Scanner;

public class ConnectingSoldiers1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for(int i = 0 ; i<t ; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] wall = new int[n];
            int left= leftOverWire(n,m,wall,0,0 );
            System.out.println(left==-1? -1: m-left);
        }

    }

    private static int leftOverWire(int n, int m, int[] wall, int used, int sol){

        if(used > m){
            return -1;
        }
        if(sol == n ){
            return used;
        }
        int maxUsed =-1;
        for(int i = 0 ; i<= n/2 ; i++){
            if(wall[i]==0){
              int l= i-1;
              int r = i+1;
              while(l >=0 && wall[l]==0){
                  l--;
              }
              while(r < n && wall[r]==0){
                  r++;
              }
              int lrSize = r-l;
              wall[i]=1;
              int cUsed = leftOverWire(n,m,wall,used+lrSize,sol+1);
              if(cUsed > maxUsed){
                  maxUsed = cUsed;

              }
              wall[i]=0;
          }

        }
        return maxUsed == -1 ? -1 : maxUsed;
    }

}
