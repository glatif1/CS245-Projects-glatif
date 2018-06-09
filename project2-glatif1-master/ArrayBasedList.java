import java.util.AbstractList;
import java.lang.*;


public class ArrayBasedList<E> extends AbstractList<E> {

    // Class variables
    private int size;
    private E[] array;
    private int max;

    // Constructor creates array of size 100 - size is doubled when necessary
    public ArrayBasedList() {
        this.size = 0;
        this.array = (E[]) new Object[100];
        this.max = 100;
    }


    @Override
    public E get(int index) {
        //checks to see if index is larger than current array size
        if (index < size) {
            return array[index];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        //adds to array and adds to size by 1
        array[size] = e;
        size ++;
        return true;
    }

    //adding an element at an index
    @Override
    public void add(int index, E element) {
        if (index < size) {
            //move everything over to make room
            for (int i = size - 1; i >= index; i--) {
                array[i+1] = array[i];
            }
            array[index] = element;
            size++;
        }
    }

    @Override
    public E set(int index, E element) {
        if (index < size) {
            array[index] = element;
            return element;
        }
        return null;
    }

    @Override
    public E remove(int index) {
        if (index < size) {
            //removes object
            E tmpArray = array[index];
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            //update array
            size = size - 1;
            return tmpArray;
        }
        return null;
    }

}
