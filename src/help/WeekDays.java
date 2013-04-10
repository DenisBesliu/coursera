package help;

/**
 * @author dbesliu
 * @created 4/4/13
 */
public enum WeekDays {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    private final String dayOfWeek;


    WeekDays(final String aDayOfWeek) {
        dayOfWeek = aDayOfWeek;
    }


    @Override
    public String toString() {
        return dayOfWeek;
    }
}
