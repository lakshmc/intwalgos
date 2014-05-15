import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 8/21/13
 * Time: 12:01 PM
 */
class MyNode {
    MyNode left;
    MyNode right;
    char name;

    MyNode(char name) {
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

public class GraphStuff {

    public static void main(String[] args) {
        MyNode node = new MyNode('A');
        node.left = new MyNode('B');
        node.left.left = new MyNode('D');
        node.left.right = new MyNode('X');
        node.left.right.right = new MyNode('E');
        node.right = new MyNode('C');
        node.right.left = new MyNode('F');
        node.right.right = new MyNode('G');
        System.out.println("node = " + node);
        MyNode previousNode = null;
        List<MyNode> previousNodeHolder = new ArrayList<MyNode>();
        previousNodeHolder.add(previousNode);
        //connectNodes(node, previousNodeHolder);
        System.out.println("node = " + node);
    }

    /*public void bfs(Node rootNode)
    {
        // BFS uses Queue data structure
        Queue queue = new LinkedList();
        queue.add(rootNode);
        System.out.println(" = " + rootNode);
        rootNode.visited = true;
        while(!queue.isEmpty()) {
            Node node = (Node)queue.remove();
            Node child=null;
            while((child=getUnvisitedChildNode(node))!=null) {
                child.visited=true;
                printNode(child);
                queue.add(child);
            }
        }
        // Clear visited property of nodes
        clearNodes();
    }*/
}
