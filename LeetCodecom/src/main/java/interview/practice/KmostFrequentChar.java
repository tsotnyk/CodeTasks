package interview.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class KmostFrequentChar {

    // worse case O(NlogN)
    public char[] findKmostFrequentChar(String s, int k){

        HashMap<Character, Integer> map = new HashMap<>();

        // O(n)
        for (char symbol : s.toCharArray()){
            map.put(symbol, map.getOrDefault(symbol, 0)+1);
        }
        LinkedList<Character> list = new LinkedList<>(map.keySet());

        // O(NlogN)
        list.sort((t1, t2) -> {
            int countT1 = map.get(t1);
            int countT2 = map.get(t2);

            if (countT1 == countT2){
                return s.indexOf(t1) - s.indexOf(t2);
            }
            return map.get(t2)- map.get(t1);
        });

        char[] result = new char[k];
        int index = 0;
        for (char symbol : list){
            result[index++] = symbol;
            if (index == k) break;
        }
        return result;
    }


    public int[] findKMostFrequentNumber(int[] array, int k){

            HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : array){

            map.put(num, map.getOrDefault(num, 0)+1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>> (map.entrySet());

        list.sort((t1, t2) -> {

            return t2.getValue() - t1.getValue();
        });

        int[] result;
        if(list.size() < k){
            result = new int[list.size()];
        }else{
            result = new int[k];
        }

        for(int index = 0; index < result.length; index++){
            result[index] = list.get(index).getKey();
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(findKmostFrequentChar("aabcdddd7bz770777", 2), new char[]{'7', 'd'});

        Assert.assertEquals(findKmostFrequentChar("aabbcccccc", 2), new char[]{'c', 'a'});
    }
}
