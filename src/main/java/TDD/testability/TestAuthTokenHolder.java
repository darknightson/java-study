package TDD.testability;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class TestAuthTokenHolder implements AuthToken {

    private String authToken;

    @Override
    public String getAuthToken() {
        return authToken;
    }
}
