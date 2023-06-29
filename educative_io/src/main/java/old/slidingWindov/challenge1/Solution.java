package old.slidingWindov.challenge1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution {

    public static boolean findPermutation(String str, String pattern) {

        HashMap<Character, Integer> patternMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++){
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0)+1);
            windowMap.put(str.charAt(i), windowMap.getOrDefault(str.charAt(i), 0)+1);
        }

        int index = pattern.length();
        while (index <= str.length()){
            if (patternMap.equals(windowMap)) return true;
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
        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(findPermutation("oidbcaf", "abc"));
    }
}
