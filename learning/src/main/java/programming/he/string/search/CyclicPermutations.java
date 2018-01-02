/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.string.search;




//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class CyclicPermutations {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numOfTests = br.readLine();                // Reading input from STDIN

        int t= Integer.parseInt(numOfTests);

        for(int i=0; i< t; i++){
            String a1 = br.readLine();
            String a2 = br.readLine();
            System.out.println(permMatchCount(a1,a2));

        }

        // Write your code here

    }

    private static int permMatchCount(String a1, String a2){
        if(a1.length()!= a2.length()){
            return 0;
        }
        int len = a1.length();
        int perm = 0;
        StringBuilder sb = new StringBuilder(len*2);

        sb.append(a1).append(a1).deleteCharAt(2*len-1);

        int ind = -1;

        String aCh = sb.toString();
        do{
            ind = aCh.indexOf(a2, ind+1);
            if(ind!=-1){
                perm++;
            }
            else{
                break;
            }

        }while(true);


            /*if(a1.regionMatches(i,a2,0,len-i) && a1.regionMatches(0,a2,len-i, i)){
                perm++;
            }*/
        return perm;
    }
}
