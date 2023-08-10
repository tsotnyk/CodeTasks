package topKElements;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    int size;
    PriorityQueue<Integer> queue;

    // constructor to initialize topKHeap and add values in it
    public KthLargestElementInStream(int k, int[] nums) {
        // Write your code Here

        this.size = k;
        this.queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length && i < k; i++) {
            queue.add(nums[i]);
        }

        for (int j = k; j < nums.length; j++) {
            add(nums[j]);
        }
    }

    // adds element in the topKHeap
    public int add(int val) {
        // Your code will replace this placeholder return statement

        this.queue.add(val);
        if (this.queue.size() > this.size) this.queue.poll();
        return this.queue.peek();
    }

    // returns kth largest element from topKHeap
    public int returnKthLargest() {
        // Your code will replace this placeholder return statement

        return this.queue.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInStream inStream = new KthLargestElementInStream(3, new int[]{4, 5, 8, 2});
        System.out.println(inStream.add(3));
        System.out.println(inStream.add(5));
        System.out.println(inStream.add(10));
        System.out.println(inStream.add(9));
        System.out.println(inStream.add(4));
    }
}
