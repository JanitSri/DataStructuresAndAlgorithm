package datastructures;


public class HashTable {
    String[] arr;
    int max;
    int num;

    public HashTable(int max){
        this.max = max;
        this.num = 0;
        this.arr = new String[max];
    }

    public int hash(String key){
        int pos = 0;
        for (int i = 0; i < key.length(); i++) {
            pos += (int) key.charAt(i);
        }

        return pos % max;
    }

    public void checkArraySize(){
        if(num >= (max*0.8)){
            System.out.println("Increased Size");
            String[] temp = new String[max*2];
            System.arraycopy(arr, 0, temp, 0, max);
            arr = temp;
            max = max * 2;
        }
    }

    public void linearProbing(String key){
        checkArraySize();
        int position = hash(key);
        while(!(arr[position] == null || arr[position] == "DELETE")){
            position = (position + 1) % max;
        }

        arr[position] = key;
        num++;
    }

    public void quadProbing(String key){
        checkArraySize();
        int position = hash(key);
        int colCount = 0;
        int temp = position;
        while(!(arr[position] == null || arr[position] == "DELETE")){
            colCount++;
            position = (temp + colCount * colCount) % max;
        }

        arr[position] = key;
        num++;
    }

    public void doubleHash(String key){
        checkArraySize();
        int position = hash(key);
        while(!(arr[position] == null || arr[position] == "DELETE")){
            position = (position + hash(key)) % max;
        }

        arr[position] = key;
        num++;
    }

    public void printList(){
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
