package prepInterviewApple;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() < 2) return s.length();

        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int result = 0;
        int index = 0;
        for (int i = 1; i < s.length(); i++){

            if (set.contains(s.charAt(i))){
                result = Math.max(result, i-index);
                while (s.charAt(i) != s.charAt(index)){
                    set.remove(s.charAt(index++));
                }
                if (s.charAt(index) == s.charAt(i)) index++;
            }

            set.add(s.charAt(i));
        }

        return Math.max(result, s.length() - index);
    }

    @Test
    public void test(){

        Assert.assertEquals(lengthOfLongestSubstring("abcabcbb"), 3);
        Assert.assertEquals(lengthOfLongestSubstring("bbbbb"), 1);
        Assert.assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
    }

}
