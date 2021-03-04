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

    int[][] diagonalsSort1(int[][] a) {

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

    boolean trafficMap(int[][] directions) {

        if(directions[0][0] != 0 && directions[0][0] != 2) return false;

        int i = 0;
        int j = 0;
        int lastI = 0;
        int lastJ = 0;

        while (i < directions.length && j < directions[0].length){
            lastJ = j;
            lastI = i;
            directions[lastI][lastJ] *= -1;
            switch(directions[i][j]){
                case 0:
                    j++;
                    if (j < directions[0].length){
                        int val = directions[i][j];
                        if (val != 0 && val != 2 && val != 5) return false;
                    }
                    break;
                case 3:
                    //todo
                case 4:
                    //todo
                    j++;
                    if (j < directions[0].length){
                        int val = directions[i][j];
                        if (val != 0 && val != 2 && val != 5) return false;
                    }
                    break;
                case 1:
                    i++;
                    if (i < directions.length){
                        int val = directions[i][j];
                        if (val != 1 && val != 4 && val != 5) return false;
                    }
                    break;
                case 2:
                    i++;
                    if (i < directions.length){
                        int val = directions[i][j];
                        if (val != 1 && val != 4 && val != 5) return false;
                    }
                    break;
                case 5:
                    if (j-1 > -1 && directions[i][j-1] >= 0){
                        j--;
                        if (j > -1) {
                            int val = directions[i][j];
                            if (val != 1 && val != 2 && val != 3) return false;
                        }
                    }else{
                        i--;
                        if (i > -1){
                            int val = directions[i][j];
                            if (val != 1 && val != 2 && val != 3) return false;
                        }
                    }
                    break;
            }
        }

        int value = directions[lastI][lastJ];
        return value == -4 || value == -3 || value == -0;

    }

    @Test
    public void tesyt(){

//        Assert.assertFalse(trafficMap(new int[][]{{0,0,2,2},{3,0,4,2},{0,3,0,0}}));
//        Assert.assertTrue(trafficMap(new int[][]{{0,2,1},{5,4,0}}));
//        Assert.assertTrue(trafficMap(new int[][]{{2,0,3,4}, {4,0,0,2},{1,2,2,1},{0,5,2,1}, {2,3,4,4}}));
        Assert.assertTrue(trafficMap(new int[][]{{2,4,0,2,2,1,0},
                {4,0,2,1,1,5,5},
        {2,5,4,0,2,3,1},
            {5,0,5,4,1,2,4},
                {0,1,5,3,5,5,3},
                    {2,1,0,4,2,2,2},
                        {2,0,1,2,4,0,0}}));


    }

    static int findMaximumEvenSumWithKElements(int A[], int k) {
        if (k > A.length)
            return -1;
        Arrays.sort(A);
        int n = A.length;
        int sum = 0;
        for (int i = n - 1, j = k; j >= 1; i--, j--) {
            sum += A[i];
        }
        if (sum % 2 == 0)
            return sum;
        if (n == k)
            return -1;
        int minOdd = -1, minEven = -1;
        for (int i = n - k; i < n; i++) {
            if (minOdd == -1 && A[i] % 2 == 1)
                minOdd = A[i];
            if (minEven == -1 && A[i] % 2 == 0)
                minEven = A[i];
            if (minOdd != -1 && minEven != -1)
                break;
        }
        int maxOdd = -1, maxEven = -1;
        for (int i = n - k - 1; i >= 0; i--) {
            if (maxOdd == -1 && A[i] % 2 == 1)
                maxOdd = A[i];
            if (maxEven == -1 && A[i] % 2 == 0)
                maxEven = A[i];
            if (maxOdd != -1 && maxEven != -1)
                break;
        }
        int diff1 = -1;
        if (maxOdd != -1 && minEven != -1)
            diff1 = minEven - maxOdd;
        int diff2 = -1;
        if (maxEven != -1 && minOdd != -1)
            diff2 = minOdd - maxEven;
        if (diff1 == -1 && diff2 == -1)
            return -1;
        if (diff1 == -1)
            return sum - diff2;
        if (diff2 == -1)
            return sum - diff1;
        return sum - Math.min(diff1, diff2);
    }

    public  static int sum(int[] A,int K) {
        int length = A.length;

        if(length < K) return -1;
        if(length == K){
            int sum = Arrays.stream(A).sum();
            return sum%2 == 0 ? sum : -1;
        }

        Arrays.sort(A);
        int sum = 0;
        int index = -1;
        int indexEvent = -1;
        boolean odd = false;

        for(int i = length-1; i >= length-K; i--){
            if(A[i]%2 != 0){
                index = i;
                odd = !odd;
            }else{
                indexEvent = i;
            }
            sum += A[i];
        }

        if(!odd) return sum;
        int nextSum = sum;
        nextSum -= A[index];
        odd = true;
        for(int i = length-K-1; i > -1; i--){
            if(A[i]%2 == 0){
                nextSum += A[i];
                odd = false;
                break;
            }
        }
        int maxSum = -1;
        if (!odd) maxSum = nextSum;

        if (indexEvent == -1) return maxSum;
        sum -= A[indexEvent];
        odd = true;
        for(int i = length-K-1; i > -1; i--){
            if(A[i]%2 != 0){
                sum += A[i];
                odd = false;
                break;
            }
        }
        if (odd) return maxSum;
        return Math.max(maxSum, sum);
    }

    public static void main(String[] args) {
        System.out.println(findMaximumEvenSumWithKElements(new int[] {4,9,8,2,6}, 3));
        System.out.println(findMaximumEvenSumWithKElements(new int[] {5,6,3,4,2}, 5));
        System.out.println(findMaximumEvenSumWithKElements(new int[] {7,7,7,7,7}, 1));
        System.out.println(findMaximumEvenSumWithKElements(new int[] {10000}, 2));
        System.out.println(findMaximumEvenSumWithKElements(new int[] {2,3,3,5,5}, 3));
System.out.println("    ");
        System.out.println(sum(new int[] {4,9,8,2,6}, 3));
        System.out.println(sum(new int[] {5,6,3,4,2}, 5));
        System.out.println(sum(new int[] {7,7,7,7,7}, 1));
        System.out.println(sum(new int[] {10000}, 2));
        System.out.println(sum(new int[] {2,3,3,5,5}, 3));
    }

    /*
    Given two strings s and t, both consisting of lowercase English letters and digits, your task is to calculate how many ways exactly one digit could be removed from one of the strings so that s is lexicographically smaller than t after the removal. Note that we are removing only a single instance of a single digit, rather than all instances (eg: removing 1 from the string a11b1c could result in a1b1c or a11bc, but not abc).

Also note that digits are considered lexicographically smaller than letters.

Example

For s = "ab12c" and t = "1zz456", the output should be removeOneDigit(s, t) = 1.

Here are all the possible removals:

We can remove the first digit from s, obtaining "ab2c". "ab2c" > "1zz456", so we don't count this removal
We can remove the second digit from s, obtaining "ab1c". "ab1c" > "1zz456", so we don't count this removal
We can remove the first digit from t, obtaining "zz456". "ab12c" < "zz456", so we count this removal
We can remove the second digit from t, obtaining "1zz56". "ab12c" > "1zz56", so we don't count this removal
We can remove the third digit from t, obtaining "1zz46". "ab12c" > "1zz46", so we don't count this removal
We can remove the fourth digit from t, obtaining "1zz45". "ab12c" > "1zz45", so we don't count this removal
The only valid case where s < t after removing a digit is "ab12c" < "zz456". Therefore, the answer is 1.

For s = "ab12c" and t = "ab24z", the output should be removeOneDigit(s, t) = 3.

There are 4 possible ways of removing the digit:

"ab1c" < "ab24z"
"ab2c" > "ab24z"
"ab12c" < "ab4z"
"ab12c" < "ab2z"
Three of these cases match the requirement that s < t, so the answer is 3.
     */
    int removeOneDigit(String s, String t) {

        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                if(stringSmaller(s, t, i, -1)) counter++;
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(Character.isDigit(t.charAt(i))){
                if(stringSmaller(s, t, -1, i)) counter++;
            }
        }
        return counter;
    }

    private boolean stringSmaller(String s, String t, int index1, int index2){

        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()){
            if(i == index1){
                i++;
                continue;
            }
            if(j == index2){
                j++;
                continue;
            }
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                continue;
            }

            return s.charAt(i) < t.charAt(j);
        }

        if(i == s.length() && j == t.length()) return false;

        return i == s.length();
    }

    @Test
    public void testRemoveOneDigit(){

        Assert.assertEquals(1, removeOneDigit("6", "h"));

        Assert.assertEquals(1, removeOneDigit("ab12c", "1zz456"));
    }

    /*
    You are given an array of integers a and two integers l and r. You task is to calculate a boolean array b, where b[i] = true if there exists an integer x, such that a[i] = (i + 1) * x and l ≤ x ≤ r. Otherwise, b[i] should be set to false.

Example

For a = [8, 5, 6, 16, 5], l = 1, and r = 3, the output should be boundedRatio(a, l, r) = [false, false, true, false, true].

For a[0] = 8, we need to find a value of x such that 1 * x = 8, but the only value that would work is x = 8 which doesn't satisfy the boundaries 1 ≤ x ≤ 3, so b[0] = false.
For a[1] = 5, we need to find a value of x such that 2 * x = 5, but there is no integer value that would satisfy this equation, so b[1] = false.
For a[2] = 6, we can choose x = 2 because 3 * 2 = 6 and 1 ≤ 2 ≤ 3, so b[2] = true.
For a[3] = 16, there is no an integer 1 ≤ x ≤ 3, such that 4 * x = 16, so b[3] = false.
For a[4] = 5, we can choose x = 1 because 5 * 1 = 5 and 1 ≤ 1 ≤ 3, so b[4] = true.
     */

    boolean[] boundedRatio(int[] a, int l, int r) {

        boolean[] result = new boolean[a.length];

        for (int i = 0; i < a.length; i++){
            if (isValid(i, a[i], l, r)){
                result[i] = true;
            }
        }

        return result;

    }

    private boolean isValid(int i, int sum, int l, int r){

        for (int j = l; j <= r; j++){
            if (sum == (i+1)*j) return true;
        }
        return false;
    }

    /*
    Given an array of integers a of even length, your task is to split it into two arrays of equal length such that all the numbers are unique in each of them.

There may be more than one possible answer, in which case you may return any of them. If there are no possible answers, return an empty array.

Hint: Count the number of occurrences of each integer in a. If there are integers occurring more than twice, then there is no solution. Next, put the integers occurring twice into both answer arrays. Finally, put all other numbers in the answer arrays, following the condition that they should have equal sizes.

Example

For a = [2, 1, 2, 3, 3, 4], the output can be divideArray(a) = [[2, 1, 3], [2, 3, 4]].

Answers like [[1, 2, 3], [2, 3, 4]] or [[4, 2, 3], [3, 2, 1]] would also be considered correct.

For a = [1, 2, 2, 1], the output can be divideArray(a) = [[1, 2], [2, 1]].

Again, there are other possible answers.

For a = [2, 2, 3, 3, 2, 2], the output should be divideArray(a) = [].

No matter how we try to split this array, there will be at least two 2s in at least one of the resulting arrays. So the answer is [].
     */

    int[][] divideArray(int[] a) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : a){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int[][] result = new int[2][a.length/2];
        int index1 = 0;
        int index2 = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int count = entry.getValue();
            int key = entry.getKey();
            if (count > 2) return new int[0][];
            if (count == 2){
                result[0][index1++] = key;
                result[1][index2++] = key;
            }else {
                if (index2 < index1){
                    result[1][index2++] = key;
                }else {
                    result[0][index1++] = key;
                }
            }
        }

        return result;
    }

    /*
    Given a square matrix of positive integers a, your task is to sort the numbers in each of its diagonals parallel to the secondary diagonal. Each diagonal should contain the same set of numbers as before, but sorted in ascending order from the bottom-left to top-right.

Example

For

a = [[1, 3, 9, 4],
     [9, 5, 7, 7],
     [3, 6, 9, 7],
     [1, 2, 2, 2]]
the output should be

diagonalsSort(a) = [[1, 9, 9, 7],
                    [3, 5, 6, 9],
                    [3, 4, 7, 7],
                    [1, 2, 2, 2]]
     */


    int[][] diagonalsSort(int[][] a) {

        int[][] result = new int[a.length][a[0].length];
        int i = 0;
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
                result[x--][y++] = num;
            }
            i++;
        }
        int j = 0;
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
                result[x--][y++] = num;
            }
            j++;
        }

        return result;
    }

    @Test
    public void testSort(){

        int[][] matrix = new int[][]{
                {1, 3, 9, 4},
                {9, 5, 7, 7},
                {3, 6, 9, 7},
                {1, 2, 2, 2}};

        int[][] result = diagonalsSort(matrix);
    }

}
