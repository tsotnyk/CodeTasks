package com.j2core.sts.leetcode.com.bullsAndCows;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String getHint(String secret, String guess) {

        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();

        int a = 0;
        int b = 0;

        for (int i = 0; i < secretArray.length; i++){

            if (secretArray[i] == guessArray[i]){

                secretArray[i] = 'A';
                guessArray[i] = 'A';
                a++;
            }
        }

        Map<Character, Integer> map = createMap(secretArray);

        for (char character : guessArray){

            if (character != 'A'){

                Integer count = map.get(character);
                if (count != null){

                    if (count > 0){
                        b++;
                        map.put(character, count-1);
                    }
                }
            }
        }

        return a+"A"+b+"B";
    }

    private Map<Character, Integer> createMap(char[] secret){

        Map<Character, Integer> result = new HashMap<>();

        for (char character : secret){

            if (character != 'A'){

                if (result.containsKey(character)){
                    result.put(character, result.get(character)+1);
                }else {
                    result.put(character, 1);
                }
            }
        }

        return result;
    }
}
