package com.j2core.sts.codefights.com.codeInterview.thumbtack;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution6 {

    String categoryRecommendations(String[][] requestData, String[] proSelections) {

        HashMap<String, List<Double>> result = new HashMap<>();

        for (String[] request : requestData){
            int counter = 0;
            HashSet<String> set = new HashSet<>(Arrays.asList(request));
            for (String pro : proSelections) {
                if (set.contains(pro)){
                    counter++;
                    set.remove(pro);
                }
            }
            double delta = (double) counter/ (request.length+proSelections.length-counter);
            for (String pro : set){
                if (result.containsKey(pro)){
                    result.get(pro).add(delta);
                }else {
                    result.put(pro, new LinkedList<>(Collections.singletonList(delta)));
                }
            }
        }

        double max = 0.0;
        String proPoten = "";

        for (Map.Entry<String, List<Double>> entry : result.entrySet()){

            List<Double> list = entry.getValue();
            double sum = 0;

            for (double num : list){

                sum += num;
            }
            sum /= list.size();
            if (sum > max){
                proPoten = entry.getKey();
                max = sum;
            }else if(sum == max && proPoten.compareTo(entry.getKey()) > 0){
                proPoten = entry.getKey();
            }
        }

        return proPoten;
    }

    @Test
    public void test(){

        Assert.assertEquals("Auctioneering", categoryRecommendations(
                new String[][]{{"Accounting", "Bodyguard"},{"Accounting", "Auctioneering"}}, new String[]{"Accounting"}));

        Assert.assertEquals("Administrative Support", categoryRecommendations(new String[][]{{"Accounting", "Administrative Support", "Advertising",
                "Bodyguard", "Auctioneering"},
                {"Accounting", "Administrative Support"},
                {"Advertising", "Auctioneering", "Bodyguard"},
                {"Bodyguard", "Services Business", "Consulting"}}, new String[]{"Accounting", "Advertising"}));
    }
}
