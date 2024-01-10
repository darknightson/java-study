package TheJava;

import java.awt.*;

public class MouseMacro {
    public static void main(String[] args) throws AWTException, InterruptedException {

        Robot robot = new Robot();
        PointerInfo info;
        while ( true ) {

            info = MouseInfo.getPointerInfo();
            robot.mouseMove(info.getLocation().x+1, info.getLocation().y+1);
            Thread.sleep(2000);  // robot.delay() 는60초이상 설정불가
        }
    }
}


