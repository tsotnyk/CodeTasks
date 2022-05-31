package slidingWindov.maxSumSubarrayOfSizeK;

public class Solution {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int sum;

        for (int i = 0; i < k; i++){
            maxSum += arr[i];
        }

        sum = maxSum;

        for (int i = k; i < arr.length; i++){
            sum -= arr[i-k];
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
