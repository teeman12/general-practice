/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.cc.medium;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * cc Code : ANUMLA
 */
public class ArrayFromSubsetSum1 {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i< t ; i++){
            int n= sc.nextInt();
            sc.nextLine();

            int sCount = 1<<n;

            int subsetSum[] = IntStream.range(0, sCount).map(j -> sc.nextInt()).sorted().toArray();
            MinHeap minHeap = new MinHeap(sCount);
            int[] num = new int[n];
            num[0] = subsetSum[1];
            int numSize=1;
            if(n>1){
                num[1] = subsetSum[2];
                numSize++;
                minHeap.insert(num[0]+num[1]);
            }

            for(int j = 3; j< sCount && numSize < n; j++){
                int minNum = minHeap.extract();

                int currentNum = subsetSum[j];
                if(minNum == currentNum){
                    //add previous subsets in heaps
                    for(int k=1; k< j; k++){
                        minHeap.insert(currentNum + subsetSum[k]);
                    }
                }
                else{//its a num
                    num[numSize++] = currentNum;
                }

            }

            for(int j=0; j < numSize-1 ; j++){
                System.out.print(num[j]+" ");
            }
            System.out.print(num[numSize-1]);

        }
    }
    private static class MinHeap {
        private int[] heap;
        private int size = 0;

        MinHeap(int n) {
            heap = new int[n];
        }

        void insert(int num) {
            heap[size] = num;
            int i = size;
            while (i > 0) {
                int j = (i-1) / 2;
                if (heap[i] < heap[j]) {
                    int temp = heap[i];
                    heap[i] = heap[j];
                    heap[j] = temp;
                }
                i = j;
            }
            size++;
        }


    int extract() {
        int min = heap[0];
        heap[0]= heap[size-1];
        size--;

        int i =0;
        while(i<size){
            int left = i*2+1;
            int right = i*2 + 2;
            int minIndex= size;
            if ((heap[left] < heap[i]) && (right >= size || heap[left] < heap[right]) &&  left < size){
                minIndex = left;
            }
            else if(right < size && heap[right] < heap[left] && heap[right] < heap[i] ){
                minIndex = right;
            }
            if(minIndex < size){
                int temp = heap[i];
                heap[i]= heap[minIndex];
                heap[minIndex] = temp;
            }
            i = minIndex;
        }

        return min;

    }



    }
}


