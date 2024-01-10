package effectivejava.item5;

public class ClientService {
    private EmailService emailService;

    public ClientService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmail(String subject, String body, String email) {
        emailService.sendEmail(subject, body, email);
    }

    public static void main(String[] args) {
        ClientService clientService = new ClientService(new SimpleEmailService());
        clientService.sendEmail("subject", "body", "email");
    }
}
