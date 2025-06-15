package prepInterviewGoogle;

import java.util.LinkedList;
import java.util.List;

public class FindWordsContainingCharacter {

    public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < words.length; i++){
            if (words[i].indexOf(x) > -1) result.add(i);
        }

        return result;
    }
}
