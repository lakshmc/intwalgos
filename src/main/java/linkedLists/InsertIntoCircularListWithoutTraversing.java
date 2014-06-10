package linkedLists;

/**
 * Problem: There is a singly linked circular list, where the tail.next points to the head. Given the head and a new node,
 * write an algorithm to insert the new node before the head, making it the new tail, without traversing the list,
 * while keeping the list circular.
 * Solution:
 * You need the new node to become the last node, which is pointed to from the former last node, and which points to the
 * head node. Now, you want to avoid traversing the list to find the last node. This means that you cannot access that
 * last node and thus, not modify its pointer. The way to make this work is to modify the place that last node points to:
    1. insert a new node after the head node
    2. copy the current head node's value to that new node
    3. put the new value into the current head node
    4. make the new node the new head node
 * From: http://stackoverflow.com/a/1097061
 *
 * TIME COMPLEXITY is O(1)
 */
public class InsertIntoCircularListWithoutTraversing {
    public static void main(String[] args) {
        Node fifth = new Node("E",null);
        Node fourth = new Node("D",fifth);
        Node third = new Node("C",fourth);
        Node second = new Node("B",third);
        Node start = new Node("A",second);

        fifth.next = start; // makes the list circular

        Node kNode = new Node("K",null);

        System.out.println("Before insertion:");
        PrintLinkedList.printCircularLinkedList(start);

        Node newNode = insertBeforeHead(start, kNode);

        System.out.println("After insertion:");
        PrintLinkedList.printCircularLinkedList(newNode);
    }

    private static Node insertBeforeHead(Node start, Node kNode) {
        if (start==null){
            start=kNode;
            kNode.next=kNode; // make it circular
        } else {
            // insert kNode after head
            Node link = start.next;
            start.next=kNode;
            kNode.next=link;
            // swap the values between head and kNode
            String headValue = start.value;
            start.value=kNode.value;
            kNode.value=headValue;

            // make kNode (with head value) as new head
            start = kNode;
        }
        return start;
    }
}
