package prepInterviewApple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOfIsland {

    public int numIslands(char[][] grid) {

        int counter = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    counter++;
                    coloredIsland(grid, i, j);
                }
            }
        }

        return counter;
    }

    public void coloredIsland(char[][] matrix, int i, int j){

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != '1') return;
        matrix[i][j] = '2';
        coloredIsland(matrix, i-1, j);
        coloredIsland(matrix, i+1, j);
        coloredIsland(matrix, i, j-1);
        coloredIsland(matrix, i, j+1);
    }

    @Test
    public void test(){

        char[][] matrix = new char[][]{{'1'},{'1'}};

        Assert.assertEquals(numIslands(matrix), 1);

        char[][] matrix1 = new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        char[][] matrix2 = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        Assert.assertEquals(numIslands(matrix1), 1);
        Assert.assertEquals(numIslands(matrix2), 3);
    }
}
