package tomcatbook.ex01.pyrmont;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    /**
     * WEB_ROOT 는 HTML 또는 그 밖의 파일이 위치하는 디렉토리 이다.
     * 이 애플리케이션에서의 WEB_ROOT 는 작업 디렉토리 아래의 "webroot" 라는 디렉토리이다.
     * 작업 디렉토리는 java 명령이 실행되는 현재의 위치를 말한다.
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    
    // 종료 명령
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    
    // 종료 명령이 받아졌는지의 여부
    private boolean shutdown = false;
    
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        System.out.println("server.WEB_ROOT = " + server.WEB_ROOT);
        server.await();
    }

    private void await() {
        ServerSocket serverSocket = null;
        int port = 8080;

        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // 요청을 기다리는 루프
        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                // Request 객체 생성 및 parse 호출
                Request request = new Request(input);
                request.parse();
                // Response 객체 생성
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();

                // 소켓 닫기
                socket.close();
                // URL이 종료 명령이었는지 확인
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

}
