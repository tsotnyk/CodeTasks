package chapter4;

import org.testng.annotations.Test;

public class MinimalTree {

    public MyTree createTree(int[] array){

        return createNode(array, 0, array.length-1);
    }

    private MyTree createNode(int[] array, int iS, int iE){
        if (iE < iS) return null;
        if (iE-iS == 0) return new MyTree(array[iS]);

        int index = ((iE-iS)/2) + iS;
        MyTree result = new MyTree(array[index]);
        result.left = createNode(array, iS, index-1);
        result.right = createNode(array, index+1, iE);

        return result;
    }

    @Test
    public void test(){

        MyTree tree = createTree(new int[]{1,2,3,4,5,6,7,8,9,10,11});

        System.out.println("Test");
    }
}
