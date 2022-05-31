package codesignal;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;

public class TestPractice1 {

    int[] solution1(int n, int[] a) {

        if (n < 2) return a;
        int[] result = new int[n];

        result[0] = a[0]+a[1];
        for (int i = 1; i < n-1; i++){
            result[i] = a[i-1]+a[i]+a[i+1];
        }
        result[n-1] = a[n-1]+a[n-2];

        return result;
    }

    @Test
    public void test1(){

        Assert.assertEquals(solution1(5, new int[]{4,0,1,-2,3}), new int[]{4,5,-1,2,1});
        Assert.assertEquals(solution1(1, new int[]{4}), new int[]{4});

    }

    /*
    You are given an array of non-negative integers numbers. You are allowed to choose any number from this array and swap any two digits in it. If after the swap operation the number contains leading zeros, they can be omitted and not considered (eg: 010 will be considered just 10).

Your task is to check whether it is possible to apply the swap operation at most once, so that the elements of the resulting array are strictly increasing.

Example

For numbers = [1, 5, 10, 20], the output should be solution(numbers) = true.

The initial array is already strictly increasing, so no actions are required.

For numbers = [1, 3, 900, 10], the output should be solution(numbers) = true.

By choosing numbers[2] = 900 and swapping its first and third digits, the resulting number 009 is considered to be just 9. So the updated array will look like [1, 3, 9, 10], which is strictly increasing.

For numbers = [13, 31, 30], the output should be solution(numbers) = false.

The initial array elements are not increasing.
By swapping the digits of numbers[0] = 13, the array becomes [31, 31, 30] which is not strictly increasing;
By swapping the digits of numbers[1] = 31, the array becomes [13, 13, 30] which is not strictly increasing;
By swapping the digits of numbers[2] = 30, the array becomes [13, 31, 3] which is not strictly increasing;
So, it's not possible to obtain a strictly increasing array, and the answer is false.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer numbers

An array of non-negative integers.

Guaranteed constraints:
1 ≤ numbers.length ≤ 103,
0 ≤ numbers[i] ≤ 103.

[output] boolean

Return true if it is possible to obtain a strictly increasing array by applying the digit-swap operation at most once, and false otherwise.
     */

    boolean solution2(int[] numbers) {

        for (int i = 0; i < numbers.length; i++){

        }

        return false;
    }

    /*
    Minesweeper is a popular single-player computer game. The goal is to locate mines within a rectangular grid of cells. At the start of the game, all of the cells are concealed. On each turn, the player clicks on a blank cell to reveal its contents, leading to the following result:

If there's a mine on this cell, the player loses and the game is over;
Otherwise, a number appears on the cell, representing how many mines there are within the 8 neighbouring cells (up, down, left, right, and the 4 diagonal directions);
If the revealed number is 0, each of the 8 neighbouring cells are automatically revealed in the same way.
demonstration

You are given a boolean matrix field representing the distribution of bombs in the rectangular field. You are also given integers x and y, representing the coordinates of the player's first clicked cell - x represents the row index, and y represents the column index, both of which are 0-based.

Your task is to return an integer matrix of the same dimensions as field, representing the resulting field after applying this click. If a cell remains concealed, the corresponding element should have a value of -1.

It is guaranteed that the clicked cell does not contain a mine.

Example

For
field = [[false, true, true],
         [true, false, true],
         [false, false, true]]
x = 1, and y = 1, the output should be

solution(field, x, y) = [[-1, -1, -1],
                                 [-1, 5, -1],
                                 [-1, -1, -1]]
example

There are 5 neighbors of the cell (1, 1) which contain a mine, so the value in (1, 1) should become 5, and the other elements of the resulting matrix should be -1 since no other cell would be expanded.

For
field = [[true, false, true, true, false],
         [true, false, false, false, false],
         [false, false, false, false, false],
         [true, false, false, false, false]]
x = 3, and y = 2, the output should be

solution(field, x, y) = [[-1, -1, -1, -1, -1],
                                 [-1, 3, 2, 2, 1],
                                 [-1, 2, 0, 0, 0],
                                 [-1, 1, 0, 0, 0]]
example

Since the value in the cell (3, 2) is 0, all of its neighboring cells ((2, 1), (2, 2), (2, 3), (3, 1), and (3, 3)) are also revealed. Since the value in the cell (2, 2) is also 0, its neighbouring cells (1, 1), (1, 2) and (1, 3) are revealed, and since the value in cell (2, 3) is 0, its neighbours (1, 4), (2, 4), and (3, 4) are also revealed. The cells (3, 3), (2, 4), and (3, 4) also contain the value 0, but since all of their neighbours have already been revealed, no further action is required.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.boolean field

A rectangular matrix representing the locations of the mines in the game field.

Guaranteed constraints:
2 ≤ field.length ≤ 100,
2 ≤ field[i].length ≤ 100.

[input] integer x

The row number of the cell which is clicked (0-based).

Guaranteed constraints:
0 ≤ x < field.length.

[input] integer y

The column number of the cell which is clicked (0-based).

Guaranteed constraints:
 0 ≤ y < field[0].length.

[output] array.array.integer

The expanded matrix after the click.
     */

    int[][] solution3(boolean[][] field, int x, int y) {

        int[][] result = new int[field.length][field[0].length];

        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[0].length; j++){
                result[i][j] = -1;
            }
        }

        LinkedList<Point> list = new LinkedList<>(new LinkedList<>(Collections.singleton(new Point(x,y))));

        while (!list.isEmpty()) {
            Point point = list.removeFirst();
            int counter = countMines(field, list, point.x, point.y, result);
            if (counter > 0) result[point.x][point.y] = counter;
        }
        return result;
    }

    private int countMines(boolean[][] field, LinkedList<Point> list, int x, int y, int[][] result){

        int counter = 0;
        LinkedList<Point> freeSpace = new LinkedList<>();
        counter += isMine(freeSpace, field, x-1, y-1, result);
        counter += isMine(freeSpace, field, x-1, y, result);
        counter += isMine(freeSpace, field, x-1, y+1, result);
        counter += isMine(freeSpace, field, x, y-1, result);
        counter += isMine(freeSpace, field, x, y+1, result);
        counter += isMine(freeSpace, field, x+1, y-1, result);
        counter += isMine(freeSpace, field, x+1, y, result);
        counter += isMine(freeSpace, field, x+1, y+1, result);

        if (counter == 0){
            list.addAll(freeSpace);
            for (Point point : freeSpace){
                result[point.x][point.y] = 0;
            }
        }

        return counter;
    }

    private int isMine(LinkedList<Point> freeSpace, boolean[][] field, int x, int y, int[][] result){

        if (x < 0 || x >= field.length || y < 0 || y >= field[0].length) return 0;
        if (field[x][y]){
            return 1;
        }
        if (result[x][y] != 0) {
            freeSpace.add(new Point(x, y));
        }
        return 0;
    }

    class Point{

        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public void test3(){

        int[][] result = solution3(new boolean[][]{{false, true}, {false, false}}, 0,0);

        System.out.println(result);
    }

    /*
    A sawtooth sequence is a sequence of numbers that alternate between increasing and decreasing. In other words, each element is either strictly greater than its neighbouring elements or strictly less than its neighbouring elements.

examples

Given an array of integers arr, your task is to count the number of contiguous subarrays that represent a sawtooth sequence of at least two elements.

Example

For arr = [9, 8, 7, 6, 5], the output should be solution(arr) = 4.

Since all the elements are arranged in decreasing order, it won't be possible to form any sawtooth subarrays of length 3 or more. There are 4 possible subarrays containing two elements, so the answer is 4.

For arr = [10, 10, 10], the output should be solution(arr) = 0.

Since all of the elements are equal, none of subarrays can be sawtooth, so the answer is 0.

For arr = [1, 2, 1, 2, 1], the output should be solution(arr) = 10.

All contiguous subarrays containing at least two elements satisfy the condition of problem. There are 10 possible contiguous subarrays containing at least two elements, so the answer is 10.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer arr

An array of integers.

Guaranteed constraints:
2 ≤ arr.length ≤ 105,
-109 ≤ arr[i] ≤ 109.

[output] integer64

Return the number of sawtooth subarrays.
     */

    long solution4(int[] arr) {


        return 0L;
    }


}
