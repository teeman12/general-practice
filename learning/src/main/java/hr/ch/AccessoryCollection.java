package hr.ch;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/challenges/accessory-collection?h_r=next-challenge&h_v=zen

public class AccessoryCollection {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int rep;int l;int p;
        for(int a0 = 0; a0 < T; a0++){
            int L = in.nextInt();
            int A = in.nextInt();
            int N = in.nextInt();
            int D = in.nextInt();
            rep = D;
            p=0;l=0;
            for(l=rep; l<=L && A > 0; l = l + rep){
                p += rep*A;
                A--;
            }
            if((l-rep) <L && A <=0){
                System.out.println("SAD");
                //continue;
            }
            else if(l >= L){
                l= l-rep;
                p += A*(L-l);
                System.out.println(p);
            }

        }


    }
}
