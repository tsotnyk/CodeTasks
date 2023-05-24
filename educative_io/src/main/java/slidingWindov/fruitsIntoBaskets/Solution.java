package slidingWindov.fruitsIntoBaskets;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution {

    public static int findLength(char[] arr) {
        // TODO: Write your code here
        HashMap<Character, Integer> fruitsMap = new HashMap<>();

        int iS = 0;
        int iE = 0;
        int maxFruits = 0;

        while (iE < arr.length){
            char tree = arr[iE++];
            fruitsMap.put(tree, fruitsMap.getOrDefault(tree, 0)+1);
            if (fruitsMap.size() > 2){
                while (fruitsMap.size() > 2){
                    char removeTree = arr[iS++];
                    int count = fruitsMap.get(removeTree);
                    if (count == 1){
                        fruitsMap.remove(removeTree);
                    }else {
                        fruitsMap.put(removeTree, count-1);
                    }
                }
            }
            maxFruits = Math.max(maxFruits, iE-iS);
        }

        return maxFruits;
    }

    @Test
    public void test(){

        Assert.assertEquals(3, findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        Assert.assertEquals(5, findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
