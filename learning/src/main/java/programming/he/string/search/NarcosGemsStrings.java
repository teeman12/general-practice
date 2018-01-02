/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.string.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * For a given string find the sum of gem value of all suffixes.
 * Gem value of a suffix: length of longest common prefix
 * a string can be considered its own suffix as well.
 *
 * e.g: abaa = 6
 */
public class NarcosGemsStrings {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testNumbers = br.readLine();                // Reading input from STDIN
        int t = Integer.parseInt(testNumbers);
        // Write your code here

        for(int i=0; i<t; i++){
            String cases = br.readLine();

            int sep = cases.lastIndexOf(' ');

            String testStr = cases.substring(0, sep);


            int k = Integer.parseInt(cases.substring(sep+1));

            long tot = calculateGemValue(testStr, k);

            System.out.println(tot);

        }

    }

    private static long calculateGemValue(String str, int times ){

        int len = str.length();
        //int[][] calMat = new int[len][len];

        long k = (long)times;
        if(k > 1){
            str = str + str;
        }

        long tot=0;
        long eqFactor = k*(k+1)/2 *len;
        for(int i=0; i<len ; i++){
            int curLen = getCommonPreLen(str,i, len);

            if(curLen== len){
                tot= tot+eqFactor - i*k;
            }
            else if(i+curLen < len){
                tot = tot + curLen*k;
            }
            else {
                tot = tot + curLen *k;
                tot = tot - ( curLen - (len-i));

            }

        }


        return tot;

    }

    private static int getCommonPreLen(String str,int stb, int len){
         int it = 0 ;

         while(it < len && stb+it < str.length() &&
                 str.charAt(it)== str.charAt(stb+it)){
             it++;
         }

         return it;

    }
}
