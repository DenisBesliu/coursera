package stack;

/**
 * @author dbesliu
 * @created 3/27/13
 */
public class FixedStack<T> implements Stack<T> {

    T[] values;
    int N = 0;


    public FixedStack(final int aSize) {
        values = (T[])new Object[aSize];
    }


    public boolean isEmpty() {
        return (N == 0);
    }


    public T pop() {
        final T value = values[--N];
        if (N > 0 && N < values.length / 4) {
            resize(values.length / 2);
        }
        return value;
    }


    public void push(final T aValue) {
        if (N == values.length) {
            resize(2 * values.length);
        }
        values[N++] = aValue;
    }


    private void resize(final int aNewSize) {
        final T[] newValues = (T[])new Object[aNewSize];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }
}
