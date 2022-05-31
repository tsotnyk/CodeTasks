package interview.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public int minSwaps(int[] data) {

        int iS = -1;
        int iE = -1;
        int counter = 0;

        for (int i = 0; i< data.length; i++){
            if (data[i] == 1){
                if (iE == -1){
                    iS = i;
                    iE = i;
                }else {
                    iE = i;
                }
                counter++;
            }
        }
        if (counter == 0) return 0;
        return countMinSwaps(data, iS, iE, counter);
    }

    private int countMinSwaps(int[] data, int iS, int iE, int counter) {
        int minSwap = 0;
        for (int i = iS; i < iS+counter; i++){
            if (data[i] == 0){
                minSwap++;
            }
        }

        int swap = minSwap;
        while (iS+counter <= iE){
            if (data[iS] == 0){
                swap--;
            }
            if (data[iS+counter] == 0){
                swap++;
            }
            iS++;
            minSwap = Math.min(minSwap, swap);
        }

        return minSwap;
    }

    @Test
    public void testMinSwaps(){

        Assert.assertEquals(3, minSwaps(new int[]{1,0,1,0,1,0,0,1,1,0,1}));
    }

    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }

    @Test
    public void testCountBinarySubstring(){

        Assert.assertEquals(6, countBinarySubstrings("00110011"));
    }

    public long subArrayRanges(int[] nums) {

        long result = 0;

        for (int i = 0; i < nums.length-1; i++){
            int min = nums[i];
            int max = nums[i];
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] < min){
                    min = nums[j];
                }else if (nums[j] > max){
                    max = nums[j];
                }
                result += max-min;
            }
        }

        return result;
    }

    public class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private void addNode(DLinkedNode node) {
            /**
             * Always add the new node right after head.
             */
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node){
            /**
             * Remove an existing node from the linked list.
             */
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedNode node){
            /**
             * Move certain node in between to the head.
             */
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            /**
             * Pop the current tail.
             */
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            // head.prev = null;

            tail = new DLinkedNode();
            // tail.next = null;

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) return -1;

            // move the accessed node to the head;
            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if(node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                addNode(newNode);

                ++size;

                if(size > capacity) {
                    // pop the tail
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // update the value.
                node.value = value;
                moveToHead(node);
            }
        }
    }

    public int minFlipsMonoIncr(String s) {
        int ones = 0, flips = 0;
        for(char c: s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                flips = Math.min(ones, flips + 1);
            }
        }
        return flips;
    }


    @Test
    public void testMinFlipsMonoIncr(){

        Assert.assertEquals(3, minFlipsMonoIncr("0101100011"));
    }

    public String[] reorderLogFiles(String[] logs) {

        List<String> digitLogs = new ArrayList<>(logs.length);
        List<String> letterLogs = new ArrayList<>(logs.length);

        for (String log : logs){
            if (Character.isDigit(log.charAt(log.length()-1))){
                digitLogs.add(log);
            }else {
                letterLogs.add(log);
            }
        }

        letterLogs.sort(((t1, t2) -> {

            String[] ar1 = t1.split(" ", 2);
            String[] ar2 = t2.split(" ", 2);

            if (ar1[1].equals(ar2[1])) {
                return ar1[0].compareTo(ar2[0]);
            }
            return ar1[1].compareTo(ar2[1]);
        }));

        letterLogs.addAll(digitLogs);
        return (String[]) letterLogs.toArray();

    }

    public int pairSum(ListNode head) {
        int res=0;

        ListNode fast=head, slow=head;
        ListNode prev=null, current=head, next= head.next;
        while (fast!=null && fast.next!=null){
            fast= fast.next.next;
            slow=slow.next;
        }

        while (current!=slow){
            // 1->2->3-6
            current.next=prev;
            prev=current;
            current=next;
            next=next.next;
        }
        while (prev!=null){
            int sum= prev.val+ current.val;
            res= sum>res? sum:res;
            current=current.next;
            prev=prev.next;
        }
        return res;
    }

    public int pairSum1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null){
            list.add(tmp);
            tmp = tmp.next;
        }
        head = reverse(head);

        int maxSum = Integer.MIN_VALUE;
        int index = 0;
        while (index < list.size()/2){
            maxSum = Math.max(maxSum, (head.val+ list.get(index++).val));
            head = head.next;
        }

        return maxSum;
    }

    private ListNode reverse(ListNode head){
        ListNode node = head;
        ListNode newHead = null;

        while (node != null){
            ListNode tmp = node;
            node = node.next;
            tmp.next = newHead;
            newHead = tmp;
        }

        return newHead;
    }

    @Test
    public void testPairSum(){

        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Assert.assertEquals(6, pairSum(head));
    }

    public int getMaxLen(int[] nums) {

        int maxLength = 0;
        int iS = 0;
        int iE = 0;
        int counter = 0;

        while (iE < nums.length){
            if (nums[iE] == 0){
                if (iE-iS > maxLength){
                    if (counter%2 == 0){
                        maxLength = Math.max(iE-iS, maxLength);
                    }else {
                        int minStep = findMinSteps(nums, iS, iE-1);
                        int length = iE-iS-minStep;
                        maxLength = Math.max(length, maxLength);
                    }
                }
                iS = iE+1;
                iE = iS;
                counter = 0;
            }else {
                if (nums[iE] < 0){
                    counter++;
                }
                iE++;
            }
        }
        if (counter%2 == 0){
            maxLength = Math.max(iE-iS, maxLength);
        }else {
            int minStep = findMinSteps(nums, iS, iE-1);
            int length = iE-iS-minStep;
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    private int findMinSteps(int[] nums, int iS, int iE) {

        int counter = 1;

        while (iS <= iE){
            if (nums[iS++] < 0 || nums[iE--] < 0) break;
            counter++;
        }

        return counter;
    }

    @Test
    public void testGetMaxLength(){

        Assert.assertEquals(4, getMaxLen(new int[]{1,2,3,5,-6,4,0,10}));
        Assert.assertEquals(3, getMaxLen(new int[]{0,1,-2,-3,-4}));

        Assert.assertEquals(14, getMaxLen(new int[]{70,-18,75,-72,-69,-84,64,-65,0,
                -82,
                62,54,-63,-85,53,-60,-59,29,32,59,
                -54,-29,-45,
                0,-10,22,42,-37,-16,0,
                -7,-76,-34,37,-10,2,-59,-24,85,45,
                -81,56,86}));
    }

    public int sumSubarrayMins(int[] arr) {
        long M = 1000000007;
        long value = 0;
        int minValue;
        for (int i = 0; i < arr.length; i++){
            minValue = arr[i];
            value = (value + minValue) % M;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < minValue){
                    minValue = arr[j];
                }
                value = (value + minValue) % M;
            }
        }
        return (int) value;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null) return  null;
        if (lists.length < 1) return null;
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++){
            ListNode newList = null;
            ListNode nextNode = null;
            ListNode node = lists[i];
            if (node == null) continue;
            while (result != null && node != null){
                ListNode tmp;
                if (result.val <= node.val){
                    tmp = result;
                    result = result.next;
                }else {
                    tmp = node;
                    node = node.next;
                }
                tmp.next = null;
                if (newList == null){
                    newList = tmp;
                    nextNode = tmp;
                }else {
                    nextNode.next = tmp;
                    nextNode = nextNode.next;
                }
            }
            if (nextNode != null) {
                if (result != null) nextNode.next = result;
                if (node != null) nextNode.next = node;
            }else {
                newList = node;
            }
            result = newList;
        }
        return result;
    }

    public int[][] kClosest(int[][] points, int k) {
        if (k < 1) return new int[][]{};

        Arrays.sort(points, (t1, t2) ->{

            double first = Math.pow(t1[0], 2)+ Math.pow(t1[1], 2);
            double second = Math.pow(t2[0], 2)+ Math.pow(t2[1], 2);

            return (int) (first - second);
        });

        int[][] result = new int[k][];

        System.arraycopy(points, 0, result, 0, k);

        return result;
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (t1, t2) -> {
            if (t1[0] != t2[0]) return t1[0] - t2[0];
            return t1[1] - t2[1];
        });

        List<int[]> list = new ArrayList<>(intervals.length);
        int[] curInterval = intervals[0];
        for (int[] inter : intervals){
            if (inter[0] > curInterval[1]){
                list.add(curInterval);
                curInterval = inter;
            }else {
                curInterval[1] = Math.max(curInterval[1], inter[1]);
            }
        }

        list.add(curInterval);
        int[][] result = new int[list.size()][];
        int index = 0;
        for (int[] ar : list){
            result[index++] = ar;
        }

        return result;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new LinkedList<>();
        List<String> baseList = new LinkedList<>();

        for (String prod : products){
            if (prod.charAt(0) == searchWord.charAt(0)){
                baseList.add(prod);
            }
        }
        Collections.sort(baseList);
        if (baseList.size() > 3) {
            result.add(baseList.subList(0, 3));
        }else result.add(baseList);

        for (int i = 1; i < searchWord.length(); i++){
            List<String> nextList = new LinkedList<>();
            char symbol = searchWord.charAt(i);
            for (String prod : baseList){
                if (prod.length() <= i) continue;
                if (prod.charAt(i) == symbol){
                    nextList.add(prod);
                }
            }
            baseList = nextList;
            if (baseList.size() > 3) {
                result.add(baseList.subList(0, 3));
            }else result.add(baseList);
        }

        return result;
    }

    String subsequence(String s, int k){

        LinkedList<Character> listChar = new LinkedList<>();
        int[] stat = new int[26];

        for (char symb : s.toCharArray()){
            int index = (int) symb-'a';
            stat[index] += 1;
            if (stat[index] >= k){
                if (listChar.isEmpty()){
                    listChar.add(symb);
                }else {
                    while (!listChar.isEmpty()){
                        if (listChar.getLast() > symb){
                            listChar.add(symb);
                            break;
                        }else {
                            listChar.removeLast();
                        }
                    }
                    if (listChar.isEmpty()) listChar.add(symb);
                }
            }
        }

        StringBuilder builder = new StringBuilder();

        for (char symb : listChar){
            for (int i = 0; i < k; i++){
                builder.append(symb);
            }
        }
        return builder.toString();
    }

}
