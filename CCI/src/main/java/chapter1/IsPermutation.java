package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IsPermutation {

    public boolean isPermutation(String base, String secondary){

        if (base == null || secondary == null) throw new IllegalArgumentException();
        if (base.length() != secondary.length()) return false;
        if (base.length() == 0) return true;
        int[] alphabet = new int[128];

        for (int symbol : base.toCharArray()){
            int index = symbol - 'A';
            alphabet[index] += 1;
        }

        for (int symbol : secondary.toCharArray()){
            int index = symbol - 'A';
            if (alphabet[index] == 0) return false;
            alphabet[index] -= 1;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPermutation("assd", "sdas"));
        Assert.assertFalse(isPermutation("", "q"));
    }
}
