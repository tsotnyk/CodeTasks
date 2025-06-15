package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveDigitFromNumberToMaximizeResult {

    public String removeDigit(String number, char digit) {

        char[] result = null;

        for (int i = 0; i < number.length(); i++){
            if (number.charAt(i) == digit){
                char[] candidate = removeDigit(number.toCharArray(), i);
                if (result == null) {
                    result = candidate;
                    continue;
                }

                if (candidateIsBigger(result, candidate)){
                    result = candidate;
                }

            }
        }

        return result != null ? String.valueOf(result) : null;
    }

    public boolean candidateIsBigger(char[] result, char[] candidate){

        for (int i = 0; i < result.length; i++){
            if (result[i] != candidate[i]) return result[i] < candidate[i];
        }

        return false;
    }

    public char[] removeDigit(char[] num, int index){

        char[] candidate = new char[num.length-1];
        if (index == 0){
            System.arraycopy(num, 1, candidate, 0, candidate.length);
        }else if(index == num.length-1){
            System.arraycopy(num, 0, candidate, 0, candidate.length);
        }else {
            System.arraycopy(num, 0, candidate, 0, index);
            System.arraycopy(num, index+1, candidate, index, candidate.length-index);
        }

        return candidate;
    }



    @Test
    public void test(){


        Assert.assertEquals(removeDigit("123", '3'), "12");
        Assert.assertEquals(removeDigit("1231", '1'), "231");
        Assert.assertEquals(removeDigit("551", '5'), "51");

    }
}
