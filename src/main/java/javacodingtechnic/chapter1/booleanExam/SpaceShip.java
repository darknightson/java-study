package javacodingtechnic.chapter1.booleanExam;

public class SpaceShip {
    Crew crew; // 승무원
    FuelTank fuelTank; // 연료 탱크
    Hull hull; // 선체
    Navigator navigator; // 항해자
    OxygenTank oxygenTank; // 산소 탱크

    boolean willCrewSurvive() {
        return hull.holes == 0 &&
                fuelTank.fuel >= navigator.requiredFuelToEarth() &&
                oxygenTank.lastsFor(crew.size) > navigator.timeToEarth();
    }

    // solution
    boolean willCrewSurvive1() {
        boolean hasEnoughResource = hasEnoughOxygen() && hasEnoughFull();
        return hull.holes == 0 && hasEnoughResource;
    }
    boolean hasEnoughOxygen() {
        return oxygenTank.lastsFor(crew.size) > navigator.timeToEarth();
    }

    boolean hasEnoughFull() {
        return fuelTank.fuel > navigator.requiredFuelToEarth();
    }

}
