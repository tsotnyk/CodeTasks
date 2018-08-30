package com.j2core.sts.codefights.com.codeInterview;

import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    List<String> retrieveMostFrequentlyUsedWord(String literetureText, List<String> wordsToExclude) {

        return null;

    }


    List<String> reorderLines(int logFileSize, List<String> loLines) {


        return null;


    }




        private void test() {

            Scanner scanner = new Scanner(System.in);
            String myString = scanner.next();
            int myInt = scanner.nextInt();
            String string = scanner.nextLine();
            long lOng = scanner.nextLong();
            scanner.close();

            System.out.println("myString is: " + myString);
            System.out.println("myInt is: " + myInt);

        }



        // code task for CaptivateIQ
    public  boolean arithmeticBoggle( int magicNumber, ArrayList<Integer> numbers ) {


        // Fill in the code here
        //
        //

        if (numbers.size() == 0){
            return magicNumber == 0;
        }
        if (numbers.size() == 1){
            return numbers.get(0).equals(magicNumber);
        }

        List<Integer> tmpResult = new ArrayList<>();
        tmpResult.add(numbers.get(0));
        tmpResult.add(numbers.get(0)*-1);

        for (int i = 1; i < numbers.size(); i++){

            List<Integer> temporaryList = new ArrayList<>();

            while (!tmpResult.isEmpty()) {
                Integer tmp = tmpResult.remove(0);

                temporaryList.add(tmp + numbers.get(i));
                temporaryList.add(tmp - numbers.get(i));
            }

            tmpResult = temporaryList;
        }

        for (int num : tmpResult){

            if (num == magicNumber){
                return true;
            }
        }

        return false;
        }
    }

