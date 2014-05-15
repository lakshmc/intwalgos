import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: balaji.gandhi
 * Date: 7/28/13
 * Time: 2:51 PM
 */

public class MainOptimized {
    public static void main(String[] args) {
        Node node = new Node('A');
        node.left = new Node('B');
        node.left.left = new Node('D');
        node.left.right = new Node('X');
        node.left.right.right = new Node('E');
        node.right = new Node('C');
        node.right.left = new Node('F');
        node.right.right = new Node('G');
        System.out.println("node = " + node);
        Node previousNode = null;
        List<Node> previousNodeHolder = new ArrayList<Node>();
        previousNodeHolder.add(previousNode);
        connectNodes(node, previousNodeHolder);
        System.out.println("node = " + node);
    }

    private static void connectNodes(Node current, List<Node> previousNodeHolder) {
        if (current == null) {
            return;
        }
        if (current.left == null && current.right == null) {
            Node previousNode = previousNodeHolder.get(0);
            if (previousNode == null) {
                previousNode = current;
            } else {
                previousNode.right = current;
                previousNode = current;
            }
            previousNodeHolder.set(0, previousNode);
        } else {
            connectNodes(current.left, previousNodeHolder);
            connectNodes(current.right, previousNodeHolder);
        }
    }
}
