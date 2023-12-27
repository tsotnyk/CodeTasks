package com.j2core.sts.leetcode.com.arrays.coinChange2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int coinChange(int[] coins, int amount) {

        int[] res = new int[amount+1];

        for (int i = 1; i < amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (i < coins[i]) break;
                int index = i - coins[j];

            }
        }

        return res[amount];

    }

//    public int solution(int N, String S) {
//
//        HashMap<Integer, HashSet<Character>> reservedSeats = createReservedSeatMap(S);
//
//        int result = (N - reservedSeats.size()) * 2;
//
//        for (HashSet<Character> rowResSeats : reservedSeats.values()){
//            boolean flag = false;
//
//            if (!rowResSeats.contains('B') && !rowResSeats.contains('C') && !rowResSeats.contains('D') && !rowResSeats.contains('E')){
//                result++;
//                flag = true;
//            }
//            if (!rowResSeats.contains('F') && !rowResSeats.contains('G') && !rowResSeats.contains('H') && !rowResSeats.contains('J')){
//                result++;
//                flag = true;
//            }
//            if (!flag && !rowResSeats.contains('D') && !rowResSeats.contains('E') && !rowResSeats.contains('F') && !rowResSeats.contains('G')){
//                result++;
//
//            }
//        }
//
//        return result;
//    }
//
//    private HashMap<Integer, HashSet<Character>> createReservedSeatMap(String S){
//
//        HashMap<Integer, HashSet<Character>> reservedSeats = new HashMap<>();
//
//        if (S.isEmpty()) return reservedSeats;
//        String[] seats = S.split(" ");
//
//        for (String position : seats){
//            int row = 0;
//            int i = 0;
//            while (Character.isDigit(position.charAt(i))){
//                row  = (row*10) + position.charAt(i)-'0';
//                i++;
//            }
//            char seat = position.charAt(i);
//
//
//            HashSet<Character> resSeats = reservedSeats.getOrDefault(row, new HashSet<>());
//            resSeats.add(seat);
//
//            reservedSeats.put(row, resSeats);
//        }
//
//        return reservedSeats;
//    }

    public String solution(String message, int K) {
        // Implement your solution here
        if (message.length() <= K) return message;

        String[] words = message.split(" ");
        StringBuilder notification = new StringBuilder();
        int spaceLeft = K-3;

        for (String word : words){
            if (word.length()+1 > spaceLeft) break;
            notification.append(word).append(" ");
            spaceLeft -= word.length()+1;
        }

        notification.append("...");

        return notification.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(solution("And now here is my secret", 15), "And now ...");
        Assert.assertEquals(solution("There is an animal with four legs", 15), "There is an ..." );
        Assert.assertEquals(solution("super dog", 4), "...");
        Assert.assertEquals(solution("how are you", 20), "how are you");
    }
}
