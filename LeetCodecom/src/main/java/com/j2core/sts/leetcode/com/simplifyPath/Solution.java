package com.j2core.sts.leetcode.com.simplifyPath;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class Solution {

    public String simplifyPath(String path) {

        Stack<String> stack = parsString(path);

        if (stack.empty()) return "/";

        Object[] array = stack.toArray();
        StringBuilder builder = new StringBuilder();

        for (Object string : array){
            builder.append(string);
        }
        return builder.toString();
    }

    private Stack<String> parsString(String path){

        Stack<String> stack = new Stack<>();

        int index = 0;
        int indexStop = 1;
        String tmp = null;

        while (indexStop < path.length()){
            while (indexStop < path.length() && path.charAt(indexStop) != '/'){
                indexStop++;
            }
            tmp = path.substring(index, indexStop);
            index = indexStop;
            indexStop++;
            if (tmp.length() > 1) {
                if (tmp.equals("/..")) {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else if (!tmp.equals("/.")) {
                    stack.push(tmp);
                }
            }
        }

        if (index < path.length()) {
            tmp = path.substring(index, indexStop);
            if (tmp.length() > 1){
                stack.push(tmp);
            }
        }

        return stack;
    }

    @Test
    public void test(){

        Assert.assertEquals(simplifyPath("/home/"), "/home");
        Assert.assertEquals(simplifyPath("/../"), "/");
        Assert.assertEquals(simplifyPath("/home//foo/"), "/home/foo");
        Assert.assertEquals(simplifyPath("/a/./b/../../c/"), "/c");
        Assert.assertEquals(simplifyPath("/a/../../b/../c//.//"), "/c");
        Assert.assertEquals(simplifyPath("/a//b////c/d//././/.."), "/a/b/c");

    }
}
