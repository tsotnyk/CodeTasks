package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FacebookOISolution {

    boolean isBadVersion(int version){
        return true;
    }
    public int firstBadVersion(int n) {

        return findBadVersion(1, n);

    }

    private int findBadVersion(int start, int end){

        if(start+1 == end) return isBadVersion(start) ? start : end;
        if (isBadVersion(start)) return start;
        int midl = start + ((end-start)/2);
        if (isBadVersion(midl)){
            return findBadVersion(start, midl);
        }
        return findBadVersion(midl, end);
    }

    public int numIslands(char[][] grid) {

        int counter = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    counter++;
                    helper(grid, i, j);
                }
            }
        }

        return counter;
    }

    private void helper(char[][] grid, int i, int j){

        grid[i][j] = '2';
        LinkedList<int[]> list = new LinkedList<>(Collections.singletonList(new int[]{i,j}));

        while (!list.isEmpty()){
            int[] point = list.removeFirst();
            if (point[0]+1 < grid.length && grid[point[0]+1][point[1]] == '1'){
                grid[point[0]+1][point[1]] = '2';
                list.add(new int[]{point[0]+1, point[1]});
            }
            if (point[0]-1 > -1 && grid[point[0]-1][point[1]] == '1'){
                grid[point[0]-1][point[1]] = '2';
                list.add(new int[]{point[0]-1, point[1]});
            }
            if (point[1]+1 < grid[0].length && grid[point[0]][point[1]+1] == '1'){
                grid[point[0]][point[1]+1] = '2';
                list.add(new int[]{point[0], point[1]+1});
            }
            if (point[1]-1 > -1 && grid[point[0]][point[1]-1] == '1'){
                grid[point[0]][point[1]-1] = '2';
                list.add(new int[]{point[0], point[1]-1});
            }
        }
    }

    class WordDictionary {

        private Map<Integer, Set<String>> map;

        /** Initialize your data structure here. */
        public WordDictionary() {
            map = new HashMap<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {

            int first = word.length();
            Set<String> list;
            if (map.containsKey(first)){

                list = map.get(first);
                list.add(word);
                map.put(first, list);
            }else {

                list = new HashSet<>();
                list.add(word);
                map.put(first, list);
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            int length = word.length();
            if (!map.containsKey(length)) return false;

            Set<String> set = map.get(length);

            if (isFullWord(word)){
                return set.contains(word);
            }else {
                for (String base : set){

                    if (equalsString(base, word)) return true;
                }
                return false;
            }
        }

        private boolean isFullWord(String word) {

            return word.indexOf('.') == -1;
        }

        private boolean equalsString(String base, String word){

            if (base.length() != word.length()) return false;

            for (int i = 0; i < word.length(); i++){

                char  tmp = word.charAt(i);
                if (tmp != '.'){
                    if (tmp != base.charAt(i)){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @Test
    public void testWordDic(){

//        WordDictionary dictionary = new WordDictionary();
//        dictionary.addWord("bad");
//        dictionary.addWord("dad");
//        dictionary.addWord("mad");
//
//        Assert.assertFalse(dictionary.search("pad"));
//        Assert.assertTrue(dictionary.search("bad"));
//        Assert.assertTrue(dictionary.search(".ad"));
//        Assert.assertTrue(dictionary.search("b.."));

//        WordDictionary dictionary = new WordDictionary();
//        dictionary.addWord("a");
//        dictionary.addWord("a");
//
//        Assert.assertTrue(dictionary.search("."));
//        Assert.assertTrue(dictionary.search("a"));
//        Assert.assertFalse(dictionary.search("aa"));
//        Assert.assertTrue(dictionary.search("a"));
//        Assert.assertFalse(dictionary.search("a."));
//        Assert.assertFalse(dictionary.search(".a"));


        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        Assert.assertFalse(dictionary.search("a"));
        Assert.assertFalse(dictionary.search(".at"));
        dictionary.addWord("bat");
        Assert.assertTrue(dictionary.search(".at"));
        Assert.assertTrue(dictionary.search("an."));
        Assert.assertFalse(dictionary.search("a.d."));
        Assert.assertFalse(dictionary.search("b."));
        Assert.assertTrue(dictionary.search("a.d"));
        Assert.assertFalse(dictionary.search("."));

    }

    public List<String> removeInvalidParentheses(String s) {

        if (s.length() == 0){
            return new LinkedList<>(Collections.singletonList(""));
        }

        int indexStart = s.indexOf('(');
        int indexEnd = s.lastIndexOf(')');

        if (indexStart < 0 && indexEnd < 0) {
            return new LinkedList<>(Collections.singleton(s));
        }

        if (validateString(s.toCharArray())) return new LinkedList<>(Collections.singletonList(s));

        List<char[]> list = new LinkedList<>(Collections.singletonList(s.toCharArray()));

        List<char[]> result = new LinkedList<>();

        while (result.isEmpty()){
            list = createPotentiallyString(list);
            for (char[] array : list){
                if (validateString(array)){
                    result.add(array);
                }
            }
        }

        return createStringList(result);
    }

    private boolean validateString(char[] toCharArray) {

        return  false;
    }

    private List<String> createStringList(List<char[]> list) {

        Set<String> result = new HashSet<>();
        StringBuilder builder;

        for (char[] array : list){
            builder = new StringBuilder();
            for (char symbol : array){
                if (symbol != ' '){
                    builder.append(symbol);
                }
            }
            result.add(builder.toString());
        }

        return new LinkedList<>(result);
    }

    private List<char[]> createPotentiallyString(List<char[]> stringList){

        List<char[]> list = new LinkedList<>();

        for (char[] array : stringList) {
            for (int i = 0; i < array.length; i++){
                if (array[i] == '(' || array[i] == ')') {
                    char[] newArray = Arrays.copyOf(array, array.length);
                    newArray[i] = ' ';
                    list.add(newArray);
                }
            }
        }
        return list;
    }
}
