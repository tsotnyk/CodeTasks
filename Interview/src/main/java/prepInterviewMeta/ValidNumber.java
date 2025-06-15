package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidNumber {

    public boolean isNumber(String s) {

        String str = s.trim();
        if (str.length() < 1) return false;
        str = str.toLowerCase();
        int eIndex = str.indexOf('e');

        if (eIndex < 0){
            return isNumberWithoutE(str);
        }else if (eIndex == 0 || eIndex == str.length()-1){
            return false;
        }else {
            if (isNumberAfterE(str.substring(eIndex+1))){
                return isNumberWithoutE(str.substring(0, eIndex));
            }else return false;
        }
    }

    private boolean isNumberWithoutE(String string){

        boolean point = false;
        int index = 0;
        int length = string.length();
        if (string.charAt(0) == '-' || string.charAt(0) == '+'){
            index++;
            if (length == 1){
                return false;
            }
        }
        for (int i = index; i < length; i++){
            char character = string.charAt(i);
            if (character == '.'){
                if (length-index == 1 || point){
                    return false;
                }
                point = true;
            }else if (character == '-' || character == '+'){
                return false;
            }else if (character < '0' || character > '9'){
                return false;
            }
        }
        return true;
    }

    private boolean isNumberAfterE(String string){

        for (int i = 0; i < string.length(); i++){

            if (string.charAt(i) == '-' || string.charAt(i) == '+'){
                if (i > 0 || string.length() == 1) return false;
            }else if (string.charAt(i) < '0' || string.charAt(i) > '9'){
                return false;
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isNumber("-1E+3"));
    }
}
