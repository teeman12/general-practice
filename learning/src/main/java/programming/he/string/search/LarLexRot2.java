/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.string.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.stream.IntStream;

public class LarLexRot2 {
    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
         */
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] stIs = IntStream.range(0,word.length()).toArray();
        int in =0;
        while(stIs.length>1 && in < word.length() ){
            stIs = maxLexWordStarts(word,stIs, in);
            in++;

        }

        in =stIs[0];

        System.out.println(word.substring(in, word.length()).concat(word.substring(0,in)));




    }

    private static int[] maxLexWordStarts(String word, int[] stIs, int index) {


        int maxCh = Arrays.stream(stIs).map(c -> word.charAt(getModIndex(c + index, word.length())))
                .max().getAsInt();

        return Arrays.stream(stIs)
                .filter(c -> word.charAt(getModIndex(c + index, word.length())) == maxCh)
                .toArray();

    }

    private static int getModIndex(int index, int len ){
        if(index < len) {
            return index;
        }
        else {
            return index%len;
        }
    }
}
