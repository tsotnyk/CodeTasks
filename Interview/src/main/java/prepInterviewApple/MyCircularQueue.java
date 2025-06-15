package prepInterviewApple;
 class MyCircularQueue {

    int[] queue;
    int inStart;
    int inEnd;


    public MyCircularQueue(int k) {

        this.queue  = new int[k];
        this.inEnd = 0;
        this.inStart = -1;
    }

    public boolean enQueue(int value) {

        if (isFull()) return false;
        this.queue[this.inEnd++] = value;
        if (this.inEnd == this.queue.length) this.inEnd = 0;
        if (this.inStart == -1) this.inStart = 0;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        this.inStart++;
        if (this.inStart == this.queue.length) this.inStart = 0;
        if (this.inStart == this.inEnd) {
            this.inStart = -1;
            this.inEnd = 0;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return this.queue[this.inStart];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        int index = this.inEnd;
        return index == 0 ? this.queue[this.queue.length-1] : this.queue[index-1];
    }

    public boolean isEmpty() {
        return this.inStart < 0;
    }

    public boolean isFull() {
        return this.inStart == this.inEnd;
    }

     public static void main(String[] args) {

//         MyCircularQueue myQueue = new MyCircularQueue(6);
//         System.out.println(myQueue.enQueue(6));
//         System.out.println(myQueue.Rear());
//         System.out.println(myQueue.Rear());
//         System.out.println(myQueue.deQueue());
//         System.out.println(myQueue.enQueue(5));
//         System.out.println(myQueue.Rear());
//         System.out.println(myQueue.deQueue());
//         System.out.println(myQueue.Front());
//         System.out.println(myQueue.deQueue());
//         System.out.println(myQueue.deQueue());
//         System.out.println(myQueue.deQueue());

        MyCircularQueue myQueue = new MyCircularQueue(3);
        System.out.println(myQueue.enQueue(1));
         System.out.println(myQueue.enQueue(2));
         System.out.println(myQueue.enQueue(3));
         System.out.println(myQueue.enQueue(4));
         System.out.println(myQueue.Rear());
         System.out.println(myQueue.isFull());
         System.out.println(myQueue.deQueue());
         System.out.println(myQueue.enQueue(4));
         System.out.println(myQueue.Rear());


     }
}
