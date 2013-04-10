package queue;

/**
 * @author dbesliu
 * @created 3/28/13
 */
public class StringOfQueue<T> implements Queue<T> {

    Node first;
    Node last;


    @Override
    public boolean isEmpty() {
        return first == null;
    }


    @Override
    public void enqueue(final T aValue) {
        final Node oldLast = last;
        final Node newNode = new Node();
        newNode.value = aValue;
        newNode.next = null;
        if (isEmpty()) {
            first = newNode;
        } else {
            oldLast.next = newNode;
        }
        last = newNode;
    }


    @Override
    public T dequeue() {
        final Node oldFirst = first;
        if (isEmpty()) {
            return null;
        }
        first = first.next;
        return oldFirst.value;
    }


    private class Node {

        public T value;
        public Node next;
    }
}
