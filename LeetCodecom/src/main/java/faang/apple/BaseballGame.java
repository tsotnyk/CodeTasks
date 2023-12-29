package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseballGame {

    public int calPoints(String[] operations) {

        int[] score = new int[operations.length];
        int index = 0;

        for (String operation : operations){

            switch (operation){
                case "C":
                    index--;
                    break;
                case "D":
                    score[index] = 2*score[index-1];
                    index++;
                    break;
                case "+":
                    score[index] = score[index-1]+score[index-2];
                    index++;
                    break;
                default:
                    if (operation.charAt(0) == '-'){
                        score[index] = Integer.parseInt(operation.substring(1)) * -1;
                    }else {
                        score[index] = Integer.parseInt(operation);
                    }
                    index++;
                    break;
            }
        }

        int resScope = 0;

        for (int i = 0; i < index; i++){
            resScope += score[i];
        }

        return resScope;
    }

    @Test
    public void test(){

        Assert.assertEquals(30, calPoints(new String[]{"5","2","C","D","+"}));
        Assert.assertEquals(27, calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        Assert.assertEquals(0, calPoints(new String[]{"1","C"}));
    }
}
