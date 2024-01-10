package javacodingtechnic.chapter2;

import java.util.Objects;

public class ConstUse {

    private double targetSpeedKmh;

    void setPreset(SpeedPreset speedPreset) {
        Objects.requireNonNull(speedPreset);
        setTargetSpeedKmh(speedPreset.speedKmh);
    }

    public void setTargetSpeedKmh(double targetSpeedKmh) {
        this.targetSpeedKmh = targetSpeedKmh;
    }

    public double getTargetSpeedKmh() {
        return targetSpeedKmh;
    }

    public static void main(String[] args) {
        ConstUse constUse = new ConstUse();
        constUse.setPreset(SpeedPreset.PLANETARY_SPEED);
        System.out.println(constUse.getTargetSpeedKmh());
    }

    static enum SpeedPreset {
        STOP(0), PLANETARY_SPEED(7667), CRUISING_SPEED(16944);

        final double speedKmh;

        SpeedPreset(double speedKmh) {
            this.speedKmh = speedKmh;
        }
    }
}


