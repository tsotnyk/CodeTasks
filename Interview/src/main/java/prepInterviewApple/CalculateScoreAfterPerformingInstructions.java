package prepInterviewApple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculateScoreAfterPerformingInstructions {

    public long calculateScore(String[] instructions, int[] values) {

        boolean[] visited = new boolean[instructions.length];

        int index = 0;
        long score = 0;

        while (index >= 0 && index < values.length){
            if (visited[index]) return score;
            visited[index] = true;
            if (instructions[index].equals("add")){
                score += values[index];
                index++;
                continue;
            }
            index += values[index];
        }

        return score;
    }

    @Test
    public void test(){

        Assert.assertEquals(calculateScore(new String[]{"jump","add","add","jump","add","jump"}, new int[]{2,1,3,1,-2,-3}), 1);
        Assert.assertEquals(calculateScore(new String[]{"jump","add","add"}, new int[]{3,1,1}), 0);
        Assert.assertEquals(calculateScore(new String[]{"jump"}, new int[]{0}), 0);
    }
}
