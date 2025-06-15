package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ApplySubstitutions {

    public String applySubstitutions(List<List<String>> replacements, String text) {

        if (!text.contains("%")) return text;

        HashMap<String, String> map = new HashMap<>();

        for (List<String> replacement : replacements){
            map.put(replacement.get(0), replacement.get(1));
        }

        return replacement(map, text);
    }

    public String replacement(HashMap<String, String> map, String text){

        if (!text.contains("%")) return text;

        int indexS = text.indexOf('%');
        int indexE = text.indexOf('%', indexS+1);

        StringBuilder builder = new StringBuilder();
        builder.append(text.substring(0, indexS));
        builder.append(map.get(text.substring(indexS+1, indexE)));
        builder.append(text.substring(indexE+1));

        return replacement(map, builder.toString());
    }

    @Test
    public void test(){

        List<List<String>> input = new LinkedList<>();
        input.add(new LinkedList<>(Arrays.asList("A", "abc")));
        input.add(new LinkedList<>(Arrays.asList("B", "def")));

        Assert.assertEquals(applySubstitutions(input, "%A%_%B%"), "abc_def");
    }
}
