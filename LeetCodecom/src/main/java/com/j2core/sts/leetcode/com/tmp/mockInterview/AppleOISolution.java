package com.j2core.sts.leetcode.com.tmp.mockInterview;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class AppleOISolution {

    public int threeSumSmaller(int[] nums, int target) {

        int counter = 0;
        for (int i = 0; i < nums.length-2; i++){
            for (int j = i+1; j < nums.length-1; j++){
                int sumTwo = nums[i]+nums[j];
                for (int k = j+1; k < nums.length; k++){
                    if (nums[k]+sumTwo < target) counter++;
                }
            }
        }
        return counter;
    }

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        Integer counter = 0;
        findSolution(board, 0, counter);
        return counter;
    }

    private void findSolution(char[][] board, int colIndex, Integer counter) {
        if(colIndex == board.length) {
            counter++;
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                findSolution(board, colIndex + 1, counter);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < y; i++) {
            if(board[x][i]=='Q')
                return false;
        }
        for(int i = x,j=y; i >=0 && j>=0; i--,j--) {
            if(board[i][j]=='Q')
                return false;
        }
        for(int i = x,j=y; j>=0 && i <board.length; i++,j--) {
            if(board[i][j]=='Q')
                return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(2, totalNQueens(4));
    }


    int binaryPatternMatching(String pattern, String s) {

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','y'));
        int counter = 0;
        for(int i = 0; i <= s.length()-pattern.length(); i++){
            if(isCorrectPattern(vowels, pattern, s, i)) counter++;
        }

        return counter;
    }

    boolean isCorrectPattern(HashSet<Character> vowels, String pattern, String string, int index){

        for(int i = index; i < index+pattern.length(); i++){
            if(pattern.charAt(i-index) == '0'){
                if(!vowels.contains(string.charAt(i))) return false;
            }else{
                if(vowels.contains(string.charAt(i))) return false;
            }
        }

        return true;
    }

    @Test
    public void testBinary(){

        Assert.assertEquals(2, binaryPatternMatching("010", "amazing"));
    }

    int[][] diagonalsSort(int[][] a) {

        int i = 1;
        int j = 0;

        while(i < a.length-1){
            int x = i;
            int y = 0;
            LinkedList<Integer> list = new LinkedList<>();
            while(x > -1){
                list.add(a[x--][y++]);
            }
            Collections.sort(list);
            x = i;
            y = 0;
            for(int num : list){
                a[x--][y++] = num;
            }
            i++;
        }

        while(j < a[0].length){
            int x = a.length-1;
            int y = j;
            LinkedList<Integer> list = new LinkedList<>();
            while(y < a[0].length){
                list.add(a[x--][y++]);
            }
            Collections.sort(list);
            x = a.length-1;
            y = j;
            for(int num : list){
                a[x--][y++] = num;
            }
            j++;
        }
        return a;
    }

    @Test
    public void testDiagonal(){

        int[][] array = new int[][]{
                {10, 1},
                {7, 5}
        };

        int[][] result = diagonalsSort(array);

        Assert.assertArrayEquals(result, array);
    }

    int preferredRestaurant(int[][] preferences) {

        int[] reiting = new int[preferences[0].length];

        for(int j = 0; j < preferences[0].length; j++){
            for(int i = 0; i < preferences.length; i++){
                reiting[j] += preferences[i][j];
            }
        }

        int restorant = reiting[0];
        boolean flag = true;
        for(int i = 1; i < reiting.length; i++){
            if(reiting[i] != restorant){
                flag = false;
                break;
            }
        }
        if (flag) return -1;
        double minRaiting = Double.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < reiting.length; i++){
            double sum = reiting[i]/3;
            if(sum < minRaiting){
                minRaiting = sum;
                index = i;
            }
        }

        return index;
    }

    @Test
    public void testPref(){

        int[][] matrix = new int[][]{
                {1},{1},{1}
        };

        Assert.assertEquals(1, preferredRestaurant(matrix));
//        int[][] matrix = new int[][]{
//                {1,2,3,4},{3,1,4,2},{4,2,1,3}
//        };
//
//        Assert.assertEquals(1, preferredRestaurant(matrix));
    }
}
