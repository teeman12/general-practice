package programming.gk.basic;

/**
 * Created by Nameet on 1/1/2017.
 */
public class SquareRoot {

    long floorSqrt(long x) {

        // o(n) solution commented
     /*   OptionalLong num =  LongStream.range(0,x)
                .filter(m -> m*m > x)
                .findFirst();


       return num.getAsLong()-1;*/
        if (x == 1)
            return 1;
        // Your code here
        Long start = 1L;
        Long end = x;

        while (end > start) {
            Long mid = (end + start) / 2;
            Long midSq = mid * mid;
            if (midSq < x) {
                start = mid + 1;
            } else if (midSq > x) {
                end = mid - 1;
            } else
                return mid;
        }

        if (end * end > x) {
            return end - 1;
        } else {
            return end;
        }


    }

}
