package gk.basic;

/**
 * Created by Nameet on 1/2/2017.
 */
public class NoSibling {

    //  A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

    class GfG
    {
        void printSibling(Node node)
        {
            // Your code here


        }

        void identifyAndPringSibling(Node node, Node sibling){
            if(node== null){
                return;
            }
            if(sibling == null){
                System.out.printf("%d ", node.data);
            }

            identifyAndPringSibling(node.left, node.right);
            identifyAndPringSibling(node.right, node.left);

        }
    }
}
