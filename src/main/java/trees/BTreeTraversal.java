package trees;

/**
 * Created on 5/11/14.
 */
public class BTreeTraversal {
    public static void main(String[] args) {
        BinaryNode one = new BinaryNode(1);
        BinaryNode two = new BinaryNode(2);
        BinaryNode three = new BinaryNode(3);
        BinaryNode four = new BinaryNode(4);
        BinaryNode five = new BinaryNode(5);
        BinaryNode six = new BinaryNode(6);
        BinaryNode seven = new BinaryNode(7);
        BinaryNode eight = new BinaryNode(8);
        BinaryNode nine = new BinaryNode(9);

        one.left=two;
        one.right=three;

        two.left=four;
        two.right=five;

        four.left=seven;
        three.left=six;
        six.left=eight;
        six.right=nine;

        System.out.print("pre: ");
        printPreOrder(one);
        System.out.print("\npost: ");
        printPostOrder(one);
        System.out.print("\nIn: ");
        printInOrder(one);
    }

    private static void printPreOrder(BinaryNode node) {
        if(node!=null){
            System.out.print(node.value+" ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
    private static void printPostOrder(BinaryNode node) {
        if(node!=null){
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.value+" ");
        }
    }
    private static void printInOrder(BinaryNode node) {
        if(node!=null){
            printInOrder(node.left);
            System.out.print(node.value+" ");
            printInOrder(node.right);
        }
    }
}
