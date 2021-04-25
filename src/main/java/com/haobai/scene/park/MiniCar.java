package com.haobai.scene.park;

/**
 * @author haobai
 * @description:
 * @date 2021/4/15 22:11
 */
public class MiniCar extends AbstractCar{
    @Override
    protected int getFee() {
        int hours = super.getExitTime().getHours() - super.getEnterTime().getHours();
        return hours * 6 > 60 ? 60 : hours * 6;
    }
}
