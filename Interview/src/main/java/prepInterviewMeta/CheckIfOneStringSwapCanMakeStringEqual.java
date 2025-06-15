package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class CheckIfOneStringSwapCanMakeStringEqual {

    public boolean areAlmostEqual(String s1, String s2) {

        HashMap<Character, Integer> charMap = new HashMap<>();

        for (char symbol : s1.toCharArray()){
            charMap.put(symbol, charMap.getOrDefault(symbol, 0)+1);
        }

        for (char symbol : s2.toCharArray()){
            if (!charMap.containsKey(symbol)) return false;
            int countSymbol = charMap.get(symbol);
            if (countSymbol == 0) return false;
            charMap.put(symbol, countSymbol-1);
        }

        int countSwapChar = 0;

        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)) countSwapChar++;
            if (countSwapChar > 2) return false;
        }

        return true;
    }

    public boolean areAlmostEqual1(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] s1FrequencyMap = new char[26];
        char[] s2FrequencyMap = new char[26];
        int numDiffs = 0;

        for (int i = 0; i < s1.length(); i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);

            if (s1Char != s2Char) {
                numDiffs++;
                // numDiffs is more than 2, one string swap will not make two strings equal
                if (numDiffs > 2) return false;
            }

            // increment frequencies
            s1FrequencyMap[s1Char - 'a']++;
            s2FrequencyMap[s2Char - 'a']++;
        }

        // check if frequencies are equal
        return Arrays.equals(s1FrequencyMap, s2FrequencyMap);
    }

    @Test
    public void test(){

        Assert.assertFalse(areAlmostEqual1("attack", "defend"));
        Assert.assertTrue(areAlmostEqual1("bank", "kanb"));
        Assert.assertFalse(areAlmostEqual1("aaab", "aabb"));
    }
}
