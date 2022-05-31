package com.j2core.sts.codefights.com.codeInterview.thumbtack;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution3 {


    int goodSubstrings(String strToSplit, int k) {

        int i = 1;
        int counter = 0;

        int min = strToSplit.charAt(0);
        int max = strToSplit.charAt(0);

        while(i < strToSplit.length()){
            int symbol = strToSplit.charAt(i);
            if(min > symbol){
                min = symbol;
            }
            if(max < symbol){
                max = symbol;
            }
            if(max-min > k){
                min = symbol;
                max = symbol;
                counter++;

            }else{
                i++;
            }
        }

        return counter+1;
    }

    @Test
    public void test(){

        Assert.assertEquals(4, goodSubstrings("aaabaaabb", 0));
        Assert.assertEquals(1, goodSubstrings("aaabaaabb", 1));
        Assert.assertEquals(3, goodSubstrings("aaabzaaabb", 10));

    }

    public static void main(String[] args) {
        HashSet<String> idSet = new HashSet<>();


        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
//            int index = 0;
            boolean line = false;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] array = data.split(",");
                if (!line){
                    line = true;
                }else {
                    idSet.add(array[0]);
                }
            }
            myReader.close();


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, int[]> map = new HashMap<>();
        for(int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int start =0;
        while(start<arr.length) {
            if(map.containsKey(arr[start])) {
                int[] piece = map.get(arr[start]);
                for(int i=0; i<piece.length; i++) {
                    if(arr[start] != piece[i]) {
                        break;
                    }
                    else{
                        start++;
                    }
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test2(){

        Assert.assertTrue(canFormArray(new int[]{1,2,5,3}, new int[][]{{5},{1,2},{3}}));
        Assert.assertFalse(canFormArray(new int[]{1, 2, 5, 3, 6}, new int[][]{{1,2},{5},{6,3}}));
        Assert.assertFalse(canFormArray(new int[]{1, 5, 4, 3, 2, 8}, new int[][]{{4,3},{1,5},{2}}));
        Assert.assertFalse(canFormArray(new int[]{1, 5, 4, 3, 2, 8}, new int[][]{{1,5,5},{3,2}}));


    }

    public static List<Integer> findCompletePrefixes(List<String> names, List<String> query) {
        // Write your code here
        HashMap<Character, List<String>> map = new HashMap<>();

        for(String name : names){
            char firstLetter = name.charAt(0);
            if(map.containsKey(firstLetter)){
                map.get(firstLetter).add(name);
            }else{
                map.put(firstLetter, new LinkedList<>(Collections.singleton(name)));
            }
        }

        List<Integer> result = new LinkedList<>();

        for(String prefix : query){
            List<String> nameList = map.getOrDefault(prefix.charAt(0), new LinkedList<>());
            int counter = 0;

            for(String name : nameList){
                if(isPrefix(prefix, name)) counter++;
            }

            result.add(counter);
        }

        return result;
    }

    private static boolean isPrefix(String prefix, String name){

        if(prefix.length() >= name.length()) return false;

        for(int i = 1; i < prefix.length(); i++){
            if(prefix.charAt(i) != name.charAt(i)) return false;
        }

        return true;
    }

    @Test
    public void testHacker(){

        Assert.assertEquals(2, findCompletePrefixes(new LinkedList<>(Arrays.asList("steve", "stevens", "danny", "steves", "dan" ,
                "john" ,
                "johnny" ,
                "joe" ,
                "alex" ,
                "alexander")), new LinkedList<>(Arrays.asList("steve", "alex", "joe", "john", "dan"))));
    }

    public List<String> removeDuplicatesAndMerge(List<String> users) {
        // Write your code here
        int index = 1;
        HashMap<Key, HashSet<String>> map = new HashMap<>();

        for(String user : users){
            String[] userData = user.split(",");
            int i = 1;
            boolean flag = true;
            while(i < index){
                boolean findDuplicate = false;

                for(String data : userData){
                    if(map.get(i).contains(data)){
                        findDuplicate = true;
                        break;
                    }

                }

                if(findDuplicate){

                    map.get(i).addAll(Arrays.asList(Arrays.copyOfRange(userData, 1, userData.length)));
                    flag = false;
                    break;
                }
                i++;
            }

            if(flag){
                map.put(new Key(index++, userData[0].toUpperCase(Locale.ROOT)), new HashSet<>(Arrays.asList(userData)));
            }
        }
        List<String> result = new LinkedList<>();
        for (Map.Entry<Key, HashSet<String>> entry : map.entrySet()){

            List<String> data = (List<String>) entry.getValue();
            Collections.sort(data, (t1, t2) ->{

                if (Character.isDigit(t1.charAt(0)) ){
                    if (Character.isDigit(t2.charAt(0))){
                        return t1.charAt(0) - t2.charAt(0);
                    }else{
                        return -1;
                    }
                }else{
                    if (Character.isLetter(t2.charAt(0))){
                        return t1.charAt(0) - t2.charAt(0);
                    }else{
                        return 1;
                    }
                }
            });

        }

        Collections.sort(result);
        return result;
    }

     class Key{
        int index;
        String name;

        public Key(int index, String name) {
            this.index = index;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return index == key.index;
        }

        @Override
        public int hashCode() {
            return index;
        }
    }

}
