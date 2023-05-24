package slidingWindov.challenge3;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String findSubstring(String str, String pattern) {
        // TODO: Write your code here
        String result = "";

        HashMap<Character, Integer> patternMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        int indexE = 0;
        while (indexE < pattern.length()){
            patternMap.put(pattern.charAt(indexE), patternMap.getOrDefault(pattern.charAt(indexE), 0)+1);
            windowMap.put(str.charAt(indexE), windowMap.getOrDefault(str.charAt(indexE), 0)+1);
            indexE++;
        }

        int indexS = 0;

        while (indexE < str.length()){
            if (windowContainPattern(windowMap, patternMap)){
                result = str.substring(indexS, indexE);
                while (indexS+pattern.length() <= indexE){
                    windowMap.put(str.charAt(indexS), windowMap.get(str.charAt(indexS++))-1);
                    if (windowContainPattern(windowMap, patternMap)){
                        result = str.substring(indexS, indexE);
                    }else break;
                }
            }else{
                windowMap.put(str.charAt(indexE), windowMap.getOrDefault(str.charAt(indexE++), 0)+1);
            }
        }

        while (indexS+pattern.length() <= str.length()){
            if (windowContainPattern(windowMap, patternMap)){
                result = str.substring(indexS, indexE);
                windowMap.put(str.charAt(indexS), windowMap.get(str.charAt(indexS++))-1);
            }else break;
        }
        return result;
    }

    private boolean windowContainPattern(HashMap<Character, Integer> windowMap, HashMap<Character, Integer> patternMap){

        for (Map.Entry<Character, Integer> entry : patternMap.entrySet()){
            if (!windowMap.containsKey(entry.getKey())) return false;
            if (windowMap.get(entry.getKey()) < entry.getValue()) return false;
        }
        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals("abdec", findSubstring("aabdec", "abc"));
        Assert.assertEquals("aabdec", findSubstring("aabdec", "abac"));
        Assert.assertEquals("bca", findSubstring("abdbca", "abc"));
        Assert.assertEquals("", findSubstring("adcad", "abc"));
    }
}
