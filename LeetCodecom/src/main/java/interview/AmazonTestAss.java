package interview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class AmazonTestAss {

    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        for (String logLine : logs) {
            String[] log = logLine.split(" ");
            map.put(log[0], map.getOrDefault(log[0], 0) + 1);
            if (!log[0].equals( log[1])) {
                map.put(log[1], map.getOrDefault(log[1], 0) + 1);
            }
        }

        List<String> userIds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= threshold) {
                userIds.add(entry.getKey());
            }
        }

        Collections.sort(userIds,new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        });

        return userIds;
    }

    public static List<String> processLogs1(List<String> logs, int threshold) {

        HashMap<String, Integer> counterTransaction = new HashMap<>();
        List<String> userId = new LinkedList<>();

        for (String log : logs){
            String[] data = log.split(" ");
            String idS = data[0];
            String idR = data[1];
            if (!counterTransaction.containsKey(idS)){
                userId.add(idS);
            }
            if (!counterTransaction.containsKey(idR)){
                userId.add(idR);
            }
            counterTransaction.put(idS, counterTransaction.getOrDefault(idS, 0)+1);
            if (!idS.equals(idR)){
                counterTransaction.put(idR, counterTransaction.getOrDefault(idR, 0)+1);
            }
        }

        List<String> result = new LinkedList<>();
        for (String id : userId){
            int countTr = counterTransaction.get(id);
            if (countTr >= threshold){
                result.add(id);
            }
        }

        result.sort((t1, t2) -> {
            int first = Integer.parseInt(t1);
            int second = Integer.parseInt(t2);
            return first-second;
        });

        return result;
    }

    @Test
    public void test(){

        LinkedList<String> list = new LinkedList<>();
        list.add("11 2 50");
        list.add("11 7 70");
        list.add("11 3 20");
        list.add("2 2 17");


        Assert.assertEquals(processLogs(list, 2), new LinkedList<>(Arrays.asList("2", "11")));

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("9 7 50");
        list1.add("22 7 70");
        list1.add("33 7 20");
        list1.add("22 7 17");


        Assert.assertEquals(processLogs(list1, 3), new LinkedList<>(Arrays.asList("7")));
    }


    //   Second question
    public static int countGroups(List<String> related) {
        // Write your code here
        if (null == related || related.isEmpty()) {
            return 0;
        }
        int count = 0;
        int[][] isConnected = new int[related.size()][related.size()];

        for (int i = 0; i < related.size(); i++) {

            String row = related.get(i);

            for (int j = 0; j < row.length(); j++) {

                // isConnected[i][j] = (row.charAt(j) - '0'); //Working
                isConnected[i][j] = Integer.parseInt(Character.toString(row.charAt(j)));
            }

        }

        boolean[] isReached = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!isReached[i]) {
                alignedGroups(isConnected, isReached, i);
                count++;

            }

        }
        return count;
    }

    private static void alignedGroups(int[][] isConnected, boolean[] isReached, int v) {
        isReached[v] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[v][i] == 1 && !isReached[i])
                alignedGroups(isConnected, isReached, i);

        }

    }

}
