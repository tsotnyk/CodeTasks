package mergeIntervals;

import java.util.*;

public class MergeIntervals {

    public static List <Interval> mergeIntervals(List <Interval> intervals) {
        // Replace this placeholder return statement with your code

        intervals.sort((a,b) -> {
            if (a.start == b.start){
                return a.end - b.end;
            }

            return a.start - b.start;
        });

        ArrayList<Interval> result = new ArrayList<>();
        Interval curInterval = intervals.get(0);

        for (Interval interval : intervals){

            if (curInterval.end < interval.start){
                result.add(curInterval);
                curInterval = interval;
            }else {
                curInterval.end = Math.max(curInterval.end, interval.end);
            }
        }

        result.add(curInterval);

        return result;
    }
}
