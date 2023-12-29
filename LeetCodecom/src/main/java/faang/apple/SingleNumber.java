package faang.apple;

import java.util.HashSet;

public class SingleNumber {

    public int singleNumber1(int[] nums) {

        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){
            sum += num;
            set.add(num);
        }

        int fullSum = 0;
        for (int num : set){
            fullSum += 2*num;
        }

        return fullSum - sum;
    }

    public int singleNumber(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){

            if (set.contains(num)) {
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        int res = 0;

        for (int num : set){
            res = num;
        }
        return res;
    }

}
