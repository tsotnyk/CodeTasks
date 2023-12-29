package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountItemsMatchingRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int res = 0;
        int index;
        switch (ruleKey){
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            default:
                index = 2;
        }

        for (List<String> list : items){
            if (list.get(index).equals(ruleValue)) res++;
        }

        return res;
    }

    @Test
    public void test(){

        List<List<String>> list = new LinkedList<>();
        list.add(new LinkedList<>(Arrays.asList("phone","blue","pixel")));
        list.add(new LinkedList<>(Arrays.asList("computer","silver","phone")));
        list.add(new LinkedList<>(Arrays.asList("phone","gold","iphone")));
        Assert.assertEquals(2, countMatches(list, "type", "phone"));
    }
}
