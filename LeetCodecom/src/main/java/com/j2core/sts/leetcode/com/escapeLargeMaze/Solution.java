package com.j2core.sts.leetcode.com.escapeLargeMaze;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Solution {

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        HashSet<Point> blockedSet = new HashSet<>();
        for (int[] pair : blocked){
            blockedSet.add(new Point(pair[0], pair[1]));
        }
        Point tar = new Point(target[0], target[1]);
        HashSet<Point> points = new HashSet<>();
        LinkedList<Point> tasks = new LinkedList<>(Collections.singletonList(new Point(source[0], source[1])));
        while (!tasks.isEmpty()){

            Point cur = tasks.removeFirst();

            Point next = new Point(cur.x-1, cur.y);
            if (findTarget(next, points, tasks, tar, blockedSet)) return true;
            next = new Point(cur.x+1, cur.y);
            if (findTarget(next, points, tasks, tar, blockedSet)) return true;
            next = new Point(cur.x, cur.y-1);
            if (findTarget(next, points, tasks, tar, blockedSet)) return true;
            next = new Point(cur.x, cur.y+1);
            if (findTarget(next, points, tasks, tar, blockedSet)) return true;
        }

        return false;
    }

    private boolean findTarget(Point point, HashSet<Point> points, LinkedList<Point> tasks, Point target, HashSet<Point> blocked){

        if (point.equals(target)) return true;
        if (blocked.contains(point)) return false;
        if (point.x < 0 || point.y < 0) return false;
        if (point.y > 1000000 || point.x > 1000000) return false;
        if (points.contains(point)) return false;
        tasks.add(point);

        return false;
    }

}
