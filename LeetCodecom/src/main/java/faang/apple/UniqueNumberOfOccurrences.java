package faang.apple;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr){

            map.put(num, map.getOrDefault(num, 0)+1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());

        return set.size() == map.size();
    }
}
