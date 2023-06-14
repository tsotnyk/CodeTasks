package Hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAccompanyHealth {


    public static int findDifferenceValue(String firstString, String secondString) {
        // Write your code here

        ArrayList<List<Integer>> m = new ArrayList<>(secondString.length());

        for (int k = 0; k < secondString.length(); k++){
            m.add(new LinkedList<>());
        }

        for (int i = 0; i < firstString.length(); i++){
            for (int j = 0; j < secondString.length(); j++){
                if (secondString.charAt(j) == firstString.charAt(i)){
                    m.get(j).add(i);
                }
            }
        }

        AtomicInteger best = new AtomicInteger(secondString.length());

        // todo

        return best.get();

    }

    private static void getScore(int left, int right){


    }

}
