package com.j2core.sts.codefights.com.dataStructures.heapsAndStacksAndQueues.simplifyPath;

public class Solution {

    String simplifyPath(String path) {

        if (path.length() < 2) return path;

        String tmpPath = removeExcessSymbols(path);

        boolean flag = false;
        int steps = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = tmpPath.length()-1; i > -1;i--){

            if (tmpPath.charAt(i) != '/' && tmpPath.charAt(i) != '.' && !flag){
                builder.append(tmpPath.charAt(i));

            } else if (tmpPath.charAt(i) == '/' && flag){
                steps--;
                if (steps < 1){
                    flag = false;
                }
            } else if (tmpPath.charAt(i) == '/' && !flag){
                builder.append(tmpPath.charAt(i));
            }else if (tmpPath.charAt(i) == '.' && tmpPath.charAt(i-2) == '/'){
                steps++;
                flag = true;
                i = i-2;
            }else if (tmpPath.charAt(i) == '.' && tmpPath.charAt(i-2) != '/'){
                builder.append(tmpPath.charAt(i));
            }
        }

        return revertString(builder.toString());

    }

    private String revertString(String path){

        if (path.length() < 2) return path;
        StringBuilder builder = new StringBuilder();
        for (int i = path.length()-1; i > 0; i--){
            builder.append(path.charAt(i));
        }

        if (path.charAt(0) != '/') builder.append(path.charAt(0));
        return builder.toString();
    }

    private String removeExcessSymbols(String path){

        int pathLength = path.length();
        char slash = '/';
        char point = '.';

        StringBuilder builder = new StringBuilder();
        int index = 0;
        char lastSymbol = 0;
        for (int i = 0; i < pathLength;){

            if (i == 0){
                if (path.charAt(i) != slash){
                    builder.append(slash);
                    lastSymbol = slash;
                }
            }

            if (path.charAt(i) == slash){
                i++;

                if (i == pathLength){
                    if (path.charAt(i-2) == point && path.charAt(i-3) == point){
                        builder.append(slash);
                        lastSymbol = slash;
                    }
                    break;
                }

                if (i < pathLength && path.charAt(i) == slash){
                    while (i+1 < pathLength && path.charAt(i+1) == slash){
                        i++;
                    }
                    i--;
                }else if (i < pathLength && path.charAt(i) == point){
                    i++;
                    if (i< pathLength && path.charAt(i) == slash){
                        i--;
                        if (i == index+2){
                            if (lastSymbol != slash) {
                                builder.append(slash);
                            }
                            lastSymbol = slash;
                        }
                    }else {
                        if (lastSymbol != '/') {
                            builder.append(slash);
                        }
                        builder.append(point);
                        builder.append(path.charAt(i));
                        lastSymbol = path.charAt(i);
                        index = i;
                    }
                }else {
                    if (lastSymbol != slash) {
                        builder.append(slash);
                    }
                    builder.append(path.charAt(i));
                    lastSymbol = path.charAt(i);
                }
            }else {
                builder.append(path.charAt(i));
                lastSymbol = path.charAt(i);
            }
            i++;
        }

        return builder.toString();

    }
}
