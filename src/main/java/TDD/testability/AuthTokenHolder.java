package TDD.testability;

import java.util.UUID;

public class AuthTokenHolder implements AuthToken {
    @Override
    public String getAuthToken() {
        return UUID.randomUUID().toString();
    }
}
