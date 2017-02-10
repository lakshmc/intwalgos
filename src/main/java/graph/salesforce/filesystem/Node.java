package graph.salesforce.filesystem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lchan39
 */
public abstract class Node {
    protected  Set<Node> children;
    protected DirectoryNode parent = null;
    protected String name = null;

    public Node(String name) {
        if(name!=null && name.length()>0){
            this.name = name;
        }
        this.children = new HashSet<Node>();
    }

    public Node(String name, DirectoryNode parent) {
        if(name!=null && name.length()>0){
            this.name = name;
        }
        this.parent = parent;
    }

    public abstract void addChild(Node child);

    public Set<Node> getChildren() {
        return children;
    }

    public void setParent(DirectoryNode parent) {
        parent.addChild(this);
        this.parent = parent;
    }


    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if(this.children.size() == 0)
            return true;
        else
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
