package queue;

/**
 * @author dbesliu
 * @created 3/28/13
 */
public interface Queue<T> {

    public boolean isEmpty();


    public void enqueue(final T aValue);


    public T dequeue();
}
