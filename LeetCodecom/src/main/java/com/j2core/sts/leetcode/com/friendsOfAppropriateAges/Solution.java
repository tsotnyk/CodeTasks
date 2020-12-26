package com.j2core.sts.leetcode.com.friendsOfAppropriateAges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Solution {

    public int numFriendRequestsBase(int[] ages) {

        int[] count = new int[121];
        for (int age: ages) count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && 100 < ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }

        return ans;

    }

    public int numFriendRequestsTLE(int[] ages) {

        int counter = 0;

        for (int personA = 0; personA < ages.length; personA++){
            for (int candidate = 0; candidate < ages.length; candidate++){
                if (candidate != personA){
                    if (ages[candidate] > ages[personA]) continue;
                    if (ages[candidate] > 100 && ages[personA] < 100) continue;
                    if (ages[candidate] <= 0.5 * ages[personA]+7) continue;
                    counter++;
                }
            }
        }

        return counter;
    }

    public int numFriendRequests(int[] ages) {
        int counter = 0;
        Arrays.sort(ages);
        for (int person = 0; person < ages.length; person++){
            double minFriendsAge = 0.5*ages[person]+7;
            for (int candidate = 0; candidate < ages.length; candidate++){
                if (candidate != person){
                    if (ages[candidate] > ages[person]) break;
//                    if (ages[candidate] > 100 && ages[person] < 100) continue;
                    if ((double)ages[candidate] <= minFriendsAge) continue;
                    counter++;
                }
            }
        }
        return counter;
    }

    public int numFriendRequests1(int[] ages) {

        int counter = 0;
        HashMap<Double, Counter> ageMap = new HashMap<>();

        for (double age : ages){
            if (ageMap.containsKey(age)){
                ageMap.get(age).increment();
            }else {
                ageMap.put(age, new Counter());
            }
        }

        Set<Double> ageSet = ageMap.keySet();

        for (double agePersonA : ageSet){
            int persons = ageMap.get(agePersonA).getCount();
//            counter += persons*(persons-1);
            double minAgeFriends = ((0.5*agePersonA)+7);
            for (double candidateAge: ageSet){
                int candidates = ageMap.get(candidateAge).getCount();
                if (agePersonA != candidateAge){
//                    if (candidateAge > 100 && agePersonA < 100) continue;
                    if (candidateAge > agePersonA) continue;
                    if (candidateAge <= minAgeFriends) continue;
                    counter += candidates*persons;
                }
            }
        }

        return counter;
    }

    class Counter{
        int count;

        Counter(){
            this.count = 1;
        }

        public int getCount(){
            return count;
        }

        public void increment(){
            this.count++;
        }

        public void setCount(int num){
            this.count += num;
        }
    }

    @Test
    public void test(){

//        Assert.assertEquals(numFriendRequests(new int[]{16,16}), 2);
        Assert.assertEquals(numFriendRequests(new int[]{73,106,39,6,26,15,30,100,71,35,46,112,6,60,110}), 29);
        Assert.assertEquals(numFriendRequests(new int[]{16,17,18}), 2);
        Assert.assertEquals(numFriendRequests(new int[]{20,30,100,110,120}), 3);

    }
}
