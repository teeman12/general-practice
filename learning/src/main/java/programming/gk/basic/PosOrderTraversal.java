package programming.gk.basic;

/**
 * Created by Nameet on 1/1/2017.
 */
public class PosOrderTraversal {


  // A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}

    class GfG
    {
        void postOrder(Node root)
        {
            // Your code goes here
            if(root == null)
                return;

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data);
        }
    }
}
