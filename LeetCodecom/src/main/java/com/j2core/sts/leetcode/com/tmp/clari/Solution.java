package com.j2core.sts.leetcode.com.tmp.clari;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    int[][] sortSubMatrix(int[][] matrix, int size){

        List<List<Integer>> listSubMatrix = new LinkedList<>();

        for (int i = 0; i < matrix.length; i = i+size){
            for (int j = 0; j < matrix[0].length; j = j+size){
                List<Integer> list = new LinkedList<>();
                for (int k = i; k < i+size; k++){
                    for (int l = j; l < j+size; l++){
                        list.add(matrix[k][l]);
                    }
                }
                listSubMatrix.add(list);
            }
        }

        Collections.sort(listSubMatrix, (t1, t2) ->{

            HashSet<Integer> set1 = new HashSet<>(t1);
            HashSet<Integer> set2 = new HashSet<>(t2);
            int min1 = 1;
            while (set1.contains(min1)){
                min1++;
            }
            int min2 = 1;
            while (set2.contains(min2)){
                min2++;
            }
            return min1 - min2;
        });

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i = i+size){
            for (int j = 0; j < matrix[0].length; j = j+size){
                List<Integer> list = listSubMatrix.remove(0);
                for (int k = i; k < i+size; k++){
                    for (int l = j; l < j+size; l++){
                        newMatrix[k][l] = list.remove(0);
                        list.add(matrix[k][l]);
                    }
                }
            }
        }

        return  newMatrix;
    }

    @Test
    public void test1(){

        Assert.assertArrayEquals(sortSubMatrix(new int[][]{{2,10,2,8},{3,1,4,7},{5,9,1,2},{11,15,5,6}}, 2),
                new int[][]{{2,8,5,9},{4,7,11,15},{1,2,2,10},{5,6,3,1}});
    }

    int[] restoreArray(int[][] pairs){

        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for(int[] pair : pairs){
            if(list.isEmpty()){
                list.add(pair[0]);
                list.add(pair[1]);
                set.add(pair[0]);
                set.add(pair[1]);
                continue;
            }
            if (set.contains(pair[0]) && set.contains(pair[1])) continue;
            if (list.getFirst() == pair[0]){
                if (list.get(1) != pair[1]){
                    list.addFirst(pair[1]);
                    set.add(pair[1]);
                }
                continue;
            }
            if (list.getFirst() == pair[1]){
                if (list.get(1) != pair[0]){
                    list.addFirst(pair[0]);
                    set.add(pair[0]);
                }
                continue;
            }
            if (list.getLast() == pair[0]){
                if (list.get(list.size()-2) != pair[1]){
                    list.add(pair[1]);
                    set.add(pair[1]);
                }
                continue;
            }
            if (list.getLast() == pair[1]){
                if (list.get(list.size()-2) != pair[0]){
                    list.add(pair[0]);
                    set.add(pair[0]);
                }
                continue;
            }
            list.add(pair[0]);
            list.add(pair[1]);
            set.add(pair[0]);
            set.add(pair[1]);
        }

        int[] result = new int[pairs.length+1];

        int index = 0;
        for (int value : list){
            result[index++] = value;
        }
        return result;
    }

    @Test
    public void test2(){

        Assert.assertArrayEquals(restoreArray(new int[][]{{1000, 1}, {3, 1000}}), new int[]{3, 1000, 1});
        Assert.assertArrayEquals(restoreArray(new int[][]{{1,2}, {2,3},{3,4}}), new int[]{1,2,3,4});
        Assert.assertArrayEquals(restoreArray(new int[][]{{3,5}, {1,4},{4,2},{1,5}}), new int[]{3,5,1,4,2});
    }

}
