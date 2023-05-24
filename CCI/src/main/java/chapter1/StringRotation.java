package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringRotation {

    public boolean isStringRotation(String str1, String str2){

        if (str1 == null || str2 == null) throw  new IllegalAccessError();
        if (str1.length() != str2.length()) return false;

        return isSubstring(str1+str1, str2);
    }

    public boolean isSubstring(String base, String substring){

        for (int i = 0; i <= base.length()-substring.length(); i++){

            int index = i;
            boolean isSub = true;
            for (int j = 0; j < substring.length(); j++){
                if (base.charAt(index++) != substring.charAt(j)){
                    isSub = false;
                    break;
                }
            }
            if (isSub) return true;
        }

        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(isSubstring("asdasdasd", "sdasd"));
        Assert.assertTrue(isStringRotation("waterbottle", "erbottlewat"));
    }
}
