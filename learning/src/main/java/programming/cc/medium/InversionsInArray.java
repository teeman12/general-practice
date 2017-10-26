/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.cc.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

// code LPAIR
public class InversionsInArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int[] fArr = IntStream.range(0,t)
                .mapToObj(i -> new CPair(sc.nextInt(), sc.nextInt()))
                .sorted(Comparator.comparing(CPair::getM))
                .mapToInt(c -> c.getF())
                .toArray();

        int temp[] = new int[t];
        System.out.print(noOfInversions(fArr,temp, 0, fArr.length-1));

    }

    private static int noOfInversions(int[] arr, int[] temp, int start, int end) {

        if (end <= start) {
            return 0;
        }

        int mid = (end+start) / 2;
        int left = noOfInversions(arr, temp, start, mid);
        int right = noOfInversions(arr, temp,  mid+1, end);

        return left + right + merge(arr, temp, start, mid, end);


    }

    private static int merge(int arr[], int[] temp, int s, int m, int e) {
        int inv = 0;
        int s1 = s;
        int p= s;
        int s2 = m+1;
        while (s1 <= m && s2 <= e) {
            if (arr[s1] <= arr[s2]) {
                temp[p++] = arr[s1++];
            } else {
                inv += m - s1 + 1;
                temp[p++] = arr[s2++];
            }
        }

        while (s1 <= m) {
            temp[p++] = arr[s1++];
        }

        while (s2 <= e) {
            temp[p++] = arr[s2++];
        }

        for(int i=s; i<= e; i++){
            arr[i] = temp[i];
        }


        return inv;


    }

    private static class CPair {
        int m;
        int f;

        CPair(int m, int f) {
            this.m = m;
            this.f = f;
        }

        public int getM() {
            return m;
        }

        public int getF() {
            return f;
        }
    }

}
