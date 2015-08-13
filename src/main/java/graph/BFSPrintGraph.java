package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lchan39 on 1/7/15.
 */
public class BFSPrintGraph {

    private static GraphNode clearNodeVisited() {
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        GraphNode nodeE = new GraphNode("E");
        GraphNode nodeF = new GraphNode("F");
        GraphNode nodeG = new GraphNode("G");
        GraphNode nodeH = new GraphNode("H");
        GraphNode nodeI = new GraphNode("I");
        GraphNode nodeJ = new GraphNode("J");
        GraphNode nodeK = new GraphNode("K");
        GraphNode nodeL = new GraphNode("L");
        GraphNode nodeM = new GraphNode("M");
        GraphNode nodeN = new GraphNode("N");
        GraphNode nodeO = new GraphNode("O");
        GraphNode nodeP = new GraphNode("P");
        GraphNode nodeQ = new GraphNode("Q");
        GraphNode nodeR = new GraphNode("R");
        GraphNode nodeS = new GraphNode("S");
        GraphNode nodeT = new GraphNode("T");
        GraphNode nodeU = new GraphNode("U");
        GraphNode nodeV = new GraphNode("V");
        GraphNode nodeW = new GraphNode("W");
        GraphNode nodeX = new GraphNode("X");
        GraphNode nodeY = new GraphNode("Y");
        GraphNode nodeZ = new GraphNode("Z");

        nodeA.addChildren(nodeB,nodeC);
        nodeB.addChildren(nodeF,nodeD,nodeE,nodeG);
        nodeD.addChildren(nodeQ,nodeO,nodeP,nodeY,nodeZ);
        nodeO.addChildren(nodeR);
        nodeP.addChildren(nodeS,nodeT);
        nodeC.addChildren(nodeH);
        nodeH.addChildren(nodeJ,nodeK,nodeI);
        nodeJ.addChildren(nodeM,nodeL);
        nodeK.addChildren(nodeN);
        nodeM.addChildren(nodeU,nodeV);
        nodeL.addChildren(nodeX,nodeW);

        return nodeA;
    }

    public static void main(String[] args) {
        GraphNode nodeA = clearNodeVisited();

        BFSPrint(nodeA);
        System.out.println();
        nodeA = clearNodeVisited();
        BFSPrintSingleQueue(nodeA);
        System.out.println();
        nodeA = clearNodeVisited();
        DFS(nodeA);
    }

    private static void BFSPrint(GraphNode root) {
        Queue<GraphNode> currentLevel = new LinkedList<GraphNode>();
        Queue<GraphNode> nextLevel = new LinkedList<GraphNode>();
        currentLevel.add(root);
        int level =0;
        while(!currentLevel.isEmpty()){
            GraphNode currentNode = currentLevel.remove(); // if queue empty, throws exception, will never happen
            nextLevel.addAll(currentNode.children);
            System.out.print(" " + currentNode.value + " ");
            if(currentLevel.isEmpty() && !nextLevel.isEmpty()){
                level++;
                currentLevel.addAll(nextLevel);
                nextLevel.clear();
                System.out.print("\nLevel: " + level + " size: " + currentLevel.size() + ": ");
            }
        }
    }

    // using single queue, but not new line for new level
    private static void BFSPrintSingleQueue(GraphNode root) {
        Queue currentLevel = new LinkedList();
        currentLevel.add(root);
        root.visited=true;
        System.out.println(" "+root.value+" ");
        int level =0;
        while(!currentLevel.isEmpty()){
            GraphNode currentNode = (GraphNode) currentLevel.remove(); // if queue empty, throws exception, will never happen
            for(GraphNode graphNode: currentNode.children){
                if(!graphNode.visited){
                    currentLevel.add(graphNode);
                    graphNode.visited=true;
                    System.out.println(" "+graphNode.value+" ");
                }
            }
        }
    }



    private static void DFS(GraphNode root){
        Stack stack = new Stack();
        stack.push(root);
        root.visited=true;
        System.out.println(" "+root.value+" ");

        while(!stack.isEmpty()){
            GraphNode node = (GraphNode)stack.peek(); // get head not, don't remove, since we are dealing with one child at a time
            GraphNode child = null;
            for (GraphNode child1: node.children){
                if(!child1.visited){
                    child=child1;
                    break;
                }
            }
            if(child!=null){
                child.visited=true;
                System.out.println(" "+child.value+" ");
                stack.push(child);
            } else {
                stack.pop();
            }
        }
    }
}
