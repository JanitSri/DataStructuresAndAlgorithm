package datastructures;


public class LinkedList{
    Node head;
    
    public LinkedList(){
        this.head = null;
    }
    
    public void addtoFront(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void addtoback(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            return;
        }
        
        Node currNode = head;
        while(currNode.next !=  null){
            currNode = currNode.next;
        }
        
        currNode.next = newNode;
    }
    
    public void addInOrderAsc(int data){
        
        if(head == null || head.data > data){
            addtoFront(data);
            return;
        }
        
        Node currNode = head;
        
        while(currNode.next != null && currNode.next.data < data){
            currNode = currNode.next;
        }
        
         Node newNode = new Node(data);
         newNode.next = currNode.next;
         currNode.next = newNode;
    }
    
    public void addInOrderDesc(int data){
        
        if(head == null || head.data < data){
            addtoFront(data);
            return;
        }
        
        Node currNode = head;
        
        while(currNode.next != null && currNode.next.data > data){
            currNode = currNode.next;
        }
        
         Node newNode = new Node(data);
         newNode.next = currNode.next;
         currNode.next = newNode;
    }
    
    
    public void deleteNode(int data){
        if(head.data == data){
            head = head.next;
            return;
        }
        
        Node currNode = head;
        Node prev = null;
        
        while(currNode != null && currNode.data != data){
            prev = currNode;
            currNode = currNode.next;
        }
        
        if(currNode != null){
            prev.next = currNode.next;
        }
    }
    
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
    } 
    
    public void findMiddle(){
        if(head == null){
            return;
        }
        
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        System.out.println(slow.data);
    }
    
    
    public void printList(){
        Node currNode = head;
        
        String out = "";
        while(currNode != null){
            out += currNode.data + " ";
            currNode = currNode.next;
        }
        
        System.out.println(out);
    }
}
