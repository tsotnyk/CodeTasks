package com.j2core.sts.leetcode.com.checkingExistenceOfEdgeLengthLimitedPathsII;
import java.util.*;

public class DistanceLimitedPathsExist {

    HashMap<Row, Integer> resultMap;
    HashMap<Integer, List<int[]>> map;
    int amount;

    public DistanceLimitedPathsExist(int n, int[][] edgeList) {

        amount = n;
        resultMap = new HashMap<>();
        map = new HashMap<>();

        for (int i = 0; i < amount; i++){
            map.put(i, new LinkedList<>());
        }

        for (int[] tmp : edgeList){
            map.get(tmp[0]).add(new int[]{tmp[1], tmp[2]});
            map.get(tmp[1]).add(new int[]{tmp[0], tmp[2]});
        }
    }

    public boolean query(int p, int q, int limit) {

        Row row = new Row(p, q);
        if (resultMap.containsKey(row)){
            return resultMap.get(row) < limit;
        }

        return countMinPath(row) < limit;
    }

    private int countMinPath(Row row) {

        int[] array = new int[amount];
        Arrays.fill(array, Integer.MAX_VALUE);
        array[row.start] = 0;
        boolean[] visit = new boolean[amount];
        int index = row.start;
        while ( index > -1) {
            visit[index] = true;
            int value = array[index];
            for (int[] steps : map.get(index)){
                if (!visit[steps[0]]){
                    array[steps[0]] = Math.min(array[steps[0]], value+steps[1]);
                }
            }

            index = findUnvisitedPoint(array, visit);
        }
        addNewResult(array, row.start);

        return array[row.end];
    }

    private int findUnvisitedPoint(int[] array, boolean[] visit){

        int index = -1;
        int value = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++){
            if (!visit[i] && array[i] < value){
                index = i;
                value = array[i];
            }
        }

        return index;
    }

    private void addNewResult(int[] array, int start){

        for (int i = 0; i < array.length; i++){
            if (i != start){
                resultMap.put(new Row(start, i), array[i]);
                resultMap.put(new Row(i, start), array[i]);
            }
        }
    }

    class Row{

        int start;
        int end;

        public Row(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Row row = (Row) o;
            return start == row.start && end == row.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }


}


class MyTest{

    public static void main(String[] args) {
        DistanceLimitedPathsExist env = new DistanceLimitedPathsExist(6, new int[][]{{0,2,4},{0,3,2},{1,2,3},{2,3,1},{4,5,5}});

        System.out.println(env.query(2,0,3));
        System.out.println(env.query(2,3,2));
        System.out.println(env.query(1,3,3));

        DistanceLimitedPathsExist env1 = new DistanceLimitedPathsExist(2, new int[][]{{0,1,3},{0,1,3},{0,1,4},{0,1,1},{1,0,5},{1,0,3}});

        System.out.println(env1.query(1,0,4));
        System.out.println(env1.query(1,0,1));
    }
}
/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */
