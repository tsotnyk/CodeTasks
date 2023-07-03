package slidingWindow;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RepeatedDNASequences {

    public static Set<String> findRepeatedSequences1(String s, int k) {


        HashSet<String> single = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (int i = k;  i <= s.length(); i++){
            String pattern = s.substring(i-k, i);
            if (!single.add(pattern)){
                repeated.add(pattern);
            }
        }
        // Your code will replace this placeholder return statement
        return repeated;
    }

    public static Set<String> findRepeatedSequences(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        HashSet<String> repeated = new HashSet<>();

        int[] numbers = new int[s.length()];

        for (int i = 0; i < numbers.length; i++){

            numbers[i] = map.get(s.charAt(i));
        }
        int a = 4;

        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();
        int hashValue = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {

            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers[j] * (int) Math.pow(a, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = ((previousHashValue - numbers[i - 1] * (int) Math.pow(a, k - 1)) * a) + numbers[i + k - 1];
            }

            if (hashSet.contains(hashValue)) {
                output.add(s.substring(i, i + k));
            }

            hashSet.add(hashValue);

        }

        return output;
    }

    @Test
    public void test(){

        Set<String> result = findRepeatedSequences("AGCTGAAAGCTTAGCTG", 5);
        Assert.assertEquals(result.size(), 1);
    }

    
}
