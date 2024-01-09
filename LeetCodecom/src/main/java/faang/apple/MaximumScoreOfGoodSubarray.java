package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaximumScoreOfGoodSubarray {

    public int maximumScoreTLE(int[] nums, int k) {

        int maxScope = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int l = 0; l < k; l++){
            queue.add(nums[l]);
        }

        for (int i = 0; i <= k; i++){
            int min = queue.isEmpty() ? Integer.MAX_VALUE : queue.peek();
            for (int j = k; j < nums.length; j++){
                min = Math.min(min, nums[j]);
                maxScope = Math.max(maxScope, min*(j-i+1));
            }
            queue.remove(nums[i]);
        }

        return maxScope;
    }

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left[] = new int[n];
        Arrays.fill(left, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left[stack.pop()] = i;
            }

            stack.push(i);
        }

        int right[] = new int[n];
        Arrays.fill(right, n);
        stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                right[stack.pop()] = i;
            }

            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] < k && right[i] > k) {
                ans = Math.max(ans, nums[i] * (right[i] - left[i] - 1));
            }
        }

        return ans;
    }

    @Test
    public void test(){

        Assert.assertEquals(15, maximumScore(new int[]{1,4,3,7,4,5}, 3));
        Assert.assertEquals(20, maximumScore(new int[]{5,5,4,5,4,1,1,1}, 0));
    }
}
