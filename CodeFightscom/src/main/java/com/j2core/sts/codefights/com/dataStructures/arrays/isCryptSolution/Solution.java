package com.j2core.sts.codefights.com.dataStructures.arrays.isCryptSolution;

public class Solution {

    boolean isCryptSolution(String[] crypt, char[][] solution) {

        String numberWord1 = getNumber(solution, crypt[0]);

        if (numberWord1.length() > 1 && numberWord1.charAt(0) == '0') return false;

        String numberWord2 = getNumber(solution, crypt[1]);

        if (numberWord2.length() > 1 && numberWord2.charAt(0) == '0') return false;

        String numberWord3 = getNumber(solution, crypt[2]);

        if (numberWord3.length() > 1 && numberWord3.charAt(0) == '0') return false;

        long result = Long.parseLong(numberWord1) + Long.parseLong(numberWord2);

        if (result != Long.parseLong(numberWord3)){

            return false;

        }else return true;
    }


    private String getNumber(char[][] solution, String word){

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < word.length(); i++){

            char tmpChar = word.charAt(i);
            for (int j = 0; j < solution.length; j++){

                if (solution[j][0] == tmpChar){
                    builder.append(solution[j][1]);
                    break;
                }
            }
        }
        return builder.toString();
    }
}
