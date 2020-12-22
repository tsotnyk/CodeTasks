package com.j2core.sts.leetcode.com.tmp;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Stack;

public class Dropbox {

    String textEditor(String[][] input) {

        Arrays.sort(input, (t1, t2) ->{
            return t1[0].compareTo(t2[0]);
        });

        StringBuilder builder = new StringBuilder();
        Stack<String> actions = new Stack<>();
        Stack<String> text = new Stack<>();

        for (String[] action : input){
            switch (action[1]){
                case "APPEND":
                    text.push(action[2]);
                    builder.append(action[2]);
                    break;
                case "BACKSPACE":
                    if (builder.length() > 0) {
                        text.push(builder.deleteCharAt(builder.length() - 1).toString());
                    }
                    break;
                case "UNDO":
                    if (!actions.isEmpty()){
                        String prevAction = actions.pop();
                        if (prevAction.equals("UNDO")){
                            actions.pop();
                            text.pop();
                            prevAction = actions.pop();
                        }
                        if (prevAction.equals("BACKSPACE")){
                            builder.append(text.peek());
                        }else if (prevAction.equals("APPEND")){
                            String lastAppend = text.peek();
                            builder.delete(builder.length()-lastAppend.length(), builder.length());
                        }
                    }
                    break;
                case "REDO":
                    if (!actions.isEmpty()){
                        if (actions.peek().equals("UNDO")){
                            actions.pop();
                            builder.append(text.pop());
                        }
                    }
                    break;
                case "SELECT":
                    int start = Integer.parseInt(action[2]);
                    if (start > 0 && start < builder.length()){
                        int end = Integer.parseInt(action[3]);
                        String remove = builder.substring(start, end);
//                        String ifBold = builder.append("*", start, start+1);

                        text.push(builder.toString());
                        builder.delete(start, end);
                    }
                    break;
                case "BOLD":
                    if (!actions.isEmpty() && actions.peek().equals("SELECT")){

                    }
                    break;
            }
            actions.push(action[1]);
        }

        return builder.toString();
    }

    @Test
    public void test(){

        String test = textEditor(new String[][]{{"2","APPEND"," word"},{"1","APPEND","Hi"},{"3","APPEND","!"},{"4","UNDO"},{"5","UNDO"},
                {"6", "REDO"}, {"7", "SELECT", "5", "7"}});
        Assert.assertEquals(test, "Hi wo");
    }
}
