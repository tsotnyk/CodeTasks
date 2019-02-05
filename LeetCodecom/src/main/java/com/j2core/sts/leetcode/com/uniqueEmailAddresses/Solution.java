package com.j2core.sts.leetcode.com.uniqueEmailAddresses;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();

        for (String string : emails){

            set.add(dropSymbols(string));
        }

        return set.size();
    }

    private String dropSymbols(String string){

        StringBuilder builder = new StringBuilder();

        int index = 0;
        boolean flag = false;

        while (index < string.length()){

            char tmp = string.charAt(index);
            if (tmp == '@'){
                break;
            }else {
                if (tmp == '+'){
                    flag = true;
                }else if (tmp != '.' && !flag){
                    builder.append(tmp);
                }
            }
            index++;
        }

        builder.append(string.substring(index));

        return builder.toString();
    }


    @Test
    public void test(){

        String[] emails = new String[]{"fg.r.u.uzj+o.pw@kziczvh.com","r.cyo.g+d.h+b.ja@tgsg.z.com","fg.r.u.uzj+o.f.d@kziczvh.com","r.cyo.g+ng.r.iq@tgsg.z.com","fg.r.u.uzj+lp.k@kziczvh.com","r.cyo.g+n.h.e+n.g@tgsg.z.com","fg.r.u.uzj+k+p.j@kziczvh.com","fg.r.u.uzj+w.y+b@kziczvh.com","r.cyo.g+x+d.c+f.t@tgsg.z.com","r.cyo.g+x+t.y.l.i@tgsg.z.com","r.cyo.g+brxxi@tgsg.z.com","r.cyo.g+z+dr.k.u@tgsg.z.com","r.cyo.g+d+l.c.n+g@tgsg.z.com","fg.r.u.uzj+vq.o@kziczvh.com","fg.r.u.uzj+uzq@kziczvh.com","fg.r.u.uzj+mvz@kziczvh.com","fg.r.u.uzj+taj@kziczvh.com","fg.r.u.uzj+fek@kziczvh.com"};

        int result = numUniqueEmails(emails);

        Assert.assertEquals(result, 2);

    }
}
