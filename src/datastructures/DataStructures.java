
package datastructures;

public class DataStructures {


    public static void main(String[] args) 
    {
//        MyMap<String, String> myMap = new MyMap<>(5);
//        myMap.put("USA", "Washington DC");
//        myMap.put("Nepal", "Kathmandu");
//        myMap.put("India", "New Delhi");
//        myMap.put("Australia", "Sydney");
//        myMap.put("ASU", "this is a test");
//
//        System.out.println(myMap.getVal("USA"));
//        System.out.println(myMap.getVal("India"));
//        System.out.println(myMap.getVal("Australia"));
//        System.out.println(myMap.getVal("ASU"));
        
////        SortingAndSearching aList = new SortingAndSearching(10);
////        aList.addLast(-6);
////        aList.addLast(3);
////        aList.addLast(5);
////        aList.addLast(9);
////        aList.addLast(9);
////        aList.addLast(11);
////        aList.addLast(17);
////        aList.addLast(23);
////        aList.addLast(29);
////        aList.addLast(32);
//     
//        
//        aList.mergeSort();
//        
//        aList.binarySearch(-5);
        
        
        BSTree bstTree = new BSTree();
        bstTree.insertNodeRecursive(50);
        bstTree.insertNodeRecursive(30);
        bstTree.insertNodeRecursive(20);
        bstTree.insertNodeRecursive(40);
        bstTree.insertNodeRecursive(70);
        bstTree.insertNodeRecursive(60);
        bstTree.insertNodeRecursive(80);
        
        bstTree.variousOrder();
        System.out.println(bstTree.getSize());
        
        bstTree.delete(80);
        bstTree.delete(30);
        bstTree.delete(20);
        bstTree.delete(40);
        bstTree.delete(70);
        bstTree.delete(60);
        
        bstTree.variousOrder();
        System.out.println(bstTree.getSize());
        
        
    }
    
}
