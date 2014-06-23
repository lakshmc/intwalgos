package trees;

import java.util.LinkedList;
import java.util.Queue;

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

        System.out.println("\nBFS: ");
        breadthFirstTraversalBFS(one);

        System.out.println("\nBFS Single Queue: ");
        breadthFirstTraversalBFSSingleQueue(one);

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

    /**
     * Keep two queues to keep track of nodes in the current level and the children of each of those nodes.
     * For each node in current node, print it and them put its children into the next-queue and once current queue is empty
     * move the contents of next-queue to current queue. When the current the queue is empty, it means a level is done so print
     * a next line.
     *
     */
    private static void breadthFirstTraversalBFS(BinaryNode root){
        Queue<BinaryNode> levelQueue = new LinkedList<BinaryNode>();
        Queue<BinaryNode> currentQueue = new LinkedList<BinaryNode>();
        currentQueue.offer(root);
        while (!currentQueue.isEmpty()){
            BinaryNode node = currentQueue.remove();
            System.out.print(node.value);
            if(node.left!=null)
                levelQueue.offer(node.left);
            if(node.right!=null)
                levelQueue.offer(node.right);
            if(currentQueue.isEmpty()){
                System.out.println();
                currentQueue.addAll(levelQueue);
                levelQueue.clear();
            } else {
                System.out.print(" ");
            }
        }

    }

    /**
     * same as above but, instead of using two queues this one uses single queue. This uses a counter to keep track current
     * level nodes and next level nodes.
     */

    private static void breadthFirstTraversalBFSSingleQueue(BinaryNode root){
        Queue<BinaryNode> currentQueue = new LinkedList<BinaryNode>();
        currentQueue.offer(root);
        int nextLevelCount=0;
        int currentLevelCount=1;
        while (!currentQueue.isEmpty()){
            BinaryNode node = currentQueue.remove();
            currentLevelCount--;
            System.out.print(node.value);
            if(node.left!=null){
                currentQueue.offer(node.left);
                nextLevelCount++;
            }
            if(node.right!=null){
                currentQueue.offer(node.right);
                nextLevelCount++;
            }
           if(currentLevelCount==0){
               System.out.println();
               currentLevelCount=nextLevelCount;
               nextLevelCount=0;
           }else {
               System.out.print(" ");
           }
        }

    }
}
