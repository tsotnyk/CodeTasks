package prepInterviewGoogle;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int iL = 0;
        int iR = height.length-1;
        int maxValue = 0;

        while (iL < iR){

            maxValue = Math.max(maxValue, (iR-iL)*Math.min(height[iL], height[iR]));
            if (height[iL] <= height[iR]) {
                iL++;
            } else {
                iR--;
            }        }

        return maxValue;
    }
}
