package faang.amazon;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MakeArrayZeroBySubtractingEqualsAmounts {

    public int minimumOperations(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){
            if (num != 0) set.add(num);
        }

        return set.size();

    }

    class Tree{

        int value;

        Tree right;
        Tree left;

        public Tree(){

        }

        public Tree(int value) {
            this.value = value;
        }
    }
}
