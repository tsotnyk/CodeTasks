package CrackingTheCodingInterview.ArrayAndString;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckPermutation {

    public boolean isPermutation(String str1, String str2){

        if(str1 == null &&str2 == null) return true;
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;

        int[] symbList = new int[256];

        for (char symb : str1.toCharArray()){
            int index = symb - 'A';
            symbList[index] += 1;
        }

        for (char symb : str2.toCharArray()){
            int index = symb - 'A';
            if (symbList[index] == 0) return false;
            symbList[index] -= 1;
        }

        return true;
    }

    @Test
    public void test1(){

        Assert.assertTrue(isPermutation(null, null));
        Assert.assertTrue(isPermutation("", ""));
        Assert.assertTrue(isPermutation("a", "a"));
        Assert.assertTrue(isPermutation("qwertyuiop", "poiuytrewq"));
        Assert.assertFalse(isPermutation(null, ""));
        Assert.assertFalse(isPermutation("", null));
        Assert.assertFalse(isPermutation("", "sfsfdf"));
        Assert.assertFalse(isPermutation("sfsfds", "sfsfdf"));

    }
}
