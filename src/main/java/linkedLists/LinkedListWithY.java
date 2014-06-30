package linkedLists;

/**
 * Created on 5/10/14.
 */
public class LinkedListWithY {
    public static void main(String[] args) {
        Node eee = new Node("E",null);
        Node dee = new Node("D",eee);
        Node cee = new Node("C",dee);
        Node bee = new Node("B",cee);
        Node node1 = new Node("A",bee);

        Node third = new Node("3",null);
        Node second = new Node("2",third);
        Node node2 = new Node("1",second);

        third.next=dee; // forms Y

        //Node fourth = new Node("4",eee);
        //third.next=fourth; // forms V

        System.out.println(hasYShape(node1, node2));

    }

    /**
     * given two heads, find the node where they form y. return false if not
     * 1. get length of first list. A
     * 2. get length of second list. B
     * 3  calc abs(A-B) = C
     * 4. traverse the longer list by C nodes. this is h1. head of shorter list is h2
     * 5. At this time, the common node is at equal distance from both h1 and h2.
     * 6. until end of (one of the)list is reached (no Y node), or h1==h2 (h1 and h2 are the Y node) is satisfied, move h1 and h2 by one node.
     */

    private static boolean hasYShape(Node node1, Node node2) {
        if(node1==null || node2==null){
            System.out.println("head is null, no Y here");
            return false;
        }

        int node1Length=1;
        int node2Length=1;
        Node node1Tracker =node1;
        Node node2Tracker =node2;

        while(node1Tracker.next!=null){
            node1Tracker = node1Tracker.next;
            node1Length++;
        }

        while(node2Tracker.next!=null){
            node2Tracker = node2Tracker.next;
            node2Length++;
        }
        node1Tracker=node1;
        node2Tracker=node2;
        int diff = Math.abs(node1Length-node2Length);
        if(node1Length>node2Length){
           while(diff>0){
               node1Tracker = node1Tracker.next;
               diff--;
           }
        } else if(node2Length>node1Length){
            while(diff>0){
                node2Tracker = node2Tracker.next;
                diff--;
            }
        }
        while(node1Tracker!=null){
            if(node1Tracker.equals(node2Tracker)){
                System.out.println("Y or V node found: "+node1Tracker.value);
                return true;
            }
            node1Tracker= node1Tracker.next;
            node2Tracker= node2Tracker.next;
        }
        return false;
    }
}
