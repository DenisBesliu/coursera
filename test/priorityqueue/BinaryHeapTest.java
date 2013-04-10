package priorityqueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import help.EmptyQueueException;
import help.Messages;
import help.QueueOutOfBoundException;
import help.WeekDays;

/**
 * @author dbesliu
 * @created 4/4/13
 */
public class BinaryHeapTest {

    private BinaryHeap binaryHeap;


    @Before
    public void setUp() throws Exception {
        binaryHeap = new BinaryHeap(10);
    }


    @Test(expected = QueueOutOfBoundException.class)
    public void insertIntoZeroLengthQueue() {
        BinaryHeap queue = new BinaryHeap(0);
        queue.insert(WeekDays.SUNDAY.toString());
    }


    @Test(expected = EmptyQueueException.class)
    public void deleteMaxKeyFromEmptyQueue() {
        BinaryHeap queue = new BinaryHeap(0);
        queue.deleteMaxKey();
    }


    @Test(expected = EmptyQueueException.class)
    public void getMaxKeyFromEmptyQueue() {
        BinaryHeap queue = new BinaryHeap(0);
        queue.getMaxKey();
    }


    @Test
    public void insertIntoQueue() {
        assertEmptyQueue();
        fillQueueWithWeekDays();
        assertNotEmptyQueue();
    }


    @Test
    public void getMaxKey() {
        fillQueueWithWeekDays();
        final String expected = WeekDays.WEDNESDAY.toString();
        final String actual = (String)binaryHeap.getMaxKey();
        assertNotEmptyQueue();
        assertWrongKey(expected, actual);
    }


    @Test
    public void deleteMaxKey() {
        fillQueueWithWeekDays();
        assertWrongKey(WeekDays.WEDNESDAY.toString(), binaryHeap.deleteMaxKey());
        assertWrongKey(WeekDays.TUESDAY.toString(), binaryHeap.deleteMaxKey());
        assertWrongKey(WeekDays.THURSDAY.toString(), binaryHeap.deleteMaxKey());
        assertWrongKey(WeekDays.SUNDAY.toString(), binaryHeap.deleteMaxKey());
        assertWrongKey(WeekDays.SATURDAY.toString(), binaryHeap.deleteMaxKey());
        assertWrongKey(WeekDays.MONDAY.toString(), binaryHeap.deleteMaxKey());
        assertWrongKey(WeekDays.FRIDAY.toString(), binaryHeap.deleteMaxKey());
        assertEmptyQueue();
    }


    @Test(expected = UnsupportedOperationException.class)
    public void getMinKey() {
        BinaryHeap queue = new BinaryHeap(0);
        queue.getMinKey();
    }


    @Test(expected = UnsupportedOperationException.class)
    public void deleteMinKey() {
        BinaryHeap queue = new BinaryHeap(0);
        queue.deleteMinKey();
    }


    private void assertEmptyQueue() {
        assertTrue(Messages.QUEUE_NOT_EMPTY_MESSAGE.toString(), binaryHeap.isEmpty());
    }


    private void assertNotEmptyQueue() {
        assertTrue(Messages.QUEUE_EMPTY_MESSAGE.toString(), !binaryHeap.isEmpty());
    }


    private void assertWrongKey(final String aExpected, final Comparable aActual) {
        assertEquals(getWrongKeyMessage(aExpected, (String)aActual), aExpected, aActual);
    }


    private String getWrongKeyMessage(final String aExpected, final String aActual) {
        return String.format(Messages.PRIORITY_QUEUE_WRONG_KEY_MESSAGE.toString(), aExpected, aActual);
    }


    private void fillQueueWithWeekDays() {
        for (WeekDays days : WeekDays.values()) {
            binaryHeap.insert(days.toString());
        }
    }
}
