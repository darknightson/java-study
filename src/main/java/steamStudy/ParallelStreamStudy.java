package steamStudy;

import fastcampusModenJava.part06.User;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamStudy {
    public static void main(String[] args) {
        // 여라개의 스레드를 이용하여 stream 의 처리 과정을 병렬화 ( parallelize )
        // 중간 과정은 병렬 처리 되지만 순서가 있는 stream 의 경우 종결 처리 했을 때의 결과물이 기존의 순차적 처리와 일치하도록
        // 종결 처리 과정에서 조정된다. 즉 List 로 collect 한다면 순서가 항상 올바르게 나온다는 것
        // 병렬처리는 순서가 상관 없을때 , 순서가 보장되지 않아도 될 때 쓰는 것이다.
        // 예를 들어 아래처럼  이메일 인증 되지 않은 사용자에게 대량으로 메일을 보낼때.
        EmailService emailService = new EmailService();
        List<User> users = Arrays.asList(
                new User(101, "anthony", "anthony.son@kakaoent.com", true),
                new User(102, "robin", "robin.kts@kakaoent.com", true),
                new User(103, "henry", "henry@kakaoent.com", false),
                new User(104, "tom", "a@kakaoent.com", false),
                new User(105, "mac", "b@kakaoent.com", false),
                new User(106, "option", "c@kakaoent.com", false),
                new User(107, "command", "c@kakaoent.com", false),
                new User(108, "brion", "e@kakaoent.com", false),
                new User(109, "lion", "f@kakaoent.com", false),
                new User(110, "tiger", "g@kakaoent.com", false)

        );
        long startTime = System.currentTimeMillis();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(user -> emailService.sendVerifyYourEmail(user.getEmailAddress()));

        long endTime = System.currentTimeMillis();
        System.out.println("SequentialGroup = " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        users.stream().parallel()
                .filter(user -> !user.isVerified())
                .forEach(user -> emailService.sendVerifyYourEmail(user.getEmailAddress()));

        endTime = System.currentTimeMillis();

        System.out.println("parallel = " + (endTime - startTime) + "ms");
    }
}
