import java.util.LinkedList;

/**
 * Isn't this solution kinda... cheating? Yes.
 * The aesthete will be especially alarmed by the fact that this
 * supposed ArrayDeque is actually using a LinkedList. SAD!
 */
<<<<<<< HEAD
public class ArrayDequeSolution<Item> extends LinkedList<Item> implements Deque<Item>{
    public void printDeque() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        //System.out.println("dummy");
=======
public class ArrayDequeSolution<Item> extends LinkedList<Item> {
    public void printDeque() {
        System.out.println("dummy");
>>>>>>> 28d2613fc341c86308ee47cb0702dae1ce0d65a5
    }

    public Item getRecursive(int i) {
        return get(i);
    }

    public Item removeFirst() {
        try {
            return super.removeFirst();
        } catch (Exception e) {
            return null;
        }
    }

    public Item removeLast() {
        try {
            return super.removeLast();
        } catch (Exception e) {
            return null;
        }
    }
}