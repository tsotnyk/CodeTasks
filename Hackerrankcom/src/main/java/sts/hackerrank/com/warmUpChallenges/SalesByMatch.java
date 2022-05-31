package sts.hackerrank.com.warmUpChallenges;

import java.util.HashMap;
import java.util.List;

public class SalesByMatch {

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int sock : ar){
            map.put(sock, map.getOrDefault(sock, 0)+1);
        }

        int counter = 0;

        for (int color : map.keySet()){
            counter += map.get(color)/2;
        }

        return counter;
    }
}
