package prepInterviewMeta;

public class StringToInteger {

    public int myAtoi(String str) {


        int start = -1;
        boolean negative = false;
        long number = 0;

        for(int i = 0; i < str.length(); i++){

            char tmp  = str.charAt(i);

            if(tmp == ' '){
                continue;
            }else if (tmp == '+' || tmp == '-'){
                if(i+1 < str.length() &&  Character.isDigit(str.charAt(i+1))){
                    start = i+1;
                    if(tmp == '-') negative = true;
                    break;
                }else{
                    return 0;
                }
            } else if(Character.isDigit(tmp)){
                start = i;
                break;
            }else{
                break;
            }

        }

        if(start < 0) return 0;

        boolean isDigit = Character.isDigit(str.charAt(start));

        while(isDigit){

            if(number == 0){
                number += (byte) str.charAt(start) - (byte) '0';
                if(negative){
                    number *= -1;
                }
            }else{

                int delta = negative ? -1 : 1;
                number  = (number * 10) + (((byte) str.charAt(start)  - (byte) '0') * delta);
            }
            if(negative){
                if(number < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }else{
                if(number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }

            if(start+1 < str.length()){
                start++;
                isDigit = Character.isDigit(str.charAt(start));
            }else{
                break;
            }


        }

        return (int) number;
    }
}
