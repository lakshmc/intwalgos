import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: balaji.gandhi
 * Date: 7/28/13
 * Time: 2:51 PM
 */

class Node {
    Node left;
    Node right;
    char name;
    public boolean visited;

    Node(char name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", name=" + name +
                '}';
    }
}

public class MainUgly {
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
        connectNodes(node);
        System.out.println("node = " + node);
    }

    private static void connectNodes(Node current) {
        Node root = current;
        //find left nodes in left subtree
        //find all leaf node and add to list
        List<Node> nodeListLeft = new ArrayList<Node>();
        findLeafNode(current.left, nodeListLeft);
        //find leaf nodes in right subtree
        List<Node> nodeListRight = new ArrayList<Node>();
        findLeafNode(current.right, nodeListRight);
        //merge
        List<Node> nodeList = new ArrayList<Node>();
        nodeList.addAll(nodeListLeft);
        nodeList.addAll(nodeListRight);
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).right = nodeList.get(i + 1);
        }
    }

    private static void findLeafNode(Node current, List<Node> nodeList) {
        if (current.left == null && current.right == null) {
            nodeList.add(current);
        } else {
            if (current.left != null) {
                findLeafNode(current.left, nodeList);
            }
            if (current.right != null) {
                findLeafNode(current.right, nodeList);
            }
        }
    }
}
