package sts.eBay;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Stack;

public class Solution {


    public boolean canConstruct(String ransomNote, String magazine) {

        int[] array = new int[26];

        for (char symbol : magazine.toCharArray()){

            int index = (int) (symbol - 'a');
            array[index] += 1;
        }

        for (char symbol : ransomNote.toCharArray()){

            int index = (int)(symbol - 'a');
            if (array[index] == 0) return false;
            array[index] -= 1;
        }

        return true;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (map.containsKey(num)){
                int index = map.get(num);
                if (i-index <= k) return true;
            }
            map.put(num, i);
        }

        return false;
    }

    public int calculate(String s) {

        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        char curSym = '+';
        int curNum = 0;

        for (int i = 0; i < s.length(); i++){
            char sym = s.charAt(i);
            if (Character.isDigit(sym)){
                curNum = curNum*10 + sym - '0';
            }
            if (!Character.isDigit(sym) && !Character.isWhitespace(sym) || i == s.length()-1){
                switch (curSym){
                    case '-':
                        curNum = -curNum;
                        break;
                    case '*':
                        curNum *= stack.pop();
                        break;
                    case '/':
                        curNum = stack.pop()/curNum;
                        break;
                }
                stack.push(curNum);
                curNum = 0;
                curSym = sym;
            }
        }

        while (!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }




    @Test
    public void test(){

        Assert.assertEquals(calculate("3/2"), 1);
    }

}
