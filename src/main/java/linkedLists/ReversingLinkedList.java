package linkedLists;

/**
 * Created on 5/10/14.
 *
 * Reversing a singly linked list
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

        System.out.println("Original:");
        PrintLinkedList.printLinkedList(node1);

        System.out.println("\nRecursive:");
        Node reversedHead = reverse(node1);
        PrintLinkedList.printLinkedList(reversedHead);

        System.out.println("\nIterative Long form:");
        reversedHead =  reverseIterativelyLong(reversedHead);
        PrintLinkedList.printLinkedList(reversedHead);

        System.out.println("\nIterative Short form:");
        reversedHead = reverseIterativelyShort(reversedHead);
        PrintLinkedList.printLinkedList(reversedHead);

    }

    /**
     * Solution: reverse of a linked list is basically reversing the list without the head and attaching the head to the end.
     * reverse of null is null
     * reverse of a node is the node itself
     * reverse of a list is:
     *      1. detach the first node (F), keep track of the first.next(N) node
     *      2. reverse the rest of the list (head of this reversed list is the head of the fully reversed list)
     *      3. attach the F to N.next
     */

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

    /**
     * 1. Keep track of previous and next node from current node
     * 2. For each current node, mark its next to previous node
     * 3. new previous is current and new current is old next
     * 4. repeat until current is null-
     *
     */

    private static Node reverseIterativelyShort(Node originalHead) {

        Node previous = null;
        Node current = originalHead;

        while(current!=null){
            Node nextNode = current.next;
            current.next=previous;
            previous=current;
            current=nextNode;
        }
        return previous;

    }

    /**
     * Given how simple and straight forward the above solution is, why would you want to use this one??
     */
    private static Node reverseIterativelyLong(Node originalHead) {
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
