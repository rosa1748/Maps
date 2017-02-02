/**
 * Created by jhinukbarman on 1/29/17.
 */
public class ArrayDeque<Item> {

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int usageRatio; //when to check this?
    private int RFACTOR = 2; //what number to use?

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1; //does last start at index 1?
        usageRatio = 0;
    }

    public void addFirst(Item i){
        items[nextFirst] = i;
        if (nextFirst == 0){
            nextFirst = items.length;
        }
        nextFirst--;
        size++;
    }

    private void resize(int srcPos, int capacity, int destPos){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, destPos, size);
        items = a;
    }

    public void addLast(Item i){
        if (nextLast == nextFirst){
           // resize(0, size * RFACTOR, 0);
            Item[] a = (Item[]) new Object[size*RFACTOR];
            System.arraycopy(items, nextFirst+1, a, 0, items.length-(nextFirst+1));
            System.arraycopy(items, 0, a, items.length-nextFirst, nextFirst);
            items = a;
        }
       // if (size == items.length){
           // resize(0, (size * RFACTOR), 0);
        //}
        items[nextLast] = i;


        if (nextLast < items.length - 1) {
            nextLast++;
        }
        else {
            nextLast = 0;
        }

        size++;
    }


    public boolean isEmpty(){
        for(int i = 0; i < items.length; i++){
            if (items[i] != null){
                return false;
            }
        }
        return true;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i = 0; i<size; i++) {
            System.out.print(items[0] + " ");
        }
    }

    public Item removeFirst(){
        if (items[nextFirst+1] == null){
            return null;
        }
        Item first = items[nextFirst+1];
        items[nextFirst] = null;
        return first;

    }

    public Item removeLast(){
        Item last = items[size-1];
        items[size - 1] = null;
        size = size - 1;
        return last;
    }

    public Item get(int index){
        if (index < size) {
            return items[index];
        }
        else{
            return null;
        }
    }



}