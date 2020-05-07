package com.j2core.sts.leetcode.com.string.firstUniqueCharacterInString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/*
  The class find the first non-repeating character in it and return it's index.
 */
public class Solution {

    /**
     * The method find the first non-repeating character in it and return it's index.
     *
     * @param s       basic string
     * @return        first non-repeating character's index or -1
     */
    public int firstUniqCharOld(String s) {
        int result = -1;

        for (int i = 0; i < s.length(); i++){

            char tmp = s.charAt(i);
            if (s.lastIndexOf(tmp) == i && s.indexOf(tmp) == i){
                result = i;
                break;
            }
            while (i < s.length()-1 && tmp == s.charAt(i+1)){
                i++;
            }

        }

        return result;
    }

    public int firstUniqChar1(String s) {

        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int[] array = new int[s.length()];

        for (int i = 0; i < s.length(); i++){
            int index = map.getOrDefault(s.charAt(i), -1);
            if (index == -1){
                map.put(s.charAt(i), i);
                array[i] = 1;
            }else {
                array[index] += 1;
                array[i] = array[index];
                map.put(s.charAt(i), i);
            }
        }

        for (int i = 0; i < s.length(); i++){
            if (array[i] == 1) return i;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {

        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;

        int index = -1;
        for (int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            int start = 0;
            int end = s.length()-1;
            boolean flag = true;
            while (start <= end){
                if (start != i){
                    if (character == s.charAt(start)){
                        flag = false;
                        break;
                    }
                }
                if (end != i) {
                    if (character == s.charAt(end)) {
                        flag = false;
                        break;
                    }
                }
                start++;
                end--;
            }
            if (flag) return i;
        }

        return index;
    }

    public int firstUniqChar3(String s) {

        for (int i = 0; i < s.length(); i++){
            int firstIndex = s.indexOf(s.charAt(i), i+1);
            int lastIndex = s.lastIndexOf(s.charAt(i), i-1);
            if (firstIndex == -1 && lastIndex == -1) return i;
        }

        return -1;
    }

    public int firstUniqChar(String s) {

        for (int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            int indexFirst = s.indexOf(character);
            int indexLast = s.lastIndexOf(character);
            if (indexFirst == indexLast) return i;
        }

        return -1;
    }

    @Test
    public void test(){

        Assert.assertEquals(firstUniqChar("cc"), -1);
        Assert.assertEquals(firstUniqChar("aadadaad"), -1);
        Assert.assertEquals(firstUniqChar("leetcode"), 0);
        Assert.assertEquals(firstUniqChar("loveleetcode"), 2);

    }
}
