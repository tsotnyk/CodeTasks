package interview;

import java.util.*;

public class AmazonAssessment {


    public static int getMinimumDays1(List<Integer> parcels) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>(parcels);

        return set.size();
    }



    /*

    Code question 1.

    Amazon Delivery Center dispatch parcels every day. There are n delivery centers, each having parcels[i] parcels to
    be delivered. On each day, an equal number of parcels are to be dispatched from each delivery center that has at
    least one parcel remaining.

    Find the minimum number of days needed to deliver all the parcels.

    Example:

    parcels = [2,3,4,3,3]

    Day1: 2 parcels are delivered from each center - [0,1,2,1,1]
    Day2: 1 parcel is delivered from the remaining centers - [0,0,1,0,0]
    Day3: 1 parcel is delivered from the remaining centers - [0,0,0,0,0]

    All parcels can be delivered in a min of 3 days.



    Code question 2

    Amazon is developing s string processing library for some of its NLP-related use cases.You are tasked with developing
    a service that takes in a string consisting of lower case English letters and returns an integer.

    More formally, given a string, we define the frequency deviation of a substring as the difference between the max and
    min frequencies of the characters in the substring. A substring of a string is formed by any contiguous segment of
    the string. For example, given "bbacccc", the character appearing most frequently is 'c' with 4 occurrences. The
    characters the fewest times is 'a' with 1 occurrence. The frequency deviation of the entire string is 4-1=3.
    Given a string s, representing the input string, find the max possible frequency deviation of any substring of the
    string.

    Example:

    s is "aabb"

    All distinct substring are considered below.
    - "a" - both values are 1, and 1-1 = 0
    - "b" - has a frequency deviation of 0
    - "ab" - has a frequency deviation of 0
    - "aabb" - has a frequency deviation of 0
    - "aab" - has a frequency deviation of 1
    - "abb" - has a frequency deviation of 1

    The max possible range is 1

    Example1

    input - "bbacccabab"
    output - 2

    Example2

    input - "aaaaaaaa"
    output - 0
     */

    public static int getMaxFreqDeviation(String s) {
        // Write your code here

        HashMap<String, Integer> map = new HashMap<>();
        int maxDiff = findMaxDeviation(s);
        map.put( s, maxDiff);
        int length = s.length();
        for (int i = 0; i < length; i++){

            if (length-i < maxDiff) break;
            String sub1 = s.substring(i, length);
            String sub2 = s.substring(0, length-i);
            int dif1 = map.getOrDefault(sub1, findMaxDeviation(sub1));
            int dif2 = map.getOrDefault(sub2, findMaxDeviation(sub1));
            map.put(sub1, dif1);
            map.put(sub2, dif2);
            maxDiff = Math.max(maxDiff, Math.max(dif1, dif2));
        }
        return maxDiff;
    }


public static int findMaxDeviation(String s){

    Map<Character, Integer> map = new HashMap<>();

    for (char symbol : s.toCharArray()){
        map.put(symbol, map.getOrDefault(symbol, 0)+1);
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (char name : map.keySet()){
        int value = map.get(name);
        max = Math.max(max, value);
        min = Math.min(min, value);
    }

    return max - min;
}


    public static int getMaxFreqDeviation1(String s) {
        // Write your code here

        int maxDiff = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                maxDiff = Math.max(countDiff(s.substring(i, j), hashMap), maxDiff);
            }
        }

        return maxDiff;
    }

    private static int countDiff(String s, HashMap<String, Integer> hashMap){

        if (hashMap.containsKey(s)) return hashMap.get(s);

        Map<Character, Integer> map = new HashMap<>();

        for (char symbol : s.toCharArray()){
            map.put(symbol, map.getOrDefault(symbol, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (char name : map.keySet()){
            int value = map.get(name);
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        int diff = max - min;

        hashMap.put(s, diff);
        return diff;
    }
}
