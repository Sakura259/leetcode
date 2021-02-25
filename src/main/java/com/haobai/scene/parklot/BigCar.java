package com.haobai.scene.parklot;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author haobai
 * @description:
 * @date 2021/2/25 10:59
 */
public class BigCar extends AbstractCar {
    @Override
    public Long getParkCost() {
        if (enterTime == null) {
            return 0L;
        }
        if (exitTime == null) {
            exitTime = LocalDateTime.now();
        }
        Duration duration = Duration.between(exitTime, enterTime);
        long hours = duration.toHours();
        return hours * 10 > 120 ? 120 : hours * 10;
    }
}
