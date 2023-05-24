package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

    public void zeroMatrix(int[][] matrix){

        Set<Integer> setI = new HashSet<>();
        Set<Integer> setJ = new HashSet<>();
        int iLength = matrix.length;
        int jLength = matrix[0].length;

        for (int i = 0; i < iLength; i++){
            for (int j = 0; j < jLength; j++){
                if (matrix[i][j] == 0){
                    setI.add(i);
                    setJ.add(j);
                }
            }
        }
        Integer[] array = new Integer[setI.size()];
        for (Integer i: setI.toArray(array)){
            for (int j=0; j < jLength; j++){
                matrix[i][j] = 0;
            }
        }
        for (Integer j: setJ.toArray(array)){
            for (int i=0; i < iLength; i++){
                matrix[i][j] = 0;
            }
        }
    }

    @Test
    public void test(){

        int[][] matrix = new int[][]{
                {0,1,2,3},
                {4,5,6,7},
                {8,9,0,1}
        };

        zeroMatrix(matrix);

        int[][] newMatrix = new int[][]{
                {0,0,0,0},
                {0,5,0,7},
                {0,0,0,0}
        };

        Assert.assertEquals(matrix[0], newMatrix[0]);
    }
}
