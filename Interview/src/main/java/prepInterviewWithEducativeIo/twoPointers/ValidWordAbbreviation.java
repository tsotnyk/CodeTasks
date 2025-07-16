package prepInterviewWithEducativeIo.twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidWordAbbreviation {

    public  boolean validWordAbbreviation(String word, String abbr) {

        int indexWord = 0;
        int indexAbbr = 0;

        while (indexWord < word.length() && indexAbbr < abbr.length()){
            if (Character.isLetter(abbr.charAt(indexAbbr))){
                if (word.charAt(indexWord++) != abbr.charAt(indexAbbr++)){
                    return false;
                }
                continue;
            }
            int endDigit = indexAbbr;
            while (endDigit < abbr.length() && Character.isDigit(abbr.charAt(endDigit))){
                endDigit++;
            }
            if (abbr.charAt(indexAbbr) == '0') return false;

            int num = Integer.parseInt(abbr.substring(indexAbbr, endDigit));

            indexAbbr = endDigit;
            indexWord += num;

            if (indexWord > word.length()) return false;
        }
        return indexWord == word.length() && indexAbbr == abbr.length();
    }

    @Test
    public void test(){

        Assert.assertTrue(validWordAbbreviation("qqqqqqqqqq", "10"));
        Assert.assertTrue(validWordAbbreviation("internationalization", "i18n"));
    }

}
