package interview.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class FindNearestZero {

    public int[][] findNearestZero(int[][] matrix){
        LinkedList<ZeroNode> list = new LinkedList<>();
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int[][] result = createOutputMatrix(matrix, list, xLength, yLength);

        while (!list.isEmpty()){
            countSteps(result, list, xLength, yLength);
        }

        return result;
    }

    private void countSteps(int[][] result, LinkedList<ZeroNode> list, int xLength, int yLength){

        ZeroNode node = list.removeFirst();
        if (node.x < 0 || node.y < 0 || node.x >= xLength || node.y >= yLength || result[node.x][node.y] <= node.steps) return;
        result[node.x][node.y] = node.steps;
        list.add(new ZeroNode(node.x-1, node.y, node.steps+1));
        list.add(new ZeroNode(node.x+1, node.y,node.steps+1));
        list.add(new ZeroNode(node.x, node.y-1,node.steps+1));
        list.add(new ZeroNode(node.x, node.y+1,node.steps+1));
    }

    private int[][] createOutputMatrix(int[][] matrix, LinkedList<ZeroNode> list, int xLength, int yLength){

        int maxSteps = xLength+yLength-1;
        int[][] result = new int[xLength][yLength];

        for (int x = 0; x < xLength; x++){
            for (int y = 0; y < yLength; y++){
                if (matrix[x][y] == 0){
                    result[x][y] = 0;
                    list.add(new ZeroNode(x-1,y,1));
                    list.add(new ZeroNode(x+1,y,1));
                    list.add(new ZeroNode(x,y-1,1));
                    list.add(new ZeroNode(x,y+1,1));
                }else {
                    result[x][y] = maxSteps;
                }
            }
        }

        return result;
    }

    @Test
    public void test(){

        int[][] matrix = new int[][]{{1,1,1,0},{1,1,0,0},{1,0,0,1}};
        int[][] result = new int[][]{{3,2,1,0},{2,1,0,0},{1,0,0,1}};

        Assert.assertEquals(findNearestZero(matrix), result);
    }
}


class ZeroNode{

    int x;
    int y;
    int steps;

    public ZeroNode(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}
