package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SortingTheSentence {

    public String sortSentence(String s) {

        HashMap<Integer, String> map = new HashMap<>();

        String[] words = s.split(" ");

        for (String word: words){

            int index = Integer.parseInt(word.substring(word.length()-1, word.length()));

            map.put(index, word.substring(0, word.length()-1));
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < words.length; i++){
            builder.append(map.get(i));
            builder.append(' ');
        }

        builder.append(map.get(words.length));

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(sortSentence("is2 sentence4 This1 a3"), "This is a sentence");
        Assert.assertEquals(sortSentence("Myself2 Me1 I4 and3"), "Me Myself and I");
    }
}
