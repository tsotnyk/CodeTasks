package topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static String reorganizeString(String str) {

        Map<Character, Integer> charCounter = new HashMap<>();

        // Calculate the frequency of characters in string and store counts
        // of each character along with the character itself in hash map.
        for (char c: str.toCharArray()) {
            charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
        }
        // initializing max heap
        PriorityQueue<Map.Entry<Character, Integer>> maxFreqChars = new PriorityQueue <Map.Entry<Character, Integer>> (
                (item1, item2) -> item2.getValue() - item1.getValue());

        // store all characters with their frequencies to the max heap
        maxFreqChars.addAll(charCounter.entrySet());

        System.out.println(maxFreqChars);
        return maxFreqChars.toString();
    }
}
