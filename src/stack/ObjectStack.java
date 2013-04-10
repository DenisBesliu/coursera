package stack;

import java.util.Iterator;

/**
 * @author dbesliu
 * @created 3/27/13
 */
public class ObjectStack<T> implements Stack<T>, Iterable<T> {

    private Node first = null;


    private class Node {

        private T value;

        private Node next;

    }


    public boolean isEmpty() {
        return first == null;
    }


    public void push(final T aValue) {
        final Node oldFirst = first;
        final Node newNode = new Node();
        newNode.value = aValue;
        newNode.next = oldFirst;
        first = newNode;
    }


    public T pop() {
        final Node oldFirst = first;
        first = first.next;
        return oldFirst.value;
    }


    @Override
    public Iterator<T> iterator() {
        return new StackIterator<T>();
    }


    private class StackIterator<T> implements Iterator<T> {

        private Node firstItem;


        private StackIterator() {
            firstItem = first;
        }


        @Override
        public boolean hasNext() {
            return firstItem != null;
        }


        @Override
        public T next() {
            final Node oldFirst = firstItem;
            firstItem = firstItem.next;
            return (T)oldFirst.value;
        }


        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
