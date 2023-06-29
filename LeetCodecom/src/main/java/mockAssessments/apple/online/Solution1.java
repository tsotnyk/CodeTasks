package mockAssessments.apple.online;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public String[] reorderLogFiles(String[] logs) {



        return null;
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new LinkedList<>();

        generateHelper(new StringBuilder(), n, n, result);

        return result;
    }

    private void generateHelper(StringBuilder builder, int open, int close, List<String> result){

        if (open == 0 && close == 0) {
            result.add(builder.toString());
            return;
        }

        if (open != 0){
            StringBuilder openBuilder = new StringBuilder(builder);
            openBuilder.append('(');
            generateHelper(openBuilder, open-1, close, result);
        }
        if (close > open){
            StringBuilder closeBuilder = new StringBuilder(builder);
            closeBuilder.append(')');
            generateHelper(closeBuilder, open, close-1, result);
        }
    }

    @Test
    public void test(){

        List<String> result = generateParenthesis(3);

        Assert.assertEquals(result.size(), 5);
    }
}
