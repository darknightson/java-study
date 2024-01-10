package effectivejava.item5;

import java.time.LocalDateTime;

public class TestClockHolder implements ClockHolder {

    private LocalDateTime now;

    public TestClockHolder(LocalDateTime now) {
        this.now = now;
    }
    @Override
    public LocalDateTime now() {
        return this.now;
    }
}
