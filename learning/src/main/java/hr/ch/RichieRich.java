package hr.ch;

import java.util.*;

/**
 * Created by Nameet on 8/20/2016.
 */
public class RichieRich {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        StringBuilder ostr = new StringBuilder("");
        for(int i=0; i< n/2 ; i++){
            char a = number.charAt(i);
            char b = number.charAt(n-i-1);
            if( a == b){
                ostr.append(a);
                continue;
            }
            else if(k == 0){
                System.out.println("-1");
                return;
            }

            ostr.append(((char) Math.max(a, b)));
            k--;
        }

        for(int i =0; i <ostr.length() && k > 0;k++){
            if(ostr.charAt(i) == '9')
                continue;

            char a = number.charAt(i);
            char b = number.charAt(n-i-1);
            if( a == b && k == 1){
                continue;
            }

            ostr.replace(i,i+1,"9");
            if( a == b){
                k = k - 2;
            }
            else {
                k = k - 1;
            }
        }
        StringBuilder ostrR = new StringBuilder(ostr);

        if(n%2 != 0){
            char midChar = number.charAt(n/2);
            if(k>0)
                midChar = '9';
            ostr.append(midChar);
        }
        System.out.println(ostr.append(ostrR.reverse()).toString());
    }
}



