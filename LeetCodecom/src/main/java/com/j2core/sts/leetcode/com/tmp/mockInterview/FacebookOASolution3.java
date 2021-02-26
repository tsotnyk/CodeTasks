package com.j2core.sts.leetcode.com.tmp.mockInterview;

import com.j2core.sts.leetcode.com.trees.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FacebookOASolution3 {

    public int rangeSumBST(TreeNode root, int low, int high) {

        int curSum = 0;
        if (root == null) return curSum;
        if (root.val < low){
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high){
            return rangeSumBST(root.left, low, high);
        }
        curSum += root.val;
        curSum += rangeSumBST(root.left, low, high);
        curSum += rangeSumBST(root.right, low, high);

        return curSum;

    }

    List<Integer> cache;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        cache = new ArrayList<>();

        depthSum(nestedList, 1);

        int maxDepth = cache.size();
        int sum = 0;

        for(int i = 0; i < maxDepth; i++) {
            sum += ((maxDepth - i) * cache.get(i));
        }

        return sum;
    }

    private void depthSum(List<NestedInteger> nestedList, int depth) {
        if(cache.size() < depth) {
            cache.add(0);
        }

        int sum = 0;

        for(Iterator<NestedInteger> it = nestedList.iterator(); it.hasNext();) {
            NestedInteger temp = it.next();

            if(temp.isInteger()) {
                sum += temp.getInteger();
            } else {
                depthSum(temp.getList(), depth + 1);
            }
        }

        cache.set(depth - 1, cache.get(depth - 1) + sum);
    }

      public interface NestedInteger {
//      /* Constructor initializes an empty nested list. */
//      NestedInteger();

//          // Constructor initializes a single integer.
//          default NestedInteger(int value) {
//
//          }

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // Set this NestedInteger to hold a single integer.
              public void setInteger(int value);

              // Set this NestedInteger to hold a nested list and adds a nested integer to it.
              public void add(NestedInteger ni);

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }
}
