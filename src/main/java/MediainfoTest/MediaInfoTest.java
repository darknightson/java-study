package MediainfoTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MediaInfoTest {

    public static void main(String[] args) {
        // 1music.MP3
        //String filePath = "\'/Users/anthony/1mp3 320'kbps'.mp3\'";
        //String filePath = "'/Users/anthony/1mp3 320kbps.mp3'";
        //String filePath = "/Users/anthony/1mp3 320kbps.mp3";
        String filePath = "/Users/anthony/1우리나라.wav";

        String concatText = "\'";
        String filePathRst = concatText.concat(filePath).concat(concatText);

        String execute = execute(filePathRst);
        System.out.println("execute = " + execute);
    }

    public static String execute(String filepath) {
        String result = "";
        Process process = null;
        Runtime runtime = Runtime.getRuntime();
        StringBuffer output = new StringBuffer(); // 아웃풋
        BufferedReader successBufferReader = null; // 성공 버퍼
        BufferedReader errorBufferReader = null; // 오류 버퍼
        String msg = null; // 메시지

        List<String> cmdList = new ArrayList<String>();

        // 운영체제 구분 (window, window 가 아니면 무조건 linux 로 판단)
        final String[] split = filepath.split("\\s");
        cmdList.add("/bin/sh");
        cmdList.add("-c");
        cmdList.add("mediainfo " + filepath);

        String[] array = cmdList.toArray(new String[cmdList.size()]);

        try {

            // 명령어 실행
            process = runtime.exec(array);

            // shell 실행이 정상 동작했을 경우
            final InputStream inputStream = process.getInputStream();
            System.out.println("inputStream = " + inputStream);
            successBufferReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            while ((msg = successBufferReader.readLine().trim()) != null) {
                if ( msg != null && msg.contains("Channel(s)") ) {
                    result  = msg.substring(msg.lastIndexOf(":") + 1);
                }
                output.append(msg + System.getProperty("line.separator"));
            }

            // shell 실행시 에러가 발생했을 경우
            errorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
            while ((msg = errorBufferReader.readLine()) != null) {
                output.append(msg + System.getProperty("line.separator"));
            }

            // 프로세스의 수행이 끝날때까지 대기
            process.waitFor();

            // shell 실행이 정상 종료되었을 경우
            if (process.exitValue() == 0) {
                return result;

            } else {
                // shell 실행이 비정상 종료되었을 경우
                result = output.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                process.destroy();
                if (successBufferReader != null) successBufferReader.close();
                if (errorBufferReader != null) errorBufferReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return result;
    }
}
