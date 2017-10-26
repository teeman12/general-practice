/*
 * Copyright (c) 2017. This belongs to teeman12. Feel free to copy and use
 */

package programming.he.string.search;

//imports for BufferedReader

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


//import for Scanner and other utility classes
//import java.util.*;


public class TopHashTags {

    final static Pattern TAG_PATTERN = Pattern.compile("#(\\d|[a-zA-Z])+");

    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);


        HashTagRepo hashTagRepo = new HashTagRepo();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            hashTagRepo.addTagCount(str);
        }

        hashTagRepo.getTopTags(5);




    }


    private static class HashTag  {

        String str;
        int count;

        HashTag(String str){
            this.str = str;
        }

        void inc(){
            count++;
        }

        public static int compare(HashTag t1, HashTag t2) {
            if (t1.count != t2.count) {
                return t1.count - t2.count;
            } else {
                return t2.str.compareTo(t1.str);
            }
        }

        @Override
        public String toString() {
            return "HashTag{" +
                    "str='" + str + '\'' +
                    ", count=" + count +
                    '}';
        }
    }


    private static class HashTagRepo{
        Map<String, HashTag> tagMap;

        HashTagRepo(){
            tagMap = new HashMap<>();
        }

        void addTagCount(String str){

            Matcher matcher = TAG_PATTERN.matcher(str);

            while(matcher.find()){
                addTagToMap(matcher.group());
            }
        }

        void getTopTags(int count){

            //heap to find top count

            PriorityQueue<HashTag> pq = new PriorityQueue<>(count, (t1, t2) -> HashTag.compare(t1,t2));

            List<HashTag> tags = new ArrayList<>(tagMap.values());

            tags.forEach(i -> System.out.println(i));

            IntStream.range(0,count).forEach(i -> pq.add(tags.get(i)));

            IntStream.range(count, tags.size()).forEach( i -> {
                HashTag tag = tags.get(i);
                HashTag peeked = pq.peek();
                if(HashTag.compare(tag,peeked) > 0){
                    pq.poll();
                    pq.add(tag);
                }
            });

            Deque<String> tagStrs = new LinkedList<>();

            IntStream.range(0,count).mapToObj(i -> pq.poll()).forEach(t -> tagStrs.addFirst(t.str));

            IntStream.range(0,count).forEach(i -> System.out.println(tagStrs.pollFirst()));

/*           using sorting to find top count
            tagMap.values().stream().sorted(
            }).limit(count)
                    .forEach(t -> System.out.println(t.str));
*/




        }

        private void addTagToMap(String tagStr){
            HashTag hashTag = tagMap.get(tagStr);
            if(hashTag == null){
                hashTag = new HashTag(tagStr);
                tagMap.put(tagStr, hashTag);
            }
            hashTag.inc();

        }



    }

}
