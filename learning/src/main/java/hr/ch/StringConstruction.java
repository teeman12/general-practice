package hr.ch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by Nameet on 8/21/2016.
 */
public class StringConstruction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String s = in.next();
            int score = 1;
            int it = 1;
            int e;
            int len = s.length();
            boolean isSubStrFlag = false;
            boolean isNotSubStrFlag = true;
            while(it < len){
                e = it;
                isSubStrFlag = false;
                String head = s.substring(0,it);
                while(e < len && ( e-it) < head.length()){
                    String tail = s.substring(it, e+1);
                    if(head.contains(tail)){
                        isSubStrFlag = true;
                    }
                    else{
                        break;
                    }
                    e++;
                }
                if(isSubStrFlag == false) {
                    it = it+1;
                }

            }

        }

    }
}
