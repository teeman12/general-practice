package cc.easy;

import java.util.Scanner;
import java.util.stream.IntStream;

//import static java.util.stream.IntStream.range;

public class ReversingDirection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        for(int i=0; i < t ; i++){
            int n= sc.nextInt();
            sc.nextLine();

            Dir[] dirList = IntStream.range(0,n).mapToObj(ii -> new Dir(sc.nextLine())).toArray(Dir[]::new);

            System.out.println("Begin on "+dirList[n-1].way);
            for(int j=n-1; j>0; j--){

                if(dirList[j].isLeft){
                    System.out.println("Right on "+dirList[j-1].way);
                }
                else{
                    System.out.println("Left on "+dirList[j-1].way);
                }

            }



        }
    }

    private static class Dir {
        boolean isLeft;
        String way;

        Dir(String dStr){
          String[] strArray = dStr.split(" ", 3);
          isLeft = strArray[0].equals("Left");
          way = strArray[2];
        }

    }
}
