package hr.ch;

/*./ */

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingUse;

import java.util.*;
import java.util.stream.IntStream;

public class MarsExploration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String sos = "SOS";
        long changedCount = IntStream.range(0,str.length())
                .mapToObj( i -> ((Character) str.charAt(i)).compareTo(sos.charAt(i%3)))
                .filter(e -> e !=0)
                .count();

        System.out.println(changedCount);

    }
}
