package com.j2core.sts.codefights.com.dataStructures.treesBasic.findProfession;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    String findProfession(int level, int pos) {

        String str1 = "Engineer";
        String str2 = "Doctor";

        if (level == 1){

            return str1;

        }else {

            if (pos == 1){

                return str1;

            }else if (pos == 2){

                return str2;

            }else {

                int result = -1;

                int[] data = new int[3];
                data[0] = 1;
                data[1] = level;
                data[2] = pos;

                while (result == -1){

                    result = trimLevel(data);

                }

                return result == 1 ? str1 : str2;
            }

        }
    }


    private int trimLevel(int[] data){

        int head = data[0];
        int level = data[1];
        int pos = data[2];

        if (pos == 1){

            return head;

        }else if (pos == 2){

            if (head == 1){

                return 2;

            }else return 1;

        }else {

            long amountHalfChildren = 2;

            for (int i = 1; i < level-1; i++) {

                amountHalfChildren = amountHalfChildren * 2;

            }

            if (pos > amountHalfChildren) {

                if (head == 1){
                    data[0] = 2;
                }else data[0] = 1;

                data[2] = (int) (pos - amountHalfChildren);

            }

            data[1] = level - 1;

            return -1;

        }

    }

    @Test
    public void test(){

        String result = findProfession(8, 100);

        Assert.assertEquals(result, "Engineer");
    }
}
