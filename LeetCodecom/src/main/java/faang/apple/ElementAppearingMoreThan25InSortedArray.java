package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementAppearingMoreThan25InSortedArray {

    public int findSpecialInteger(int[] arr) {

        int target = arr.length/4;
        int counter = 1;

        for (int i = 1; i < arr.length; i++){
            if (arr[i] == arr[i-1]) {
                counter++;
            }else {
                counter = 1;
            }
            if (counter > target) return arr[i];
        }

        return arr[0];
    }

    @Test
    public void test(){

        Assert.assertEquals(6, findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        Assert.assertEquals(1, findSpecialInteger(new int[]{1, 1}));
    }

}
