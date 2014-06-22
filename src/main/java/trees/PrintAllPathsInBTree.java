package trees;

import java.util.ArrayList;

/**
 * Given a binary tree, print all the unique paths from root to child nodes
 * Using recursion: (use a list to gather each node of a given path
 *  if given node is null then return
 *  if not null include the node in the path list
 *  if the node has no children, then it is leaf, so the path is done. print the path nodes
 *  otherwise get the paths from right child and left child into the path list
 *
 */
public class PrintAllPathsInBTree {
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

        printAllPaths(one, new ArrayList<BinaryNode>());
    }

    private static void printAllPaths(BinaryNode node, ArrayList<BinaryNode> paths) {
        if(node==null){
            return;
        }
        paths.add(node);
        if(node.left==null && node.right==null){
            System.out.println(paths);
        }
        else {
            printAllPaths(node.left,new ArrayList<BinaryNode>(paths));
            printAllPaths(node.right,new ArrayList<BinaryNode>(paths));
        }

    }


}
