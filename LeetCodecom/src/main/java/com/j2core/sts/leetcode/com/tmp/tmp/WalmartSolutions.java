package com.j2core.sts.leetcode.com.tmp.tmp;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class WalmartSolutions {

    public String reversOfStringV1(String text){
        if (text == null || text.length() < 2) return text;
        char[] array = text.toCharArray();
        int left = 0;
        int right = text.length()-1;

        while (left < right){
            char tmpSymbol = array[left];
            array[left] = array[right];
            array[right] = tmpSymbol;
            left++;
            right--;
        }
        return String.valueOf(array);
    }


    public  int findNumberInArray(int[] array, int num){
        if (array == null || array.length < 1) return -1;
        if (array.length == 1) return array[0] == num ? 0 : -1;

        if (array[0] > num) return -1;
        if (array[array.length-1] < num) return -1;

        int left = 0;
        int right = array.length-1;

        while (left < right){
            int delta = (right-left)/2;
            int midl = left+delta;
            if (array[midl] == num) return midl;
            if (array[midl] > num){
                right = midl-1;
            }else {
                left = midl+1;
            }
        }
        return array[left] == num ? left : -1;
    }

    @Test
    public void test(){

        Assert.assertEquals(4, findNumberInArray(new int[]{3,5,7,9,10,11}, 10));
        Assert.assertEquals(3, findNumberInArray(new int[]{3,5,7,9,10,11}, 9));
        Assert.assertEquals(0, findNumberInArray(new int[]{3,5,7,9,10,11}, 3));
        Assert.assertEquals(5, findNumberInArray(new int[]{3,5,7,9,10,11}, 11));
        Assert.assertEquals(-1, findNumberInArray(new int[]{3,5,7,9,10,11}, 8));
        Assert.assertEquals(-1, findNumberInArray(new int[]{}, 9));

    }

    boolean shopInAndOutEvents(String[][] events) {

        HashSet<String> map = new HashSet<>();

        for(String[] event : events){
            switch(event[1]){
                case "in":
                    if(map.contains(event[0])) return false;
                    map.add(event[0]);
                    break;
                default:
                    if (!map.contains(event[0])) return false;
                    map.remove(event[0]);
            }
        }

        return map.isEmpty();
    }

    @Test
    public void test1(){

        Assert.assertTrue(shopInAndOutEvents(new String[][]{{"AB","in"},{"AB","out"}}));
    }


    int[][] meanGroups(int[][] a) {

        HashMap<Double, List<Integer>> map = new HashMap<>();
        int i = 0;
        for(int[] array : a){
            double sum = 0;
            for(int num : array){
                sum += num;
            }
            sum /= array.length;
            List<Integer> list = map.getOrDefault(sum, new LinkedList<>());
            list.add(i);

            map.put(sum, list);
            i++;
        }

        int[][] result = new int[map.size()][];
        i = 0;
        for(Map.Entry<Double, List<Integer>> entry : map.entrySet()){

            int[] array = new int[entry.getValue().size()];
            int index = 0;
            for(int num : entry.getValue()){
                array[index++] = num;
            }
            result[i++] = array;
        }

        Arrays.sort(result, (t1, t2)->{
            return t1[0] - t2[0];
        });

        return result;
    }

    @Test
    public void test2(){

        int[][] result = meanGroups(new int[][]{{3, 3, 4, 2},
        {4, 4},
        {4, 0, 3, 3},
        {2, 3},
        {3, 3, 3}});

        System.out.println(result.length);
    }

}
