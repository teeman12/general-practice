/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.string.search;

/* IMPORTANT: Multiple classes and nested static classes are supported */


//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

//import for Scanner and other utility classes
//import java.util.*;


class Palindrome {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
         */

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        //Scanner
        //    Scanner s = new Scanner(System.in);
        //  int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            char[] chStr = str.toCharArray();
            int len = str.length();

           boolean testFailed = IntStream.range(0, len/2).anyMatch(d -> chStr[d] != chStr[len-1-d]);

            if(testFailed) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }


    }
}
