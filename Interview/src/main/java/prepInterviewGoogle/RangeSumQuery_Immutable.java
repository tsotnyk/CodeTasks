package prepInterviewGoogle;

public class RangeSumQuery_Immutable {
}

class NumArray {

    int[] sumArray;
    public NumArray(int[] nums) {

        sumArray = new int[nums.length+1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            sumArray[i+1] = sum;
        }
    }

    public int sumRange(int left, int right) {

        return left == 0 ? sumArray[right+1] : sumArray[right+1] - sumArray[left];
    }
}
