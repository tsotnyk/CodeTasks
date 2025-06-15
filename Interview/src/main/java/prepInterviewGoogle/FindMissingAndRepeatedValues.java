package prepInterviewGoogle;

public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {

        boolean[] array = new boolean[(grid.length* grid.length)+1];
        int[] result = new int[2];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                int num = grid[i][j];
                if (array[num]) result[0] = num;
                array[num] = true;
            }
        }

        for (int i = 1; i < array.length; i++){
            if (!array[i]){
                result[1] = i;
                break;
            }
        }

        return result;
    }
}
