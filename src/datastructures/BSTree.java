package datastructures;


public class BSTree {
    BSTNode root;

    public BSTree(){
        this.root = null;
    }


    public void insertNode(int key){
        BSTNode newNode = new BSTNode(key);

        if(root == null){
            root = newNode;
        }
        else{
            BSTNode currNode = root;
            BSTNode parent = null;

            while(currNode != null){
                parent = currNode;
                if(key > currNode.data){
                    currNode = currNode.right;
                }
                else{
                    currNode = currNode.left;
                }

            }

            if(key > parent.data){
                parent.right = newNode;
            }
            else{
                parent.left = newNode;
            }
        }
    }
    
    public void insertNodeRecursive(int key){
        root = insertNodeRecursive(root, key);
    }
    
    public BSTNode insertNodeRecursive(BSTNode node, int key){
        if(node == null){
            node = new BSTNode(key);
            return node;
        }
        
        if(key < node.data){
            node.left = insertNodeRecursive(node.left, key);
        }
        else{
            node.right = insertNodeRecursive(node.right, key);
        }
        
        return node;
    }
    

    public void printInOrder(){
        recPrintInOrder(root);
    }


    public void recPrintInOrder(BSTNode curr){
        if(curr != null){
            recPrintInOrder(curr.left);
            System.out.print(curr.data + " ");
            recPrintInOrder(curr.right);
        }
    }

    public void variousOrder(){
        System.out.println("InOrder");
        inOrder(root);
        System.out.println();

//        System.out.println("PreOrder");
//        preOrder(root);
//        System.out.println();
//        
//        System.out.println("PostOrder");
//        postOrder(root);
//        System.out.println();   
    }


    public void inOrder(BSTNode curr){
        if(curr != null){
            inOrder(curr.left);
            System.out.print(curr.data+" ");
            inOrder(curr.right);
        }
    }

    public void preOrder(BSTNode curr){
        if(curr != null){
            System.out.print(curr.data+" ");
            preOrder(curr.left);
            preOrder(curr.right);
        }
    }

    public void postOrder(BSTNode curr){
        if(curr != null){ 
            postOrder(curr.left);
            postOrder(curr.right);
            System.out.printf(curr.data+" ");
        }
    }
    
    public int getSize(){
        return getSizeRec(root);
    }
    
    public int getSizeRec(BSTNode node){
        if(node == null){
            return 0;
        }
        
        return getSizeRec(node.left) + getSizeRec(node.right) + 1;
    }
    
    
    public void delete(int key){
        root = delete(key, root);
    }
    
    public BSTNode delete(int key, BSTNode node){
        if(node == null){
            return null;
        }
        
        // found the key 
        if(node.data == key){
            if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }
            else{
                int replacement = findLeftTreeMax(node.left);
                node.data = replacement;
                node.left = delete(replacement, node.left);
            }
        }
        // key not found 
        else{
            if(key < node.data){
                node.left = delete(key, node.left);
            }
            else{
                node.right = delete(key, node.right);
            }
        }
        
        return node;
    }
    
    private int findLeftTreeMax(BSTNode node){
        BSTNode currNode = node;
        while(currNode.right != null){
            currNode = currNode.right;
        }
        
        return currNode.data;
    }

}
