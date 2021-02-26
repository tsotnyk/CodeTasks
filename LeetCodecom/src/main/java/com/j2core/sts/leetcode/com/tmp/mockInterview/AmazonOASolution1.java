package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class AmazonOASolution1 {

    public String longestPalindromeTLE(String s) {

        if (s.length() < 2) return s;
        if (isPalindrome(s)) return s;
        String left = longestPalindrome(s.substring(1));
        String right = longestPalindrome(s.substring(0, s.length()-1));
        return left.length() < right.length() ? right : left;
    }

    private boolean isPalindrome(String str){

        int i = 0;
        int j = str.length()-1;

        while (i < j){
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }

        return true;
    }

    public String longestPalindrome(String s) {

        int[][] matrix = new int[s.length()+1][s.length()+1];
        String reverse = new StringBuilder(s).reverse().toString();

        int maxLength = 1;
        int iS = 0;
        int jS = 1;

        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= s.length(); j++){
                if (s.charAt(i-1) == reverse.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                    if (matrix[i][j] > maxLength) {
                        if (matrix[i][j] == 2 && s.charAt(i - 1) == s.charAt(i - 2)) {
                            maxLength = 2;
                            iS = i-2;
                            jS = i;
                        }else if (isPalindrome(s.substring(i-matrix[i][j], i))){
                            maxLength = matrix[i][j];
                            jS = i;
                            iS = i-maxLength;
                        }
                    }
                }

            }
        }

        return s.substring(iS, jS);
    }

    @Test
    public void testLongestPalindrome(){

        Assert.assertEquals(longestPalindrome("aacabdkacaa").length(), 3);

        Assert.assertEquals(longestPalindrome("babad").length(), 3);
    }

    public int[][] kClosest(int[][] points, int K) {

        Arrays.sort(points, (t1, t2) ->{

            double first = Math.pow(t1[0], 2)+ Math.pow(t1[1], 2);
            double second = Math.pow(t2[0], 2)+ Math.pow(t2[1], 2);

            return (int) (first - second);
        });

        int[][] result = new int[K][];

        if (K >= 0) System.arraycopy(points, 0, result, 0, K);

        return result;

    }

    int[][] meanGroups(int[][] a) {

        HashMap<Double, List<Integer>> map = new HashMap<>();
        int indexArray = 0;
        for(int[] array : a){

            double sum = 0;
            for(int val : array){
                sum += val;
            }
            sum /= array.length;

            if(map.containsKey(sum)){
                map.get(sum).add(indexArray);
            }else{
                map.put(sum, new LinkedList<>(Arrays.asList(indexArray)));
            }
            indexArray++;
        }

        int[][] result = new int[map.size()][];
        int index = 0;
        for(Map.Entry<Double,List<Integer>> node : map.entrySet()){
            int[] array = new int[node.getValue().size()];
            int i = 0;
            for(int value : node.getValue()){
                array[i++] = value;
            }
            result[index++] = array;
        }

         Arrays.sort(result, (t1, t2) -> {

             return t1[0] - t2[0];
         });

        return result;
    }

    @Test
    public void test(){

        int[][] result = meanGroups(new int[][]{{3,3,4,2},{4,4},{4,0,3,3},{2,3},{3,3,3}});
    }

    int countTinyPairs(int[] a, int[] b, int k) {

        int j = b.length-1;
        int counter = 0;
        String baseNum = String.valueOf(k);
        for(int i = 0; i < a.length; i++){
            String num = String.valueOf(a[i]) + String.valueOf(b[j--]);
            if(isTiny(baseNum, num)) counter++;
        }

        return counter;
    }

    boolean isTiny(String base, String num){

        if(base.length() > num.length()) return false;
        if(base.length() < num.length()) return true;

        int i = 0;

        while(i < base.length()-1){

            if(base.charAt(i) < num.charAt(i)) return false;
            if(base.charAt(i) > num.charAt(i)) return true;
            i++;
        }

        return base.charAt(i) > num.charAt(i);
    }

    @Test
    public void test123(){

        Assert.assertEquals(countTinyPairs(new int[]{16, 1, 4, 2, 14}, new int[]{7, 11, 2, 0, 15}, 743), 4);
    }
}
