package customDataStructures;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SnapshotArray {

    int[] array;

    HashMap<Integer, Integer> curUpdate;

    int snapshotId;

    HashMap<Integer, HashMap<Integer, Integer>> snapshots;

    public SnapshotArray(int length) {
        this.array = new int[length];
        this.snapshots = new HashMap<>();
        this.curUpdate = new HashMap<>();
        this.snapshotId = 0;
    }

    // Function setValue sets the value at a given index idx to val.
    public void setValue(int idx, int state) {
        this.curUpdate.put(idx, state);
        this.array[idx] = state;
    }

    // This function takes no parameters and returns the snapid.
    // snapid is the number of times that the snapshot() function was called minus 1.
    public int snapshot() {

        this.snapshots.put(snapshotId, this.curUpdate);
        this.curUpdate = new HashMap<>();

        return this.snapshotId++;
    }

    // Function getValue returns the value at the index idx with the given snapid.
    public int getValue(int idx, int snapshotId1) {

        if (snapshotId1 == this.snapshotId){
            return this.array[idx];
        }

        int res = 0;

        for (int i = snapshotId1; i >= 0; i--){
            if (this.snapshots.containsKey(i)){
                if(this.snapshots.get(i).containsKey(idx)){
                    res = this.snapshots.get(i).get(idx);
                    break;
                }
            }
        }

        return res;
    }





// "SnapshotArray", "set",  "set",  "set",   "set",  "snap", "get",   "set",   "set",   "set",  "snap", "get", "get",   "get"]
// [ , [[7],        [0, 2], [1, 5], [2, 9], [3, 14], [],     [2, 0], [4, 20], [5, 21], [2, 10], [],     [5, 1], [2, 1], [6, 1]]

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(7);
        snapshotArray.setValue(0,2);
        snapshotArray.setValue(1,5);
        snapshotArray.setValue(2,9);
        snapshotArray.setValue(3,14);
                snapshotArray.snapshot();
                int value1 = snapshotArray.getValue(2, 0);
        snapshotArray.setValue(4,20);
        snapshotArray.setValue(5,21);
        snapshotArray.setValue(2,10);
        snapshotArray.snapshot();
        int value2 = snapshotArray.getValue(5,1);
        int value3 = snapshotArray.getValue(2,1);
        int value4 = snapshotArray.getValue(6,1);
    }

}




