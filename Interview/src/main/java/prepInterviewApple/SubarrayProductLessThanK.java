package prepInterviewApple;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;

        int counter = 0;
        int iS = 0;
        int iE = 0;
        int sum = 1;

        while (iE < nums.length){
            sum *= nums[iE];
            if (sum  >= k){
                sum /= nums[iE];
                if (iS == iE){
                    iS++;
                    iE++;
                    continue;
                }
                counter += iE - iS;
                sum /= nums[iS++];
                continue;
            }
            iE++;
        }

        while (iS < nums.length){
            counter += iE - iS++;
        }

        return counter;
    }

}
