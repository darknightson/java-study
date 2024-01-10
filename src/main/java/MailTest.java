import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class MailTest {

    // 메일 전송 정보를 생성한다.
    public static void main(String[] args) {

        String host          = "send.sktmlb.com";
        int port          =  25;
        String hostNm        = "send.sktmlb.com";
        String fromAddr      = "anthony.son@kakaoent.com";     // 보내는 주소
        String toAddr        = "hanmiks@gmail.com";        // 받는 주소

        StringBuffer sbBody = new StringBuffer();

        sbBody.append("<table style='border-collapse:collapse;' cellspacing='0' border='1' >");
        sbBody.append("<tr>");
        sbBody.append("<td bgcolor='#cfe5fe' align='center' width='150'><font color='#0A3876'><b>와우/b></font></td>");
        sbBody.append("</tr>");
        sbBody.append("<tr>");

        sbBody.append("</tr>");
        sbBody.append("</table>");
        sbBody.append("<br>");
        sbBody.append("<br>");

        String body = sbBody.toString();

        Socket smtpSocket = null;
        DataOutputStream os = null;
        DataInputStream is = null;

        Date dDate = new Date();
        DateFormat dFormat = DateFormat.getDateInstance(DateFormat.FULL,Locale.KOREAN);

        try {
            // Open port to server
            smtpSocket = new Socket(host, port);
            os = new DataOutputStream(smtpSocket.getOutputStream());
            is = new DataInputStream(smtpSocket.getInputStream());

            if(smtpSocket != null && os != null && is != null) {
                try {
                    os.writeBytes("HELO\r\n");
                    os.writeBytes("MAIL From: "+fromAddr+"\r\n");

                    os.writeBytes("RCPT To: "+toAddr+"\r\n");
                    os.writeBytes("DATA\r\n");

                    os.writeBytes("X-Mailer: Via Java\r\n");
                    os.writeBytes("DATE: " + dFormat.format(dDate) + "\r\n");
                    String responseline;

                    while((responseline = is.readLine())!= null) {
                        if(responseline.indexOf("Ok") != -1)
                            break;
                    }
                }
                catch(Exception e) {
                    System.out.println("e.getMessage() = " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch(Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (os != null) try {os.close();} catch(Exception e) { System.out.println("e.getMessage() = " + e.getMessage()); e.printStackTrace(); }
            if (is != null) try {is.close();} catch(Exception e){ System.out.println("e.getMessage() = " + e.getMessage()); e.printStackTrace(); }
            if (smtpSocket != null) try {smtpSocket.close();} catch(Exception e){ System.out.println("e.getMessage() = " + e.getMessage()); e.printStackTrace(); }
        }
    }
}
