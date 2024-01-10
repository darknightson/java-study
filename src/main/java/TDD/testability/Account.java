package TDD.testability;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@Builder(access = lombok.AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Account {

    private final String username;
    private final String authToken;

    public static Account create(String username, AuthToken authToken) {
        return Account.builder()
                .username(username)
                .authToken(authToken.getAuthToken())
                .build();
    }
}
