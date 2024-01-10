package TDD.testability;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    @DisplayName("계정을 생성합니다. 의존성 주입을 통해 테스트 가능하게 만듭니다.")
    @Test
    void accountCreate() {

        // given
        String username = "test";
        String authToken = UUID.randomUUID().toString();

        // when
        Account account = Account.create(username, new TestAuthTokenHolder(authToken));
        Account account1 = Account.create(username, new AuthTokenHolder());

        // then
        assertThat(account.getUsername()).isEqualTo(username);
        assertThat(account.getAuthToken()).isEqualTo(authToken);

        assertThat(account1.getUsername()).isEqualTo(username);
    }
}