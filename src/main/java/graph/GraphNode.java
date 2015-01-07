package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lchan39 on 1/7/15.
 */
public class GraphNode {
    public String value;
    public List<GraphNode> children;

    GraphNode(String value){
        this.value = value;
        children=new ArrayList<GraphNode>();
    }
    GraphNode(String value, List<GraphNode> children){
        this.value = value;
        this.children=children;
    }

    public void addChildren(GraphNode... nodes){
        Collections.addAll(children, nodes);
    }
}
