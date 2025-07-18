package prepInterviewApple;

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
