package com.haobai.scene.park;

/**
 * @author haobai
 * @description:
 * @date 2021/4/15 22:08
 */
public class BigCar extends AbstractCar {

    @Override
    protected int getFee() {
        int hours = super.getExitTime().getHours() - super.getEnterTime().getHours();
        return hours * 12 > 120 ? 120 : hours * 12;
    }
}
