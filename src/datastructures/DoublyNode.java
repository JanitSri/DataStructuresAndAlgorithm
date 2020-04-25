package datastructures;


public class DoublyNode<E> {
    
    E data;
    DoublyNode<E> next;
    DoublyNode<E> prev;
    
    public DoublyNode(E data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
