/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.string.search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    public static void main(String args[]){

        //read http://tutorials.jenkov.com/java-regex/matcher.html

        String tweetString = "I am trending hastag #nBNabc123z on twitter";
        String sampleTag = "#nBNabc123z";

        Pattern pattern = Pattern.compile("#(\\d|[a-zA-Z])+");

        Matcher matcher = pattern.matcher(sampleTag);

        System.out.println("Matches :" + matcher.matches());

        matcher = pattern.matcher(tweetString);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
        //System.out.println("Hash String: " + matcher.group(1));


    }


}
