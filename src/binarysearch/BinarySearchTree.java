package binarysearch;

/**
 * @author dbesliu
 * @created 4/10/13
 */
public class BinarySearchTree<Key extends Comparable, Value> {

    private Node<Key, Value> root;
    private int N;


    public void put(final Key aKey, final Value aValue) {
        if (aKey == null) {
            return;
        }
        root = put(root, aKey, aValue);
    }


    private Node<Key, Value> put(final Node<Key, Value> aRoot, final Key aKey, final Value aValue) {
        if (aRoot == null) {
            N++;
            return new Node<Key, Value>(aKey, aValue);
        }

        final int i = aKey.compareTo(aRoot.key);
        if (i < 0) {
            aRoot.left = put(aRoot.left, aKey, aValue);
        } else if (i > 0) {
            aRoot.right = put(aRoot.right, aKey, aValue);
        } else {
            aRoot.value = aValue;
        }

        return aRoot;
    }


    public boolean isEmpty() {
        return root == null;
    }


    public int getLength() {
        return N;
    }


    public Value search(final Key aKey) {
        if (aKey == null) {
            return null;
        }
        Node<Key, Value> aux = root;
        while (aux != null) {
            final int i = aKey.compareTo(aux.key);
            if (i < 0) {
                aux = aux.left;
            } else if (i > 0) {
                aux = aux.right;
            } else {
                return aux.value;
            }
        }

        return null;
    }


    private class Node<Key extends Comparable, Value> {

        public Key key;
        public Value value;
        public Node<Key, Value> left, right;


        private Node(final Key aKey, final Value aValue) {
            key = aKey;
            value = aValue;
        }
    }
}
