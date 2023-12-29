package faang.apple;

import java.util.HashSet;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();

        for (int num : nums1){
            set1.add(num);
        }

        HashSet<Integer> resSet = new HashSet<>();

        for (int num : nums2){

            if (set1.contains(num)){
                resSet.add(num);
            }
        }

        int[] res = new int[resSet.size()];
        int index = 0;
        for (int num : resSet){
            res[index++] = num;
        }

        return res;
    }
}
