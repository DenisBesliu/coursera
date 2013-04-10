package sort.comparable;

import java.util.Arrays;
import java.util.List;

import help.Customer;
import help.Messages;
import help.NullArrayException;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import priorityqueue.HeapSort;

/**
 * @author dbesliu
 * @created 3/28/13
 */
@RunWith(Parameterized.class)
public class SortTest {

    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] { { new Shell() }, { new SelectionSort() }, { new MergeSort() }, { new InsertionSort() },
                                             { new QuickSort() }, { new HeapSort() } });
    }

    private final Sort sort;


    public SortTest(final Sort aSort) {
        sort = aSort;
    }


    @Test(expected = NullArrayException.class)
    public void nullArray() {
        sort.sort(null);
    }


    @Test
    public void emptyArray() {
        String[] names = new String[] {};
        sort.sort(names);
        assertArrayEquals(new String[] {}, names);
        assertEquals(String.format(Messages.ARRAY_NOT_EMPTY_MESSAGE.toString(), names.length), 0, names.length);
    }


    @Test
    public void sortStringArray() {
        String[] names = new String[] { "Denis", "Alex", "Alexandr", "Stanislav", "Alina", "Andrei", };
        sort.sort(names);
        assertNameEquals("Alex", names[0]);
        assertNameEquals("Alexandr", names[1]);
        assertNameEquals("Alina", names[2]);
        assertNameEquals("Andrei", names[3]);
        assertNameEquals("Denis", names[4]);
        assertNameEquals("Stanislav", names[5]);
    }


    private void assertNameEquals(final String aExpected, final String aActual) {
        assertEquals(String.format(Messages.NOT_EQUALS_NAMES_MESSAGE.toString(), aExpected, aActual), aExpected, aActual);
    }


    @Test
    public void sortIntegerArray() {
        Integer[] daysOfWeek = new Integer[] { 2, 5, 3, 4, 1, 7, 6 };
        sort.sort(daysOfWeek);
        assertDaysEquals(1, daysOfWeek[0]);
        assertDaysEquals(2, daysOfWeek[1]);
        assertDaysEquals(3, daysOfWeek[2]);
        assertDaysEquals(4, daysOfWeek[3]);
        assertDaysEquals(5, daysOfWeek[4]);
        assertDaysEquals(6, daysOfWeek[5]);
    }


    private void assertDaysEquals(final Integer aExpected, final Integer aCurrent) {
        assertEquals(String.format(Messages.NOT_EQUALS_DAYS_MESSAGE.toString(), aExpected, aCurrent), aExpected, aCurrent);
    }


    @Test
    public void sortCustomerArray() {
        final Customer alex = createNewCustomer("Alex");
        final Customer denis = createNewCustomer("Denis");
        final Customer alexandr = createNewCustomer("Alexandr");
        final Customer andrei = createNewCustomer("Andrei");
        final Customer stanislav = createNewCustomer("Stanislav");
        final Customer vitalie = createNewCustomer("Vitalie");

        Customer[] customers = new Customer[] { denis, alexandr, stanislav, vitalie, alex, andrei };
        sort.sort(customers);

        assertCustomerEquals(alex, customers[0]);
        assertCustomerEquals(alexandr, customers[1]);
        assertCustomerEquals(andrei, customers[2]);
        assertCustomerEquals(denis, customers[3]);
        assertCustomerEquals(stanislav, customers[4]);
        assertCustomerEquals(vitalie, customers[5]);
    }


    private Customer createNewCustomer(final String aName) {
        return new Customer(aName);
    }


    private void assertCustomerEquals(final Customer aExpected, final Customer aCurrent) {
        assertEquals(String.format(Messages.NOT_EQUALS_CUSTOMERS_MESSAGE.toString(), aExpected, aCurrent), aExpected, aCurrent);
    }
}
