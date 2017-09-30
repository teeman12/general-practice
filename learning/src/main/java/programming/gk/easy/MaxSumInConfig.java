package programming.gk.easy;

/**
 * Created by Nameet on 1/10/2017.
 */
public class MaxSumInConfig {


    /*You are required to complete this method*/
    int max_sum(int A[],int N){
        //Your code here
        int max = 0;
        int last=0;
        int total=0;

        for(int i =0; i< A.length; i++){
            total = total + A[i];
            last = last + i * A[i];
        }
        max = last;
        for(int i =0; i < A.length ; i++){
            int cur = last - (total - A[i]) + A[i]*(A.length - 1);
            last = cur;
            if(cur > max){
                max = cur;
            }
        }

        return max;

    }
}
