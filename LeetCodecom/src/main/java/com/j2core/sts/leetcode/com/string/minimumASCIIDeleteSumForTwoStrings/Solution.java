package com.j2core.sts.leetcode.com.string.minimumASCIIDeleteSumForTwoStrings;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    // TODO

    public int minimumDeleteSum(String s1, String s2) {

        int sumCharStr1 = countSumLetter(s1);
        int sumCharStr2 = countSumLetter(s2);
        String string1 = createDoubleCharList(s1, s2);
        String string2 = createDoubleCharList(s2, s1);

        if (string1.length() == 0 || string2.length() == 0) return sumCharStr1+sumCharStr2;

        if (string1.equals(string2)) return sumCharStr1 + sumCharStr2 - (countSumLetter(string1)*2);

        if (string1.length() < string2.length()){
            String tmp = string1;
            string1 = string2;
            string2 = tmp;
        }

        Map<Integer, List<String>> variableString = createVariableStringList(string2);
        List<String> stringEqualsString = findEqualsString(variableString, string1, string2.length());

        return minSumChar(stringEqualsString, sumCharStr1, sumCharStr2);

    }

    private List<String> findEqualsString(Map<Integer, List<String>> variableMap, String stringBig, int length){

        List<String> result = new LinkedList<>();

        for (int k = length; k > 0; k--) {

            List<String> variableString = variableMap.get(k);

            for (String string : variableString) {

                if (string.length() > 1) {
                    int index = stringBig.indexOf(string.charAt(0));
                    while (index != -1) {

                        int indexStringChar = 1;

                        for (int i = index + 1; i < stringBig.length(); ) {

                            char tmp = string.charAt(indexStringChar);
                            int nextIndex = stringBig.indexOf(tmp, i);
                            if (nextIndex != -1) {
                                i = nextIndex + 1;
                                indexStringChar++;
                            } else break;
                            if (indexStringChar == string.length()) break;
                        }

                        if (indexStringChar == string.length()) {
                            result.add(string);
                            break;
                        }

                        index = stringBig.indexOf(string.charAt(0), index + 1);
                    }
                } else {
                    result.add(string);
                }
            }

            if (!result.isEmpty()) return result;
        }

        return result;
    }


    private Map<Integer,List<String>> createVariableStringList(String str){

        Map<Integer, List<String>> result = new HashMap<>();

        List<String> tmpData = new LinkedList<>();
        tmpData.add(str);

        while (!tmpData.isEmpty()){

            String string = ((LinkedList<String>) tmpData).removeFirst();
            int stringLength = string.length();

            if (result.containsKey(stringLength)){
                List<String> tmp = result.get(stringLength);
                tmp.add(string);
            }else {
                List<String> tmp = new LinkedList<>();
                tmp.add(string);
                result.put(stringLength, tmp);
            }

            if (string.length() > 1) {
                for (int i = 0; i < string.length(); i++) {

                    StringBuilder tmpString = new StringBuilder();

                    for (int j = 0; j < string.length(); j++) {

                        if (j != i) {

                            tmpString.append(string.charAt(j));
                        }
                    }

                    String tmp = tmpString.toString();

                    boolean flag = false;

                    for (String s : tmpData) {

                        if (s.equals(tmp)) {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) tmpData.add(tmp);
                }
            }
        }

        return result;

    }


    private int minSumChar(List<String> list, int sumStr1, int sumStr2){

        List<Integer> sumList = new LinkedList<>();

        for (String string : list){

            sumList.add(sumStr1 + sumStr2 - (countSumLetter(string)*2));

        }

        int result = sumList.get(0);

        for (int sum : sumList){

            if (sum < result){

                result = sum;
            }
        }

        return result;
    }


    private String createDoubleCharList(String s1, String s2){

        StringBuilder doubleCharacter = new StringBuilder();

        for (int i = 0; i < s1.length(); i++){

            char tmp = s1.charAt(i);
            for (int j = 0; j < s2.length(); j++){

                if (tmp == s2.charAt(j)){
                    doubleCharacter.append(tmp);
                    break;
                }

            }
        }

        return doubleCharacter.toString();

    }

    private int countSumLetter(String string){

        int sum = 0;

        for (int i = 0; i < string.length(); i++){

            sum = sum + string.charAt(i);

        }

        return sum;

    }

    @Test
    public void testCreateVariableStringList(){

        Map<Integer, List<String>> result = createVariableStringList("leet");

        Assert.assertEquals(result.size(), 4);

    }

    @Test
    public void testFindEqualsString(){

        Map<Integer, List<String>> data = createVariableStringList("leet");

        List<String> result = findEqualsString(data, "eletele", 4);

        Assert.assertEquals(9, result.size());


    }

    @Test
    public void testMinSumChar(){

        List<String> data = new LinkedList<>();
        data.add("let");
        data.add("eet");
        data.add("lee");

        int result = minSumChar(data, countSumLetter("delete"), countSumLetter("leet"));

        Assert.assertEquals(403, result);

    }


    @Test
    public void testCreateDoubleCharList(){

        String result1 = createDoubleCharList("delete", "leet");
        String result2 = createDoubleCharList("leet", "delete");

        Assert.assertEquals(result1, "elete");
        Assert.assertEquals(result2, "leet");

    }

    @Test
    public void test(){

        int result = minimumDeleteSum1("igijekdtywibepwonjbwykkqmrgmtybwhwjiqudxmnniskqjfbkpcxukrablqmwjndlhblxflgehddrvwfacarwkcpmcfq" +
                "najqfxyqwiugztocqzuikamtvmbjrypfqvzqiwooewpzcpwhdejmuahqtukistxgfafrymoaodtluaexucnndlnpeszdfsvfofdylcicrrevjggasrgdhwd" +
                "gjwcchyanodmzmuqeupnpnsmdkcfszznklqjhjqaboikughrnxxggbfyjriuvdsusvmhiaszicfa",
                "ikhuivqorirphlzqgcruwirpewbjgrjtugwpnkbrdfufjsmgzzjespzdcdjcoioaqybciofdzbdieegetnogoibbwfielwungehetanktjqjrddkrnsxvdmeha" +
                        "eyrpzxrxkhlepdgpwhgpnaatkzbxbnopecfkxoekcdntjyrmmvppcxcgquhomcsltiqzqzmkloomvfayxhawlyqxnsbyskjtzxiyrsaobbnjpgzmetpqvscyycutdkpjpzfokvi");

        Assert.assertEquals(result, 403);

    }

    public int minimumDeleteSum1(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= n; i++){
            dp[0][i] += s2.charAt(i-1) + dp[0][i-1];
        }

        for (int i = 1; i <= m; i++){
            dp[i][0] += s1.charAt(i-1) + dp[i-1][0];
        }



        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(s1.charAt(i-1) + dp[i-1][j], s2.charAt(j-1) + dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    @Test
    public void test1(){

        int result = minimumDeleteSum1("delete", "leet");

        Assert.assertEquals(result, 403);

    }

}
