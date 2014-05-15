package trees;

/**
 * Created on 5/11/14.
 */
public class LowestCommonAncestor {
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

        System.out.println("LCA: "+ getLCANode(thirteen, fourteen, twentyone));
        System.out.println("LCA: "+ getLCANode(thirteen, seventeen, twelve));
        System.out.println("LCA: "+ getLCANode(thirteen, ten, thirteen));
        System.out.println("LCA: "+ getLCANode(thirteen, one, twelve));
    }

    private static BinaryNode getLCANode(BinaryNode root, BinaryNode node1, BinaryNode node2) {
        if(root==null){
            return null;
        }
        else if(node1==root || node2==root){
            return root;
        } else {
            BinaryNode left = getLCANode(root.left, node1, node2);
            BinaryNode right = getLCANode(root.right, node1, node2);
            if(left!=null && right!=null){
                return root;
            }

            return (left!=null)? left: right;
        }
    }
}
