/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.string.search;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//import for Scanner and other utility classes
//import java.util.*;


public class AllVowelsCheck {

    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

*/

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        String vowels = "aeiou";
        final Map<Integer, Boolean> vowelMap = initVMap(vowels);


        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            str.chars().boxed().forEach(c -> {
                if (vowelMap.get(c) != null && vowelMap.get(c).equals(Boolean.FALSE)) {
                    vowelMap.put(c, Boolean.TRUE);
                }
            });

            if (checkForAllVowels(vowelMap)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            resetVMap(vowelMap);

        }
    }

    private static Map<Integer, Boolean> initVMap(String str) {

        return str.chars().boxed().collect(Collectors.toMap(Function.identity(), c -> false));

    }

    private static boolean checkForAllVowels(Map<Integer, Boolean> vowelMap){

        boolean notAllVowels = vowelMap.entrySet().stream().anyMatch(e -> e.getValue().equals(Boolean.FALSE));

        return !notAllVowels;
    }


    private static void resetVMap(Map<Integer, Boolean> vmap) {

        vmap.entrySet().forEach( e -> {
            if(e.getValue().equals(Boolean.TRUE)){
                e.setValue(Boolean.FALSE);
            }
        });

    }
}



