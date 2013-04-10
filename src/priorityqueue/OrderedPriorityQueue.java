package priorityqueue;

/**
 * @author dbesliu
 * @created 4/4/13
 */
public class OrderedPriorityQueue extends PriorityQueue {

    public OrderedPriorityQueue(final int aN) {
        super(aN);
    }


    @Override
    public void insert(final Comparable aKey) {
        checkQueueIsFull();
        array[N++] = aKey;
        sortArray();
    }


    private void sortArray() {
        for (int i = 0; i < N; i++) {
            int min = findMin(i);
            exchange(min, i);
        }
    }


    private int findMin(final int aI) {
        int min = aI;
        for (int j = aI; j < N; j++) {
            if (less(j, min)) {
                min = j;
            }
        }
        return min;
    }


    @Override
    public Comparable deleteMaxKey() {
        checkIsNotEmpty();
        return array[--N];
    }


    @Override
    public Comparable getMaxKey() {
        checkIsNotEmpty();
        return array[N - 1];
    }


    @Override
    public Comparable deleteMinKey() {
        checkIsNotEmpty();
        Comparable minKey = array[0];
        exchange(0, --N);
        sortArray();
        return minKey;
    }


    @Override
    public Comparable getMinKey() {
        checkIsNotEmpty();
        return array[0];
    }
}
