/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package cc.medium;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * cc Code : ANUMLA
 */
public class ArrayFromSubsetSum {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i< t ; i++){
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            int n= sc.nextInt();
            sc.nextLine();

            int sCount = 1<<n;

            int subsetSum[] = IntStream.range(0, sCount).map(j -> sc.nextInt()).sorted().toArray();

            int[] num = new int[n];
            num[0] = subsetSum[1];
            int numSize=1;
            if(n>1){
                num[1] = subsetSum[2];
                numSize++;
                priorityQueue.add(num[0]+num[1]);
            }

            for(int j = 3; j< sCount && numSize < n; j++){
                int minNum = priorityQueue.poll();

                int currentNum = subsetSum[j];
                if(minNum == currentNum){
                    //add previous subsets in heaps
                    for(int k=1; k< j; k++){
                        priorityQueue.add(currentNum+subsetSum[k]);
                    }
                }
                else{//its a num
                    num[numSize++] = currentNum;
                }

            }

            for(int j=0; j < numSize-1 ; j++){
                System.out.print(num[j]+" ");
            }
            System.out.println(num[numSize-1]);

            priorityQueue.clear();

        }
    }

}


