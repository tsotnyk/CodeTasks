package chapter1;

import org.testng.annotations.Test;

public class RotateMatrix {

    public void rotateMatrixIn90Degrees(int[][] matrix){

        int countLevels = matrix.length/2;

        for (int i = 0; i < countLevels; i++){
            rotateLevel(matrix, i);
        }
    }

    public void rotateLevel(int[][] matrix, int level){
        int length = matrix.length;
        for (int i = level; i < length-level-1; i++){
            int tmpValue = matrix[level][i];
            matrix[level][i] = matrix[i][length-1-level];
            matrix[i][length-1-level] = matrix[length-1-level][length-1-i];
            matrix[length-1-level][length-1-i] = matrix[length-1-i][level];
            matrix[length-1-i][level] = tmpValue;
        }
    }

    @Test
    public void test(){

        int[][] matrix = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        rotateMatrixIn90Degrees(matrix);

        System.out.println(matrix);
    }
}
