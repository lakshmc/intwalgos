package IOStuff;

import java.util.*;

/**
 * Created by lchan39
 */
public class ConsoleInput {
    static Set<String> oprSet = new HashSet<String>(
            Arrays.asList("mkdir","ls","cd")
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        try{
            /*System.out.println(">");
            str = scanner.next();*/
            while(str.equals("") || !str.equals("exit")){
                if(str.length()>0) {
                    if (oprSet.contains(str)) {
                        System.out.println("operation found");
                    } else {
                        System.out.println("No operation");
                    }
                }
                System.out.print(">");
                str = scanner.next();
            }

        } catch (Exception e){
            System.out.println("Exception happened");
        }
    }
}
