/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.cc.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectingSoldiers {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for(int i = 0 ; i<t ; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int maxUsage = maxUsageWire(n);
            int minUsage = minUsageWire(n);

            if(m < minUsage){
                System.out.println(-1);
            }
            else if(m >= minUsage && m<=maxUsage){
                System.out.println(0);
            }
            else{
                System.out.println(m-maxUsage);
            }

        }

    }

    private static int maxUsageWire(int n){
        return n * (n+3) /2;

    }

    private static int minUsageWire(int n){
        n= n+1;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n/2);
        queue.add(n- n/2);
        int usage = 0;
        while(queue.size() > 0){
            int curSize = queue.size();
            for(int i=0; i< curSize; i++){
                int curPar = queue.remove();
                usage= usage+ curPar;
                if(curPar>1){
                    queue.add(curPar/2);
                    queue.add(curPar - curPar/2);
                }
            }
        }

        return usage;

    }

}
