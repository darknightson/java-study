package tomcatbook.ex01.pyrmont;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 HTTP Response = Status-Line
 * (( general-header | response-header | entity-header ) CRLF)
 * CRLF
 * [ message-body ]
 * Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
 */

public class Response {

    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {

                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }

            } else {
                // 파일이 없을 경우
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content=Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes(StandardCharsets.UTF_8));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if ( fis != null ) {
                fis.close();
            }
        }
    }

    public void randomAccessFileTest() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("/ssss"), "a");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //randomAccessFile.close();
        }
    }
}
