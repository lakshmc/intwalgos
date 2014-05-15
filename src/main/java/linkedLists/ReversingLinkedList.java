package linkedLists;

/**
 * Created on 5/10/14.
 */
public class ReversingLinkedList {
    public static void main(String[] args) {
        Node ech = new Node("H",null);
        Node gee = new Node("G",ech);
        Node eff = new Node("F",gee);
        Node eee = new Node("E",eff);
        Node dee = new Node("D",eee);
        Node cee = new Node("C",dee);
        Node bee = new Node("B",cee);
        Node node1 = new Node("A",bee);

        PrintLinkedList.printLinkedList(node1);

        //Node reversedHead = reverse(node1);

        //PrintLinkedList.printLinkedList(reverse(node1));

        PrintLinkedList.printLinkedList(reverseIteratively(node1));

    }

    private static Node reverse(Node node) {
        if(node==null) return null; // only possible if first argument is itself null
        else if(node.next==null) return node;
        else{
            Node nextNode = node.next;
            node.next=null;
            Node reversedHead = reverse(nextNode);
            nextNode.next=node;
            return reversedHead;
        }

    }

    private static Node reverseIteratively(Node originalHead) {
        Node nextHead = null, futureHead = null;
        if (originalHead == null) return null;
        if(originalHead.next==null) return originalHead;

        nextHead=originalHead.next;
        futureHead=originalHead.next.next;

        nextHead.next=originalHead;
        originalHead.next=futureHead;

        futureHead = originalHead.next.next;

        while(originalHead.next!=null){
            originalHead.next.next=nextHead;
            nextHead=originalHead.next;
            originalHead.next=futureHead;

            if(futureHead!=null){
                futureHead=futureHead.next;
            }
        }
        return nextHead;

    }
}
