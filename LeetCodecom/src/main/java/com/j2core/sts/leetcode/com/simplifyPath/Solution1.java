package com.j2core.sts.leetcode.com.simplifyPath;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class Solution1 {

    public String simplifyPath(String path) {

        LinkedList<String> list = new LinkedList<>();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i <= path.length(); i++){
            if (i == path.length() || path.charAt(i) == '/'){
                if (builder.length() == 0) continue;
                String dir = builder.toString();
                switch (dir){
                    case ".":
                        break;
                    case "..":
                        if (!list.isEmpty()) list.removeLast();
                        break;
                    default:
                        list.add(dir);
                }
                builder = new StringBuilder();
                continue;
            }
            builder.append(path.charAt(i));
        }

        if (list.size() == 0) return "/";

        builder = new StringBuilder();
        while (!list.isEmpty()){
            builder.append('/');
            builder.append(list.removeFirst());
        }

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(simplifyPath("/home/"), "/home");
        Assert.assertEquals(simplifyPath("/../"), "/");
        Assert.assertEquals(simplifyPath("/home//foo/"), "/home/foo");
        Assert.assertEquals(simplifyPath("/a/./b/../../c/"), "/c");
        Assert.assertEquals(simplifyPath("/a//b////c/d//././/.."), "/a/b/c");
    }

}
