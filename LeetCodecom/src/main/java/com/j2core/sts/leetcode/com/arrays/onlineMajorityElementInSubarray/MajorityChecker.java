package com.j2core.sts.leetcode.com.arrays.onlineMajorityElementInSubarray;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MajorityChecker {

    Map<Pair, Map<Integer, Integer>> majorityMap;

    public MajorityChecker(int[] arr) {

        majorityMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = arr.length-1; j >= i; j--){
                if (j == arr.length-1) {
                    for (int k = i; k <= j; k++) {
                        if (map.containsKey(arr[k])) {
                            map.put(arr[k], map.get(arr[k]) + 1);
                        } else {
                            map.put(arr[k], 1);
                        }
                    }
                }else {
                    HashMap<Integer, Integer> tmp = new HashMap<>(map);
                    tmp.put(arr[j+1], map.get(arr[j+1])-1);
                    map = tmp;
                }
                majorityMap.put(new Pair(i, j), map);
            }
        }
    }

    public int query(int left, int right, int threshold) {

        if (right-left+1 < threshold) return -1;

        Map<Integer, Integer> intervalMap = majorityMap.get(new Pair(left, right));

        for (Map.Entry<Integer, Integer> entity : intervalMap.entrySet()){
            if (entity.getValue() >= threshold){
                return entity.getKey();
            }
        }
        return -1;
    }

    class Pair{

        private int left;
        private int right;

        public Pair(int left, int right){
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return left == pair.left &&
                    right == pair.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }

    @Test
    public static void test(){

        MajorityChecker majorityChecker = new MajorityChecker(new int[]{1,1,2,2,1,1});
        System.out.println(majorityChecker.query(0,5,4));
        System.out.println(majorityChecker.query(0,3,3));
        System.out.println(majorityChecker.query(2,3,2));

        System.out.println("*******************************");
        MajorityChecker checker = new MajorityChecker(new int[]{2,1,2,1,2,2,2,2,2,1,2,2,1,1,1,1,2,1,1,1,1,2});
        System.out.println(checker.query(9,21,12));
        System.out.println(checker.query(5,17,13));
        System.out.println(checker.query(17,19,3));
        System.out.println(checker.query(13,14,2));
        System.out.println(checker.query(13,18,4));
        System.out.println(checker.query(14,16,2));
        System.out.println(checker.query(13,20,8));
        System.out.println(checker.query(12,14,3));
        System.out.println(checker.query(15,21,7));
        System.out.println(checker.query(2,8,5));
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */