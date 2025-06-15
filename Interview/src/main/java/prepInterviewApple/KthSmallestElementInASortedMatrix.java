package prepInterviewApple;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (pq.size() < k) {
                    pq.add(matrix[i][j]);
                    continue;
                }
                if (matrix[i][j] < pq.peek()){
                    pq.poll();
                    pq.add(matrix[i][j]);
                }
            }
        }

        return pq.peek();

    }

    @Test
    public void test(){

        Assert.assertEquals(kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8), 13);
    }
}
