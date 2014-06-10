package linkedLists;

/**
 * Created on 5/10/14.
 */
public class PrintLinkedList {
    public static void main(String[] args) {
        Node ech = new Node("H",null);
        Node gee = new Node("G",ech);
        Node eff = new Node("F",gee);
        Node eee = new Node("E",eff);
        Node dee = new Node("D",eee);
        Node cee = new Node("C",dee);
        Node bee = new Node("B",cee);
        Node node1 = new Node("A",bee);

        printLinkedList(node1);
    }

    public static void printLinkedList(Node root) {
        while(root!=null){
            System.out.print(root.value+(root.next!=null?"->":""));
            root=root.next;
        }
        System.out.println();
    }

    public static void printCircularLinkedList(Node root) {
        Node originalRoot = root;
        System.out.print(root.value+(root.next!=null?"->":""));
        root=root.next;
        while(root!=null && !originalRoot.equals(root)){
            System.out.print(root.value+(root.next!=null?"->":""));
            root=root.next;
        }
        System.out.print(root==null?"\n":root.value+"\n");
    }

    public static void printLoopedList(Node root, Node loopStartNode){
        while(root!=null){
            if(root.equals(loopStartNode)){
                printCircularLinkedList(loopStartNode);
                root=null; // break out of loop
            } else {
                System.out.print(root.value+(root.next!=null?"->":""));
                root=root.next;
            }
        }
        System.out.println();

    }
}
