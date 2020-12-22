package com.j2core.sts.leetcode.com.lastStoneWeightII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public int lastStoneWeightIIOld(int[] stones) {

        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : stones){
            queue.add(num);
        }

        while (queue.size() > 1){
            int number = queue.poll();
            number = number - queue.poll();
            queue.add(number);
        }

        return queue.poll();
    }

    public int lastStoneWeightIITLE(int[] stones) {

        Map<Task, Integer> memo = new HashMap<>();
        Task head = new Task(stones);
        return minCost(head, memo);
    }

    private int minCost(Task task, Map<Task, Integer> memo){

        int minCost;
        if (memo.containsKey(task)) return memo.get(task);
        if (task.numbers.size() == 2){
            minCost = Math.abs(task.numbers.get(0)-task.numbers.get(1));
            memo.put(task, minCost);
        }else {
            minCost = Integer.MAX_VALUE;
            for (int i = 0; i < task.numbers.size()-1; i++){
                for (int j = i+1; j < task.numbers.size(); j++){
                    Task nextTask = new Task(task.numbers, i, j);
                    if (nextTask.numbers.size() > 1) {
                        int cost = memo.getOrDefault(nextTask, minCost(nextTask, memo));
                        memo.put(nextTask, cost);
                        minCost = Math.min(minCost, cost);
                    }
                }
            }
        }
        return minCost;
    }

class Task{

        ArrayList<Integer> numbers;

    public Task(int[] nums) {
        this.numbers = new ArrayList<>();

        for (int num : nums){
            numbers.add(num);
        }
    }

    public Task(ArrayList<Integer> nums, int first, int second) {
        this.numbers = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++){
            if (i == first){
                if (!nums.get(first).equals( nums.get(second))){
                    numbers.add(Math.abs(nums.get(first)-nums.get(second)));
                }
            }else if (i != second){
                numbers.add(nums.get(i));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(numbers, task.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}

    public int lastStoneWeightII(int[] stones) {

        Vector<Integer> head = new Vector<>();
        for (int num : stones){
            head.add(num);
        }

        return minCost(head);
    }

    private int minCost(Vector<Integer> task){

        if (task.size() == 0) return Integer.MAX_VALUE;
        if (task.size() == 1) return task.get(0);
        if (task.size() == 2){
            return Math.abs(task.get(0)-task.get(1));
        }else {
            int minCost = Integer.MAX_VALUE;
            Vector<Integer> nextIterTask;
            for (int candidateX= 0; candidateX < task.size()-1; candidateX++){
                for (int candidateY = candidateX+1; candidateY < task.size(); candidateY++){
                    nextIterTask = new Vector<>(task);
                    int amountStoneY = nextIterTask.remove(candidateY);
                    int amountStoneX = nextIterTask.remove(candidateX);
                    if (amountStoneX != amountStoneY){
                        nextIterTask.add(Math.abs(amountStoneX-amountStoneY));
                    }

                    minCost = Math.min(minCost, minCost(nextIterTask));
                }
            }
            return minCost;
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(lastStoneWeightII(new int[]{2,7,4,1,8,1}), 1);
        Assert.assertEquals(lastStoneWeightII(new int[]{31,26,33,21,40}), 5);
//        Assert.assertEquals(lastStoneWeightII(new int[]{1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98}), 3);

    }
}
