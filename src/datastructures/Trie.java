package datastructures;


public class Trie {
    private TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public int getCharLoc(char c){
        return Character.toUpperCase(c) - 'A';
    }
    
    public void insert(String word){
        TrieNode currNode = root;
        
        for (int i = 0; i < word.length(); i++) {
            
            int index = getCharLoc(word.charAt(i));
            
            if(currNode.children[index] == null){
                currNode.children[index] = new TrieNode();
                currNode.numOfChilds++;
            }
            
            currNode = currNode.children[index];
        }
        
        currNode.endOfWord = true;
    }
    
    public void searchWord(String word){
        searchWord(word, 0, root);
    }
    
    public boolean searchWord(String word, int count, TrieNode node){
        
        if(node == null){
            System.out.println(word + " DOES NOT EXIST");   
            return false;
        }
        
        if(word.length() == count && node.endOfWord == true){
            System.out.println(word + " EXISTS");  
            return true;
        }
        
        if(word.length() == count && node.endOfWord == false){
            System.out.println(word + " IS A PREFIX BUT NOT A EXISTING WORD");  
            return true;
        }
        
        int index = getCharLoc(word.charAt(count));
        
        if (searchWord(word, count+1, node.children[index])) {
            //System.out.println(Character.toString((char)(index + (int)'a')) + " " +  node.children[index].numOfChilds + " " + node.children[index].endOfWord);
            return true;
        }
        
        return false;
    }
    
    public void delete(String word){
        delete(root, word, 0);
    }
    
    public boolean delete(TrieNode node, String word, int count){
        
        if(node == null){
            System.out.println(word + " DOES NOT EXIST, CANNOT BE DELETED");   
            return false;
        }
        
        if(word.length() == count){
            node.endOfWord = false;
            return true;
        }
        
        int index = getCharLoc(word.charAt(count));
        
        if (delete(node.children[index], word, count+1)) {
            if (node.children[index].numOfChilds == 0 && !node.children[index].endOfWord){
                node.children[index] = null;
                node.numOfChilds--;
                return true;
            }
        }
        return false;
    }
}
