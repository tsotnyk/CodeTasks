package com.j2core.sts.leetcode.com.hackerrank;

class MyComparator {

    public boolean compareInt(int a, int b){

        return a == b;

    }

    public boolean compareString(String s1, String s2){

        return s1.equals(s2);
    }

    public boolean compareArray(int[] a, int[] b){

        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++){
            if (a[i] != b[i]) return false;
        }

        return true;
    }
}
