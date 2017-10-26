/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.challenge.heoct17;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PolynamiacSign {
    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
        */
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        line = br.readLine();
        int maxCoff = Integer.parseInt(line.split("\\s")[N]);


        int posFn=0;
        int negFn=0;

        if(maxCoff>0){
            posFn=1;
        }
        else if(maxCoff<0){
            posFn=-1;
        }

        if(N%2!=0){
            maxCoff= maxCoff*-1;
        }

        if(maxCoff>0){
            negFn=1;
        }
        else if(maxCoff<0){
            negFn=-1;
        }

        System.out.print(posFn+" "+negFn);
    }
}

