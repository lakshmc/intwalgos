package graph.salesforce.filesystem;

import graph.salesforce.filesystem.commands.MakeDirectoryCmd;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lchan39
 */
public class CommandParser {

    public static Map<String, Class> commands;

    static {
        commands = new HashMap<String, Class>();
        //commands.put("touch", TouchCommand.class);
        commands.put("mkdir", MakeDirectoryCmd.class);
        /*commands.put("del", DeleteCommand.class);
        commands.put("rm", DeleteCommand.class);
        commands.put("dir", ListDirCommand.class);
        commands.put("ls", ListDirCommand.class);
        commands.put("cd", ChangeDirCommand.class);
        commands.put("type", TypeCommand.class);
        commands.put("cat", TypeCommand.class);
        commands.put("write", WriteCommand.class);*/
        //commands.put("test", MakeDirectoryCmd.class);
    }

    public static void execute(String cmdLine){
        try {
            if (cmdLine != null && cmdLine.length() > 0) {
                String[] cmds = cmdLine.split(" ");
            } else {

            }
        }catch (Exception e){

        }
    }
}
