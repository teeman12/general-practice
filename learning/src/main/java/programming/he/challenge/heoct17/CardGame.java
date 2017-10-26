/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.challenge.heoct17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CardGame {

    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
         * */

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        line = br.readLine();
        int[] fArray = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
        line = br.readLine();
        int M = Integer.parseInt(line);
        line = br.readLine();

        int maxInSecond = Arrays.stream(line.split("\\s"))
                .mapToInt(Integer::parseInt)
                .max().getAsInt();

        int dollarSpent = Arrays.stream(fArray).map(c -> buyStrength(c, maxInSecond)).sum();


        System.out.println(dollarSpent);
    }

    private static int  buyStrength(int card, int maxCard){
        if(card > maxCard){
            return 0;
        }
        else {
            return maxCard-card+1;
        }
    }
}

