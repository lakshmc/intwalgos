package linkedLists;

/**
 * Circular Linked list is one where the tail points to head
 * Linked List with Loop is one where the tail points one of the other nodes, which may or may not be the head,
 * inside the list, creating a loop. The length of the list is m+n where m is the number of nodes from head to the
 * node that forms the beginning loop and n is the number nodes that form the loop.
 *
 * Find if there is a loop: isCircularList()
 * Use slow/fast index (a.k.a Tortoise/hare method)
 *
 * Find the node where the loop starts: findLoopBeginning()
 */
public class LinkedListHasLoop {

    public static void main(String[] args) {

        Node nine = new Node("9",null);
        Node eight = new Node("8",nine);
        Node seven = new Node("7",eight);
        Node sixth = new Node("6",seven);
        Node fifth = new Node("5",sixth);
        Node fourth = new Node("4",fifth);
        Node third = new Node("3",fourth);
        Node second = new Node("2",third);
        Node start = new Node("1",second);

        System.out.println("Original List: ");
        PrintLinkedList.printLinkedList(start);

        eight.next=fourth; //this makes it circular

        System.out.println("\nHas loop:"+isCircularList(start));

        Node returned = findLoopBeginning(start);
        System.out.println("Loop starts at: "+(returned==null?null:returned.value));

        PrintLinkedList.printLoopedList(start,returned);

    }

    /**
     * Follows Floyd's Algorithm for cycle detection
     * Solution:
     * 1. Have two indexes: fast index and slow index
     * 2. Move slow index once and fast index twice
     * 3. Repeat step 2 until
     *  a. slow and fast index are equal-> there is a loop (note: this may or may not be the start of the loop)
     *  b. fast index is null-> there is no loop and you have reached the end of the list.
     *
     * The mathematical principle that guarantees this is available here: http://stackoverflow.com/a/6110767
     */
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

    /**
     * Follows Floyd's Algorithm for cycle detection
     * Solution:
     * 1. Using the fast node/ slow node process (isCircularList(node) shown) find the first time the nodes meet
     * 2. set the slow node to head
     * 3. move both fast and slow nodes by one until they meet again
     * 4. this meeting point is the start node of the loop
     *
     * The mathematical principle that guarantees this is available here: http://stackoverflow.com/a/6110767
     */
    private static Node findLoopBeginning(Node start) {
        Node fastIndex=start;
        Node slowIndex=start;
        boolean isLoopPresent = false;
        while (fastIndex!=null && fastIndex.next!=null){
            fastIndex=fastIndex.next.next;
            slowIndex=slowIndex.next;
            if(fastIndex.equals(slowIndex)){
                // first meet, will be inside the loop.
                isLoopPresent =true;
                break;
            }
        }

        if(isLoopPresent){
            slowIndex=start;
            while(true){
                if(fastIndex.equals(slowIndex)){
                    return slowIndex;
                } else {
                    slowIndex=slowIndex.next;
                    fastIndex=fastIndex.next;
                }
            }
        }
        return null;
    }
}
