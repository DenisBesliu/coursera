package iterator;

import java.util.Iterator;

import stack.ObjectStack;

/**
 * @author dbesliu
 * @created 3/28/13
 */
public class Main {

    public static void main(String[] args) {
        final Main main = new Main();
        main.iterateStrings();
        main.iterateIntegers();
    }


    private void iterateStrings() {
        ObjectStack<String> stack = new ObjectStack<String>();
        fillStrings(stack);
        iterateStrings(stack);
    }


    private void fillStrings(final ObjectStack<String> aStack) {
        String[] names = new String[] { "Alex", "Andrei", "Vitalie", "Alexandr", "Denis", "Alina", "Andrei" };
        for (String name : names) {
            aStack.push(name);
        }
    }


    private void iterateStrings(final ObjectStack<String> aStack) {
        final Iterator<String> iterator = aStack.iterator();
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
    }


    private void iterateIntegers() {
        ObjectStack<Integer> stack = new ObjectStack<Integer>();
        fillIntegers(stack);
        iterateIntegers(stack);
    }


    private void fillIntegers(final ObjectStack<Integer> aStack) {
        Integer[] daysOfWeek = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
        for (Integer name : daysOfWeek) {
            aStack.push(name);
        }
    }


    private void iterateIntegers(final ObjectStack<Integer> aStack) {
        final Iterator<Integer> iterator = aStack.iterator();
        newLine();
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
    }


    private void newLine() {
        System.out.println();
    }
}
