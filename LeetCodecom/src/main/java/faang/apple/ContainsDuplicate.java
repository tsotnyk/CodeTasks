package faang.apple;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int num : nums){
            if(!set.add(num)) return true;
        }
        return false;
    }
}
