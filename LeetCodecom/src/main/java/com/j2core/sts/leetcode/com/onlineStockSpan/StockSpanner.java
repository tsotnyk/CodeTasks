package com.j2core.sts.leetcode.com.onlineStockSpan;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class StockSpanner {
    Stack<int[]> collection;

    public StockSpanner() {

        collection = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!collection.isEmpty() && price >= collection.peek()[0]) { // If the current price is greater than stack peek.
            span += collection.peek()[1];
            collection.pop();
        }
        collection.push(new int[]{price, span});
        return span;
    }

    public int tmp(int[] prices){

        int max = 1;
        int counterMin = 1;
        int counterMax = 1;
        int num = prices[0];

        for (int i = 1; i < prices.length;){
            if (num < prices[i]){
                counterMax++;
                num = prices[i++];
                while (i < prices.length && num < prices[i]){
                    counterMax++;
                    num = prices[i];
                    i++;
                }
                max = Math.max(max, counterMax);
                counterMax = 1;
            }else {
                counterMin++;
                num = prices[i++];
                while (i < prices.length && num < prices[i]){
                    counterMin++;
                    num = prices[i];
                    i++;
                }
                max = Math.max(max, counterMin);
                counterMin = 1;
            }
            i++;
        }

        return max;
    }



//    Stack<Info> collection;
//
//    public StockSpanner() {
//
//        collection = new Stack<>();
//    }
//
//    public int next(int price) {
//        int counter = 1;
//        while (!collection.isEmpty() && collection.peek().price <= price) {
//            Info info = collection.pop();
//            counter += info.counter;
//        }
//
//        collection.push(new Info(price, counter));
//
//        return counter;
//    }
//
//    class Info{
//        int price;
//        int counter;
//
//        public Info(int price, int counter) {
//            this.price = price;
//            this.counter = counter;
//        }
//    }

/* Time limit exception
    TreeMap<Integer, Integer> map;

    public StockSpanner() {

        map = new TreeMap<>();
    }

    public int next(int price) {

        Map.Entry<Integer, Integer> entry = map.floorEntry(price);

        if (entry == null){
            map.put(price, 1);
            return 1;
        }else {
            int counter = 1;
            while (entry != null) {
                counter += entry.getValue();
                map.remove(entry.getKey());
                map.put(price, counter);
                entry = map.floorEntry(entry.getKey());
            }
            return counter;
        }
    }
*/
    @Test
    public static void test(){

        StockSpanner spanner = new StockSpanner();

        int x1 = spanner.next(100);
        int x2 = spanner.next(80);
        int x3 = spanner.next(60);
        int x4 = spanner.next(70);
        int x5 = spanner.next(60);
        int x6 = spanner.next(75);
        int x7 = spanner.next(85);

        System.out.println(x7);

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
