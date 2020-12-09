package com.j2core.sts.leetcode.com.arrays.searchInSortedArrayOfUnknownSize;

public class Solution {

    public int search(ArrayReader reader, int target) {

        if (reader.get(0) > target) return -1;

        return 0;
    }
}

  interface ArrayReader {
      public int get(int index);
 }
