package com.j2core.sts.leetcode.com.groupsOfSpecialEquivalentStrings;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int numSpecialEquivGroups(String[] A) {

        List<String> result = new LinkedList<>();

        for (String str : A){

            boolean flag = true;

            for (String str2 : result){

                if (equalsSpecialString(str, str2)){
                    flag = false;
                    break;
                }

            }

            if (flag){
                result.add(str);
            }
        }

        return result.size();

    }

    private boolean equalsSpecialString(String str1, String str2){

        if (str1.length() != str2.length()){
            return false;
        }

        if (equalsString(str1, str2) && equalsString(str2, str1)){
            return true;
        }else
            return false;
    }

    private boolean equalsString(String str1, String str2){

        for (int i = 0; i < str1.length(); i++){

            int index = str2.indexOf(str1.charAt(i));

            boolean tmp = false;
            while (index != -1){

                if (index%2 == i%2){
                    tmp = true;
                    break;
                }
                index = str2.indexOf(str1.charAt(i), ++index);
            }

            if (!tmp){
                return false;
            }
        }

        return true;
    }


    @Test
    public void test(){


        boolean resu = equalsString("mcli", "lcli");

        int result = numSpecialEquivGroups(new String[]{"isqc","owem","wted","rinx","kgwo","dnfz","arjn","osbl","bsxf",
                "dqng","ebyt","jgwe","ugez","bnnv","mcli","mdcs","lfxv","zdfp","rmen","grnz","dwbp","wxvg","denc","foee",
                "tuse","bxcu","azog","kmln","jkpl","favw","nsgn","yust","rzki","msid","wojf","miiu","amyl","tahc","jsdo",
                "xjlk","rqmo","xajm","ajvq","gacb","uzax","pfdv","yzyl","pgbl","tsyh","bkwc","lhhm","bicc","ulug","ruxn",
                "wurr","yrni","pjdm","wmbx","xzvh","fbzx","oeuy","rxhw","fyua","bmna","iewf","fmax","wvhn","bcom","fers",
                "zrvo","cneh","xekb","mqwu","tmdo","apjb","kjso","zcdq","hdlw","eqtt","exdm","mxel","ykgs","lumw","uret",
                "blvl","opal","bkep","ttxa","lzrr","cqsa","yhfl","typs","djxh","yrep","ywlr","ccnt","sgrb","ttqe","ttue",
                "nmfj","ftig","itsi","zvhu","meag","xvvw","efoc","twfn","qxae","wmjg","amzg","mpja","bdai","frso","ipyc",
                "ifdr","lazp","hyup","vhkt","nmxd","icfs","cfqp","fkko","mmio","byqa","ndgv","grrh","ekal","vgid","lcli",
                "zwcg","diap","lxdh","wyim","qxnp","ncww","grnx","voht","hvuy","jjth","nwjh","xfdj","envd","aafo","qmxd",
                "kzfb","qnwy","vpcl","ouez","hzqa","ezvy","fciu","boei","paau","npxh","cicu","xdat","bmny","xkwz","tiks",
                "hios","ovgr","hdrj","fcja","tlor","ylnr","lehi","oprm","gzcl","xguq","tmjv","aaxz","xueg","nxbx","rfgu",
                "worx","itfi","kkid","vhmh","upui","ofrz","ilfu","qsna","mqsg","ebup","pzsz","nxxq","utef","gbqc","fiue",
                "rjnt","fkwc","glfz","zgna","xgik","ajyr","figf","eait","bwbf","kcvf","uelc","gkzi","bzxg","zosj","pcqy",
                "nmpd","tqzx","kxkt","mmpp","pusv","lqhk","tygg","zvsj","bzir","dimj","hcna","qowh","pbwe","awvl","vqtu",
                "rnjc","wala","ahzx","dkir","ifjg","ehmv","spfu","jhgb","xzen","kjzz","mqfd","ngcf","ombk","uryd","ukug",
                "mfqf","cckq","iirz","zpon","umim","wexl","oqen","pmbz","ncnp","gaom","hlkd","ansi","sdgr","skgj","ectt",
                "scoi","glxi","hpsw","zqqr","bpmy","qizb","ooyp","krsh","fjzp","xxeb","cxrd","atdr","gkpa","whuj","efco",
                "chyz","wkqu","lbft","fdck","baaf","ldnj","fymt","rbrn","jqhe","vqsm","btzp","uyor","sqdc","wrab","bcak",
                "yjgc","cftq","yjwu","tdcn","ezan","flls","cvid","pifn","foxo","gwhl","quhe","mxij","enph","hiww","elbs",
                "wgnl","jghd","tjbc","erpf","wvsj","xcon","airp","cnvq","snwr","bheb","nzxy","oqps","wybc","mevi","xmrz",
                "erim","grpo","xkkb","nvjl","djdu","wwem","vjrd","ygtu","izdc","cjzv","xrgo","wqtw","lcmm","scts","ekic",
                "xfog","girv","zqzz","emvq","uxoa","ptpr","bqyr","ewyz","soie","agyc","youk","nbhl","yhkr","jtgc","cfsu",
                "ahcd","zgvt","udap","hkzt","gvxo","dlyb","tbeb","uqpy","tqqx","excv","hmtl","wuoq","dqmf","vgja","whsv",
                "bpck","mjjh","kudv","rosx","cxpc","oski","lmyi","rzhu","hfsi","cpjb","winr","sxwe","woww","liri","vqjr",
                "zygh","nxrl","zifj","hqjn","arfr","sbpl","vdcx","tbvj","jjca","pflg","pdff","snmi","eqfi","jqav","zeqz",
                "errg","xkxr","ldds","fzyl","awmt","sveo","ahhc","byoh","nihj","rrbh","jmkg","otlg","ridf","bqza","yusc",
                "glyz","mcvx","iacb","rtrz","quld","aouq","knuj","gbfr","gonp","icrz","vfsp","avfh","wznr","fwfb","jwmd",
                "dnih","rltd","pndr","rwzi","myfx","aodv","pjbm","lnop","fvxv","rxto","zssv","wtbq","fgld","rkgv","fpuj",
                "elwn","fmla","djub","cokq","ckxh","zvau","qoxe","ampt","hztz","rgxf","dulf","yihb","yxmw","zmcu","tago",
                "fvcs","xbaz","dqnz","dtzb","dycj","puvo","oxls","ktdu","tluw","aquq","upsh","tbkf","boqk","dxuo","vcut",
                "oybv","mrak","nhyq","arfp","ffcm","spdo","fmes","vwaj","yzut","lgez","mgrj","vghp","hvjy","oyld","mdcx",
                "drry","tzic","lgot","olnm","bnhc","lsap","hvtc","xrit","kkig","kuec","faof","xeqz","zroq","enzv","riim",
                "jzzw","jszh","wsru","zoiy","rlui","wjmq","sjdh","izwv","qvlk","nppz","fbop","sane","wmtx","ogdq","xjmd",
                "zidh","bmgh","ywav","rylj","uuzs","ihkz","dyap","iqcb","maze","qbvq","zoqb","czti","dcee","lgqd","teji",
                "beug","tkui","sxji","hvrc","dqct","qaoq","natr","aega","lusm","miaa","nill","bmuw","mohc","gvku","ecpz",
                "wxct","kdlu","nlui","rgxn","mdtg","hrcy","bkgc","qslc","wjav","bexk","dqsh","yqbg","mvgy","aejh","ohka",
                "zbms","dqry","mqvo","ersg","mxjt","csyo","qcdy","ppth","ckaj","lfrf","ykbv","wmxy","wkek","vhui","svyz",
                "tvom","qbci","vtue","gajp","qonc","xwlh","ojwv","uzkd","mmeh","zvzk","cyaj","ndbh","crma","mqok","iwco",
                "dpzc","zwny","ssaz","bkok","ivlf","dyfv","sjwr","qokw","doul","vqtg","vqkz","llgi","nqqu","izwg","ndvj",
                "dpkw","kzma","hcak","hkaa","atzs","ofxg","dyju","xvkc","kazi","bkps","aipf","fart","nmng","gstc","cnig",
                "mqwz","srcr","eerw","gksq","uycm","qxxp","xqnv","voxk","qfta","eujl","rugd","sgqn","liwq","fsoq","dcxd",
                "pgbm","hyqo","ksnp","cfmu","gwjd","fmkh","qull","rxlp","uljf","xibv","jdqv","leba","qrsy","wfeg","jcnj",
                "cfzf","nvid","biiy","bkuz","jqdb","dcjd","dqgs","iwwx","zwho","zliq","ufwy","ynlk","cmtl","vziz","zyvf",
                "njmn","gtlk","xcml","dofz","hhsd","iqeb","nljd","wlto","nblt","xtpd","dqqk","duil","uzio","rlwf","celu",
                "fdtr","txaa","qvaz","qrhe","chxq","vsas","kemy","xyvd","ltel","wmlr","ibhs","cunn","pygi","uvvr","ajcg",
                "dova","vnns","zhsl","avqo","bafp","cbuy","ycdn","ugft","zftd","spsc","lbbg","tmvw","sexd","nnir","xpfn",
                "estp","hmwl","htty","zgzn","wvif","imgb","xyfu","ikjz","knon","pqhg","crjs","pffo","cboq","ypkg","oxpg",
                "esei","tcin","poul","ayil","wwsr","trom","pypj","hibh","nkqr","nmtn","ytxd","vhzs","wbbd","xydy","wmzg",
                "qujl","wzdo","ijyw","nody","piqh","wahv","hsob","eurz","zpco","gnic","jcil","icmu","xoqe","ogdh","xfjt",
                "azmx","vxex","shws","rrua","cocu","cvfl","oltk","xion","agxm","zexz","flyx","dlox","yudp","ksfn","vpjz",
                "cxtf","hwit","guie","hceb","umox","nsfz","fjpa","uuym","hwqw","htxl","plgv","vhdx","teez","eamt","bvim",
                "mjqq","epir","njva","jtwj","gjtf","xlpg","xdwt","pxwq","wntk","jawv","xcdo","qduj","cdce","lepv","pcgo",
                "mjpx","jzcn","ctli","avxi","uskh","rjzh","huek","nebq","vkqv","bumb","evxb","xcln","higc","uobl","coje",
                "pijw","ggnm","qloq","zkyn","wvct","cnfk","zoal","jghf","pdco","lfjs","maqw","srwn","vysx","xlqe","juua",
                "cdee","mgsi","weez","icue","efwa","ihkv","xqlc","eltc","iswi","mfao","ajni","bldw","wmhj","lmom","pyur",
                "hjyi","bvyo","hkcx","gvgm","dzex","kitt","nfwv","ultg","lyzw","nnib","yxsb","ygmp","nkcb","rqhh","aoua",
                "qkhy","xxet","hqgx","enxu","tzzt","dpmu","miwl","nlqo","proo","ijou","qlmt","jdnf","hznf","qkib","vocv",
                "dwcg","hpqr","cbvb","uyya","oemu","vfag","qqsk","dtmn","nptt","szmj","mgqm","lpwb","mttq","oieq","kaut",
                "jmve","unza","hxob","dveh","jxbj","pyuf","kluc","gwbw","rpuw","tdit","zmqq","rlly","pmno","oqqk","hyfp",
                "iyxb","utkz","vutq","tdoq","fnkq","cgjf","byap","gyqj","vgql","zhia","vdfn","brpf","nvqa","zfmg","dkcr",
                "aglr","bjfa","ngor","kghd","uhnq","ioid","ylcd","whvu","zqlg","adic","rqkj","lsnr","uvgd","qcue","wbbn",
                "vyad","mcyt","girt","hnuj","guuf","nrjx","nwbg","iddb","piez","ztvs","tzwx","oyfz","eech","tczp","ytzy",
                "guel","byht","lyjn","nwvg","pgno","iudl","ugft","onkn","mohc","yzew","cftx","lbbg","ssaz","jnar","phtp",
                "cxwt","ksfn","hoqy","dosp","guel","girv","dwbp","ridf","eyvz","tsep","chen","cyub","wzdo","sijx","sihf",
                "gmgv","mscd","wvsh","vwtm","izwg","vckf","skgj","zzzq","wsru","okbm","spuh","upsh","agzm","qgsn","lbbg",
                "bjpm","cqxh","ntcc","lukd","txaa","cgjf","jwpi","cyub","shkr","amzg","vtuc","uuzs","syqr","vxcd","mzsj",
                "ersg"});

        Assert.assertEquals(939, result);

    }
}
