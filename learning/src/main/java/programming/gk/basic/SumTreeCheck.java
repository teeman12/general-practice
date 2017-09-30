package programming.gk.basic;

/**
 * Created by Nameet on 1/1/2017.
 */
public class SumTreeCheck {


}

// A Binary Tree node

class GfG1
{
    boolean isSumTree(Node node)
    {
        // Your code here

        if(sumTreeValue(node) >= 0){
            return true;
        }

        return false;
    }

    private Integer sumTreeValue(Node node){

        if(node == null){
            return 0;
        }

        Integer sumLeft = sumTreeValue(node.left);
        Integer sumRight = sumTreeValue(node.right);

        if(sumLeft < 0 || sumRight < 0){
           return -1;
        }
        Integer sumLeftRight = sumLeft + sumRight;
        if(sumLeftRight == 0 || sumLeftRight == node.data){
            return node.data + sumLeftRight;
        }

        return -1;
    }

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

}
