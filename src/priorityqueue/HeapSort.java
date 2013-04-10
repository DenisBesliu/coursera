package priorityqueue;

import sort.comparable.Sort;
import help.Messages;
import help.NullArrayException;

/**
 * @author dbesliu
 * @created 4/8/13
 */
public class HeapSort implements Sort {

    @Override
    public void sort(final Comparable[] aArray) {
        if (aArray == null) {
            throw new NullArrayException(Messages.NULL_ARRAY_EXCEPTION_MESSAGE.toString());
        }

        sinkArray(aArray);
        sortArray(aArray);
    }


    private void sortArray(final Comparable[] aArray) {
        int length = aArray.length - 1;
        while (length > 0) {
            exchange(aArray, 0, length--);
            sink(aArray, 0, length);
        }
    }


    private void sinkArray(final Comparable[] aArray) {
        int length = aArray.length - 1;
        for (int i = length / 2; i >= 0; i--) {
            sink(aArray, i, length);
        }
    }


    private void sink(final Comparable[] aArray, int aI, final int aEnd) {
        while (2 * aI <= aEnd) {
            int j = 2 * aI;
            if (j < aEnd && less(aArray, j, j + 1)) {
                j++;
            }
            if (!less(aArray, aI, j)) {
                break;
            }
            exchange(aArray, aI, j);
            aI = j;
        }
    }


    private void exchange(final Comparable[] aArray, final int aI, final int aJ) {
        final Comparable aux = aArray[aI];
        aArray[aI] = aArray[aJ];
        aArray[aJ] = aux;
    }


    private boolean less(final Comparable[] aArray, final int aJ, final int aI) {
        return aArray[aJ].compareTo(aArray[aI]) < 0;
    }
}
