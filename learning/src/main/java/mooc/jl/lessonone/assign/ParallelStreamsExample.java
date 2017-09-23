/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package mooc.jl.lessonone.assign;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ParallelStreamsExample {

   public static void main(String []args){
       List<Integer> arr = Arrays.asList(1,2,3,4,5,6,7,8,9,10,
               1,2,3,4,5,6,7,8,9,10);

       //1.
       //mapCheck(arr);

       //2.
       //reduceCheck(arr);

       //System.out.println(ForkJoinPool.commonPool());
       //3.
       forkJoinEx(arr);


   }

   private static void forkJoinEx(List<Integer> arr){
     ForkJoinPool fk = new ForkJoinPool(30);
     fk.submit( () -> mapCheck(arr));
     try {
         fk.awaitTermination(10, TimeUnit.SECONDS);
     }
     catch (Exception e){

     }

     fk.shutdown();

   }

   private static  void mapCheck(List<Integer> arr){
       arr.stream()
       .sequential()
               .map(ParallelStreamsExample::transform)
               .forEachOrdered(ParallelStreamsExample::print);
   }

    private static  void reduceCheck(List<Integer> arr){
        System.out.println(arr.stream()
                .parallel()
                .reduce(10,ParallelStreamsExample::add));
    }

    private static int add(int total, int num){
        System.out.println(" total: "+ total + " thread: " + Thread.currentThread());
        return total+num;
    }

    private static void print(int i){
       System.out.println("p :"+ i + " thread : " + Thread.currentThread());
   }

   private static int transform(int num) {
       System.out.println("t :" + num + " thread : " + Thread.currentThread());
       try {
           Thread.sleep(1000);
       }
       catch(Exception e){

       }
       return num * 1;
   }

}
