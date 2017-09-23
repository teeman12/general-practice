package  hr.ch;
import java.text.ParseException;
import java.util.*;
import java.util.stream.*;


class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            if ((k | k - 1) <= n) {
                System.out.println(k - 1);
            } else {
                System.out.println(k - 2);
            }
        }
    }
}

