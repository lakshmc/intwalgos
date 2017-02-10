package graph.salesforce.filesystem;

/**
 * Created by lchan39
 */
public class FileSystemMgr {

    private final Node homeNode;

    private static final class SingletonHolder{
        static FileSystemMgr INSTANCE = new FileSystemMgr();
    }

    public static FileSystemMgr getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private FileSystemMgr(){
        homeNode = new DirectoryNode("/");
    }

}
