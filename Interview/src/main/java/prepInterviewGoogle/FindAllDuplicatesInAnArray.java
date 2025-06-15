package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[nums.length+1];

        for (int num : nums){
            if (visited[num]){
                result.add(num);
                continue;
            }
            visited[num] = true;
        }


        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(findDuplicates(new int[]{4,3,2,7,8,2,3,1}), new LinkedList<>(Arrays.asList(2,3)));
    }
}
