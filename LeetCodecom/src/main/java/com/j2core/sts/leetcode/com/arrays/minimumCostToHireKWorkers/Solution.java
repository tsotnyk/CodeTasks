package com.j2core.sts.leetcode.com.arrays.minimumCostToHireKWorkers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n=wage.length;
        double[][] val= new double[n][2];
        for (int i=0; i<n; i++) val[i]=new double[]{(double)wage[i]/quality[i], wage[i]*1.0, quality[i]*1.0};
        Arrays.sort(val, (a,b)->Double.compare(b[0], a[0]));
        LinkedList<double[]> pq= new LinkedList<>();
        for (double[] d: val) pq.add(d);
        Collections.sort(pq, (a,b)->Double.compare(a[2],b[2]));
        double res=Integer.MAX_VALUE;
        for (int cs=0; cs<=n-K; cs++){
            double r= val[cs][0], temp= val[cs][1];
            pq.remove(val[cs]);
            int sz=K-1;
            for (double[] d: pq){
                if (sz--==0) break;
                temp+=r*d[2];
            }
            res=Math.min(res, temp);
        }
        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(mincostToHireWorkers(new int[]{3,1,10,10,1}, new int[]{4,8,2,2,7}, 3), 30.66667, 0.0001);
    }

}
