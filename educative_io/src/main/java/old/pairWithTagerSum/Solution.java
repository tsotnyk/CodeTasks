package old.pairWithTagerSum;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int[] search(int[] arr, int targetSum) {
        // TODO: Write your code here

        int iL = arr.length/2;
        int iR = iL+1;

        while (true){
            int sum = arr[iL] + arr[iR];
            if (sum == targetSum) return new int[]{iL, iR};
            if (sum < targetSum){
                iR++;
                if (iR == arr.length) break;
            }else {
                if (iR > iL+1){
                    iR--;
                }else {
                    iL--;
                    if (iL < 0) break;
                }
            }

        }
        return new int[] { -1, -1 };
    }

    @Test
    public void test(){

        int a = 4/3;

        Assert.assertEquals(new int[]{1,3}, search(new int[]{1, 2, 3, 4, 6}, 6));
        Assert.assertEquals(new int[]{0,2}, search(new int[]{2, 5, 9, 11}, 11));

    }
}
