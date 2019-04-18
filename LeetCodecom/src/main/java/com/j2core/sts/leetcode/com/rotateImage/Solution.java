package com.j2core.sts.leetcode.com.rotateImage;


public class Solution {

    public void rotate(int[][] matrix) {

        int length = matrix.length;
        int maxAction = length/2;
        int maxStep = length-1;

        for (int action = 0; action < maxAction; action++){

            for (int step = 0; step < maxStep; step++){

                int tmp = matrix[action][action+step];

                matrix[action][action+step] = matrix[action+maxStep-step][action];
                matrix[action+maxStep-step][action] = matrix[action+maxStep][action+maxStep-step];
                matrix[action+maxStep][action+maxStep-step] = matrix[action+step][action+maxStep];
                matrix[action+step][action+maxStep] = tmp;
            }

            maxStep -= 2;
        }
    }
}
