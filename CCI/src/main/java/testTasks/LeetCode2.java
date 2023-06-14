package testTasks;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2 {

    public boolean canConstruct(String s, int k) {

        if (s.length() < k) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char symbol : s.toCharArray()){
            int amount = map.getOrDefault(symbol, 0);
            map.put(symbol, amount+1);
        }
        int counter = 0;
        for (Map.Entry<Character, Integer> value : map.entrySet()){
            if (value.getValue()%2 != 0) counter++;
        }
        return counter <= k;

    }

    public boolean canFormArray(int[] arr, int[][] pieces) {

        for (int[] pies : pieces){
            if(!piesNotExist(arr, pies)) return false;
        }
        return true;
    }

    private boolean piesNotExist(int[] arr, int[] pies) {
        boolean exist = true;
        for(int i = 0; i <= arr.length- pies.length; i++){
            exist = true;
            for (int j = 0; j < pies.length; j++){
                if (arr[i+j] != pies[j]){
                    exist = false;
                    break;
                }
            }
            if (exist) break;
        }
        return exist;
    }



}
