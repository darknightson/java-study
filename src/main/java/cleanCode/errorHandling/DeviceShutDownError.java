package cleanCode.errorHandling;

public class DeviceShutDownError extends RuntimeException {
    public DeviceShutDownError() {
        super();
    }

    public DeviceShutDownError(String message) {
        super(message);
    }
}
