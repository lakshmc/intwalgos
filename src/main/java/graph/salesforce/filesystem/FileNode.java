package graph.salesforce.filesystem;

/**
 * Created by lchan39
 */
public class FileNode extends Node {

    public FileNode(String name) {
        super(name);
    }

    public FileNode(String name, DirectoryNode parent) {
        super(name, parent);
    }

    public void addChild(Node child) {
        throw new IllegalArgumentException(this.name+" is not a directory");
    }
}
