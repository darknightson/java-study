package cleanCode.boundary;

public class Sensor {

    private Long sensorId;

    public Sensor() {
    }

    public Sensor(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Long getSensorId() {
        return sensorId;
    }
}
