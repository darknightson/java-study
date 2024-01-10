package effectivejava.item5;

import java.time.LocalDateTime;

public class LocalDateTimeClockHolder implements ClockHolder {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
