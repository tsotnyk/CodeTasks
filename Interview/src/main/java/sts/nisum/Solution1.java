package sts.nisum;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1 {

    // O(banned.length + in.length)
    public String findMostFreqString(String in, String[] banned){

        HashSet<String > bannedSet = new HashSet<>();

        // O(n)
        for (String word : banned){
            bannedSet.add(word.toLowerCase());
        }

        // O(in.length)
        return createWordMap(in, bannedSet);


//        // O(k) k - amount of uniq word in input data
//        for (Map.Entry<String,Integer> entry : wordMap.entrySet()){
//
//            if (entry.getValue() > count){
//                count = entry.getValue();
//                word = entry.getKey();
//            }
//        }

//        return word;
    }

    // O(in.length)
    private String createWordMap(String in, HashSet<String> bannedSet){

     //    "Bob hit a ball, the hit BALL flew far after it was hit."
        int iS= 0;
        int iE = 0;
        int counter = 0;
        String result = "";

        HashMap<String, Integer> map = new HashMap<>();

        // O(in.length)
        while (iE < in.length()){

            if (!Character.isAlphabetic(in.charAt(iE)) && iS == iE){
                iS = iE+1;
                iE = iS;
            }

            if (Character.isAlphabetic(in.charAt(iE))){
                iE++;
                continue;
            }

            String word = in.substring(iS, iE);
            // O(in.length)
            word = word.toLowerCase();

            if (!bannedSet.contains(word)){

                int curC = map.getOrDefault(word, 0)+1;
                map.put(word, curC);
                if (curC > counter){
                    result = word;
                    counter = curC;
                }
            }

            iS = iE+1;
            iE = iS;
        }

        String word = in.substring(iS);
        word = word.toLowerCase();

        int curC = map.getOrDefault(word, 0)+1;
        map.put(word, curC);
        if (curC > counter){
            result = word;
            counter = curC;
        }

        return result;
    }




}
