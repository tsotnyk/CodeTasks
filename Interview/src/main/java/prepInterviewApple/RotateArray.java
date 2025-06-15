package prepInterviewApple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        int steps = k% nums.length;
        int [] tmpArr = new int[steps];
        int index = steps-1;
        for (int i = nums.length-1; i >= nums.length-steps; i--){
            tmpArr[index--] = nums[i];
        }
        for (int i = nums.length-steps-1; i >= 0; i--){
            nums[i+steps] = nums[i];
        }

        for (int i = 0; i < tmpArr.length; i++){
            nums[i] = tmpArr[i];
        }

    }

    public void rotateFast(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums,int start ,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test(){

        int[] res = new int[]{5,6,7,1,2,3,4};

        int[] arr = new int[]{1,2,3,4,5,6,7};

        rotate(arr, 3);

        Assert.assertEquals( res, arr);
    }
}
