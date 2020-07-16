package adatraining;

import java.util.LinkedList;
import java.util.Scanner;

public class DAbril {
    static TrieNode root;
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for (int i = 0; i < T; i++) {
            root = new TrieNode();
            int N = scn.nextInt();
            LinkedList<String> solution = new LinkedList<>();

            String str;

            for (int j = 0; j < N; j++) {
                str = scn.next();

                if(insert(str)){
                    solution.add(str);
                }
            }

            System.out.println(solution.size());
            for(String s: solution)
                System.out.println(s);
        }
    }

    // Java implementation of search and insert operations
// on Trie
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        int number;
        char letter;

        TrieNode(){
            isEndOfWord = false;
            number = 0;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };



    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static boolean insert(String key){
        boolean parecida = false;
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++){
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
            pCrawl.number++;
            parecida = (pCrawl.number > 1);
            pCrawl.letter = key.charAt(level);
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
        pCrawl = root;
        if(!parecida){
            for (level = 0; level < length; level++){
                index = key.charAt(level) - 'a';

                pCrawl = pCrawl.children[index];
                parecida = (pCrawl.number > 1);

                if(parecida)
                    break;
            }
        }

        return parecida;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    // Driver
/*
        public static void main(String args[])
        {
            // Input keys (use only 'a' through 'z' and lower case)
            String keys[] = {"the", "a", "there", "answer", "any",
                    "by", "bye", "their"};

            String output[] = {"Not present in trie", "Present in trie"};


            root = new TrieNode();

            // Construct trie
            int i;
            for (i = 0; i < keys.length ; i++)
                insert(keys[i]);

            // Search for different keys
            if(search("the") == true)
                System.out.println("the --- " + output[1]);
            else System.out.println("the --- " + output[0]);

            if(search("these") == true)
                System.out.println("these --- " + output[1]);
            else System.out.println("these --- " + output[0]);

            if(search("their") == true)
                System.out.println("their --- " + output[1]);
            else System.out.println("their --- " + output[0]);

            if(search("thaw") == true)
                System.out.println("thaw --- " + output[1]);
            else System.out.println("thaw --- " + output[0]);

        }*/

}
