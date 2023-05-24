package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IsTheSameStringWithOneAction {

    public boolean isTheSameStringWithOneAction(String first, String second){

        if (first == null || second == null) throw new IllegalArgumentException();
        if (Math.abs(first.length() - second.length()) > 1) return false;

        return isTheSame(first, second, 0, 0, 0);
    }

    private boolean isTheSame(String first, String second, int index1, int index2, int changes) {
        if (changes > 1) return false;
        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) == second.charAt(index2)) {
                index1++;
                index2++;
            } else {
                if (isTheSame(first, second, index1+1, index2+1, changes+1)) return true;
                if (isTheSame(first, second, index1+1, index2, changes+1)) return true;
                return  (isTheSame(first, second, index1, index2+1, changes+1));
            }
        }

        return index1 == first.length() && index2 == second.length() || changes == 0;
    }

    @Test
    public void test(){

        Assert.assertTrue(isTheSameStringWithOneAction("pale", "ple"));
        Assert.assertTrue(isTheSameStringWithOneAction("pales", "pale"));
        Assert.assertTrue(isTheSameStringWithOneAction("pale", "bale"));
        Assert.assertFalse(isTheSameStringWithOneAction("pale", "bake"));
    }
}
