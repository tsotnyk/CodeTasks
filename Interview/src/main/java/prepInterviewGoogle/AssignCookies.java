package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int counter = 0;

        int indexCookies = 0;

        for (int i = 0; i < g.length; i++){
            if (indexCookies == s.length) break;
            while (indexCookies < s.length && s[indexCookies] < g[i]){
                indexCookies++;
            }
            if (indexCookies == s.length) break;
            indexCookies++;
            counter++;
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(findContentChildren(new int[]{1,2,3}, new int[]{1,1}), 1);
        Assert.assertEquals(findContentChildren(new int[]{1,2,3}, new int[]{1,1,1,2,2,2,2,2,2,2,3,3}), 3);
        Assert.assertEquals(findContentChildren(new int[]{1,2}, new int[]{1,2,3}), 2);
    }
}
