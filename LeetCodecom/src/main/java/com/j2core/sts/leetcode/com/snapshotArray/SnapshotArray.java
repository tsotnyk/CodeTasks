package com.j2core.sts.leetcode.com.snapshotArray;

import java.util.ArrayList;
import java.util.List;

public class SnapshotArray {

    private int[] array;
    private List<int[]> snapShotList;
    private int snapShotIndex;
    private int length;

    public SnapshotArray(int length) {

        this.length = length;
        this.array = new int[length];
        this.snapShotIndex = -1;
        this.snapShotList = new ArrayList<>();
    }

    public void set(int index, int val) {

        array[index] = val;
    }

    public int snap() {

        snapShotList.add(array.clone());
        return ++snapShotIndex;
    }

    public int get(int index, int snap_id) {

        if (index < 0 || index > length) return 0;
        if (snap_id < 0 || snap_id > snapShotIndex) return -1;
        int[] snapshotArray = snapShotList.get(snap_id);
        return snapshotArray[index];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
class Solution{

    public static void main(String[] args) {

        SnapshotArray array = new SnapshotArray(1);
        array.set(0, 12);
        array.snap();
        array.snap();
        int result = array.get(1, 0);
        int result1 = array.get(1, 0);

    }
}