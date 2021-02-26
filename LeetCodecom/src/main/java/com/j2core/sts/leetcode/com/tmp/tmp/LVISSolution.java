package com.j2core.sts.leetcode.com.tmp.tmp;

import org.junit.Test;

import java.util.Arrays;

public class LVISSolution {

    public char[][] createCharacterMatrix(String word1, String word2){

        PairIndex indexes = findCrossWord(word1, word2);
        char[][] matrix = new char[word2.length()][word1.length()];
        for (char[] array : matrix){
            Arrays.fill(array, '.');
        }
        for (int i = 0; i < word1.length(); i++){
            matrix[indexes.i][i] = word1.charAt(i);
        }
        for(int i = 0; i < word2.length(); i++){
            matrix[i][indexes.j] = word2.charAt(i);
        }

        return matrix;
    }

    class PairIndex{
        int i;
        int j;

        public PairIndex(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    private PairIndex findCrossWord(String word1, String word2){

        for(int j = 0; j < word1.length(); j++){
            for (int i = 0; i < word2.length(); i++){
                if (word1.charAt(j) == word2.charAt(i)) return new PairIndex(i, j);
            }
        }

        return null;

    }

    @Test
    public void testFindCrossWord(){

        PairIndex indexes = findCrossWord("ABBA", "CCBB");

        System.out.println("i =" + indexes.i + "; j = " + indexes.j);

        PairIndex indexes1 = findCrossWord("TRIANGLE", "RECTANGLE");

        System.out.println("i =" + indexes1.i + "; j = " + indexes1.j);
    }

    @Test
    public void test(){

        char[][] matrix = createCharacterMatrix("ABBA", "CCBB");

        for (char[] array : matrix){
            System.out.println(array);
        }

        System.out.println("**********************");

        char[][] matrix1 = createCharacterMatrix("BANANA", "APPLE");

        for (char[] array : matrix1){
            System.out.println(array);
        }
        System.out.println("**********************");

        char[][] matrix2 = createCharacterMatrix("TRIANGLE", "RECTANGLE");

        for (char[] array : matrix2){
            System.out.println(array);
        }
        System.out.println("**********************");

        char[][] matrix3 = createCharacterMatrix("PLANET", "EARTH");

        for (char[] array : matrix3){
            System.out.println(array);
        }

    }
}
