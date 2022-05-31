package miscellaneous.kSmallestNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public static int findKthSmallestNumber1(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums){
            if (heap.size() < k){
                heap.add(num);
            }else {
                if (heap.peek() > num){
                    heap.poll();
                    heap.add(num);
                }
            }
        }

        return heap.peek();
    }

    public static int findKthSmallestNumber(int[] nums, int k) {
        return findKthSmallestNumberRec(nums, k, 0, nums.length - 1);
    }

    public static int findKthSmallestNumberRec(int[] nums, int k, int start, int end) {
        int p = partition(nums, start, end);

        if (p == k - 1)
            return nums[p];

        if (p > k - 1) // search lower part
            return findKthSmallestNumberRec(nums, k, start, p - 1);

        // search higher part
        return findKthSmallestNumberRec(nums, k, p + 1, end);
    }

    private static int partition(int[] nums, int low, int high) {
        if (low == high)
            return low;

        int pivot = nums[high];
        for (int i = low; i < high; i++) {
            // all elements less than 'pivot' will be before the index 'low'
            if (nums[i] < pivot)
                swap(nums, low++, i);
        }
        // put the pivot in its correct place
        swap(nums, low, high);
        return low;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    @Test
    public void test(){

        Assert.assertEquals(findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 3), 5);
        Assert.assertEquals(findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 4), 5);
        Assert.assertEquals(findKthSmallestNumber(new int[]{5, 12, 11, -1, 12}, 3), 11);
    }
}
