package effectivejava.item5;

public class SimpleEmailService implements EmailService {
    @Override
    public void sendEmail(String subject, String body, String email) {
        System.out.println("subject = " + subject + ", body = " + body + ", email = " + email);
    }
}
