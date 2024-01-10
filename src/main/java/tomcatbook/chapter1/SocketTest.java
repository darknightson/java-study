package tomcatbook.chapter1;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class SocketTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream os = socket.getOutputStream();
        boolean autoflush = true;
        PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // 웹 서버에 HTTP 요청을 전송
        out.println("GET /login HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();

        // 응답을 읽음
        boolean loop = true;
        StringBuffer sb = new StringBuffer();
        while (loop) {
            if ( in.ready() ) {
                int i = 0;
                while ( i != -1 ) {
                    i = in.read();
                    sb.append((char)i);
                }
                loop = false;
            }
            Thread.sleep(50);
        }
        System.out.println("sb.toString() = " + sb.toString());
        socket.close();
    }

}
