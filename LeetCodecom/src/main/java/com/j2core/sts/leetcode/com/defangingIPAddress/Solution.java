package com.j2core.sts.leetcode.com.defangingIPAddress;

public class Solution {

    public String defangIPaddrOneLine(String address) {

        return address.replace(".", "[.]");

    }

    public String defangIPaddr(String address) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < address.length(); i++){

            char character = address.charAt(i);
            if (character == '.'){
                builder.append("[.]");
            }else {
                builder.append(character);
            }
        }

        return builder.toString();
    }
}
