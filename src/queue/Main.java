package queue;

/**
 * @author dbesliu
 * @created 3/28/13
 */
public class Main {

    public static void main(final String[] args) {
        final Main main = new Main();
        main.computeDaysOfWeek();
        main.computeNames();
    }


    private void computeDaysOfWeek() {
        final Integer[] daysOfWeek = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
        final StringOfQueue<Integer> queue = new StringOfQueue<Integer>();

        fillQueue(queue, daysOfWeek);
        printQueue(queue);
    }


    private void fillQueue(final StringOfQueue<Integer> aQueue, final Integer[] aDaysOfWeek) {
        for (Integer dayOfWeek : aDaysOfWeek) {
            aQueue.enqueue(dayOfWeek);
        }
    }


    private void printQueue(final StringOfQueue<Integer> aQueue) {
        Integer value = 0;
        newLine();
        while (value != null) {
            value = aQueue.dequeue();
            if (value != null) {
                System.out.print(" " + value);
            }
        }
    }


    private void newLine() {
        System.out.println();
    }


    private void computeNames() {
        final String[] names = new String[] { "Alex", "Andrei", "Vitalie", "-", "Alexandr", "Denis", "Alina", "-", "Andrei" };
        final StringOfQueue<String> queue = new StringOfQueue<String>();

        processNames(queue, names);
    }


    private void processNames(final StringOfQueue<String> aQueue, final String[] aNames) {
        final StringOfQueue<String> queue = aQueue;
        newLine();
        for (String name : aNames) {
            if (name.equals("-")) {
                printName(queue.dequeue());
            } else {
                queue.enqueue(name);
            }
        }
    }


    private void printName(final String aName) {
        System.out.print(" " + aName);
    }
}
