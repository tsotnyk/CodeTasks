package com.j2core.sts.leetcode.com.flatten2DVector;

public class Vector2D {

    int[][] matrix;
    int arrayIndex;
    int valueIndex;



    public Vector2D(int[][] v) {

        if (v.length > 0){
            this.arrayIndex = 0;
            this.valueIndex = 0;
        }else {
            this.arrayIndex = -1;
        }

        this.matrix = v;
    }

    public int next() {

        if (valueIndex < matrix[arrayIndex].length){
            return matrix[arrayIndex][valueIndex++];
        }else {
            arrayIndex++;
            valueIndex = 0;
            return next();
        }
    }

    public boolean hasNext() {

        if (arrayIndex < 0) return false;
        if (valueIndex >= matrix[arrayIndex].length) {
            valueIndex = 0;
            arrayIndex++;
            while (arrayIndex < matrix.length && (matrix[arrayIndex] == null || matrix[arrayIndex].length == 0)) {
                arrayIndex++;
            }

            if (arrayIndex == matrix.length) return false;
        }
        return true;
    }

}




/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */