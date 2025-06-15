package faang.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String s) {

        int[] counter = new int[26];
        char mostProvLetter = ' ';
        int maxCount = 0;

        for (char symbol : s.toCharArray()){
            int index = symbol-'a';
            counter[index] += 1;
            if (counter[index] > maxCount){
                maxCount = counter[index];
                mostProvLetter = symbol;
            }
        }

        if (maxCount > (s.length()+1)/2) return "";

        int index = 0;
        char[] res = new char[s.length()];
        while (index < s.length()){
            res[index] = mostProvLetter;
            maxCount--;
            index = index+2;
            if (maxCount == 0) break;
        }
        counter[mostProvLetter-'a'] = 0;

//        while ()


        return new String(res);
    }
}
