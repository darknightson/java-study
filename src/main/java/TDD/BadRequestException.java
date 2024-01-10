package TDD;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String invalidInput) {
        super(invalidInput);
    }
}
