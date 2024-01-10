package javacodingtechnic.chapter3;

import java.util.ArrayList;
import java.util.List;

public class FuelSystem {

    List<Double> tanks = new ArrayList<>();

    int getAverageTankFillingPercent() {
        double sum = 0;
        for (double tank : tanks) {
            sum += tank;
        }
        double averageFuel = sum / tanks.size();
        // 정수 백분율로 반올림
        return Math.toIntExact(Math.round(averageFuel));
    }
}
