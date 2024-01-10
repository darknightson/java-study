package cleanCode.function;

public class InvalidEmployeeType extends RuntimeException {
    public InvalidEmployeeType(String message) {
        super("Invalid employee type: " + message);
    }

    public InvalidEmployeeType(EmployeeType type) {

    }
}
