/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.string.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindCommas {

    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        line= br.readLine();

        int M = Integer.parseInt(line);

        //Scanner

        for (int i = 0; i < N; i++) {

            long maxCommaCount=0;
            String maxCommaName = "";

            for(int j=0; j< M; j++){
                String inp = br.readLine();
                String name = inp.split("\\s")[0];
                String amt= inp.split("\\s")[1];

                long commaCount = amt.chars().filter(c -> c==',').count();
                if(commaCount >= maxCommaCount){
                    maxCommaCount = commaCount;
                    maxCommaName = name;
                }
            }

            System.out.println(maxCommaName+" "+maxCommaCount );


        }



    }
}
