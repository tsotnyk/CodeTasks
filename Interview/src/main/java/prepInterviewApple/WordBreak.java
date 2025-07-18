package prepInterviewApple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();

        for (String word : wordDict){
            set.add(word);
        }

        HashMap<String, Boolean> memo = new HashMap<>();
        memo.put("", true);

        return isWords(s, set, memo);

    }

    private boolean isWords(String str, HashSet<String> set, HashMap<String, Boolean> memo){

        if (memo.containsKey(str)) return memo.get(str);

        for (int i = 1; i <= str.length(); i++){
            if (set.contains(str.substring(0, i))){
                if (isWords(str.substring(i), set, memo)){
                    memo.put(str, true);
                    return true;
                }
            }
        }

        memo.put(str, false);
        return false;
    }
}
