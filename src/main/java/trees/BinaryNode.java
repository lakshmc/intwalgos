package trees;

/**
 * Created on 5/11/14.
 */
public class BinaryNode {
    int value;
    BinaryNode right;
    BinaryNode left;

    public BinaryNode(int i) {
        this.value=i;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "value=" + value +
                '}';
    }
}
