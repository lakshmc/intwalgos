package stringarray;

import java.util.HashMap;
import java.util.Map;

/**
 * Q. Build a data structure that allows addition of new words and search
 *
 * S. Trie: Tree with each node representing a letter, each path from root to leaf represents a word.
 *  Search/Retrieval-> DFS traversal -> O(M) (M -length of word)
 *  Insert: Storage is concern since each letter can have many child nodes depending on the size of the dictionary.
 *      - O(ALPHABET_SIZE * key_length * N) where N is number of keys in trie
 */
public class BuildSearchDictionaryTrie {

    public static void main(String[] args) {

        TrieDictionary dictionary = new TrieDictionary();
        System.out.println(dictionary.wordExists("hello"));
        dictionary.addWord("hello");
        System.out.println(dictionary.wordExists("hello"));
        System.out.println(dictionary.wordExists("world"));
        System.out.println(dictionary.wordExists(""));
        dictionary.addWord("");
        System.out.println(dictionary.wordExists(""));
    }
}

class TrieDictionary {
    private TrieNode root;

    TrieDictionary() {
        root = new TrieNode();
    }

    void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Map<Character, TrieNode> children = root.children;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char key = chars[i];
            TrieNode node = null;
            if (children.containsKey(key)) {
                node = children.get(key);
            } else {
                node = new TrieNode(key);
                children.put(key, node);
            }
            children = node.children;
            if (i == chars.length - 1) {
                node.isLeaf = true;
            }
        }
    }

    boolean wordExists(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return findNode(word) != null;
    }

    private TrieNode findNode(String word) {
        char[] chars = word.toCharArray();
        Map<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for (char key : chars) {
            if (children.containsKey(key)) {
                node = children.get(key);
                children = node.children;
            } else {
                return null;
            }
        }
        return node;
    }

    private class TrieNode{
        Map<Character, TrieNode> children;
        boolean isLeaf;
        char key;

        TrieNode(){
            this.children = new HashMap<Character, TrieNode>();
        }
        TrieNode(char key){
            this.key=key;
            this.children = new HashMap<Character, TrieNode>();
        }
    }
}


