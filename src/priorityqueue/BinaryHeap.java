package priorityqueue;

/**
 * @author dbesliu
 * @created 4/4/13
 */
public class BinaryHeap extends PriorityQueue {

    public BinaryHeap(final int aN) {
        super(aN);
    }


    @Override
    public void insert(final Comparable aKey) {
        checkQueueIsFull();
        array[++N] = aKey;
        swim(N);
    }


    private void swim(final int aI) {
        int k = aI;
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }


    @Override
    public Comparable deleteMaxKey() {
        checkIsNotEmpty();
        final Comparable maxKey = array[1];
        exchange(1, N--);
        sink(1);
        array[N+1] = null;
        return maxKey;
    }


    private void sink(int aI) {
        while (2 * aI <= N) {
            int j = 2 * aI;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(aI, j)) {
                break;
            }
            exchange(aI, j);
            aI = j;
        }
    }


    @Override
    public Comparable getMaxKey() {
        checkIsNotEmpty();
        return array[1];
    }


    @Override
    public Comparable deleteMinKey() {
        throw new UnsupportedOperationException("Unsupported Operation Exception");
    }


    @Override
    public Comparable getMinKey() {
        throw new UnsupportedOperationException("Unsupported Operation Exception");
    }
}
