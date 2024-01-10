package javacodingtechnic.chapter3;

import java.util.List;

public class LaunchCheckList {

    List<String> checks = List.of(
            "Cabin Pressure",
            // "Communication", // 휴스턴과 정말 통신하고 싶은가
            "Engine",
            "Fuel",
            // "Rover", // 내 생각에는 필요없는데...
            "Instruments"
            //"Power Plant"
    );
    Status prepareLaunch(Commander commander) {
        for (String check : checks) {
            boolean shouldAbortTakeoff = commander.isFailing(check);
            if (shouldAbortTakeoff) {
                //System.out.println("check = " + check);
                return Status.ABORT_TAKE_OFF;
            }
        }
        return Status.READY_FOR_TAKE_OFF;
    }


    public static void main(String[] args) {
        LaunchCheckList launchCheckList = new LaunchCheckList();
        Status status = launchCheckList.prepareLaunch(question -> question != null && question.contains("Engine"));
    }
}
