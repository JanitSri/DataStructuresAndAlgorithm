package datastructures;


public class TrieNode {
    static final int ALPHABET_SIZE = 26;
    TrieNode[] children;
    boolean endOfWord;
    int numOfChilds;
    
    public TrieNode() {
        this.endOfWord = false;
        this.numOfChilds = 0;
        this.children = new TrieNode[ALPHABET_SIZE];
        
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }    
}
