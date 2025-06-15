package prepInterviewMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {

    if (k == 0 && nums.length == 0) {
        return new double[0];
    }

    double[] result = new double[nums.length - k + 1];
    int index = 0;
    boolean flag = k%2 == 0;

    List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++){
        list.add(nums[i]);
    }

        while (index < result.length){

        getMedian(list, k, flag, result, index);
        if (index+1 < result.length) {
            list.remove(Integer.valueOf(nums[index]));
            list.add(nums[k+index]);
        }
        index++;
    }

        return result;
}

    private void getMedian(List<Integer> list, int k, boolean flag, double[] result, int index){

        Collections.sort(list);
        if (flag){
            int delta = k/2;
            if (list.get(delta).equals(list.get(delta-1))){
                result[index] = Double.valueOf(list.get(delta));
            }else {
                result[index] = ((double)list.get(delta)/2)+((double)list.get(delta-1)/2);
            }
        }else {
            result[index] = list.get(k/2);
        }
    }
}
