package com.j2core.sts.leetcode.com.rectangleArea;

public class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int firstArea = Math.abs(C-A) * Math.abs(D-B);

        int secondArea = Math.abs(G-E) * Math.abs(H-F);

        int minesX = Math.abs(Math.max(A, E) - Math.max(Math.min(C, G), Math.max(A, E)));

        int minesY = Math.abs(Math.max(B, F)- Math.max(Math.min(D, H), Math.max(B, F)));

        int minesArea = minesX * minesY;

        return firstArea + secondArea - minesArea;

    }
}
