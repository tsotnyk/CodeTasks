package twoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream {

    PriorityQueue<Integer> biggest;
    PriorityQueue<Integer> smallest;

    public MedianOfStream() {

        this.biggest = new PriorityQueue<>(Comparator.reverseOrder());
        this.smallest = new PriorityQueue<>();
        // Write your code here
    }

    public void insertNum(int num) {
        // Write your code here

        if (this.biggest.isEmpty() || this.smallest.isEmpty()){
            this.biggest.add(num);
            if (this.biggest.size() > 1){
                this.smallest.add(this.biggest.poll());
            }
            return;
        }

        if (this.biggest.peek() > num){
                this.biggest.add(num);
            }else {
                this.smallest.add(num);
        }

        if (Math.abs(this.biggest.size()-this.smallest.size()) > 1){
            if (this.biggest.size() > this.smallest.size()){
                this.smallest.add(this.biggest.poll());
            }else {
                this.biggest.add(this.smallest.poll());
            }
        }
    }

    public double findMedian() {

        if (this.biggest.size() == 0 && this.smallest.size() == 0) return 0;

        if (this.biggest.size() == this.smallest.size()){
            return ((double)this.biggest.peek()+(double)this.smallest.peek())/2.0;
        }
        // Replace this placeholder return statement with your code
        return this.smallest.size() > this.biggest.size() ? this.smallest.peek() : this.biggest.peek();
    }


   // ["MedianOfStream", "insertNum", "findMedian", "insertNum", "findMedian", "insertNum", "findMedian", "insertNum", "findMedian", "insertNum", "findMedian"] ,
    // [[], [-1], [], [-22], [], [-3], [], [-4], [], [-5]]

}
