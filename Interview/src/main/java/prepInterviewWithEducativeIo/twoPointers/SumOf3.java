package prepInterviewWithEducativeIo.twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SumOf3 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int firstI = 0;

        while (firstI < nums.length-2 && nums[firstI] < 1){
            if (firstI == 0 || nums[firstI-1] != nums[firstI]) {
                findPair(res, nums, firstI++);
            }else firstI++;
        }

        return res;
    }

    private static void findPair(List<List<Integer>> res, int[] nums, int firstI){

        int low = firstI+1;
        int high = nums.length-1;

        while (low < high){
            int candidateSum = nums[low] + nums[high] + nums[firstI];
            if (candidateSum == 0){
                res.add(new ArrayList<>(Arrays.asList(nums[firstI], nums[low], nums[high])));
                low++;
                high--;
                while (low < high && nums[low] == nums[low-1]) low++;
                while (low < high && nums[high] == nums[high+1]) high--;
                continue;
            }
            if (candidateSum < 0){
                low++;
                continue;
            }
            high--;
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(threeSum(new int[]{-4,-2,-2,-2,0,2,2,2,4}).size(), 4);
    }
}
