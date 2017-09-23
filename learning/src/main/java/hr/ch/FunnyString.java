package hr.ch;

import java.util.*;
import java.util.stream.*;

/**
 * Created by Nameet on 8/19/2016.
 */
public class FunnyString {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String a = "abc";
        in.nextLine();
        for(int i = 0 ; i < t ; i++){
            String inStr = in.nextLine();
            boolean isFunnyString = false;
            int len = inStr.length() - 1;

            isFunnyString = IntStream.rangeClosed(1, len)
                    .allMatch(e -> funnyCheck(inStr, e, len));

            if(isFunnyString){
                System.out.println("Funny");
            }
            else{
                System.out.println("Not Funny");
            }

        }


    }

    private static boolean funnyCheck(String inStr, int index, int strLen){

        int funny1 = Math.abs(inStr.charAt(index) - inStr.charAt(index-1));
        int funny2 = Math.abs(inStr.charAt(strLen-index) - inStr.charAt(strLen- index + 1));

        return (funny1 == funny2);
    }
}
