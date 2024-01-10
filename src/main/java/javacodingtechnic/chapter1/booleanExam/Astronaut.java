package javacodingtechnic.chapter1.booleanExam;

public class Astronaut {

    String name;
    int missions;

    // solution 1
    private boolean isValid1() {
        return missions >= 0 && name != null && !name.trim().isEmpty();
    }

    // solution 2
    private boolean isValid2() {
        boolean isValidMissions = missions >= 0;
        boolean isValidName = name != null && !name.trim().isEmpty();
        return isValidMissions && isValidName;
    }

    // solution 3
    boolean isValid3() {
        return isValidMission() && isValidName();

    }

    private boolean isValidName() {
        return name != null && !name.isEmpty();
    }

    private boolean isValidMission() {
        return missions >= 0;
    }

    public static void main(String[] args) {
        Astronaut astronaut = new Astronaut();
        astronaut.missions = 1;
        astronaut.name = "anthony";
        System.out.println("isValid1() ==> " + astronaut.isValid1());
        System.out.println("isValid2() ==> " + astronaut.isValid2());
        System.out.println("isValid3() ==> " + astronaut.isValid3());
    }
}
