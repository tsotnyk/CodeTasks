package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PalindromePermutation {

    public boolean isPalindromePermutation(String input){

        if (input == null) throw new IllegalArgumentException();
        if (input.length() < 2) return true;

        boolean[] alphabet = new boolean[128];

        for (char symbol : input.toCharArray()){
            if (symbol == ' ') continue;
            int index = symbol - 'A';
            alphabet[index] = !alphabet[index];
        }

        int counter = 0;
        for (boolean value : alphabet){
            if (value){
                counter++;
            }
            if (counter > 1) return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPalindromePermutation("taco cat"));
    }
}
