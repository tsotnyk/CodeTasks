package faang.apple;

import java.util.HashSet;

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> set = new HashSet<>();

        for (char sym : jewels.toCharArray()){
            set.add(sym);
        }
        int res = 0;
        for (char sym : stones.toCharArray()){

            if (set.contains(sym)) res++;
        }
        return res;
    }
}
