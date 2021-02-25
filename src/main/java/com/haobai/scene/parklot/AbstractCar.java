package com.haobai.scene.parklot;

import java.time.LocalDateTime;

/**
 * @author haobai
 * @description:
 * @date 2021/2/25 10:49
 */
public abstract class AbstractCar implements Car {
    LocalDateTime enterTime;

    LocalDateTime exitTime;

    @Override
    public void enter() {
        if (enterTime == null) {
            enterTime = LocalDateTime.now();
        }
    }

    @Override
    public void exit() {
        if (exitTime == null) {
            exitTime = LocalDateTime.now();
        }
    }

    public abstract Long getParkCost();
}
