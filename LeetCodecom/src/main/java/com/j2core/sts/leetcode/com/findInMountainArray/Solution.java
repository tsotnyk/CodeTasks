package com.j2core.sts.leetcode.com.findInMountainArray;

public class Solution {

     // This is MountainArray's API interface.
     // You should not implement it, or speculate about its implementation
     class MountainArray {
         public int get(int index) {
             return 0;
         }
         public int length() {
             return 0;
         }
     }


    public int findInMountainArray(int target, MountainArray mountainArr) {

        int pivot = findPivotPoint(mountainArr);

        int index1 = findElement(mountainArr, target, 0, pivot - 1, true);

        if (index1 > -1) {
            return index1;
        }

        int index2 = findElement(mountainArr, target, pivot, mountainArr.length() - 1, false);

        if (index2 > -1) {
            return index2;
        }

        return -1;
    }

    private int findPivotPoint(MountainArray mountainArr) {

        int low = 1;
        int high = mountainArr.length() - 1;

        Integer maxElement = Integer.MIN_VALUE;
        Integer maxElementIndex = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            int midElement = mountainArr.get(mid);
            int previousElement = mountainArr.get(mid - 1);

            if (midElement < previousElement && previousElement > maxElement) {
                maxElementIndex = mid - 1;
            } else if (midElement > previousElement && midElement > maxElement) {
                maxElementIndex = mid;
            }

            if (midElement < previousElement) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            continue;
        }

        return maxElementIndex + 1;
    }

    private int findElement(MountainArray mountainArr, int target, int low, int high, boolean ascSearch) {

        Integer lastKnownIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mountainArr.get(mid) == target) {
                lastKnownIndex = mid;
                high = mid - 1;
                continue;
            }

            if (mountainArr.get(mid) < target) {

                if (ascSearch) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

                continue;
            }

            if (ascSearch) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lastKnownIndex;
    }
}
