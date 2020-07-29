package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1_9 {

    public boolean isRotationString(String base, String rotate){

        if (base == null && rotate == null) return true;
        if (base == null || rotate == null) return false;
        if (base.length() != rotate.length()) return false;

        char firstLetter = base.charAt(0);
        int index = rotate.indexOf(firstLetter);

        while (index > -1){

            int tmpIndex = index;
            boolean isRotate = true;
            for (int i = 0; i < base.length(); i++){
                if (tmpIndex == base.length()){
                    tmpIndex = 0;
                }
                if (base.charAt(i) != rotate.charAt(tmpIndex++)){
                    isRotate = false;
                    break;
                }
            }
            if (isRotate) return true;
            index = rotate.indexOf(firstLetter, index+1);
        }

        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(isRotationString(null, null));
        Assert.assertFalse(isRotationString(null, " "));
        Assert.assertFalse(isRotationString("null", null));
        Assert.assertFalse(isRotationString("null", "df"));
        Assert.assertFalse(isRotationString("null", "qwer"));
        Assert.assertFalse(isRotationString("null", "nnnn"));
        Assert.assertTrue(isRotationString("null", "ulln"));
        Assert.assertTrue(isRotationString("null", "null"));
        Assert.assertTrue(isRotationString("nullnullnull", "ullnullnulln"));
        Assert.assertTrue(isRotationString("qqwweerrttyyuuiioopp", "rrttyyuuiiooppqqwwee"));

    }
}
