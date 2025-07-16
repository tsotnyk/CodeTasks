package prepInterviewWithEducativeIo.twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortColors {

    public int[] sortColors (int[] colors) {

        int start = 0;
        int end = colors.length-1;
        int index = 0;

        while (index <= end){
            if (colors[index] == 2){
                colors[index] = colors[end];
                colors[end] = 2;
                end--;
                continue;
            }

            if (colors[index] == 1){
                index++;
                continue;
            }

            colors[index] = colors[start];
            colors[start] = 0;
            start++;
            index++;
        }

        return colors;
    }

    @Test
    public void test(){

        Assert.assertEquals(sortColors(new int[]{2, 1, 1, 0, 1, 0, 2}), new int[]{0,0,1,1,1,2,2});
    }
}
