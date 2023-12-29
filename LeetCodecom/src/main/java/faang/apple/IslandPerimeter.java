package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int per = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 0) continue;
                per += helper(grid, i-1, j);
                per += helper(grid, i+1, j);
                per += helper(grid, i, j-1);
                per += helper(grid, i, j+1);
            }
        }

        return per;
    }

    private int helper(int[][] grid, int i, int j){

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 1;

        return grid[i][j] == 1 ? 0 : 1;
    }

    @Test
    public void test(){

        Assert.assertEquals(16, islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }

}
