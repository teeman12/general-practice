package gk.easy;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * Created by Nameet on 1/30/2017.
 */
public class MatrixBinaryUniqueRows {
    /*Complete the given function*/
    static class GfG {
        public static void printMat(int a[][], int r, int c) {
            //add code here.
            BinaryTrie bTrie = new BinaryTrie();

            for (int i = 0; i < r; i++) {
                if(bTrie.addBinaryArray(a[i], c)) {
                    int[] b = a[i];
                    java.util.stream.IntStream.range(0,c)
                            .forEach(j -> System.out.printf("%d ", b[j]));
                    System.out.print("$");
                }
            }

        }

        private static class TrieNode {
            Boolean isEndOfColumn;
            TrieNode[] cTrie;
            TrieNode() {
                isEndOfColumn = false;
                cTrie = new TrieNode[2];
            }

        }

        private static class BinaryTrie {
            TrieNode root;

            BinaryTrie() {
                root = new TrieNode();
            }

            Boolean addBinaryArray(int b[], int c) {
                TrieNode curr = root;

                for (int i = 0; i < c; i++) {
                    //TrieNode newNode = new TrieNode();
                    if(curr.cTrie[b[i]] == null){
                        curr.cTrie[b[i]] = new TrieNode();
                    }
                    curr = curr.cTrie[b[i]];
                }
                if(curr.isEndOfColumn){
                    return false;
                }
                curr.isEndOfColumn = true;

                return true;
            }

        }
    }
}
