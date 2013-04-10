package priorityqueue;

import help.QueueOutOfBoundException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import help.EmptyQueueException;
import help.Messages;
import help.WeekDays;

/**
 * @author dbesliu
 * @created 4/4/13
 */
public class OrderedPriorityQueueTest {

    private OrderedPriorityQueue priorityQueue;


    @Before
    public void setUp() throws Exception {
        priorityQueue = new OrderedPriorityQueue(10);

    }


    @Test(expected = QueueOutOfBoundException.class)
    public void insertIntoZeroLengthQueue() {
        OrderedPriorityQueue queue = new OrderedPriorityQueue(0);
        queue.insert(WeekDays.SUNDAY.toString());
    }


    @Test(expected = EmptyQueueException.class)
    public void deleteMaxKeyFromEmptyQueue() {
        OrderedPriorityQueue queue = new OrderedPriorityQueue(0);
        queue.deleteMaxKey();
    }


    @Test(expected = EmptyQueueException.class)
    public void deleteMinKeyFromEmptyQueue() {
        OrderedPriorityQueue queue = new OrderedPriorityQueue(0);
        queue.deleteMinKey();
    }


    @Test(expected = EmptyQueueException.class)
    public void getMaxKeyFromEmptyQueue() {
        OrderedPriorityQueue queue = new OrderedPriorityQueue(0);
        queue.getMaxKey();
    }


    @Test(expected = EmptyQueueException.class)
    public void getMinKeyFromEmptyQueue() {
        OrderedPriorityQueue queue = new OrderedPriorityQueue(0);
        queue.getMinKey();
    }


    @Test
    public void insertIntoQueue() {
        assertEmptyQueue();
        priorityQueue.insert(WeekDays.SUNDAY.toString());
        priorityQueue.insert(WeekDays.MONDAY.toString());
        assertNotEmptyQueue();
    }


    @Test
    public void getMaxKey() {
        fillQueueWithWeekDays();
        final String expected = WeekDays.WEDNESDAY.toString();
        final String actual = (String)priorityQueue.getMaxKey();
        assertNotEmptyQueue();
        assertWrongKey(expected, actual);
    }


    @Test
    public void deleteMaxKey() {
        fillQueueWithWeekDays();
        assertWrongKey(WeekDays.WEDNESDAY.toString(), priorityQueue.deleteMaxKey());
        assertWrongKey(WeekDays.TUESDAY.toString(), priorityQueue.deleteMaxKey());
        assertWrongKey(WeekDays.THURSDAY.toString(), priorityQueue.deleteMaxKey());
        assertWrongKey(WeekDays.SUNDAY.toString(), priorityQueue.deleteMaxKey());
        assertWrongKey(WeekDays.SATURDAY.toString(), priorityQueue.deleteMaxKey());
        assertWrongKey(WeekDays.MONDAY.toString(), priorityQueue.deleteMaxKey());
        assertWrongKey(WeekDays.FRIDAY.toString(), priorityQueue.deleteMaxKey());
        assertEmptyQueue();
    }


    @Test
    public void getMinKey() {
        fillQueueWithWeekDays();
        final String expected = WeekDays.FRIDAY.toString();
        final String actual = (String)priorityQueue.getMinKey();
        assertNotEmptyQueue();
        assertWrongKey(expected, actual);
    }


    @Test
    public void deleteMinKey() {
        fillQueueWithWeekDays();
        assertWrongKey(WeekDays.FRIDAY.toString(), priorityQueue.deleteMinKey());
        assertWrongKey(WeekDays.MONDAY.toString(), priorityQueue.deleteMinKey());
        assertWrongKey(WeekDays.SATURDAY.toString(), priorityQueue.deleteMinKey());
        assertWrongKey(WeekDays.SUNDAY.toString(), priorityQueue.deleteMinKey());
        assertWrongKey(WeekDays.THURSDAY.toString(), priorityQueue.deleteMinKey());
        assertWrongKey(WeekDays.TUESDAY.toString(), priorityQueue.deleteMinKey());
        assertWrongKey(WeekDays.WEDNESDAY.toString(), priorityQueue.deleteMinKey());
        assertEmptyQueue();
    }


    private void assertEmptyQueue() {
        assertTrue(Messages.QUEUE_NOT_EMPTY_MESSAGE.toString(), priorityQueue.isEmpty());
    }


    private void assertNotEmptyQueue() {
        assertTrue(Messages.QUEUE_EMPTY_MESSAGE.toString(), !priorityQueue.isEmpty());
    }


    private void assertWrongKey(final String aExpected, final Comparable aActual) {
        assertEquals(getWrongKeyMessage(aExpected, (String)aActual), aExpected, aActual);
    }


    private String getWrongKeyMessage(final String aExpected, final String aActual) {
        return String.format(Messages.PRIORITY_QUEUE_WRONG_KEY_MESSAGE.toString(), aExpected, aActual);
    }


    private void fillQueueWithWeekDays() {
        for (WeekDays days : WeekDays.values()) {
            priorityQueue.insert(days.toString());
        }
    }
}
