package programming.gk.basic;

/**
 * Created by Nameet on 1/1/2017.
 */
public class StackUsingLinkedList {


    //The structure of the node of the stack is
    class StackNode {
        int data;
        StackNode next;
    }

    class Stack_using_LinkedList {
        StackNode top;
    }


// This is method only submission

    class GfG {
        /* The method push to push element into the stack */
        void push(int a, Stack_using_LinkedList ob) {
            // Your code here
            StackNode sn = new StackNode();
            sn.data = a;
            sn.next = ob.top;
            ob.top = sn;
        }

        /*The method pop which return the element poped out of the stack*/
        int pop(Stack_using_LinkedList ob) {
            //Your code here
            if(ob.top == null)
                return -1;

            StackNode node = ob.top;

            ob.top = node.next;
            return node.data;
        }

    }

}
