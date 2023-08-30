package old.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime {

    public static List<Interval> employeeFreeTime(ArrayList <ArrayList<Interval>> schedule) {

        List<Interval> busyTime = schedule.get(0);

        for (int j = 1; j < schedule.size(); j++){
            busyTime.addAll(schedule.get(j));
        }

        busyTime = MergeIntervals.mergeIntervals(busyTime);

        List<Interval> ans = new ArrayList<Interval>();

        if (busyTime.size() == 1) return ans;

        for (int i = 0; i < busyTime.size()-1; i++){

            Interval freeInt = new Interval(busyTime.get(i).end, busyTime.get(i+1).start);
            ans.add(freeInt);
        }

        return ans;
    }
}
