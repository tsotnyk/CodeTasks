package sts.amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

   public int get(){

       return 0;
   }

    public static List<Integer> maximumBookCopies(List<Integer> portalUpdate) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new LinkedList<>();

        int book = portalUpdate.get(0);
        int max = portalUpdate.get(0) > 0 ? 1 : 0;

        for (int num : portalUpdate){
            int delta = num > 0 ? 1 : -1;
            int key = Math.abs(num);
            int newVal = map.getOrDefault(key, 0)+delta;
            map.put(key, newVal);
            if (num > 0 && newVal > max){
                max = newVal;
                book = key;
            }else {
                if (book == key){
                    max = 0;
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                        if (max < entry.getValue()){
                            max = entry.getValue();
                            book = entry.getKey();
                            break;
                        }
                    }
                }
            }
            res.add(max);
        }
        // Write your code here

        return res;
    }

   @Test
    public void test(){

       Assert.assertEquals(maximumBookCopies(new LinkedList<>(Arrays.asList(6,6,2,-6,-2,-6))), new LinkedList<>(Arrays.asList(1,2,2,1,1,0)));
   }

}
