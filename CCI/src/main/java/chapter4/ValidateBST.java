package chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateBST {

    public boolean isBST(MyTree root){

        return validation(root, new MinMaxObject()).valid;
    }

    private MinMaxObject validation(MyTree root, MinMaxObject result){

        if (root == null){
            return result;
        }

        result.min = Math.min(result.min, root.value);
        result.max = Math.max(result.max, root.value);

        if (root.left != null){
            if (root.left.value > root.value){
                result.valid = false;
                return result;
            }
        }
        if (root.right != null){
            if (root.right.value < root.value){
                result.valid = false;
                return result;
            }
        }
        result = validation(root.left, result);
        if (!result.valid) return result;
        if (result.max > root.value) {
            result.valid = false;
            return result;
        }

        result = validation(root.right, result);
        if (!result.valid) return result;
        if (result.min < root.value) {
            result.valid = false;
        }
        return result;
    }

    @Test
    public void test(){

        MyTree root = new MyTree(6);
        root.right = new MyTree(9);
        root.right.left = new MyTree(5);
        root.right.right = new MyTree(10);
        root.left = new MyTree(3);
        root.left.left = new MyTree(1);
        root.left.left.right = new MyTree(2);
        root.left.right = new MyTree(4);

        Assert.assertFalse(isBST(root));
    }


}

class MinMaxObject{

    int min;
    int max;
    boolean valid;

    public MinMaxObject() {
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.valid = true;
    }
}
