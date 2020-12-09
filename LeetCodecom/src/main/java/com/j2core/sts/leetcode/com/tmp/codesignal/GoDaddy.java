package com.j2core.sts.leetcode.com.tmp.codesignal;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GoDaddy {

    String[] domainType(String[] domains) {

        String[] result = new String[domains.length];
        int index = 0;
        for (String url : domains){
            int indexDomain = url.lastIndexOf('.');
            String domainType = null;
            switch (url.substring(indexDomain)){
                case ".com":
                    domainType = "commercial";
                    break;
                case ".org":
                    domainType = "organization";
                    break;
                case ".net":
                    domainType = "network";
                    break;
                case ".info":
                    domainType = "information";
                    break;
            }
            result[index++] = domainType;
        }

        return result;
    }

    int reorderingOfProducts(ArrayList<Integer> boundaries, int y) {
        final int INF = Integer.MAX_VALUE;
        boundaries.add(0, -INF);
        int l = 0;
        int r = boundaries.size() - 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (boundaries.get(mid) < y) {
                l = mid;
            }else {
                r = mid;
            }
        }
        return l;
    }

    @Test
    public void test(){

//        Assert.assertEquals(reorderingOfProducts(new ArrayList<>(Arrays.asList(0,10,50,100,120)), 45), 2);
        Assert.assertEquals(reorderingOfProducts(new ArrayList<>(Arrays.asList(0,10,50,100,120)), 110), 3);


    }
}
