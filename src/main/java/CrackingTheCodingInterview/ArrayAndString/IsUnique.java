package CrackingTheCodingInterview.ArrayAndString;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IsUnique {

    public boolean isAllSymbolUnique(String input){

        if (input == null) return false;
        if (input.length() < 2) return true;
        boolean[] symbolList = new boolean[256];

        for (char symbol : input.toCharArray()){

            int index = symbol - 'A';
            if(symbolList[index]) return false;
            symbolList[index] = true;
        }
        return true;
    }

    @Test
    public void test1(){

        Assert.assertTrue(isAllSymbolUnique(""));
        Assert.assertTrue(isAllSymbolUnique("a"));
        Assert.assertTrue(isAllSymbolUnique("as"));
        Assert.assertTrue(isAllSymbolUnique("asoiutqevbnSDHJKUYTR"));
        Assert.assertFalse(isAllSymbolUnique(null));
        Assert.assertFalse(isAllSymbolUnique("qq"));
        Assert.assertFalse(isAllSymbolUnique("kjhfdASDFGKJHH"));

    }
}


