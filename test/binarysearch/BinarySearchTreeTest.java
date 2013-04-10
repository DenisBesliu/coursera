package binarysearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author dbesliu
 * @created 4/10/13
 */
public class BinarySearchTreeTest {

    private static final String WRONG_TREE_LENGTH_MESSAGE = "Wrong tree Length: Expected %d but was %d";
    private static final String WRONG_VALUE_FOUND_MESSAGE = "Wrong value found: Expected %s but was %s";

    private BinarySearchTree<String, Integer> binarySearchTree;


    @Before
    public void setUp() throws Exception {
        binarySearchTree = new BinarySearchTree<String, Integer>();
    }


    @Test
    public void putRootNode() {
        binarySearchTree.put("a", 2);
        assertTrue(!binarySearchTree.isEmpty());
    }


    @Test
    public void putManyNodes() {
        fillTree();

        assertTreeLength(7);
    }


    private void assertTreeLength(final int aExpected) {
        final int actual = binarySearchTree.getLength();
        assertEquals(String.format(WRONG_TREE_LENGTH_MESSAGE, aExpected, actual), aExpected, actual);
    }


    @Test
    public void putDuplicateKey() {
        fillTree();
        assertTreeLength(7);
        binarySearchTree.put("h", 15);
        assertTreeLength(7);

    }


    @Test
    public void testPullNullKey() {
        fillTree();
        assertTreeLength(7);
        binarySearchTree.put(null, 15);
        assertTreeLength(7);
    }


    @Test
    public void searchInEmptyTree() {
        assertTreeSearchResult(null, binarySearchTree.search("a"));
    }


    private void assertTreeSearchResult(final Object aExpected, final Integer aActual) {
        final String expected = aExpected != null ? aExpected.toString() : "null";
        final String actual = aActual != null ? aActual.toString() : "null";
        assertEquals(String.format(WRONG_VALUE_FOUND_MESSAGE, expected, actual), aExpected, aActual);
    }


    @Test
    public void searchNull() {
        assertTreeSearchResult(null, binarySearchTree.search(null));
    }


    @Test
    public void search() {
        fillTree();
        assertTreeSearchResult(new Integer(10), binarySearchTree.search("s"));
    }


    @Test
    public void searchDuplicatedKey() {
        fillTree();
        assertTreeSearchResult(new Integer(2), binarySearchTree.search("c"));
        binarySearchTree.put("c", 30);
        assertTreeSearchResult(new Integer(30), binarySearchTree.search("c"));
    }


    private void fillTree() {
        binarySearchTree.put("a", 0);
        binarySearchTree.put("h", 11);
        binarySearchTree.put("s", 10);
        binarySearchTree.put("f", 9);
        binarySearchTree.put("c", 2);
        binarySearchTree.put("e", 5);
        binarySearchTree.put("m", 1);
    }

}
