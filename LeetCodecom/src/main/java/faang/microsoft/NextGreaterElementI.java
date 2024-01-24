package faang.microsoft;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while (!stack.empty())
            map.put(stack.pop(), -1);

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(new int[]{-1, 3, -1}, nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}));
        Assert.assertEquals(new int[]{3,-1}, nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4}));

    }
}
