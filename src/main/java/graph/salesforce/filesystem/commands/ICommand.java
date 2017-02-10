package graph.salesforce.filesystem.commands;

import graph.salesforce.filesystem.FileSystemMgr;

import java.io.IOException;
import java.nio.file.FileSystem;

/**
 * Created by lchan39
 */
public interface ICommand {
    public void execute(FileSystemMgr fs, String[] parts) throws IOException;
}
