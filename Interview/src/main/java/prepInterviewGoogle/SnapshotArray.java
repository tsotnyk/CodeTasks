package prepInterviewGoogle;

import java.util.Arrays;
import java.util.HashMap;

public class SnapshotArray {

    int snapshotId;

    HashMap<Integer, Integer> currentNums;

    HashMap<Integer, HashMap<Integer, Integer>> snapshotsMap;
    public SnapshotArray(int length) {

        snapshotId = 0;
        snapshotsMap = new HashMap<>();
        currentNums = new HashMap<>();
    }

    public void set(int index, int val) {
        currentNums.put(index, val);
    }

    public int snap() {

        snapshotsMap.put(snapshotId, currentNums);
        currentNums = new HashMap<>();
        snapshotId++;
        return snapshotId-1;
    }

    public int get(int index, int snap_id) {

        int num = -1;
        while (snap_id >= 0 && num < 0){
            num = snapshotsMap.get(snap_id).getOrDefault(index, -1);
            snap_id--;
        }

        return num > -1 ? num : 0;
    }
}

class Test{

    public static void main(String[] args) {

        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0,4);
        snapshotArray.set(0,16);
        snapshotArray.set(0,13);
        int s1 = snapshotArray.snap();
        int get1 = snapshotArray.get(0,0);
        int s2 = snapshotArray.snap();

        System.out.println(s1);
        System.out.println(get1);
        System.out.println( s2);

    }
}
