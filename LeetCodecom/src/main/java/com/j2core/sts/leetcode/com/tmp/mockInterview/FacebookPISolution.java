package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FacebookPISolution {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> nums1Map = new HashMap<>();

        for (int num : nums1){
            nums1Map.put(num, nums1Map.getOrDefault(num, 0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums2){
            int amount = nums1Map.getOrDefault(num, 0);
            if (amount > 0){
                nums1Map.put(num, amount-1);
                list.add(num);
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        for (int num : list){
            result[index++] = num;
        }
        return result;
    }

    @Test
    public void test1(){

        Assert.assertArrayEquals(new int[]{2,2}, intersect(new int[]{1,2,2,1}, new int[]{2,2,2}));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (k == 0) return 0;
        if (k >= s.length()) return s.length();
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int indexS = 0;
        int indexE = 0;
        while (indexE < s.length() && s.length()-indexS > maxLength){
            char symbol = s.charAt(indexE);
            if (map.containsKey(symbol)){
                map.put(symbol, map.get(symbol)+1);
                indexE++;
            }else {
                if (map.size() < k){
                    map.put(symbol, 1);
                    indexE++;
                }else {
                    char startSymbol = s.charAt(indexS);
                    maxLength = Math.max(maxLength, indexE-indexS);
                    if (map.get(startSymbol)== 1){
                        map.remove(startSymbol);
                    }else {
                        map.put(startSymbol, map.get(startSymbol)-1);
                    }
                    indexS++;
                }
            }
        }

        return Math.max(maxLength, indexE-indexS);
    }

    @Test
    public void test(){
        Assert.assertEquals(2, lengthOfLongestSubstringKDistinct("aa", 1));
        Assert.assertEquals(3, lengthOfLongestSubstringKDistinct("ecekba", 2));
    }

}
