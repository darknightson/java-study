package effectivejava.item5;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class User {

    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    @Builder
    public User(String name, String email, String password, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public static User create(String name, String email, String password, ClockHolder clockHolder) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                // 실제 저장되는 시간 이므로 상용에서는 LocalDateTime.now()를 강제로 사용해야 한다.
                .createdAt(clockHolder.now())
                .build();
    }
}
