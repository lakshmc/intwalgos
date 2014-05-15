package linkedLists;

/**
 * Created on 5/10/14.
 */
public class LinkedListHasLoop {

   /* static class Node{
        String value;
        Node next;

        Node(String value, Node next){
            this.value=value;
            this.next=next;
        }

    }*/

    public static void main(String[] args) {

        Node fifth = new Node("E",null);
        Node fourth = new Node("D",fifth);
        Node third = new Node("C",fourth);
        Node second = new Node("B",third);
        Node start = new Node("A",second);

        //fourth.next=third; //this makes it circular

        System.out.println(""+isCircularList(start));

    }

    private static boolean isCircularList(Node start) {
        Node fastIndex=start;
        Node slowIndex=start;
        while (fastIndex!=null && fastIndex.next!=null){
            fastIndex=fastIndex.next.next;
            slowIndex=slowIndex.next;
            if(fastIndex.equals(slowIndex)){
                return true;
            }
        }
        return false;
    }
}
