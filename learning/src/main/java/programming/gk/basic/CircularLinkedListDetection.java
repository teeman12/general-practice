package programming.gk.basic;

/**
 * Created by Nameet on 1/1/2017.
 */
public class CircularLinkedListDetection {
}

// Structure of LinkedList
class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
class GfG
{
    boolean isCircular(Node head)
    {
        // Your code here
        if(head == null)
            return true;


        Node pt1 = head;
        Node pt2 = head;

        while(true) {
            pt1 = pt1.next;
            if (pt1 == null) {
                return false;
            }

            pt2 = pt2.next;
            if (pt2 == null) {
                return false;
            }
            pt2 = pt2.next;
            if (pt2 == null)
                return false;

            if (pt1 == head || pt2 == head) {
                return true;
            }
            if (pt1 == pt2) {
                return false;
            }

        }

    }
}