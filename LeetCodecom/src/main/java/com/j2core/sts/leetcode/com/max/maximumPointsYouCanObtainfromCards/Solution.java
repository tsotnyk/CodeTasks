package com.j2core.sts.leetcode.com.max.maximumPointsYouCanObtainfromCards;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxScoreNotCorrect(int[] cardPoints, int k) {

        int sum = 0;
        if (k == cardPoints.length){
            for (int num : cardPoints){
                sum += num;
            }
        }else {

            int indexStart = 0;
            int indexEnd = cardPoints.length-1;

            while (k-- > 0){
                if (cardPoints[indexStart] == cardPoints[indexEnd]){
                    int start = indexStart+1;
                    int end = indexEnd-1;
                    while (start < end && cardPoints[start] == cardPoints[end]){
                        start++;
                        end--;
                    }
                    if (start < end){
                        if (cardPoints[indexStart] > cardPoints[indexEnd]){
                            sum += cardPoints[indexStart++];
                        }else {
                            sum += cardPoints[indexEnd--];
                        }
                    }else {
                        sum += cardPoints[indexStart++];
                    }
                }else {
                    if (cardPoints[indexStart] > cardPoints[indexEnd]){
                        sum += cardPoints[indexStart++];
                    }else {
                        sum += cardPoints[indexEnd--];
                    }
                }
            }
        }
        return sum;
    }

    public int maxScoreTLE(int[] cardPoints, int k) {

        if (k == cardPoints.length){
            int sum = 0;
            for (int num : cardPoints){
                sum += num;
            }
            return sum;
        }
        return Math.max(maxScore(cardPoints, 1, cardPoints.length-1, k-1, cardPoints[0]),
                maxScore(cardPoints, 0, cardPoints.length-2, k-1, cardPoints[cardPoints.length-1]));
    }

    private int maxScore(int[] points, int start, int end, int k, int sum){

        if (k == 0) return sum;

        if (k == 1){
            return sum+Math.max(points[start], points[end]);
        }else {
            return Math.max(maxScore(points, start+1, end, k-1, sum+points[start]),
                    maxScore(points, start, end-1, k-1, sum+ points[end]));
        }
    }

    public int maxScore(int[] cardPoints, int k) {

        int maxScore = 0;
        int indexLeft = -1;
        int indexRight = cardPoints.length-1;

        while (indexLeft < k-1){
            indexLeft++;
            maxScore += cardPoints[indexLeft];
        }

        int score = maxScore;
        while (k-- > 0){
            score -= cardPoints[indexLeft--];
            score += cardPoints[indexRight--];
            maxScore = Math.max(score, maxScore);
        }

        return maxScore;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxScore(new int[]{11,49,100,20,86,29,72}, 4), 232);
        Assert.assertEquals(maxScore(new int[]{1,2,3,4,5,6,1}, 3), 12);
        Assert.assertEquals(maxScore(new int[]{2,2,2}, 2), 4);
        Assert.assertEquals(maxScore(new int[]{9,7,7,9,7,7,9}, 7), 55);
        Assert.assertEquals(maxScore(new int[]{1,1000,1}, 1), 1);
        Assert.assertEquals(maxScore(new int[]{1,79,80,1,1,1,200,1}, 3), 202);

    }
}
