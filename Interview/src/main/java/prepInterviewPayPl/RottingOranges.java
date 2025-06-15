package prepInterviewPayPl;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        AtomicInteger freshOr = new AtomicInteger(0);

        List<int[]> rottenOrange = new LinkedList<>();

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0) continue;
                if (grid[i][j] == 1){
                    freshOr.addAndGet(1);
                    continue;
                }
                rottenOrange.add(new int[]{i, j});
            }
        }

        if (freshOr.get() == 0) return 0;
        if (rottenOrange.isEmpty()) return -1;

        int counter = 0;

        while (freshOr.get() > 0 && !rottenOrange.isEmpty()){
            rottenOrange = getMin(grid, rottenOrange, freshOr);
            counter++;
        }

        return freshOr.get() == 0 ? counter : -1;
    }

    private List<int[]> getMin(int[][] grid, List<int[]> rottenOr, AtomicInteger freshOr){

        List<int[]> newRottenOr = new LinkedList<>();
        while (freshOr.get() > 0 && !rottenOr.isEmpty()){
            int[] cell = rottenOr.remove(0);
            if (cell[0] > 0) {
                if (grid[cell[0]-1][cell[1]] == 1){
                    freshOr.addAndGet(-1);
                    grid[cell[0]-1][cell[1]] = 2;
                    newRottenOr.add(new int[]{cell[0]-1, cell[1]});
                }
            }
            if (cell[1] > 0){
                if (grid[cell[0]][cell[1]-1] == 1){
                    freshOr.addAndGet(-1);
                    grid[cell[0]][cell[1]-1] = 2;
                    newRottenOr.add(new int[]{cell[0], cell[1]-1});
                }
            }
            if (cell[0] < grid.length-1){
                if (grid[cell[0]+1][cell[1]] == 1){
                    freshOr.addAndGet(-1);
                    grid[cell[0]+1][cell[1]] = 2;
                    newRottenOr.add(new int[]{cell[0]+1, cell[1]});
                }
            }
            if (cell[1] < grid[0].length-1){
                if (grid[cell[0]][cell[1]+1] == 1){
                    freshOr.addAndGet(-1);
                    grid[cell[0]][cell[1]+1] = 2;
                    newRottenOr.add(new int[]{cell[0], cell[1]+1});
                }
            }
        }

        return newRottenOr;
    }

    @Test
    public void test(){

        Assert.assertEquals(orangesRotting(new int[][]{{1}, {2}}), 1);
    }
}
