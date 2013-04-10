package help;

/**
 * @author dbesliu
 * @created 4/4/13
 */
public class QueueOutOfBoundException extends RuntimeException {

    public QueueOutOfBoundException(final String message) {
        super(message);
    }
}
