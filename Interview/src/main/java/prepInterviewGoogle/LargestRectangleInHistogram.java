package prepInterviewGoogle;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public int largestRectangleAreaTLE(int[] heights) {

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++){

            int counter = 0;
            int tmp = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++){
                counter++;
                tmp = Integer.min(tmp, heights[j]);
                maxArea = Integer.max(maxArea, tmp*counter);
            }
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while (
                    (stack.peek() != -1) && (heights[stack.peek()] >= heights[i])
            ) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}
