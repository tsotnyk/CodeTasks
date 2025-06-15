package prepInterviewMeta;


import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {

        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 1; i <= 9; i++){
            Stack<Integer> stack = new Stack<>();
            int num = i;
            if (num > n) break;
            result.add(num);
            num *=10;
            while (num <= n){
                result.add(num);
                stack.push(num);
                num *= 10;
            }

            while (!stack.isEmpty()) {
                int candidate = stack.pop();

                for (int k = 1; k <= 9; k++){
                    if (candidate+k > n) break;
                    result.add(candidate+k);
                }
            }
        }
        return result;
    }

    @Test
    public void test(){

        List<Integer> result = lexicalOrder(192);

        for (int num : result){
            System.out.println(num);
        }
    }
}
