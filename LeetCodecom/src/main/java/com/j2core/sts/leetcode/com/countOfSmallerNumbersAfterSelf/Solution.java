package com.j2core.sts.leetcode.com.countOfSmallerNumbersAfterSelf;

import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<Integer> countSmaller(int[] nums) {

        LinkedList<Integer> result = new LinkedList<>();
        ArrayList<Integer> sortNumList = new ArrayList<>(nums.length);

        for (int i = nums.length-1; i > -1; i--){

            if (sortNumList.isEmpty()){
                sortNumList.add(nums[i]);
                result.addFirst(0);
            }else {
                result.addFirst(addNum2sortList(nums[i], sortNumList));
            }
        }

        return result;
    }

    private int addNum2sortList(Integer num, ArrayList<Integer> sortNumList){

        int i = 0;

        for (int tmp : sortNumList){
            if (tmp < num){
                i++;
            }else {
                break;
            }
        }

        sortNumList.add(i, num);

        return i;
    }


//    Map<Integer, Integer> doubleMap = new HashMap<>();
//    List<Integer> doubleNum = new LinkedList<>();
//
//    public List<Integer> countSmaller(int[] nums) {
//
//        LinkedList<Integer> result = new LinkedList<>();
//        TreeSet<Integer> tree = new TreeSet<>();
//        for (int i = nums.length-1; i > -1; i--){
//            if (!tree.add(nums[i])){
//                if (doubleMap.containsKey(nums[i])){
//                    doubleMap.put(nums[i], doubleMap.get(nums[i])+1);
//                }else {
//                    doubleMap.put(nums[i], 1);
//                    doubleNum.add(nums[i]);
//                }
//            }
//            result.addFirst(countSmallerNumbers(nums[i], tree));
//        }
//
//        return result;
//    }
//
//    private int countSmallerNumbers(int num, TreeSet<Integer> treeSet){
//
//        if (treeSet.isEmpty()) return 0;
//
//        SortedSet<Integer> tmp = treeSet.tailSet(num);
//        int counter = treeSet.size()-tmp.size();
//
//        for (int repeatedNum : doubleNum){
//            if (repeatedNum < num){
//                counter += doubleMap.get(repeatedNum);
//            }
//        }
//        return counter;
//    }

//
//    public List<Integer> countSmaller(int[] nums) {
//
//        LinkedList<Integer> result = new LinkedList<>();
//        List<Integer> list = new LinkedList<>();
//        for (int i = nums.length-1; i > -1; i--){
//            list.add(nums[i]);
//            list.sort((integer, t1) -> integer.compareTo(t1));
//            result.addFirst(list.indexOf(nums[i]));
//        }
//
//        return result;
//    }

//    public List<Integer> countSmaller(int[] nums) {
//
//        ArrayList<Integer> list = new ArrayList<>(nums.length);
//        for (int i = 0; i < nums.length; i++){
//            list.add(0);
//            for (int j = 0; j < i; j++){
//                if (nums[i] < nums[j]){
//                    list.set(j, list.get(j)+1);
//                }
//            }
//        }
//
//        return list;
//    }

//    public List<Integer> countSmaller(int[] nums) {
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = nums.length-1; i > -1; i--){
//            list.addFirst(countSmallerNum(nums[i], queue));
//            queue.add(nums[i]);
//        }
//        return list;
//    }
//
//    private int countSmallerNum(int num, PriorityQueue<Integer> queue){
//
//        PriorityQueue<Integer> tmpQueue = new PriorityQueue<>(queue);
//        int counter = queue.size();
//        while (!tmpQueue.isEmpty()){
//            int tmp = tmpQueue.poll();
//            if (tmp >= num){
//                counter--;
//            }else {
//                break;
//            }
//        }
//
//        return counter;
//    }

    @Test
    public void test(){

        List<Integer> tmp = countSmaller(new int[]{5,2,6,1});


        List<Integer> result = countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41});

        System.out.println(result.toArray());
    }
}
