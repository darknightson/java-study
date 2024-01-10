package cleanCode.objectAndDataStructures;

public class NoSuchShapeException extends RuntimeException {

    public NoSuchShapeException() {
        super();
    }

    public NoSuchShapeException(String message) {
        super("No such shape: " + message);
    }
}
