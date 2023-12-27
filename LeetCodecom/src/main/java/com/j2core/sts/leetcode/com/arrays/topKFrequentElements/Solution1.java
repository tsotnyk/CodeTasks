package com.j2core.sts.leetcode.com.arrays.topKFrequentElements;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution1 {

    class Entity{

        int value;
        int amount;

        public Entity(int value, int amount){

            this.value = value;
            this.amount = amount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entity entity = (Entity) o;
            return amount == entity.amount;
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){

            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Entity> queue = new PriorityQueue<>(new Comparator<Entity>() {
            @Override
            public int compare(Entity entity, Entity t1) {
                return t1.amount - entity.amount;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            Entity tmp = new Entity(entry.getKey(), entry.getValue());
            queue.add(tmp);
        }

        int[] res = new int[k];

        while (k > 0){
            res[--k] = queue.poll().value;
        }

        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(topKFrequent(new int[]{1,1,1,2,2,3}, 2), new int[]{1,2});
    }

}
