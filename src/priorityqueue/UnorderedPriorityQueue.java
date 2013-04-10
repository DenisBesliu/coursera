package priorityqueue;

/**
 * User: dbesliu Date: 4/4/13 Time: 9:41 AM
 */
public class UnorderedPriorityQueue extends PriorityQueue {

    public UnorderedPriorityQueue(final int aN) {
        super(aN);
    }


    @Override
    public void insert(final Comparable aKey) {
        checkQueueIsFull();
        array[N++] = aKey;
    }


    @Override
    public Comparable deleteMaxKey() {
        checkIsNotEmpty();
        final int maxKeyIndex = getMaxKeyIndex();
        exchange(maxKeyIndex, N - 1);
        return array[--N];
    }


    @Override
    public Comparable getMaxKey() {
        checkIsNotEmpty();
        final int maxKeyIndex = getMaxKeyIndex();
        return array[maxKeyIndex];
    }


    private int getMaxKeyIndex() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        return max;
    }


    @Override
    public Comparable deleteMinKey() {
        checkIsNotEmpty();
        final int minKeyIndex = getMinKeyIndex();
        exchange(minKeyIndex, N - 1);
        return array[--N];
    }


    private int getMinKeyIndex() {
        int min = 0;
        for (int i = 1; i < N; i++) {
            if (less(i, min)) {
                min = i;
            }
        }
        return min;
    }


    @Override
    public Comparable getMinKey() {
        checkIsNotEmpty();
        final int minKeyIndex = getMinKeyIndex();
        return array[minKeyIndex];
    }
}
