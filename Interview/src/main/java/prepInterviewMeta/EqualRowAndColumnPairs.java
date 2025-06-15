package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EqualRowAndColumnPairs {

    public int equalPairs(int[][] grid) {

        int counter = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                if (sameValues(grid, i, j)) counter++;
            }
        }

        return counter;
    }

    public boolean sameValues(int[][] grid, int i, int j){

        for (int k = 0; k < grid.length; k++){
            if (grid[i][k] != grid[k][j]) return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}), 1);
        Assert.assertEquals(equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}), 3);
    }
}
