import java.util.LinkedList;
import java.util.Queue;

/*
         5
        / \
       3  2
      /  / \
     4  2  1
       / \
      9  9
     /
    7
*/


public class BinaryTreePrinting2 {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        public String toString() {
            return "[" + data + "]";
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left=new Node(4);
        root.right = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(1);
        root.right.left.left = new Node(9);
        root.right.left.left.left = new Node(7);
        root.right.left.right = new Node(9);
        printBFSTree(root);
    }

    private static void printBFSTree(Node root) {
        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();
        currentLevel.offer(root);
        while (!currentLevel.isEmpty()) {
            Node peek = currentLevel.peek();
            if (peek != null) {
                System.out.print(peek.data + " ");
                if (peek.left != null) {
                    nextLevel.add(peek.left);
                }
                if (peek.right != null) {
                    nextLevel.add(peek.right);
                }
                currentLevel.remove();
            }
            if (currentLevel.isEmpty()) {
                System.out.println();
                while (!nextLevel.isEmpty()) {
                    currentLevel.offer(nextLevel.remove());

                }
            }
        }
    }

}
