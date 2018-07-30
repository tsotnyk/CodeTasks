package com.j2core.sts.leetcode.com.string.subdomainVisitCount;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {

        List<VisitDomain> tmpResult = new LinkedList<>();

        for (String string : cpdomains){

            int index = 0;

                while (Character.isDigit(string.charAt(index))){

                    index++;
                }

                int amountVisit = Integer.parseInt(string.substring(0, index));
                index++;
            List<String> tmpDomain = new LinkedList<>();
            tmpDomain.add(string.substring(index));

            while (index < string.length()){

                if (string.charAt(index) == '.'){

                    tmpDomain.add(string.substring(index+1));
                }
                index++;
            }

            for (String tmpString : tmpDomain){
                boolean flag = true;
                for (VisitDomain domain : tmpResult){

                    if (domain.domain.equals(tmpString)){

                        domain.setAmountVisit(amountVisit);
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    tmpResult.add(new VisitDomain(amountVisit, tmpString));
                }
            }
        }

        return revertVisitDomainToString(tmpResult);

    }


    private List<String> revertVisitDomainToString(List<VisitDomain> data){

        List<String> result = new LinkedList<>();

        for (VisitDomain domain : data){

            result.add(domain.amountVisit + " " + domain.domain);

        }

        return result;
    }


    class VisitDomain{

        int amountVisit;
        String domain;

        public VisitDomain(int amountVisit, String domain){

            this.amountVisit = amountVisit;
            this.domain = domain;
        }

        public void setAmountVisit(int amountVisit) {
            this.amountVisit = this.amountVisit + amountVisit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VisitDomain that = (VisitDomain) o;
            return amountVisit == that.amountVisit &&
                    Objects.equals(domain, that.domain);
        }

        @Override
        public int hashCode() {

            return Objects.hash(amountVisit, domain);
        }
    }

}
