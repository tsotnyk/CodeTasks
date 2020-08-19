package com.j2core.sts.leetcode.com.triplebute;

import org.testng.annotations.Test;

import java.util.*;

public class MySpreadsheet {

    private long key;
    long column;
    private Map<Long, List<String>> map;

    public MySpreadsheet(long row, long column) {
        this.key = 0;
        this.column = column;
        this.map = new HashMap<Long, List<String>>();

        for (int i = 0; i < row; i++){

            ArrayList<String> list = new ArrayList<String>();
            for (int j = 0; j < column; j++){
                list.add("");
            }
            map.put(key++, list);
        }
    }

    public boolean updateContent(int row, int column, String info){

        if (row <= key && column <= 3){
            map.get((long)row).add(column, info);
            return true;
        }
        return false;
    }

    public void printSpreadSheet(){

        for (Map.Entry entry : map.entrySet()){
            StringBuilder builder = new StringBuilder();
            ArrayList<String> list = (ArrayList<String>) entry.getValue();

            for (long i = 0; i < column-1; i++){
                builder.append(list.get((int)i)).append("|");
            }
            builder.append(list.get((int)column-1));

            System.out.println(builder.toString());
        }
    }

    @Test
    public static void main() {

        MySpreadsheet spreadsheet = new MySpreadsheet(4, 3);
        spreadsheet.updateContent(0, 0, "bob");
        spreadsheet.updateContent(0, 1, "10");
        spreadsheet.updateContent(0, 2, "foo");
        spreadsheet.updateContent(1, 0, "alice");
        spreadsheet.updateContent(1, 1, "5");

        spreadsheet.printSpreadSheet();
    }
}
