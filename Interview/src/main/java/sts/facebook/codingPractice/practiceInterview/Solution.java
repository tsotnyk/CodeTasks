package sts.facebook.codingPractice.practiceInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Solution {


    List<int[]> aboveAverageSubarrays(int[] A){

        List<int[]> result = new LinkedList<>();
        int sum1 = 0;
        int sum2;
        for (int num : A){
            sum1 += num;
        }

        for (int i = 0; i < A.length-1; i++){
            sum2 = 0;
            for (int j = i; j < A.length; j++){
                sum2 += A[j];
                int subArrayLength = j-i+1;
                if (subArrayLength == A.length){
                    result.add(new int[]{i+1, j+1});
                }else if (sum2/subArrayLength > (sum1-sum2)/(A.length-subArrayLength)){
                    result.add(new int[]{i+1, j+1});
                }
            }
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(aboveAverageSubarrays(new int[]{3,4,2}).size(), 3);
    }

    int[] answerQueriesSet(ArrayList<Query> queries, int N){

        TreeSet<Integer> mapTrueValue = new TreeSet<>();
        int[] result = new int[queries.size()];
        int index = 0;

        for (Query query : queries){
            if (query.data[0] == 1){
                mapTrueValue.add(query.data[1]);
            }else {
                int tmpIndex = -1;
                if (mapTrueValue.contains(query.data[1])){
                    tmpIndex = query.data[1];
                } else {
                    Integer value = mapTrueValue.higher(query.data[1]);
                    if (value != null){
                        tmpIndex = value;
                    }
                }
                result[index++] = tmpIndex;
            }
        }

        return result;
    }

    int[] answerQueries(ArrayList<Query> queries, int N){

        boolean[] array = new boolean[N];
        int[] result = new int[queries.size()];
        int index = 0;

        for (Query query : queries){
            if (query.data[0] == 1){
                array[query.data[1]] = true;
            }else {
                int tmpIndex = -1;
                for (int i = query.data[1]; i < array.length; i++){
                    if (array[i]){
                        tmpIndex = i;
                        break;
                    }
                }
                result[index++] = tmpIndex;
            }
        }

        return result;
    }
}

class Query{

    int[] data;
    public Query(int[] data){
        this.data = data;
    }
}
