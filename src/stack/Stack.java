package stack;

/**
 * @author dbesliu
 * @created 3/27/13
 */
public interface Stack<T> {

    public boolean isEmpty();


    public T pop();


    public void push(final T aValue);
}
