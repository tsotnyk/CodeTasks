package com.j2core.sts.leetcode.com.tmp.mockInterview.uberOA;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    public boolean wordPattern(String pattern, String s) {


        String[] wordArray = s.split(" ");
        HashMap<String, Character> map = new HashMap<>();
        HashMap<Character, String> letterMap = new HashMap<>();

        if (wordArray.length != pattern.length()) return false;

        for (int i = 0; i < wordArray.length; i++){
            String word = wordArray[i];
            char symbol = pattern.charAt(i);
            if (map.containsKey(word)){
                if (map.get(word) != symbol) return false;
            }else if(letterMap.containsKey(symbol)){
                if (!letterMap.get(symbol).equals(word)) return false;
            }
            else{
                letterMap.put(symbol, word);
                map.put(word, symbol);
            }
        }

        return true;
    }

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Point> q = new LinkedList<>();
        int[][] dist = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 0)
                    q.add(new Point(i, j));
                else
                    dist[i][j] = -1;
            }
        }
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int x1 = p.x + x[i];
                int y1 = p.y + y[i];
                if(x1 < 0 || y1 < 0 || x1 >= row || y1 >= col || dist[x1][y1] != -1)
                    continue;
                q.add(new Point(x1, y1));
                dist[x1][y1] = 1 + dist[p.x][p.y];
            }


            HashMap<Integer, Integer> map = new HashMap<>();
            map.entrySet();
//            Character.toLowerCase()
//            Collections.singleton()
        }
        return dist;
    }

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
