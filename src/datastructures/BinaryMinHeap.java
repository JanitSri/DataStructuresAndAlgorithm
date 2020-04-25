
package datastructures;

import java.util.Arrays;

public class BinaryMinHeap {
    int[] array;
    int max;
    int num;
    
    public BinaryMinHeap(int max){
        this.num = 0;
        this.max = max;
        this.array = new int[max];
    } 
    
    public int getParentIndex(int childIndex){return (childIndex-1)/2;}
    public int getLeftChildIndex(int parentIndex){return parentIndex*2+1;}
    public int getRightChildIndex(int parentIndex){return parentIndex*2+2;}
    
    public boolean hasParent(int index){return getParentIndex(index) >= 0;}
    public boolean hasLeftChild(int index){return getLeftChildIndex(index) < num;}
    public boolean hasRightChild(int index){return getRightChildIndex(index) < num;}
    
    public int getParent(int index){return array[getParentIndex(index)];}
    public int getLeftChild(int index){return array[getLeftChildIndex(index)];}
    public int getRightChild(int index){return array[getRightChildIndex(index)];}
    
    
    public void swap(int first, int second)
    {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    
    
    public void ensureCapacity(){
        if(num == max){
            array = Arrays.copyOf(array, max*2);
            max *= 2;
        }
    }
    
    public int peak(){
        if(num != 0)
        {
            return array[0];
        }
        return -1;
    }
    
    public int poll()
    {
        int element = array[0];
        array[0] = array[num-1];
        num--;
        heapifyDown();
        return element;
    }
    
    public boolean add(int element)
    {
        ensureCapacity();
        array[num++] = element;
        heapifyUp();
        return true;
    }
    
    public void heapifyDown()
    {
        int index = 0;
        while(hasLeftChild(index))
        {
           int smallerChildIndex =  getLeftChildIndex(index);
           if(hasRightChild(index) && getRightChild(index) < getLeftChild(index))
           {
               smallerChildIndex =  getRightChildIndex(index);
           }
           
           if(array[index] < array[smallerChildIndex])
           {
               break;
           }
           else
           {
               swap(index, smallerChildIndex);
           }
           
           index = smallerChildIndex;
        }       
    }
    
    public void heapifyUp(){
       int index = num - 1;
       while(hasParent(index) && getParent(index) > array[index])
       {
           swap(getParentIndex(index), index);
           index = getParentIndex(index);
       }
    }
    
    public void printHeap()
    {
        for(int i = 0; i < num; i++)
        {
            System.out.println(array[i]);
        }
    } 
}
