package stack;

/**
 * @author dbesliu
 * @created 3/27/13
 */
public class Main {

    public static void main(final String[] args) {
        final String[] values = new String[] { "to", "me", "me", "to", "me", "me", "-", "you", "-", "your", "-", "-" };
        final Main main = new Main();
        main.compute(values, new ObjectStack<String>());
        main.compute(values, new FixedStack<String>(4));
        main.compute();
    }


    private void compute(final String[] aValues, final Stack aStack) {
        newLine();
        for (final String value : aValues) {
            if (value.equals("-")) {
                System.out.print(" " + aStack.pop());
            } else {
                aStack.push(value);
            }
        }
    }


    private void newLine() {
        System.out.println();
    }


    private void compute() {
        final ObjectStack<Integer> stack = new ObjectStack<Integer>();
        final Integer[] daysOfWeek = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };

        newLine();
        for (final Integer dayOfWeek : daysOfWeek) {
            fillStackWithDay(stack, dayOfWeek);
        }

    }


    private void fillStackWithDay(final ObjectStack<Integer> aStack, final Integer dayOfWeek) {
        if (isOdd(dayOfWeek)) {
            printDayOfWeek(aStack.pop());
        } else {
            aStack.push(dayOfWeek);
        }
    }


    private boolean isOdd(final Integer dayOfWeek) {
        return dayOfWeek % 2 == 0;
    }


    private void printDayOfWeek(final Integer aDayOfWeek) {
        System.out.print(" " + aDayOfWeek);
    }

}
