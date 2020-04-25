
package datastructures;


import java.lang.Math;

//Implementation of a Hashtable using Linked List for collisions
public class MyMap<K, V> {
    Entry<K,V>[] arr;
    int max;

    public MyMap(int max) {
        this.max = max;
        this.arr = new Entry[max];
    }

    public int hasher(K key){
        /**
         * get the position of the key
         * @param key --- input the key to get the location
         * @return --- the hashed position for insertion
         */
        int out = key.hashCode() % max;
        return Math.abs(out);
    }

    public void put(K key, V val){
        /**
         * insert a key,value pair into the array
         * @param key --- use the key to look up the position
         * @param val --- the value to insert into the table
         */

        int position = hasher(key);
        Entry<K,V> currentLoc = arr[position];
        if(currentLoc == null){
            arr[position] = new Entry<K, V>(key,val);
        }
        else{
            while(currentLoc.next != null){
                if(currentLoc.key.equals(key)){
                    currentLoc.value = val;
                    return;
                }
                currentLoc = currentLoc.next;
            }

            if(currentLoc.key.equals(key)){
                currentLoc.value = val;
            }
            else{
                currentLoc.next = new Entry<K, V>(key,val);
            }
        }
    }

    public V getVal(K key){
        /**
         * get the value using the key
         * @param key --- the key to look up
         * @return -- value if exists or null
         */
        int position = hasher(key);
        Entry<K,V> currentLoc = arr[position];
        while(currentLoc != null){
            if(currentLoc.key.equals(key)){
                return currentLoc.value;
            }
            currentLoc = currentLoc.next;
        }

        return null;
    }
}



