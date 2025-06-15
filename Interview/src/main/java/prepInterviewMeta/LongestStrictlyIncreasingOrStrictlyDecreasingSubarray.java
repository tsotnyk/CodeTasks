package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    public int longestMonotonicSubarray(int[] nums) {

        int maxLength = 1;

        if (nums.length < 2) return maxLength;

        int candidateLength = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1]){
                candidateLength++;
            }else {
                maxLength = Math.max(candidateLength, maxLength);
                candidateLength = 1;
            }
        }

        maxLength = Math.max(candidateLength, maxLength);
        candidateLength = 1;
        for (int i = nums.length-2; i >= 0; i--){
            if (nums[i] > nums[i+1]){
                candidateLength++;
            }else {
                maxLength = Math.max(candidateLength, maxLength);
                candidateLength = 1;
            }
        }
        return Math.max(candidateLength, maxLength);
    }

    @Test
    public void test(){

        Assert.assertEquals(longestMonotonicSubarray(new int[]{1,4,3,3,2}), 2);
        Assert.assertEquals(longestMonotonicSubarray(new int[]{3,3,3,3,3,3,3}), 1);
        Assert.assertEquals(longestMonotonicSubarray(new int[]{3,2,1}), 3);
    }
}
