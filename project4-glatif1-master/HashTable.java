/*
My program re-hashes when the the table full to the point of the load factor.
It re-hashes by taking the modulo of the hashed key to the array size. If the table
gets too full it has a resize function which raises the cap by 100
 */

import java.lang.*;
import java.util.*;


public class HashTable {

    private LinkedList<myObj>[] theArray;
    private int arraySize;
    private int size = 0;

    public void resizeArray() {

        int tempArraySize = arraySize + 100;

        LinkedList<myObj>[] tempArray = new LinkedList[tempArraySize];

        for (int i=0; i < arraySize; i++) {
            if (tempArray[i] != null && !tempArray[i].isEmpty()) {
                for (int j=0; j<tempArray[i].size(); j++) {
                    myObj data = tempArray[i].get(j);
                    Object key = data.key;
                    int haskey = hashFunction(key);
                    if (tempArray[haskey] == null) {
                        tempArray[haskey] = new LinkedList<myObj>();
                        tempArray[haskey].add(data);
                    } else {
                        tempArray[haskey].add(data);
                    }
                }
            }
        }
        arraySize = tempArraySize;
        theArray = tempArray;
    }

    public HashTable(int initialCapacity) {
        theArray = new LinkedList[initialCapacity];
        arraySize = initialCapacity;
    }


    private int hashFunction(Object key)
    {
        int hashedKey = key.hashCode();
        hashedKey = hashedKey % arraySize;
        return hashedKey;
    }

    public Object get(Object key) {
        int Hashedkey = hashFunction(key);
        if (theArray[Hashedkey] != null) {
            for(int i=0; i < theArray[Hashedkey].size(); i++) {
                myObj tmp = theArray[Hashedkey].get(i);
                if (tmp.key.equals(key)) {
                    return tmp.value;
                }
            }
        }
        return null;
    }

    public boolean setValue(Object key, Object value) {
        int hashkey = hashFunction(key);
        if (theArray[hashkey] != null) {
            for(int i=0; i<theArray[hashkey].size(); i++) {
                myObj tmp = theArray[hashkey].get(i);
                if (tmp.key.equals(key)) {
                    tmp.value = (String) value;
                    return true;
                }
            }
        }
        return false;
    }


    public void put(Object key, Object value) {


        //checking for load factor here!!
        if (size >= arraySize * .75) {
            resizeArray();
        }
        if (!setValue(key, value)) {
            myObj data = new myObj(key, value);
            int hashkey = hashFunction(key);
            if (theArray[hashkey] == null) {
                theArray[hashkey] = new LinkedList<myObj>();
                theArray[hashkey].add(data);
                size++;
            } else {
                theArray[hashkey].add(data);
            }
        }
    }





    public static void main(String[] args){
        HashTable myTable = new HashTable(10);
        myTable.put("12","22");

        System.out.println(myTable.get("12"));
    }



}