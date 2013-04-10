package priorityqueue;

import help.EmptyQueueException;
import help.Messages;
import help.QueueOutOfBoundException;

/**
 * User: dbesliu Date: 4/4/13 Time: 9:43 AM
 */
public abstract class PriorityQueue {

    protected final Comparable[] array;
    protected int N = 0;


    public PriorityQueue(final int aN) {
        array = new Comparable[aN];
    }


    public abstract void insert(Comparable aKey);


    public boolean isEmpty() {
        return N == 0;
    }


    public abstract Comparable deleteMaxKey();


    public abstract Comparable getMaxKey();


    public abstract Comparable deleteMinKey();


    public abstract Comparable getMinKey();


    protected void checkIsNotEmpty() {
        if (isEmpty()) {
            throw new EmptyQueueException(Messages.EMPTY_QUEUE_EXCEPTION_MESSAGE.toString());
        }
    }


    protected void exchange(final int aMaxKeyIndex, final int aLastKeyIndex) {
        final Comparable aux = array[aMaxKeyIndex];
        array[aMaxKeyIndex] = array[aLastKeyIndex];
        array[aLastKeyIndex] = aux;
    }


    protected boolean less(final int aI, final int aMin) {
        return array[aI].compareTo(array[aMin]) < 0;
    }


    protected void checkQueueIsFull() {
        if (N >= array.length) {
            throw new QueueOutOfBoundException(Messages.QUEUE_OUT_OF_BOUND_EXCEPTION_MESSAGE.toString());
        }
    }
}
