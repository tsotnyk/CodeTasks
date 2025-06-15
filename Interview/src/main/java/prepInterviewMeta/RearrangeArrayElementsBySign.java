package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {

        LinkedList<Integer> evenNumbers = new LinkedList<>();
        LinkedList<Integer> otherNumbers = new LinkedList<>();

        for(int num : nums){
            if (num < 0){
                otherNumbers.add(num);
            }else {
                evenNumbers.add(num);
            }
        }

        for (int i = 0; i < nums.length; i++){

            if (i%2 == 0){
                nums[i] = evenNumbers.removeFirst();
                continue;
            }

            nums[i] = otherNumbers.removeFirst();

        }

        return nums;
    }

    @Test
    public void test(){

        Assert.assertEquals(rearrangeArray(new int[]{3,1,-2,-5,2,-4}), new int[]{3,-2,1,-5,2,-4});
        Assert.assertEquals(rearrangeArray(new int[]{-1,1}), new int[]{1, -1});
    }
}
