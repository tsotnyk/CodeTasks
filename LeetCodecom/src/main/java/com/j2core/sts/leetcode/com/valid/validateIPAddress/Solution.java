package com.j2core.sts.leetcode.com.valid.validateIPAddress;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String validIPAddress(String IP) {

        List<String> list = new LinkedList<>();
        int index = 0;
        int indexEnd = 0;
        int length = IP.length();
        int counter = 0;
        int points = 0;

        while (indexEnd < length){
            if (counter > 4){
                return "Neither";
            }
            char tmp = IP.charAt(indexEnd);
            if (tmp == '.' || tmp == ':'){
                points++;
                if (counter == 0){
                    return "Neither";
                }
                list.add(IP.substring(index, indexEnd));
                index = ++indexEnd;
                counter = 0;
            }else {
                indexEnd++;
                counter++;
            }
        }
        if (index != indexEnd){

            if (length - index > 4){
                return "Neither";
            }
            list.add(IP.substring(index));
        }

        if (list.size() == 8){
            if (points > 7){
                return "Neither";
            }else {
                return validateIPv6(list) ? "IPv6" : "Neither";
            }
        }

        if (list.size() == 4) {
            if (points > 3) {
                return "Neither";
            } else {
                return validateIPv4(list) ? "IPv4" : "Neither";
            }
        }
        return "Neither";
    }

    private boolean validateIPv4(List<String> list){

        if (list.size() != 4){
            return false;
        }
            for (String string : list){
                int length = string.length();
                if (length > 3){
                    return false;
                }
                if (length > 1 && string.charAt(0) == '0'){
                    return false;
                }
                int index = 0;
                while (index < length){
                    if (!Character.isDigit(string.charAt(index))){
                        return false;
                    }
                    index++;
                }

                int num = Integer.parseInt(string);
                if (num > 255){
                    return false;
                }
            }

        return true;
    }

    private boolean validateIPv6(List<String> list){

        for (String string : list) {
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                boolean isDigit = c >= 48 && c <= 57;
                boolean isUppercaseAF = c >= 65 && c <= 70;
                boolean isLowerCaseAF = c >= 97 && c <= 102;
                if (!(isDigit || isUppercaseAF || isLowerCaseAF))
                    return false;
            }
        }
        return true;
    }


    @Test
    public void test(){

        String result  = validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:73341");

        Assert.assertEquals(result, "Neither");
    }
}
