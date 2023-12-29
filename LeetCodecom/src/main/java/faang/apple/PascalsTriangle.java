package faang.apple;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        if (numRows == 0) return new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>(numRows);
        int length = 1;
        ArrayList<Integer> curLevel = new ArrayList<>(length++);
        curLevel.add(1);

        while (length <= numRows){
            ArrayList<Integer> nextLevel = new ArrayList<>(length);
            nextLevel.add(1);
            for (int i = 1; i < length-1; i++){
                nextLevel.add(curLevel.get(i)+ curLevel.get(i-1));
            }
            nextLevel.add(1);
            res.add(curLevel);
            curLevel = nextLevel;
            length++;
        }

        res.add(curLevel);

        return res;
    }

    @Test
    public void test(){

        generate(5);
    }

}
