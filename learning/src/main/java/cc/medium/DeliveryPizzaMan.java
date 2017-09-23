/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package cc.medium;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DeliveryPizzaMan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[] a= readArray(sc, n);
        int[] b= readArray(sc,n);

        PriorityQueue<TipPair> pqA = new PriorityQueue<>((p1,p2) -> p2.a - p1.a);
        PriorityQueue<TipPair> pqB = new PriorityQueue<>((p1,p2) -> p2.b - p1.b);

        int maxTip = 0;
        for(int i=0; i<n ; i++){
            if(a[i] > b[i]){
                if(x>0){
                    maxTip= maxTip+ a[i];
                    pqA.add(new TipPair(a[i], b[i]));
                    x--;
                }
                else {
                    TipPair t = pqA.peek();
                    if(a[i] + t.b > t.a + b[i]){
                        t = pqA.poll();
                        maxTip = maxTip + a[i];
                        pqA.add(new TipPair(a[i],b[i]));
                    }
                    else{
                        maxTip= maxTip+ b[i];
                        pqB.add(new TipPair(a[i], b[i]));
                        y--;

                    }
                }
            }
            else {
                if(y>0){
                    maxTip= maxTip+ b[i];
                    pqB.add(new TipPair(a[i], b[i]));
                    y--;
                }
                else {
                    TipPair t = pqB.peek();
                    if(b[i] + t.a > t.b + a[i]){
                        t = pqB.poll();
                        maxTip = maxTip + b[i];
                        pqA.add(new TipPair(a[i],b[i]));
                    }
                    else {
                        maxTip= maxTip+ a[i];
                        pqA.add(new TipPair(a[i], b[i]));
                        x--;

                    }
                }
            }

        }
        System.out.println(maxTip);
    }

    private static int[] readArray(Scanner sc, int n){
        return IntStream.range(0,n).map(i -> sc.nextInt()).toArray();
    }

    private static class TipPair {
        int a;
        int b;

        TipPair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}
