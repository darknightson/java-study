package designpattern.adapter.ex;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InflearnAccount {

    private String email;
    private String password;
    private String username;
    public static final String INFLEARN_SECRET = "INF_SECRET";

    public String login() {
        // 인증 절차 생략
        System.out.println("인프런 로그인 성공");
        return email + INFLEARN_SECRET + password;
    }
}
