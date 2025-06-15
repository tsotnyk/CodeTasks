package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] envelop : envelopes){
            int key = envelop[0];
            List<Integer> list = map.getOrDefault(key, new LinkedList<>());
            list.add(envelop[1]);
            map.put(key, list);
        }

        ArrayList<Integer> width = new ArrayList<>(map.keySet());
        width.sort((a, b) -> {
            return a-b;
        });

        return countEnvelop(width, map, 0, 0, 0);
    }

    public int countEnvelop(ArrayList<Integer> width, HashMap<Integer, List<Integer>> map, int index, int steps, int height){

        int candidate = 0;
        if (index == width.size()) return steps;
        int curWidth = width.get(index);
        if (height == 0){
            for (int curHeight : map.get(curWidth)){
                candidate = Math.max(candidate, countEnvelop(width, map, index+1, steps+1, curHeight));
            }

            candidate = Math.max(candidate, countEnvelop(width, map, index+1, steps, 0));
        }else {
            for (int curHeight : map.get(width.get(index))){
                if (curHeight > height) {
                    candidate = Math.max(candidate, countEnvelop(width, map, index+1, steps+1, curHeight));
                }
            }
            candidate = Math.max(candidate, countEnvelop(width, map, index+1, steps, height));
        }

        return candidate;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxEnvelopes(new int[][]{{1,3},{3,5},{6,7},{6,8}, {8,4}, {9,5}}), 3);

        Assert.assertEquals(maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}), 3);
    }


}
