package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TypeOfTriangle {

    public String triangleType(int[] nums) {

        Arrays.sort(nums);
        if (nums[0]+nums[1] <= nums[2]) return "none";

        if (nums[0] == nums[1]){
            return nums[0] == nums[2] ? "equilateral" : "isosceles";
        }else {
            return nums[1] == nums[2] || nums[0] == nums[2] ? "isosceles" : "scalene";
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(triangleType(new int[]{9,4,9}), "isosceles");
    }
}
