package prepInterviewWithEducativeIo.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    public boolean isStrobogrammaticMyOld (String num)
    {

        StringBuilder builder = new StringBuilder();

        for (int i = num.length()-1; i >= 0; i--){
            char symbol = num.charAt(i);
            switch (symbol){
                case '6':
                    builder.append('9');
                    break;
                case '9':
                    builder.append('6');
                    break;
                default:
                    builder.append(symbol);

            }
        }
        // Replace this placeholder return statement with your code
        return num.equals(builder.toString());
    }

    public boolean isStrobogrammaticSites(String num) {
        Map<Character, Character> dict = new HashMap<>();
        dict.put('0', '0');
        dict.put('1', '1');
        dict.put('8', '8');
        dict.put('6', '9');
        dict.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            if (!dict.containsKey(num.charAt(left)) || dict.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isStrobogrammaticMyNew (String num)
    {
        int right = num.length()-1;
        int left = 0;

        while (left < right){
            if (num.charAt(left) == '9'){
                if (num.charAt(right) != '6') return false;
                right--;
                left++;
                continue;
            }
            if (num.charAt(left) == '6'){
                if (num.charAt(right)!= '9') return false;
                right--;
                left++;
                continue;
            }
            if (num.charAt(right) != num.charAt(left)) return false;
            right--;
            left++;
        }

        return true;
    }
}
