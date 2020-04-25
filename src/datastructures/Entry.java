
package datastructures;


public class Entry<K,V> {
    Entry<K,V> next;
    K key;
    V value;

    public Entry(K key, V value) {
        /**
         * Node that is stored in the array
         * @param key --- used for lookup
         * @param value --- value that will be returned on matching key
         */
        this.next = null;
        this.key = key;
        this.value = value;
    }
}