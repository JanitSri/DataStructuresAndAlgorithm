
package datastructures;


public class DoublyLinkedList<E> {
    
    private DoublyNode<E> head;
    private DoublyNode<E> currNode;
    private DoublyNode<E> tail;
    private int size;
    
    
    public DoublyLinkedList(){
        this.head = null;
        this.size = 0;
    }
    
    public int getSize(){return size;}
    
    public void addToEnd(E data)
    {
        DoublyNode<E> newNode = new DoublyNode<>(data);
        
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            currNode = head;
            while(currNode.next != null)
            {
                currNode = currNode.next;
            }
            
            currNode.next = newNode;
            newNode.prev = currNode;
        }
        
        tail = newNode;
        size++;
    }
    
    public void addToFront(E data)
    {
        DoublyNode<E> newNode = new DoublyNode<>(data);
        
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            currNode = head;
            head = newNode;
            head.next = currNode;
            currNode.prev = head;
        }
        
        size++;
    }
    
    public void print()
    {
        if(head == null)
        {
            System.out.println("The Double Linked List Empty");
        }
        else
        {
            currNode = head;
            System.out.println(currNode.data);
            
            while(currNode.next != null)
            {
                currNode = currNode.next;
                System.out.println(currNode.data);
            }
        }
    }
    
    public void printReverse()
    {
        if(head == null)
        {
            System.out.println("The Double Linked List Empty");
        }
        else
        {
            currNode = tail;
            System.out.println(currNode.data);
            
            while(currNode.prev != null)
            {
                currNode = currNode.prev;
                System.out.println(currNode.data);
            }
        }
    }
    
}
