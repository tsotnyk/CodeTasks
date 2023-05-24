package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IsUnique {

    public boolean isUnique(String input){

        if (input == null) throw new IllegalArgumentException();
        if (input.length() < 2) return true;
        if (input.length() > 128) return false;
        boolean[] alphabet = new boolean[126];

        for (char symbol : input.toCharArray()){

            int index = (int) symbol - 'A';
            if (alphabet[index]) return false;
            alphabet[index] = true;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isUnique("asdfghjkl"));
        Assert.assertTrue(isUnique("asdfghjklASDFGHJKL"));
        Assert.assertFalse(isUnique("asdASDa"));
    }
    
}
