package com.j2core.sts.leetcode.com.designParkingSystem;

import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {

//    Map<Integer, Integer> map;
    int capacityBig;
    int capacityMedium;
    int capacitySmall;

    public ParkingSystem(int big, int medium, int small) {

        capacityBig = big;
        capacityMedium = medium;
        capacitySmall = small;
//
//        map = new HashMap<>();
//
//        for (int i = 1; i <=3; i++){
//            map.put(i, 0);
//        }

    }

    public boolean addCar(int carType) {

        switch (carType){
            case 1:
                if (capacityBig == 0) return false;
                capacityBig--;
                break;
            case 2:
                if (capacityMedium == 0) return false;
                capacityMedium--;
                break;
            case 3:
                if (capacitySmall == 0) return false;
                capacitySmall--;
        }
        return true;

//        int capacity = map.get(carType);
//        switch (carType){
//            case 1:
//                if (capacity == capacityBig) return false;
//                break;
//            case 2:
//                if (capacity == capacityMedium) return false;
//                break;
//            case 3:
//                if (capacity == capacitySmall) return false;
//                break;
//        }
//        map.put(carType, capacity+1);
//        return true;
    }
}
