package com.j2core.sts.codefights.com.sortingAndSearching.higherVersion2;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    int higherVersion2(String ver1, String ver2) {

        List<Integer> listVer1 = parsStringVersion(ver1);
        List<Integer> listVer2 = parsStringVersion(ver2);
        int list1Size = listVer1.size();
        int list2Size = listVer2.size();

        int barrier = list1Size > list2Size ? list2Size : list1Size;
        int i;

        for(i = 0; i < barrier; i++){

            int num1 = listVer1.get(i);
            int num2 = listVer2.get(i);
            if (num1 != num2){

                if (num1 > num2){

                    return 1;

                }else {

                    return -1;

                }
            }
        }

        if (list1Size != list2Size){

            int result;
            int lastNum;
            List<Integer> ver;
            if(list1Size > list2Size){
                lastNum = list1Size;
                ver = listVer1;
                result = 1;
            }else {
                lastNum = list2Size;
                ver = listVer2;
                result = -1;
            }

            for (int j = i; j < lastNum; j++){

                int num = ver.get(j);
                if(num != 0){

                    return result;

                }
            }
        }

        return 0;
    }


    private List<Integer> parsStringVersion(String version){

        List<Integer> result = new LinkedList<>();

        int firstIndex = 0;
        for (int i = 0; i < version.length(); i++){

            if(version.charAt(i) == '.'){

                result.add(Integer.parseInt(version.substring(firstIndex, i)));
                firstIndex = i+1;
            }
        }

        if (firstIndex != version.length()){
            result.add(Integer.parseInt(version.substring(firstIndex)));
        }

        return result;

    }
}
