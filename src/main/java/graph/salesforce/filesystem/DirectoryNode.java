package graph.salesforce.filesystem;

import org.junit.Test;

/**
 * Created by lchan39
 */
public class DirectoryNode extends Node {

    public DirectoryNode(String name) {
        super(name);
    }

    public DirectoryNode(String name, DirectoryNode parent) {
        super(name, parent);
    }

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }
}
