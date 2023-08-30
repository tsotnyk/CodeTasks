package old.slidingWindow;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubsequence {

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int index1 = 0;
        int inS = 0;
        int index2 = 0;

        String result = "";

        while (index1 < s.length()){
            if (s.charAt(index1) == t.charAt(index2)){
                index1++;
                index2++;
            }else {

            }
        }

        return result;

    }

}
