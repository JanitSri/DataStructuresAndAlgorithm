package datastructures;

import java.lang.*;

public class SortingAndSearching {
    private int[] m_array;
    private int numElements;
    private int maxSize;
    private int passes;

    public SortingAndSearching(int size){
        maxSize=size;
        m_array= new int[maxSize];
        numElements=0;
        this.passes = 0;
    }

    public void addLast(int key){
        if (numElements<maxSize){
            m_array[numElements]=key;
            numElements++;
        }
    }
    
    public void listItems(){
        for (int x=0;x<numElements;x++){
            System.out.print(m_array[x]+" ");
        }
        System.out.println();
    }
    
    public void SelectionSort(){
        for (int x=0;x<numElements-1;x++){
            int locSmall=x;
            for (int y=x+1;y<numElements;y++){
                if (m_array[y]<m_array[locSmall]){
                    locSmall=y;
                }
            }
            //swap
            int temp= m_array[x];
            m_array[x]=m_array[locSmall];
            m_array[locSmall]=temp;
        }
    }

    public void insertionSort(){
        for (int x=1;x<numElements;x++){ 
            int temp = m_array[x];  
            int pos =x-1;
            while (pos >=0 && m_array[pos]>temp){
                m_array[pos+1]=m_array[pos]; 
                pos--;                       
            }
            m_array[pos+1]=temp;  
        }
    }
    
    public int binarySearch(int key){
        int low=0,high=numElements-1,mid=0;
        while (low <= high){
            
            mid = (low+high) / 2; 
            if (m_array[mid]==key){
                System.out.println(low + " " + " " + mid + " " + high);
                return mid;
            }
            
            if (key > m_array[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        System.out.println(low + " " + " " + mid + " " + high);
        return -1;
    }
    
    public boolean addInOrder(int value){
        this.insertionSort();
        
        int low = 0, high = numElements -1, mid;
        while(low <= high){
            mid = (low+high) / 2; 
            if (m_array[mid]==value)
                return false;
            
            if (value > m_array[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        
        for (int i = numElements - 1; i >= low; i--) {
            m_array[i+1] = m_array[i];
        }
        
        m_array[low] = value;
        numElements++;
        return true;

    }
    
    public void mergeSort(){
        mergeSort(m_array, new int[numElements], 0, numElements-1);
    }
    
    public void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd){
        if(leftStart < rightEnd){
            int mid = (leftStart+rightEnd)/2;
            mergeSort(arr, temp, leftStart, mid);
            mergeSort(arr, temp, mid+1, rightEnd);
            merge(arr, temp, leftStart, rightEnd);
        }
    }
    
    public void merge(int[] arr, int[] temp, int leftStart, int rightEnd){
        
        int leftEnd = (leftStart+rightEnd)/2;
        int rightStart = leftEnd+1;
        int size = rightEnd-leftStart+1;
        
        
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        
        
        while(left <= leftEnd && right <= rightEnd){
            
            if(arr[left] < arr[right]){
                temp[index] = arr[left];
                left++;
            }
            else{
                temp[index] = arr[right];
                right++;
            }
            
            index++;
        }
        
        System.arraycopy(arr, left, temp, index, leftEnd-left+1);
        System.arraycopy(arr, right, temp, index, rightEnd-right+1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
        
        passes++;
        System.out.print("PASS " + passes + ": ");
        listItems();
    }
    
    public void quickSort(){
        quickSort(m_array, 0, numElements-1);
    }
    
    public void quickSort(int[] arr, int leftStart, int rightEnd){
        if(leftStart < rightEnd){
            int partition = partition(arr, leftStart, rightEnd);
            quickSort(arr, leftStart, partition - 1);
            quickSort(arr, partition+1, rightEnd);
        }
    }

    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;

        return i+1;
    }

}
