package com.j2core.sts.intreviewbit.com.largestNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {

        List<List<Integer>> tmpResult = permutationString(A);

        List<String> stringList = new LinkedList<>();

        for (List<Integer> numList : tmpResult){

            StringBuilder builder = new StringBuilder();

            for (Integer num : numList){

                builder.append(num);

            }

            stringList.add(builder.toString());
        }

        Collections.sort(stringList);

        return stringList.get(stringList.size()-1);

    }


    private List<List<Integer>> permutationString(final int[] A){

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(A[0]);
        resultList.add(tmp);

        for (int i = 1; i < A.length; i++){
            List<List<Integer>> tmpList = new ArrayList<>();

            while (!resultList.isEmpty()) {
                List<Integer> tmpStr = resultList.remove(0);

                for (int k = 0; k <= tmpStr.size(); k++){

                    int index = 0;
                    List<Integer> list = new ArrayList<>();
                    for(int l = 0; l <= tmpStr.size(); l++){
                        if(k == l){
                            list.add(A[i]);
                        }else {
                            list.add(tmpStr.get(index));
                            index++;
                        }
                    }
                    tmpList.add(list);
                }
            }

            resultList = tmpList;
        }
        return resultList;
    }

    @Test
    public void test(){


        String tn= largestNumber(new int[]{472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412});

        Assert.assertEquals(tn, "9648527226766636354854724412368319");

    }


}
