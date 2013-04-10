package help;

/**
 * @author dbesliu
 * @created 3/28/13
 */
public class Customer implements Comparable<Customer> {

    private final String name;


    public Customer(final String aName) {
        name = aName;
    }


    @Override
    public int compareTo(final Customer aThat) {
        return this.name.compareTo(aThat.name);
    }


    @Override
    public String toString() {
        return name;
    }
}
