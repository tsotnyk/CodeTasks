package prepInterviewApple;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        List<int[]> list = new LinkedList<>();
        int[] curInt = intervals[0];

        for (int i = 1; i < intervals.length; i++){
            int[] candidate = intervals[i];
            if (curInt[1] < candidate[0]){
                list.add(curInt);
                curInt = candidate;
                continue;
            }
            curInt[1] = Math.max(curInt[1], candidate[1]);
        }
        list.add(curInt);

        int[][] res= new int[list.size()][];
        int index = 0;
        for (int[] arr : list){
            res[index++] = arr;
        }

        return res;
    }
}
