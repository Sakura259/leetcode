package com.haobai.scene.park;

import java.util.Date;

/**
 * @author haobai
 * @description:
 * @date 2021/4/15 22:06
 */
public abstract class AbstractCar implements Car {

    public Integer getId() {
        return id;
    }

    private Integer id;

    private Date enterTime;

    private Date exitTime;

    @Override
    public void enter() {
        enterTime = new Date();
    }

    @Override
    public void exit() {
        exitTime = new Date();
    }

    protected abstract int getFee();

    public Date getEnterTime() {
        return enterTime;
    }

    public Date getExitTime() {
        return exitTime;
    }
}
