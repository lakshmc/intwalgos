import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {
    private static class Member{
        String name;
        List<Member> friends;
        boolean isVisited;

        Member(String name){
            this.name = name;
            friends = new ArrayList<Member>();
        }
        
        boolean hasFriends(){
            return friends!=null && friends.size()>0;
        }
        
        void addFriends(String name){
            if(hasFriends()){
                friends.add(new Member(name));
            }
        }

        Member getUnvisitedFriend(){
            for(Member m:friends){
                if(!m.isVisited){
                    return m;
                }
            }
            return null;
        }
    }
    
    public static void main(String args[]){
        Member root = new Member("KC");

        Member muan = new Member("Muan");
        Member sen = new Member("Sen");
        Member pani = new Member("Pani");
        root.friends.add(muan);
        root.friends.add(sen);
        root.friends.add(pani);
        Member muansfriend = new Member("muansfriend");
        muan.friends.add(muansfriend);
        Member sensfriend = new Member("sensfriend");
        sen.friends.add(sensfriend);
        sen.addFriends("sen'ssecondfriend");
        Member balaji = new Member("Balaji");
        Member sundar = new Member("Sundar");
        pani.friends.add(balaji);pani.friends.add(sundar);
        Member sundarfriend = new Member("sundarfriend");
        sundar.friends.add(sundarfriend);

        printBFSFriends(root);
        System.out.println();
        printBFSFriends_SingleQueue(root);
        
    }

    /**
     * Queue.poll()-> removes head element is queue is not empty vs remove() which will throw exception if queue empty
     * Queue.offer()-> adds to the queue and returns true vs add() which will throw exception is queue is full
     * Queue.peek()-> same as poll but doesnt remove the head. Like element()
     */

    private static void printBFSFriends(Member root) {
        Queue<Member> currentLevel = new LinkedList<Member>();
        Queue<Member> nextLevel = new LinkedList<Member>();
        currentLevel.offer(root);
        while (!currentLevel.isEmpty()){
            Member currentMember = currentLevel.poll();
            if(currentMember!=null){
                System.out.print(currentMember.name + " ");
                if(currentMember.hasFriends()){
                    nextLevel.addAll(currentMember.friends);
                }
            }
            if(currentLevel.isEmpty()){
                System.out.println();
                while(!nextLevel.isEmpty()){
                    currentLevel.offer(nextLevel.remove());
                }
            }

        }
    }

    private static void printBFSFriends_SingleQueue(Member root) {
        Queue<Member> currentLevel = new LinkedList<Member>();
        currentLevel.offer(root);
        root.isVisited=true;
        while (!currentLevel.isEmpty()){
            Member currentMember = currentLevel.poll();
            if(currentMember!=null){
                System.out.print(currentMember.name + " ");
                if(currentMember.hasFriends()){
                        while(currentMember.getUnvisitedFriend()!=null){
                        Member fr = currentMember.getUnvisitedFriend();
                        fr.isVisited=true;
                        currentLevel.offer(fr);
                    }
                }

            }
        }
    }

}
