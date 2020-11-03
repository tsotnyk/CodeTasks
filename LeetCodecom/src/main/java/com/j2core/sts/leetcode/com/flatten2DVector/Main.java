package com.j2core.sts.leetcode.com.flatten2DVector;

public class Main {

    public static void main(String[] args) {

        Vector2dWithLIst vector2d = new Vector2dWithLIst(new int[][]{{}, null});

        System.out.println(vector2d.hasNext());
        System.out.println("****************");

        Vector2D vector2D = new Vector2D(new int[][]{{1,2},{3},{4}});

        System.out.println(vector2D.next());
        System.out.println(vector2D.next());
        System.out.println(vector2D.next());
        System.out.println(vector2D.hasNext());
        System.out.println(vector2D.hasNext());
        System.out.println(vector2D.next());
        System.out.println(vector2D.hasNext());
        System.out.println("****************");

        Vector2D vector2D1 = new Vector2D(new int[][]{{}, null});

        System.out.println(vector2D1.hasNext());
        System.out.println("****************");

        Vector2D vector2D2 = new Vector2D(new int[][]{{1,2},{3},{},{}, null,{},{4}});

        System.out.println(vector2D2.next());
        System.out.println(vector2D2.next());
        System.out.println(vector2D2.next());
        System.out.println(vector2D2.hasNext());
        System.out.println(vector2D2.hasNext());
        System.out.println(vector2D2.next());
        System.out.println(vector2D2.hasNext());
        System.out.println("****************");

        Vector2D vector2D3 = new Vector2D(new int[][]{{},{1,2},{3},{},{}, null,{},{4}});

        System.out.println(vector2D3.next());
        System.out.println(vector2D3.next());
        System.out.println(vector2D3.next());
        System.out.println(vector2D3.hasNext());
        System.out.println(vector2D3.hasNext());
        System.out.println(vector2D3.next());
        System.out.println(vector2D3.hasNext());
    }
}
