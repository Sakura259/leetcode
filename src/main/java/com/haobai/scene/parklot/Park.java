package com.haobai.scene.parklot;

/**
 * @author haobai
 * @description:
 * @date 2021/2/25 11:00
 */
public class Park {
    private volatile int freeCar;

    private Long cost;

    public Park(int freeCar) {
        this.freeCar = freeCar;
    }

    public synchronized void enter(AbstractCar car) {
        if (freeCar > 0) {
            car.enter();
            freeCar--;
        }
    }

    public synchronized void exit(AbstractCar car) {
        car.exit();
        Long parkCost = car.getParkCost();
        freeCar++;
        cost += parkCost;
    }

    public Long getCost() {
        return cost;
    }
}
