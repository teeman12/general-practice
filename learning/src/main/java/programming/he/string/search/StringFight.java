/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.string.search;

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;


public class StringFight {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);


        for (int i = 0; i < N; i++) {
            String charCount = br.readLine();
            int count = Integer.parseInt(charCount.split(" ")[0]);
            int num = Integer.parseInt(charCount.split(" ")[1]);
            String str = br.readLine();

            int numOfChar = substrCount(str, count, '0'+num);
            System.out.println(numOfChar);
        }

    }

    private static int substrCount(String str, int count, int ch){

        LinkedList<Integer> chLoc = new LinkedList<>();
        int ind = -1;
        do{
            chLoc.add(ind);
            ind = str.indexOf(ch,ind+1);
        }while(ind!=-1);

        chLoc.add(str.length());


        ListIterator<Integer> ist = chLoc.listIterator(1);
        ListIterator<Integer> iend = chLoc.listIterator(count);

        ListIterator<Integer> limitSt = chLoc.listIterator(0);
        ListIterator<Integer> limitEd = chLoc.listIterator(count+1);


        int substrCount = 0;
        while(limitEd.hasNext()){

            int limitStart = limitSt.next();

            int cStart = ist.next();

            int limitEnd = limitEd.next();
            int cEnd = iend.next();


            int stLen = cStart-limitStart-1;
            int endLen = limitEnd - cEnd-1;

            int gr;
            int sm;
            if(stLen > endLen){
                gr = stLen;
                sm = endLen;
            }
            else{
                sm = stLen;
                gr= endLen;
            }

            int sum = (sm+1)*(sm+2)/2 + (sm+1)*(gr-sm);


            substrCount+=sum;

        }

        return substrCount;
    }
}

