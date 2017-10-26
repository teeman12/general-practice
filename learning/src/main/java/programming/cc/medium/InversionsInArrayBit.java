/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.cc.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

// code LPAIR
public class InversionsInArrayBit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int[] fArr = IntStream.range(0,t)
                .mapToObj(i -> new CPair(sc.nextInt(), sc.nextInt()))
                .sorted(Comparator.comparing(CPair::getM))
                .mapToInt(CPair::getF)
                .toArray();

        CPair[] cpairs = IntStream.range(0,t)
                .mapToObj(i -> new CPair(i, fArr[i]))
                .sorted(Comparator.comparing(CPair::getF))
                .toArray(CPair[]::new);
        for(int i = 0; i< t; i++){
            fArr[cpairs[i].getM()] = i+1;
        }

//        Arrays.stream(fArr).forEach(System.out::println);


        System.out.print(noOfInversions(fArr, t));

    }

    private static int noOfInversions(int[] arr, int n) {
        BIndexTree bit = new BIndexTree(n+1 );
        int inv =0;
        for(int i=n-1; i>=0; i--){
            inv+=bit.getSum(arr[i]-1);
            bit.update(arr[i], 1);
        }

        return inv;

    }

    private static class BIndexTree{
        int[] bit ;

        BIndexTree(int n){
            bit = new int[n];
        }

        int getSum(int index){

            int sum = 0;
            while(index > 0){
                sum= sum+bit[index];
                index = index - (index & -index);
            }


            return sum;

        }

        void update(int index, int val){
            while(index< bit.length){
                bit[index]+=val;
                index = index + (index & -index);

            }
        }
    }


    private static class CPair {
        private int m;
        private int f;

        CPair(int m, int f) {
            this.m = m;
            this.f = f;
        }

        int getM() {
            return m;
        }

        int getF() {
            return f;
        }
    }


}
