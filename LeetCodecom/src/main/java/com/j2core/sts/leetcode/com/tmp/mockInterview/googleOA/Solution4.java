package com.j2core.sts.leetcode.com.tmp.mockInterview.googleOA;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Solution4 {

    @Test
    public void test(){

        int[] array = new int[]{1,3,5,6,7,3,9,10,34,12,56,3,5,0,2,9,4,6,5,12,2,7,4,87,2,0,3,8,6,12,34};
        NumArray instance = new NumArray(array);

        instance.update(0, 10);
        int sum = instance.sumRange(3, 25);

        int correctSum = 0;
        for (int i = 3; i <= 25; i++){
            correctSum += array[i];
        }

        Assert.assertEquals(sum, correctSum);
    }
}

class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }


}
