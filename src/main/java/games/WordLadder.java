package games;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 *
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        Set<String> dict =  new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(ladder.ladderLength_BruteForce("hit", "cog", dict));
        System.out.println(ladder.ladderLength("hit", "cog", dict));
    }

    public int ladderLength(String start, String end, Set<String> dict) {

        if (dict.size() == 0)
            return 0;

        if (start.equals(end)){
            return 1;
        }
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> distanceQueue = new LinkedList<Integer>();

        wordQueue.add(start);
        distanceQueue.add(1);


        while(!wordQueue.isEmpty()){
            String currWord = wordQueue.poll();
            Integer currDistance = distanceQueue.poll();

            /*if(currWord.equals(end)){
                return currDistance;
            }*/

            for(int i=0; i<currWord.length(); i++){
                char[] currCharArr = currWord.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if(newWord.equals(end)){
                        return currDistance+1;
                    } else if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance+1);
                        dict.remove(newWord); //why?
                    }
                }
            }
        }

        return 0;
    }

    public int ladderLength_BruteForce(String start, String end, Set<String> dict) {

        int len=0;

        for(int i=0; i<start.length(); i++){
            char[] startArr = start.toCharArray();

            for(char c='a'; c<='z'; c++){
                if(c==start.toCharArray()[i]){
                    continue;
                }

                startArr[i] = c;
                String temp = new String(startArr);
                if(dict.contains(temp)){
                    len++;
                    start = temp;
                    if(temp.equals(end)){
                        return len;
                    }
                }
            }
        }

        return len;
    }
}
