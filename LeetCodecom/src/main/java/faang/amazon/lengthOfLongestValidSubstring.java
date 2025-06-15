package faang.amazon;

import java.util.HashMap;
import java.util.List;

public class lengthOfLongestValidSubstring {

    public int longestValidSubstring(String word, List<String> forbidden) {

        HashMap<String, int[]> forbiddenMap = createForbiddenMap(forbidden);
        HashMap<String, Integer> subStringMap = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < word.length(); i++){

            int[] arr = new int[26];

            for (int j = i; j < word.length(); j++){
                String subString = word.substring(i, j+1);
                if (subStringMap.containsKey(subString)){
                    continue;
                }

                int index = word.charAt(j) - 'a';
                arr[index] += 1;

                if (wordNotContaineForbiddenSymbols(arr, forbiddenMap)){
                    if (validWord(subString, forbiddenMap)){
                        int length = j-i+1;
                        maxLength = Math.max(maxLength, length);
                        subStringMap.put(subString, length);
                    }
                }
            }

        }

        return maxLength;
    }

    private boolean validWord(String subString, HashMap<String, int[]> forbiddenMap) {

        return false;
    }

    private boolean wordNotContaineForbiddenSymbols(int[] subString, HashMap<String, int[]> forbiddenMap) {

        return false;
    }

    private HashMap<String,int[]> createForbiddenMap(List<String> forbidden) {

        HashMap<String, int[]> map = new HashMap<>();

        for (String word : forbidden){

            int[] arr = new int[26];

            for (char symbol : word.toCharArray()){
                int index = symbol - 'a';
                arr[index] += 1;
            }

            map.put(word, arr);
        }

        return map;
    }
}
