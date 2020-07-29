package com.j2core.sts.leetcode.com.tmp.liftoff;

public class IPv6Solution {


    public int[] parseString(String path) throws Exception {

        int[] result = new int[16];
        int indexResult = 15;
        String[] arraySubString = path.split(":");
        int indexSubString = arraySubString.length-1;

        if (arraySubString[indexSubString].indexOf('.') > -1){
            String[] array = arraySubString[indexSubString].split(".");
            if (array.length < 4) throw new Exception();
            for (String subString : array){
                int num = Integer.parseInt(subString);
                if (num > 255) throw new Exception();
                result[indexResult--] = num;
            }
            indexSubString--;
        }

        while (indexSubString > -1 && arraySubString[indexSubString].length() > 0){
            String tmpString = arraySubString[indexSubString--];
            if (tmpString.length() < 4){
                if (tmpString.length() == 1){
                    int num = Integer.parseInt(tmpString, 16);
                    if (num == 0){
                        indexResult -= 2;
                    }else {
                        result[indexResult--] = num;
                        indexResult--;
                    }
                }else {
                    if (tmpString.length() == 2){
                        result[indexResult--] = Integer.parseInt(tmpString, 16);
                        indexResult--;
                    }else {
                        result[indexResult--] = Integer.parseInt(tmpString.substring(1), 16);
                        result[indexResult--] = Integer.parseInt(tmpString.substring(0, 1), 16);
                    }
                }

            }else {
                int part2 = Integer.parseInt(tmpString.substring(2), 16);
                result[indexResult--] = part2;
                int part1 = Integer.parseInt(tmpString.substring(0, 2), 16);
                result[indexResult--] = part1;
            }
        }

        if (indexSubString > -1){
            int firstResult = 0;
            int firstSubString = 0;

            while (firstSubString < indexSubString){

            }
        }

        return result;
    }
}
