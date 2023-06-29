package old.slidingWindov.challenge2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        HashMap<Character, Integer> patternMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++){
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0)+1);
            windowMap.put(str.charAt(i), windowMap.getOrDefault(str.charAt(i), 0)+1);
        }

        int index = pattern.length();
        while (index <= str.length()){
            if (patternMap.equals(windowMap)) resultIndices.add(index-pattern.length());
            if (index == str.length()) break;
            windowMap.put(str.charAt(index), windowMap.getOrDefault(str.charAt(index), 0)+1);
            int count = windowMap.get(str.charAt(index-pattern.length()));
            if (count > 1) {
                windowMap.put(str.charAt(index - pattern.length()), count-1);
            }else {
                windowMap.remove(str.charAt(index-pattern.length()));
            }
            index++;
        }

        return resultIndices;
    }
}
