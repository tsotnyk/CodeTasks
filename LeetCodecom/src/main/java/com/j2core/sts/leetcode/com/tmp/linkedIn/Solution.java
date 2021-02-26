package com.j2core.sts.leetcode.com.tmp.linkedIn;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    // leetcode 0 ms, faster than 100.00% of Java online submissions 01/25/21
    public int search(int[] nums, int target) {
        int index = nums.length-1;
        if(nums[0] == target) return 0;
        if (nums[index] == target) return index;
        int prevElement;
        if (nums[index] > target){
            prevElement = nums[index--];
            for (int i = index; i > -1 && nums[i] < prevElement; i--){
                if (nums[i] == target) return i;
            }
            return -1;
        }
        prevElement = nums[0];
        for (int i = 1; i < index && nums[i] > prevElement; i++){
            if (nums[i] == target) return i;
        }
        return -1;
    }

    // leetcode 0 ms, faster than 100.00% of Java online submissions 01/25/21
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        int product=1;

        for(int num : nums){
            product *= num;
            max = Math.max(product,max);
            if(product == 0)product = 1;

        }

        product = 1;
        for(int i=nums.length-1;i>=0;i--){
            product *= nums[i];
            max = Math.max(product,max);
            if(product ==0) product = 1;
        }

        return max;
    }

    //leetcode 14 ms, faster than 34.21% of Java online submissions 01/25/21
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<SortSymbol, List<String>> map = new HashMap<>();

        for (String str : strs){
            SortSymbol sortStr = new SortSymbol(str.toCharArray());
            if (map.containsKey(sortStr)){
                map.get(sortStr).add(str);
            }else {
                map.put(sortStr, new LinkedList<>(Collections.singletonList(str)));
            }
        }

        List<List<String>> result = new LinkedList<>();
        Set<SortSymbol> keySet = map.keySet();
        for (SortSymbol key : keySet){
            result.add(map.get(key));
        }

        return result;
    }

    class SortSymbol{

        char[] word;

        public SortSymbol(char[] array){

            Arrays.sort(array);
            this.word = array;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SortSymbol that = (SortSymbol) o;
            return Arrays.equals(word, that.word);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(word);
        }
    }

    @Test
    public void testGroupAnagrams(){

        Assert.assertEquals(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}).size(), 3);
    }

    // leetcode 6 ms, faster than 54.84% of Java online submissions
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (t1, t2) ->{

            if(t1[0] == t2[0]) return t1[1] - t2[1];

            return t1[0] - t2[0];
        });

        LinkedList<int[]> list = new LinkedList<>();

        for(int[] interval : intervals){
            if(list.isEmpty()){
                list.add(interval);
            }else{
                if(list.getLast()[1] < interval[0]){
                    list.add(interval);
                }else{
                    if(list.getLast()[1] < interval[1]){
                        list.getLast()[1] = interval[1];
                    }
                }
            }
        }

        int[][] matrix = new int[list.size()][];
        int index = 0;
        for(int[] interval : list){
            matrix[index++] = interval;
        }

        return matrix;
    }

    //leetcode 9 ms, faster than 13.84% of Java online submissions
    public boolean containsDuplicate2(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }

    //leetcode 1 ms, faster than 98.62% of Java online submissions
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char symbol : s.toCharArray()){

            if(symbol == '[' || symbol == '(' || symbol == '{'){
                stack.add(symbol);
            }else{
                if(stack.isEmpty()) return false;
                if(symbol == ')'){
                    if(stack.pop() != '(') return false;
                }else if(symbol == '}'){
                    if(stack.pop() != '{') return false;
                }else{
                    if(stack.pop() != '[') return false;
                }
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void testIsValid(){

        Assert.assertTrue(isValid("()"));
    }

    //leetcode 4 ms, faster than 81.86% of Java online submissions
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
            if(nums[i]==nums[i+1])
                return true;
        return false;
    }

    //leetcode 2 ms, faster than 95.52% of Java online submissions
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] array = new int[26];

        for(int symbol : s.toCharArray()){
            array[symbol-'a'] += 1;
        }

        for(int symbol : t.toCharArray()){
            if(array[symbol-'a'] == 0) return false;
            array[symbol-'a'] -= 1;
        }

        return true;
    }

    //leetcode 2 ms, faster than 36.53% of Java online submissions
    public int maxProfitV1(int[] prices) {

        if (prices.length <= 1) return 0;
        int profit = 0;
        int minPrice = prices[0];
        int maxPrice = prices[0];

        for (int i = 1; i < prices.length; i++){

            if (minPrice > prices[i]){
                minPrice = prices[i];
                maxPrice = prices[i];
            }else if (maxPrice < prices[i]){
                    maxPrice = prices[i];
                    int tmpProfit = maxPrice-minPrice;
                    if (profit < tmpProfit){
                        profit = tmpProfit;
                    }
            }
        }
        return profit;
    }

    //leetcode 2 ms, faster than 36.53% of Java online submissions
    public int maxProfitV2(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < min)
                min = prices[i];
            else
                profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    //leetcode 2 ms, faster than 28.00% of Java online submissions
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int sum = 1;
        int index = nums.length-1;
        while (index > -1){
            result[index] = sum;
            sum *= nums[index--];
        }

        index++;
        sum = 1;

        while (index < nums.length){
            result[index] *= sum;
            sum *= nums[index++];
        }

        return result;
    }

    //leetcode 1 ms, faster than 50.18% of Java online submissions
    public int maxSubArray(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

    //leetcode 0 ms, faster than 100.00% of Java online submissions
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                int compIndex = map.get(comp);
                return new int[]{i, compIndex};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }

    //leetcode 1 ms, faster than 6.49% of Java online submissions
    public int findMinV1(int[] nums) {

        int index;
        if (nums[0] < nums[nums.length-1]) return nums[0];

        int min = nums[0];
        int i = 1;
        int j = nums.length-1;

        while(i <= j){
            min = Math.min(min, nums[i++]);
            min = Math.min(min, nums[j--]);
        }
        return min;
    }

    // leetcode 0 ms, faster than 100.00% of Java online submissions
    public int findMinV2(int[] nums) {
        int first = 0;
        int last = nums.length-1;
        if (nums[first] < nums[last]) return nums[first];

        while (first < last){

            if (nums[first] > nums[first+1]) return nums[first+1];

            if (nums[last] < nums[last-1]) return nums[last];

            first++;
            last--;
        }

        return nums[0];
    }

      public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  //leetcode 1 ms, faster than 14.25% of Java online submissions
    public ListNode removeNthFromEndV1(ListNode head, int n) {

        ListNode node = head;
        ListNode nextNode = head;
        int counter = 0;

        while (nextNode.next != null){
            nextNode = nextNode.next;
            if (counter >= n){
                node = node.next;
            }
            counter++;
        }
        if (counter < n) return head.next;

        node.next = node.next.next;
        return head;
    }

    //leetcode 0 ms, faster than 100.00% of Java online submissions
    public ListNode removeNthFromEndV2(ListNode head, int n) {

        ListNode first = head, second = head;
        for (int i=0; i<n; i++) {
            first = first.next;
        }
        if (first == null) {
            return head.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        if (second.next != null) {
            second.next = second.next.next;
        }
        return head;
    }

    @Test
    public void testRemoveFromList(){

        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next  = new ListNode(2);
        root.next.next.next  = new ListNode(3);
        root.next.next.next.next  = new ListNode(4);
        root.next.next.next.next.next  = new ListNode(5);

        ListNode tmp = removeNthFromEndV2(root, 2);
        Assert.assertTrue(tmp.val == 0);
    }

    public int characterReplacementV1(String s, int k) {
        int length = s.length();
        if (length <= k){
            return length;
        }

        int result = k;
        for (int i = 0; i < length-k; i++){
            int changes = k;
            char baseChar = s.charAt(i);
            int index = i+1;
            int counter = 1;
            while (index < length && (s.charAt(index) == baseChar || changes > 0)){
                counter++;
                if(s.charAt(index) != baseChar){
                    changes--;
                }
                index++;
            }
            counter = Math.min(counter + changes, length);

            if (result < counter){
                result = counter;
            }
        }
        return result;
    }

    public int characterReplacement(String s, int k) {

        if (s.length() < 1) return k;
        int nextIndex = -1;
        int counter = 1;
        int maxLength = k;
        int changes = k;
        char symbol = s.charAt(0);
        for (int i = 1; i < s.length();){
            if (symbol == s.charAt(i)){
                counter++;
                i++;
            }else {
                if (changes > 0){
                    if (nextIndex < 0) nextIndex = i;
                    changes--;
                    counter++;
                    i++;
                }else {
                    i = nextIndex != -1 ? nextIndex : i;
                    symbol = s.charAt(i);
                    nextIndex = -1;
                    maxLength = Math.max(maxLength, counter);
                    counter = 1;
                    changes = k;
                    i++;
                }
            }
        }

        if (changes > 0){

            counter = counter+changes >= s.length() ? s.length() : counter;
        }
        return  Math.max(maxLength, counter);
    }

    @Test
    public void testCharacterReplacement(){

        Assert.assertEquals(characterReplacement("AAAB", 0), 3);
    }

    //leetcode 2 ms, faster than 95.70% of Java online submissions
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxWater = j*Math.min(height[i], height[j]);
        if (height[i] < height[j]){
            i++;
        }else j--;
        while (i < j){
            maxWater = Math.max((j-i)*Math.min(height[i], height[j]), maxWater);
            if (height[i] < height[j]){
                i++;
            }else j--;
        }

        return  maxWater;
    }

    //leetcode 0 ms, faster than 100.00% of Java online submissions
    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        ListNode node;

        while (head != null){
            node = head;
            head = head.next;
            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    //leetcode 0 ms, faster than 100.00% of Java online submissions
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode rabbit = head.next;
        ListNode tortoise = head;

        while (rabbit != null && rabbit.next != null){
            if (rabbit == tortoise) return true;
            rabbit = rabbit.next.next;
            tortoise = tortoise.next;
        }

        return false;
    }

    //leetcode 13 ms, faster than 26.54% of Java online submissions
    public int lengthOfLongestSubstringV1(String s) {
        if (s.length() < 1) return 0;
        int maxLength = 1;
        HashSet<Character> map = new HashSet<>();
        int indexS = 0;
        int index = 0;

        while (index < s.length()){

            if (map.contains(s.charAt(index))){
                maxLength = Math.max(maxLength, index-indexS);
                while (map.contains(s.charAt(index))){
                    map.remove(s.charAt(indexS++));
                }
            }
            map.add(s.charAt(index++));
        }

        return Math.max(maxLength, index-indexS);
    }

    public int lengthOfLongestSubstringV2(String s) {

        if (s.length() < 2) return s.length();

        int maxLength = 1;
        int tmpLength = 0;
        int indexBack = 0;
        int[] alphabet = new int[128];

        for (int i = 0; i < s.length(); i++){
            char tmpChar = s.charAt(i);
            if (alphabet[tmpChar] == 0){
                alphabet[tmpChar] += 1;
                tmpLength++;
            }else {
                int index = s.lastIndexOf(tmpChar, i-1);
                maxLength = Math.max(maxLength, tmpLength);
                indexBack = Math.max(index, indexBack);
                tmpLength = i-indexBack;
            }
        }
        return Math.max(maxLength, tmpLength);
    }

    @Test
    public void testLengthOfLongestSubString(){

        Assert.assertEquals(lengthOfLongestSubstringV1("cbb"), 2);
        Assert.assertEquals(lengthOfLongestSubstringV1("abcabcbb"), 3);
        Assert.assertEquals(lengthOfLongestSubstringV1("dvdf"), 3);

    }

    //leetcode 1 ms, faster than 100.00% of Java online submissions
    public int numIslands(char[][] grid) {

        int counter = 0;
        for(int i = 0; i  < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    counter++;
                    paintIsland(grid, i, j);
                }
            }
        }

        return counter;
    }

    private void paintIsland(char[][] grid, int i, int j) {

        grid[i][j] = '2';
        if (i-1 > -1 && grid[i-1][j] == '1'){
            paintIsland(grid, i-1, j);
        }
        if (i+1 < grid.length && grid[i+1][j] == '1'){
            paintIsland(grid, i+1, j);
        }
        if (j-1 > -1 && grid[i][j-1] == '1'){
            paintIsland(grid, i, j-1);
        }
        if (j+1 < grid[0].length && grid[i][j+1] == '1'){
            paintIsland(grid, i, j+1);
        }
    }

    @Test
    public void testNumIslands(){

        Assert.assertEquals(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}), 1);
    }

    //leetcode 462 ms, faster than 9.46% of Java online submissions
    public int countSubstringsV1(String s) {

        int counter = s.length();
        for (int i = 0; i < s.length()-1; i++){
            for (int j = i+1; j < s.length(); j++){
                if (isSubStringPalindrome(s, i, j)) counter++;
            }
        }

        return counter;
    }

    boolean isSubStringPalindrome(String srt, int i, int j){

        while (i < j){
            if (srt.charAt(i++) != srt.charAt(j--)) return false;
        }
        return true;
    }

    public int countSubstringsV2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                if(s.charAt(i)==s.charAt(j) && (j+1>i-1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public int countSubstringsV3(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandOutward(s, i, i);
            count += expandOutward(s, i, i + 1);
        }
        return count;
    }

    private int expandOutward(String s, int lo, int hi) {
        int count = 0;
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
            count++;
        }
        return count;
    }

    public ListNode mergeKListsV1(ListNode[] lists) {

        if (lists.length < 1) return null;
        ListNode root = findSmallestValue(lists);
        if (root == null) return root;
        ListNode node = root;
        node.next = findSmallestValue(lists);
        while (node.next != null){
            node = node.next;
            node.next = findSmallestValue(lists);
        }

        return root;

    }

    private ListNode findSmallestValue(ListNode[] lists){
        int index = -1;
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++){
            if (lists[i] != null && lists[i].val < value){
                value = lists[i].val;
                index = i;
            }
        }
        if (index < 0) return null;
        ListNode node = lists[index];
        lists[index] = node.next;
        node.next = null;
        return node;
    }

    @Test
    public void testMergeKLists(){

//        ListNode r1 = null;
//        ListNode r2 = new ListNode(1);
//        ListNode result1 = mergeKLists(new ListNode[]{r1, r2});


        ListNode array1 = new ListNode(1);
        array1.next = new ListNode(4);
        array1.next.next = new ListNode(5);
        ListNode array2 = new ListNode(1);
        array2.next = new ListNode(3);
        array2.next.next = new ListNode(4);
        ListNode array3 = new ListNode(2);
        array3.next = new ListNode(6);
        ListNode[] list = new ListNode[]{array1, array2, array3};

        ListNode result = mergeKListsV2(list);
    }

    public ListNode mergeKListsV2(ListNode[] lists) {

        if (lists == null || lists.length < 1) return null;
        if (lists.length == 1) return lists[0];

        for (int i = 1; i < lists.length; i++){
            lists[i] = mergeTwoListNodes(lists[i-1], lists[i]);
        }

        return lists[lists.length-1];
    }

    private ListNode mergeTwoListNodes(ListNode node1, ListNode node2){

        if (node1 == null) return node2;
        if (node2 == null) return node1;

        ListNode root;
        if (node1.val <= node2.val){
            root = node1;
            node1 = node1.next;
            root.next = null;
        }else {
            root = node2;
            node2 = node2.next;
            root.next = null;
        }
        ListNode node = root;

        while (node1 != null && node2 != null){
            if (node1.val <= node2.val){
                node.next = node1;
                node1 = node1.next;
            }else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }

        if (node1 != null){
            node.next = node1;
        }
        if (node2 != null){
            node.next = node2;
        }

        return root;
    }

    class MedianFinderV1 {

        ArrayList<Integer> list;
        int size = 0;
        /** initialize your data structure here. */
        public MedianFinderV1() {
            this.list = new ArrayList<>();
        }

        public void addNum(int num) {

            if (size == 0){
                list.add(num);
                this.size++;
                return;
            }

            if (num < list.get(0)){
                list.add(0, num);
            }else if (num > list.get(size-1)){
                list.add(num);
            }else {
                int left = 0;
                int right = size - 1;
                while(left <= right)
                {
                    int mid = left + (right - left) / 2;
                    if(num >= list.get(mid)) left = mid + 1;
                    else right = mid - 1;
                }
                    list.add(left, num);
            }
            this.size++;
        }

        public double findMedian() {
            int index = this.size/2;
            if (this.size%2 != 0){
                return list.get(index);
            }else {
                return ((double)list.get(index)+(double)list.get(index-1))/2.0;
            }
        }
    }

    class MedianFinder {

        // [...MaxHeap... | ...MinHeap...]
        // max heap contains all the smaller numbers - left half of the array
        // min heap contains all the larger numbers - right half of the array

        PriorityQueue<Double> minHeap;
        PriorityQueue<Double> maxHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        // O(lgn)
        public void addNum(int num) {
            if (maxHeap.isEmpty() || num > maxHeap.peek()) {
                minHeap.offer((double)num);
                if (minHeap.size() - maxHeap.size() == 2) {
                    maxHeap.offer(minHeap.poll());
                }
            }
            else {
                maxHeap.offer((double)num);
                if (maxHeap.size() - minHeap.size() == 2) {
                    minHeap.offer(maxHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) { // even # of elements
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
            else { // odd # of elements
                return (minHeap.size() > maxHeap.size()) ? minHeap.peek() : maxHeap.peek();
            }
        }
    }

    @Test
    public void testMedianFinder(){

        MedianFinder finder = new MedianFinder();
        finder.addNum(6);
        double v1 = finder.findMedian();
        finder.addNum(10);
        double v2 = finder.findMedian();
        finder.addNum(2);
        double v3 = finder.findMedian();
        finder.addNum(6);
        double v4 = finder.findMedian();
        finder.addNum(5);
        double v5 = finder.findMedian();
        finder.addNum(0);
        double v6 = finder.findMedian();
        finder.addNum(6);
        double v7 = finder.findMedian();
        finder.addNum(3);
        double v8 = finder.findMedian();
        finder.addNum(1);
        double v9 = finder.findMedian();
        finder.addNum(0);
        double v10 = finder.findMedian();
        finder.addNum(0);
        double v11 = finder.findMedian();

        System.out.println("Yes");
    }
}
