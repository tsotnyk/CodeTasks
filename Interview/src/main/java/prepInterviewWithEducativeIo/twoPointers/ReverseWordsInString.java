package prepInterviewWithEducativeIo.twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseWordsInString {

    public String reverseWordsMy(String sentence) {

        StringBuilder builder = new StringBuilder();
        int start = 0;
        int index = 0;

        while (index <= sentence.length()){

            if ( index == sentence.length() || sentence.charAt(index) == ' '){

                if (index == start){
                    index++;
                    start++;
                    continue;
                }
                reversWord(sentence, start, index, builder);
                index++;
                start = index;
                continue;
            }
            index++;
        }

        if (builder.charAt(0) == ' '){
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    private static void reversWord(String sentence, int start, int end, StringBuilder builder){

        builder.insert(0, sentence.substring(start, end));

        if (end != sentence.length()){
            builder.insert(0, ' ');
        }
    }

    public static String reverseWords(String sentence) {
        sentence = sentence.trim();
        String[] words = sentence.split("\\s+");
        int left = 0, right = words.length - 1;

        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);
    }

    @Test
    public void test(){

//        Assert.assertEquals(reverseWords("The quick brown fox jumped over a lazy dog"), "dog lazy a over jumped fox brown quick The");
        Assert.assertEquals(reverseWords("We love Python "), "Python love We");

    }
}
