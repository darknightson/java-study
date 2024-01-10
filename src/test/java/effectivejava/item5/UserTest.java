package effectivejava.item5;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void 신규_유저를_생성할_수_있다() {

        // given
        String name = "test";
        String email = "test@naver.com";
        String password = "1234";

        // when
        ClockHolder clockHolder = new TestClockHolder(LocalDateTime.now());

        User user = User.create(name, email, password, clockHolder);

        // then
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getCreatedAt()).isEqualTo(clockHolder.now());
    }
}