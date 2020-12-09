package com.j2core.sts.leetcode.com.rangeModule;

import java.util.Map;
import java.util.TreeMap;

public class RangeModule {

    TreeMap<Integer, Integer> rangeMap;

    public RangeModule() {
        this.rangeMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {

        Map.Entry<Integer, Integer> smallerRange = this.rangeMap.floorEntry(left);
        Map.Entry<Integer, Integer> biggerRange = this.rangeMap.ceilingEntry(left);

        if (smallerRange == null && biggerRange == null) {
            this.rangeMap.put(left, right);
            return;
        }

        if (smallerRange == null){
            if (right < biggerRange.getKey()){
                this.rangeMap.put(left, right);
            }else {
                this.rangeMap.put(left, biggerRange.getValue());
                this.rangeMap.remove(biggerRange);
            }
            return;
        }

        if (biggerRange == null){
            if (smallerRange.getValue() < left){
                this.rangeMap.put(left, right);
            }else {
                this.rangeMap.put(smallerRange.getKey(), right);
            }
            return;
        }

        if (smallerRange.getValue() < left && biggerRange.getKey() > right){
            this.rangeMap.put(left, right);
            return;
        }

        if (biggerRange.getKey() > right){
            this.rangeMap.put(smallerRange.getKey(), right);
            return;
        }

        if (smallerRange.getValue() < left){
            this.rangeMap.put(left, biggerRange.getValue());
            this.rangeMap.remove(biggerRange);
            return;
        }

        this.rangeMap.put(smallerRange.getKey(), biggerRange.getValue());
        this.rangeMap.remove(biggerRange);
    }

    public boolean queryRange(int left, int right) {

        Map.Entry<Integer, Integer> range = this.rangeMap.floorEntry(left);
        if (range != null){
            return range.getValue() >= right;
        }
        return false;
    }

    public void removeRange(int left, int right) {

        Map.Entry<Integer, Integer> smallerRange = this.rangeMap.floorEntry(left);
        Map.Entry<Integer, Integer> biggerRange = this.rangeMap.ceilingEntry(left);

        if (smallerRange != null){
            if (smallerRange.getValue() == right && smallerRange.getKey() == left){
                this.rangeMap.remove(smallerRange);
                return;
            }
            if (smallerRange.getKey() == left){
                this.rangeMap.put(right, smallerRange.getValue());
                this.rangeMap.remove(smallerRange);
                return;
            }
            if (smallerRange.getValue() == right){
                this.rangeMap.put(smallerRange.getKey(), left);
                return;
            }
            if (smallerRange.getValue() > right){
                this.rangeMap.put(smallerRange.getKey(), left);
                this.rangeMap.put(right, smallerRange.getValue());
                return;
            }
        }

        if (biggerRange != null){

        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */