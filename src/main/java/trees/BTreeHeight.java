package trees;

/**
 * Created on 5/11/14.
 */

/**
 * Height of a node = 1 + max(height of left node, height of right node)
 */
public class BTreeHeight {
    public static void main(String[] args) {
        BinaryNode one = new BinaryNode(1);
        BinaryNode thirteen = new BinaryNode(13);
        BinaryNode ten = new BinaryNode(10);
        BinaryNode twelve = new BinaryNode(12);
        BinaryNode eleven = new BinaryNode(11);
        BinaryNode fifteen = new BinaryNode(15);
        BinaryNode fourteen = new BinaryNode(14);
        BinaryNode seventeen = new BinaryNode(17);
        BinaryNode eighteen = new BinaryNode(18);
        BinaryNode twentyone = new BinaryNode(21);

        thirteen.left=ten;
        thirteen.right=fifteen;

        ten.left=one;
        ten.right=twelve;
        twelve.left=eleven;

        fifteen.left=fourteen;
        fifteen.right=seventeen;
        seventeen.right=twentyone;
        twentyone.left=eighteen;

        System.out.println("height: "+ calcHeight(thirteen));
    }

    private static int calcHeight(BinaryNode node) {
        if(node==null){
            return 0;
        } else {
            return 1 + Math.max(calcHeight(node.left), calcHeight(node.right));
        }
    }
}
