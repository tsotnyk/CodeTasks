package sts.airbnb.test1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Solution {

    //1
    public static List<String> doesCircleExist(List<String> commands) {
        // Write your code here


        return null;

    }

    //2
    private static int isPresent(Node root, int val){

        if (root == null) return 0;
        if (root.data == val) return 1;

        if (root.data < val){
            return isPresent(root.right, val);
        }else {
            return isPresent(root.left, val);
        }
    }

    class Node {
        Node left, right;
        int data;
        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    //3
    static String[] triangleOrNot(int[] a, int[] b, int[] c) {

        String[] result = new String[a.length];

        for (int i = 0; i < a.length; i++){

            boolean flag = true;
            if (a[i]+b[i] <= c[i]){
                flag = false;
            }
            if (flag && b[i] + c[i] <= a[i]){
                flag = false;
            }
            if (flag && a[i] + c[i] <= b[i]){
                flag = false;
            }
            if (flag){
                result[i] = "Yes";
            }else {
                result[i] = "No";
            }
        }

        return result;
    }

    @Test
    public void test3(){

        Assert.assertEquals(triangleOrNot(new int[]{7,10,7}, new int[]{2,3,4}, new int[]{2,7,4}), new String[]{"No", "No", "Yes"});
    }

    //4
    public static int consecutive(long num) {
        // Write your code here

        int counter = 0;
        int maxValue = (int)(Math.sqrt(2 * num + 0.25) - 0.5);
        for (int i = 1; i <= maxValue; ++i) {
            num -= i;
            if (num % i == 0)
                counter++;
        }
        return counter-1;


//        if (num < 3) return 0;
//
//        int counter = 0;
//        long half = (num/2) +1;
//        long prevNum = half-1;
//        long sum = half + prevNum--;
//
//        while (sum >= num){
//
//            if (sum == num){
//                counter++;
//            }
//            sum -= half--;
//            while (prevNum > 0 && sum < num){
//                sum += prevNum--;
//            }
//        }
//
//        return counter;
//
//        int counter = 0;
//        long startNum = 1;
//        long endNum = 1;
//        long sum = 0;
//
//        while (startNum <= num/2){
//            if (sum > num){
//                sum -= startNum++;
//            }else{
//                if (sum == num){
//                    counter++;
//                    while (startNum <= endNum/2){
//                        sum -= startNum++;
//                    }
//                }
//                sum += endNum++;
//
//            }
//        }
//
//        return counter;
    }

    @Test
    public void test4(){

//        Assert.assertEquals(consecutive(10), 1);
        Assert.assertEquals(consecutive(15), 3);
        Assert.assertEquals(consecutive(21), 3);
    }
}
