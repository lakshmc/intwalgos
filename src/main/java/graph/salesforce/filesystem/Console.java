package graph.salesforce.filesystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by lchan39
 */
public class Console {

    public static void main(String[] args) {
        FileSystemMgr fsMgr = FileSystemMgr.getInstance();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("exit")){
                break;
            } else {
                CommandParser.execute(line);
            }
        }
    }
}
