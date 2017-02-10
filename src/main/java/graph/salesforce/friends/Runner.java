package graph.salesforce.friends;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lchan39
 */
public class Runner {

    private static FriendManager friendsMgr;

    public static void main(String[] args) {

        friendsMgr = new FriendManager();

        friendsMgr.makeFriends("Alfred", new HashSet<String>(Arrays.asList("Bruce","Stark","Rogers")));

        Set<String> bruceSet = new HashSet<String>(Arrays.asList("Joker","Fox"));
        friendsMgr.makeFriends("Bruce", bruceSet);

        Set<String> rogerSet = new HashSet<String>(Arrays.asList("HawkEye","Baner"));
        friendsMgr.makeFriends("Rogers", rogerSet);
        Set<String> starkSet = new HashSet<String>(Arrays.asList("Rhodes", "Piper"));
        friendsMgr.makeFriends("Stark", starkSet);


        // Level 3
        friendsMgr.makeFriends("Rhodes", new HashSet<String>(Arrays.asList("Piper","Baner","Peter")));

        // level 4
        friendsMgr.makeFriends("Peter", new HashSet<String>(Arrays.asList("Mae","MJ")));


        printDirectFriends("Alfred");

        printInDirectFriends("Alfred", 3);

    }
    public static void printDirectFriends(String personName){
        if(personName!=null && personName.length()>0){
            System.out.println("DIRECT FRIENDS of "+personName);
            System.out.println(friendsMgr.getDirectFriends(personName));
        }
    }

    /**
     *
     * @param persons
     * @param level - direct friends are level 0. -1 for all levels.
     */
    public static void printInDirectFriends(String personName, int level){
        if(personName!=null && personName.length()>0){
            System.out.println("INDIRECT FRIENDS of "+personName);
            friendsMgr.getIndirectFriends(personName, level);
            //System.out.println();
        }
    }
}
