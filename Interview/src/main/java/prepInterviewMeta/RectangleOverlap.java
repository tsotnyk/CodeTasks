package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
    }

    @Test
    public void test(){

        Assert.assertFalse(isRectangleOverlap(new int[]{5,15,8,18}, new int[]{0,3,7,9}));
    }
}
