package programming.ch;

import java.util.*;

/**
 * Created by Nameet on 8/21/2016.
 */
public class StringConstruction2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String s = in.next();
            int score = 0;
            Map<Character,Integer> chrMap = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                if(!chrMap.containsKey(s.charAt(i))){
                    chrMap.put(s.charAt(i),1);
                    score++;
                }
            }

            System.out.println(score);

        }


    }
}
