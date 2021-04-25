package com.haobai.scene.park;

import java.util.HashMap;

/**
 * @author haobai
 * @description:
 * @date 2021/4/15 22:11
 */
public class Park {

    private HashMap<Integer, AbstractCar> map;

    private Integer sum;

    private Integer num;

    public Park(Integer sum, Integer num) {
        this.sum = sum;
        this.num = sum;
        this.map = new HashMap<>(num);
    }

    public void enter(AbstractCar car) {
        if (num > 0) {
            car.enter();
            map.put(car.getId(), car);
            num--;
        } else {
            System.out.println("停车场已满");
        }
    }

    public void exit(Integer id) {
        AbstractCar car = map.get(id);
        car.exit();
        num++;
        sum += car.getFee();
        map.remove(id);
    }

    public Integer getSum() {
        return sum;
    }

}
