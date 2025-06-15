package prepInterviewPayPl;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {

        HashMap<Character, Integer> charsMap = new HashMap<>();

        for (char symbol : chars.toCharArray()){

            charsMap.put(symbol, charsMap.getOrDefault(symbol, 0)+1);
        }
        int sum = 0;
        for (String word : words){
            if (canCreate(word, charsMap)){
                sum += word.length();
            }

        }

        return sum;
    }

    private boolean canCreate(String word, HashMap<Character, Integer> charsMap) {

        HashMap<Character, Integer> charWordMap = new HashMap<>();

        for (char symbol : word.toCharArray()){
            charWordMap.put(symbol, charWordMap.getOrDefault(symbol, 0)+1);
        }

        for (Map.Entry<Character, Integer> entry : charWordMap.entrySet()){
            if (!charsMap.containsKey(entry.getKey())) return false;
            if (charsMap.get(entry.getKey()) < entry.getValue()) return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"), 6);
    }
}
