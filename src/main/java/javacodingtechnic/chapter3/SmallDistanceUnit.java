package javacodingtechnic.chapter3;

public enum SmallDistanceUnit {

    CENTIMETER,
    INCH;

    static final double INCH_IN_CENTIMETERS = 2.54;
    static final double CENTIMETER_IN_INCHES = 1 / INCH_IN_CENTIMETERS;
    static final int IDENTITY = 1;
    double getConversionRate(SmallDistanceUnit unit) {
        if (this == unit) {
            return IDENTITY;
        }

        if (this == CENTIMETER && unit == INCH) {
            return CENTIMETER_IN_INCHES;
        } else {
            return INCH_IN_CENTIMETERS;
        }
    }

    public static void main(String[] args) {
        SmallDistanceUnit unit = SmallDistanceUnit.INCH;
        System.out.println("unit = " + unit);
        System.out.println("unit.name() = " + unit.name());
        System.out.println(unit.getConversionRate(SmallDistanceUnit.CENTIMETER));
    }
}
