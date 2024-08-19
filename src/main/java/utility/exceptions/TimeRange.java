package utility.exceptions;

import java.time.LocalTime;

public class TimeRange {
    private LocalTime openTime;
    private LocalTime closeTime;

    public TimeRange(LocalTime openTime, LocalTime closeTime) {
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public boolean includes(LocalTime time) {
        return !time.isBefore(openTime) && !time.isAfter(closeTime);
    }

    @Override
    public String toString() {
        return openTime + " - " + closeTime;
    }
}
