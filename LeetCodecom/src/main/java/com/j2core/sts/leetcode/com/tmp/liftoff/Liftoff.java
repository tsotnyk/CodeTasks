package com.j2core.sts.leetcode.com.tmp.liftoff;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Liftoff {

    public TimeLineObject addSeries(TimeLineObject timeLine1, TimeLineObject timeLine2){

        TimeLineObject result = new TimeLineObject();

        if (timeLine1.timeList.isEmpty() && timeLine2.timeList.isEmpty()) return result;
        if (timeLine1.timeList.isEmpty()) return timeLine2;
        if (timeLine2.timeList.isEmpty()) return timeLine1;

        int index1 = 0;
        int index2 = 0;
        TimeObject tmp = null;

        while (index1 < timeLine1.timeList.size() && index2 < timeLine2.timeList.size()){

            if (timeLine1.timeList.get(index1).time == timeLine2.timeList.get(index2).time){
                if (tmp != null){
                    result.timeList.add(tmp);
                    tmp = null;
                }
                result.timeList.add(new TimeObject(timeLine1.timeList.get(index1).value + timeLine2.timeList.get(index2).value, timeLine1.timeList.get(index1).time));
                index1++;
                index2++;
            }else {
                if (tmp != null){

                }else {
                    if (timeLine1.timeList.get(index1).time < timeLine2.timeList.get(index2).time){
                        tmp = timeLine1.timeList.get(index1++);
                    }else {
                        tmp = timeLine2.timeList.get(index2++);
                    }
                }
            }
        }

        result.timeList.add(tmp);

        if (index1 < timeLine1.timeList.size()){
            for (int i = index1; i < timeLine1.timeList.size(); i++){
                result.timeList.add(timeLine1.timeList.get(i));
            }
        }else {
            for (int i = index1; i < timeLine2.timeList.size(); i++){
                result.timeList.add(timeLine2.timeList.get(i));
            }
        }

        return result;
    }

}


class TimeObject{
    int value;
    double time;

    public TimeObject(int value, double time) {
        this.value = value;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeObject that = (TimeObject) o;
        return value == that.value &&
                Double.compare(that.time, time) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, time);
    }
}

class TimeLineObject{
    List<TimeObject> timeList = new LinkedList<>();
}
