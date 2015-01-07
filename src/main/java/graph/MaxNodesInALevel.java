package graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lchan39 on 1/7/15.
 */
public class MaxNodesInALevel {
    public static void main(String[] args) {
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

        maxNodesInLevel(nodeA);// 8 in 3

        maxNodesInLevel(nodeU);// 1 in zero

        maxNodesInLevel(nodeM);// 2 in 1

    }

    private static void maxNodesInLevel(GraphNode root) {
        if(root==null){
            System.out.println("No root node");
        } else {
            int max=1 ,maxLevel=0,level=0; // max is 1 to account for root
            Queue<GraphNode> currentLevel = new LinkedList<GraphNode>();
            Queue<GraphNode> nextLevel = new LinkedList<GraphNode>();
            currentLevel.add(root);
            while(!currentLevel.isEmpty()){
                GraphNode currentNode = currentLevel.remove();
                nextLevel.addAll(currentNode.children);
                if(currentLevel.isEmpty() && !nextLevel.isEmpty()){ // go in only if there are nodes in next level
                    level++;
                    if(nextLevel.size()>max){
                        max = nextLevel.size();
                        maxLevel=level;
                    }
                    currentLevel.addAll(nextLevel);
                    nextLevel.clear();
                }
            }
            System.out.println("Max nodes "+ max +" in level " + maxLevel);
        }
    }
}
