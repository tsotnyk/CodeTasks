package com.j2core.sts.leetcode.com.string.guessWord;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

class Master {

    String secret;
    int count = 0;

    public int getCount(){
        return this.count;
    }

    public void setSecret(String str){
        this.secret = str;
    }

      public int guess(String word){

        this.count++;
        int counter = 0;
        for (int i = 0; i < 6; i++){
            if (secret.charAt(i) == word.charAt(i)){
                counter++;
            }
        }
        return counter;
      }
  }

public class Solution {

    public void findSecretWord(String[] wordlist, Master master) {

        List<String> wordLinkedList = new LinkedList<>(Arrays.asList(wordlist));

        do {
            String tmp1 = wordLinkedList.get(0);
            String tmp2;
            int counter = master.guess(tmp1);
            int counter1 = 0;
            int index = 0;

            while (counter < 1) {
                wordLinkedList.remove(index);
                tmp1 = wordLinkedList.get(index);
                counter = master.guess(tmp1);
            }
            if (counter == 6) return;

            tmp2 = wordLinkedList.get(1);
            counter1 = master.guess(tmp2);

            while (counter1 < 1) {
                wordLinkedList.remove(1);
                tmp2 = wordLinkedList.get(1);
                counter1 = master.guess(tmp2);
            }
            if (counter1 == 6) return;

            wordLinkedList = findPotentiallyMatch(tmp1, tmp2, wordLinkedList);

        }while (true);

    }

    private List<String> findPotentiallyMatch(String string1, String string2, List<String> wordList){

        List<String> result = new LinkedList<>();

        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < 6; i++){
            if (string1.charAt(i) == string2.charAt(i)){
                map.put(i, string1.charAt(i));
            }
        }

        if (map.isEmpty()) return wordList;

        Set<Integer> set = map.keySet();
        for (String word : wordList){
            boolean flag = true;
            for (int index : set){
                if (!map.get(index).equals(word.charAt(index))){
                    flag = false;
                    break;
                }
            }
            if (flag){
                result.add(word);
            }
        }

        result.remove(string1);
        result.remove(string2);
        return result;
    }

//    private List<String> removeUnSecretWords(List<String> wordList, String removeWord){
//
//        List<String> result = new LinkedList<>();
//
//        for (String word : wordList){
//            boolean flag = true;
//            for (int i = 0; i < 6; i++){
//                if (word.charAt(i) == removeWord.charAt(i)){
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag){
//                result.add(word);
//            }
//        }
//
//        return result;
//    }

    @Test
    public void test(){

        Master master = new Master();
        master.setSecret("cymplm");
        findSecretWord(new String[]{"eykdft","gjeixr","eksbjm","mxqhpk","tjplhf","ejgdra","npkysm","jsrsid","cymplm","vegdgt"
                ,"jnhdvb","jdhlzb","sgrghh","jvydne","laxvnm","xbcliw","emnfcw","pyzdnq","vzqbuk","gznrnn"
                ,"robxqx","oadnrt","kzwyuf","ahlfab","zawvdf","edhumz","gkgiml","wqqtla","csamxn","bisxbn"
                ,"zwxbql","euzpol","mckltw","bbnpsg","ynqeqw","uwvqcg","hegrnc","rrqhbp","tpfmlh","wfgfbe"
                ,"tpvftd","phspjr","apbhwb","yjihwh","zgspss","pesnwj","dchpxq","axduwd","ropxqf","gahkbq"
                ,"yxudiu","dsvwry","ecfkxn","hmgflc","fdaowp","hrixpl","czkgyp","mmqfao","qkkqnz","lkzaxu"
                ,"cngmyn","nmckcy","alpcyy","plcmts","proitu","tpzbok","vixjqn","suwhab","dqqkxg","ynatlx"
                ,"wmbjxe","hynjdf","xtcavp","avjjjj","fmclkd","ngxcal","neyvpq","cwcdhi","cfanhh","ruvdsa"
                ,"pvzfyx","hmdmtx","pepbsy","tgpnql","zhuqlj","tdrsfx","xxxyle","zqwazc","hsukcb","aqtdvn"
                ,"zxbxps","wziidg","tsuxvr","florrj","rpuorf","jzckev","qecnsc","rrjdyh","zjtdaw","dknezk"}, master);

        System.out.println(master.getCount());

//        Master master = new Master();
//        master.setSecret("hbaczn");
//        findSecretWord(new String[]{"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos"
//                ,"acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla"
//                ,"ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc"
//                ,"tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl"
//                ,"tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz"
//                ,"arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy"
//                ,"novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp"
//                ,"jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm"
//                ,"ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel"
//                ,"rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"}, master);
//
//        System.out.println(master.getCount());

    }

    /*
    "hbaczn"
["gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos"
,"acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla"
,"ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc"
,"tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl"
,"tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz"
,"arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy"
,"novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp"
,"jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm"
,"ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel"
,"rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"]
10
     */

    /*
    "cymplm"
["eykdft","gjeixr","eksbjm","mxqhpk","tjplhf","ejgdra","npkysm","jsrsid","cymplm","vegdgt"
,"jnhdvb","jdhlzb","sgrghh","jvydne","laxvnm","xbcliw","emnfcw","pyzdnq","vzqbuk","gznrnn"
,"robxqx","oadnrt","kzwyuf","ahlfab","zawvdf","edhumz","gkgiml","wqqtla","csamxn","bisxbn"
,"zwxbql","euzpol","mckltw","bbnpsg","ynqeqw","uwvqcg","hegrnc","rrqhbp","tpfmlh","wfgfbe"
,"tpvftd","phspjr","apbhwb","yjihwh","zgspss","pesnwj","dchpxq","axduwd","ropxqf","gahkbq"
,"yxudiu","dsvwry","ecfkxn","hmgflc","fdaowp","hrixpl","czkgyp","mmqfao","qkkqnz","lkzaxu"
,"cngmyn","nmckcy","alpcyy","plcmts","proitu","tpzbok","vixjqn","suwhab","dqqkxg","ynatlx"
,"wmbjxe","hynjdf","xtcavp","avjjjj","fmclkd","ngxcal","neyvpq","cwcdhi","cfanhh","ruvdsa"
,"pvzfyx","hmdmtx","pepbsy","tgpnql","zhuqlj","tdrsfx","xxxyle","zqwazc","hsukcb","aqtdvn"
,"zxbxps","wziidg","tsuxvr","florrj","rpuorf","jzckev","qecnsc","rrjdyh","zjtdaw","dknezk"]
10
     */
}
