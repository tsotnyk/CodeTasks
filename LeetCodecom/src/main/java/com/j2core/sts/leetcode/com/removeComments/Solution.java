package com.j2core.sts.leetcode.com.removeComments;

import java.util.LinkedList;
import java.util.List;

public class Solution {


    public List<String> removeComments (String[] source){

        List<String> result = new LinkedList<>();
        List<List<Integer>> commentMarkers;

        String dopString = "";
        String tmpStr;
        boolean commentFlag = false;

        for (String line : source) {
            tmpStr = "";
            if (!line.contains("/") && !commentFlag) {
                result.add(line);
            } else {
                int index = line.indexOf("*/");

                if (commentFlag && index == -1) {
                    continue;
                } else {
                    if (commentFlag) {
                        if (index > -1) {
                            line = dopString + line.substring(index + 2);
                            commentFlag = false;
                            dopString = "";
                        }
                    }
                    commentMarkers = getCommentMarker(line);
                    if (!commentMarkers.get(2).isEmpty()) {
                        line = line.substring(0, commentMarkers.get(2).get(0));
                    }
                    if (!commentMarkers.get(0).isEmpty()) {
                        int i = 0;
                        dopString = line.substring(0, commentMarkers.get(0).get(i));
                        for (i = 1; i < commentMarkers.get(0).size(); i++) {
                            tmpStr = dopString + tmpStr + line.substring(commentMarkers.get(1).get(i - 1) + 2, commentMarkers.get(0).get(i));
                            dopString = "";
                        }
                        if (i - 1 < commentMarkers.get(1).size()) {
                            tmpStr = dopString + tmpStr + line.substring(commentMarkers.get(1).get(i - 1) + 2);
                            dopString = "";
                        } else {
                            commentFlag = true;
                        }
                    } else {
                        tmpStr = line;
                    }

                    if (tmpStr.length() > 0) {
                        result.add(tmpStr);
                    }
                }
            }
        }

        return result;
    }


    private List<List<Integer>> getCommentMarker(String line){

        List<Integer> openCommentIndex = new LinkedList<>();
        List<Integer> closeCommentIndex = new LinkedList<>();
        List<Integer> lineCommentIndex = new LinkedList<>();
        boolean openComment = false;

        for (int i = 0; i < line.length()-1; i++){
            if (line.charAt(i) == '/') {
                if (line.charAt(i+1) == '/'){
                    if (!openComment){
                        lineCommentIndex.add(i);
                        break;
                    }
                }if (line.charAt(i+1) == '*'){
                    if (!openComment) {
                        openCommentIndex.add(i);
                        i++;
                        openComment = true;
                    }
                }
            }else if (line.charAt(i) == '*'){
                if (line.charAt(i+ 1) == '/'){
                    if (openComment) {
                        closeCommentIndex.add(i);
                        i++;
                        openComment = false;
                    }
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        result.add(openCommentIndex);
        result.add(closeCommentIndex);
        result.add(lineCommentIndex);

        return result;
    }

}
