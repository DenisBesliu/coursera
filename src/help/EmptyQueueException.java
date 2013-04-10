package help;

/**
 * @author dbesliu
 * @created 4/4/13
 */
public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(final String message) {
        super(message);
    }
}
