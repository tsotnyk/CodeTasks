package com.j2core.sts.leetcode.com.string.guessWord;

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

        LinkedList<String> stringList = new LinkedList<>(Arrays.asList(wordlist));
        String word1 = stringList.removeFirst();
        int count1 = master.guess(word1);

        while (count1 == 0){
            stringList = removeUnmatchedWord(stringList, word1);
            word1 = stringList.removeFirst();
            count1 = master.guess(word1);
        }

        if (count1 == 6) return;

        stringList = createMatchedList(stringList, word1);

        String word2 = stringList.removeLast();
        int count2 = master.guess(word2);

        while (count2 == 0){
            stringList = removeUnmatchedWord(stringList, word2);
            word2 = stringList.removeLast();
            count2 = master.guess(word2);
        }

        if (count2 == 6) return;

        int count = Math.min(count1, count2);
        String word;

        while (count != 6){
            word = findPosMatchString(stringList, word1, word2);
            count = master.guess(word);
            if (count != 6){
                if (count > count1){
                    count1 = count;
                    word1 = word;
                }else if (count > count2){
                    count2 = count;
                    word2 = word;
                }
            }
        }
    }

    private String findPosMatchString(LinkedList<String> wordList, String word1, String word2){

        int index = -1;
        char character = ' ';

        for (int i = 5; i > -1; i--){
            if (word1.charAt(i) == word2.charAt(i)){
                index = i;
                character = word1.charAt(i);
                break;
            }
        }

        if (index > -1) {
            for (int i = 0; i < wordList.size(); i++) {
                String word = wordList.get(i);
                if (word.charAt(index) == character){
                    wordList.remove(i);
                    return word;
                }
            }

        }
        return wordList.removeLast();
    }

    public void findSecretWordOld(String[] wordlist, Master master) {

        LinkedList<String> stringList = new LinkedList<>(Arrays.asList(wordlist));
        Collections.sort(stringList);

        String word;
        int count = 0;

        while (count != 6){

            word = stringList.removeFirst();
            count = master.guess(word);
            if (count == 0){
                stringList = removeUnmatchedWord(stringList, word);
            }else {
                stringList = createMatchedList(stringList, word);
            }
        }
    }

    private LinkedList<String> createMatchedList(LinkedList<String> wordList, String word) {

        LinkedList<String> canMatch = new LinkedList<>();

        for (String str : wordList){
            for (int i = 0; i < 6; i++){
                if (str.charAt(i) == word.charAt(i)){
                    canMatch.add(str);
                    break;
                }
            }
        }

        return canMatch;
    }

    private LinkedList<String> removeUnmatchedWord(LinkedList<String> wordList, String string){

        LinkedList<String> result = new LinkedList<>();

        for (String word : wordList){
            boolean flag = true;
            for (int i = 0; i < 6; i++){
                if (word.charAt(i) == string.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                result.add(word);
            }
        }
        return result;
    }


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

        Master master1 = new Master();
        master1.setSecret("hbaczn");
        findSecretWord(new String[]{"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos"
                ,"acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla"
                ,"ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc"
                ,"tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl"
                ,"tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz"
                ,"arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy"
                ,"novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp"
                ,"jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm"
                ,"ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel"
                ,"rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"}, master1);

        System.out.println(master1.getCount());

        Master master2 = new Master();
        master2.setSecret("ccoyyo");
        findSecretWord(new String[]{"wichbx","oahwep","tpulot","eqznzs","vvmplb","eywinm","dqefpt","kmjmxr","ihkovg","trbzyb"
                ,"xqulhc","bcsbfw","rwzslk","abpjhw","mpubps","viyzbc","kodlta","ckfzjh","phuepp","rokoro"
                ,"nxcwmo","awvqlr","uooeon","hhfuzz","sajxgr","oxgaix","fnugyu","lkxwru","mhtrvb","xxonmg"
                ,"tqxlbr","euxtzg","tjwvad","uslult","rtjosi","hsygda","vyuica","mbnagm","uinqur","pikenp"
                ,"szgupv","qpxmsw","vunxdn","jahhfn","kmbeok","biywow","yvgwho","hwzodo","loffxk","xavzqd"
                ,"vwzpfe","uairjw","itufkt","kaklud","jjinfa","kqbttl","zocgux","ucwjig","meesxb","uysfyc"
                ,"kdfvtw","vizxrv","rpbdjh","wynohw","lhqxvx","kaadty","dxxwut","vjtskm","yrdswc","byzjxm"
                ,"jeomdc","saevda","himevi","ydltnu","wrrpoc","khuopg","ooxarg","vcvfry","thaawc","bssybb"
                ,"ccoyyo","ajcwbj","arwfnl","nafmtm","xoaumd","vbejda","kaefne","swcrkh","reeyhj","vmcwaf"
                ,"chxitv","qkwjna","vklpkp","xfnayl","ktgmfn","xrmzzm","fgtuki","zcffuv","srxuus","pydgmq"}, master2);

        System.out.println(master2.getCount());
    }
}
