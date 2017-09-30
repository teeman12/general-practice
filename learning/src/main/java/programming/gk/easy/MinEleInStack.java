package programming.gk.easy;

import java.util.Stack;

/**
 * Created by Nameet on 1/23/2017.
 */
public class MinEleInStack {

    class GfG
    {
        int minEle;
        Stack<Integer> s = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> ss = new Stack<>();

        /*returns min element from stack*/
        int getMin()
        {
            // Your code here
            if(s.empty()){
                return -1;
            }
            return Math.min(s.peek(), ms.peek());
        }

        /*returns poped element from stack*/
        int pop()
        {

            if(s.empty()){
                return -1;
            }
            // Your code here
            if(s.size() == ss.peek()){
                ss.pop();
                ms.pop();
            }

            return s.pop();
        }

        /*push element x into the stack*/
        void push(int x)
        {
            if(s.empty()) {
                ms.push(x);
                ss.push(1);
            }
            else if (s.peek() < x && s.peek() < ms.peek()){
                ms.push(s.peek());
                ss.push(s.size());
            }

            s.push(x);


            // Your code here
        }
    }
}
