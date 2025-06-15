package prepInterviewMeta;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int i = nums.length - 1;

        if (nums[i] > nums[i - 1]) {
            swap(nums, i, i - 1);
            return;
        } else {
            int k = i;

            while (i > 0 && nums[i - 1] >= nums[i]) {
                i--;
            }

            rev(nums, i, k);

            if (i - 1 >= 0) {
                int t = indexOfsmallestNumGreaterThan(nums, i, nums[i - 1]);
                swap(nums, i - 1, t);
                return;
            } else {
                return;
            }
        }
    }

    private int indexOfsmallestNumGreaterThan(int[]arr, int i, int target) {
        for (int k = i; k < arr.length; k++) {
            if (arr[k] > target) {
                return k;
            }
        }
        return -1;
    }

    private void rev(int[]arr, int a, int b) {
        int i = a;
        int j = b;
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    private void swap(int[]arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
