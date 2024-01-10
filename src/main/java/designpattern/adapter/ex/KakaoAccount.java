package designpattern.adapter.ex;

import lombok.*;
import org.checkerframework.checker.lock.qual.GuardedBy;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoAccount {

    private String id;
    private String password;
    private String name;
    private String email;
    public static final String KAKAO_SECRET = "KA_SECRET";

    public String getAuthToken() {
        // 인증 절차 생략
        System.out.println("카카오 로그인 성공");
        return id + KAKAO_SECRET + password;
    }
}
