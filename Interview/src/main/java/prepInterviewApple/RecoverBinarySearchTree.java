package prepInterviewApple;

import java.util.LinkedList;
import java.util.List;

public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {

        if (root != null){

            while (!isBSTRight(root, root.val) || !isBSTLeft(root, root.val)){
                recoverTree(root);
            }
        }
    }

    private boolean isBSTLeft(TreeNode node, int rootVal){

        if (node.left != null){

            List<TreeNode> nodeList = new LinkedList<>();
            nodeList.add(node.left);
            int maxValue = rootVal;
            TreeNode tmpNode;

            while (!nodeList.isEmpty()){
                tmpNode = nodeList.remove(0);
                if (tmpNode.val > maxValue){
                    maxValue = tmpNode.val;
                }
                if (tmpNode.left != null){
                    nodeList.add(tmpNode.left);
                }
                if (tmpNode.right != null){
                    nodeList.add(tmpNode.right);
                }
            }

            if (node.val != maxValue) {
                node.val = maxValue;

                nodeList.add(node.left);

                while (!nodeList.isEmpty()) {
                    tmpNode = nodeList.remove(0);
                    if (tmpNode.val == node.val) {
                        tmpNode.val = rootVal;
                        return false;
                    }
                    if (tmpNode.left != null) {
                        nodeList.add(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        nodeList.add(tmpNode.right);
                    }
                }
            }else {recoverTree(node.left);}
        }

        return true;
    }

    private boolean isBSTRight(TreeNode node, int rootVal){

        if (node.right != null){

            List<TreeNode> nodeList = new LinkedList<>();
            nodeList.add(node.right);
            int minVal = rootVal;
            TreeNode tmpNode;

            while (!nodeList.isEmpty()){
                tmpNode = nodeList.remove(0);
                if (tmpNode.val < minVal){
                    minVal = tmpNode.val;
                }
                if (tmpNode.left != null){
                    nodeList.add(tmpNode.left);
                }
                if (tmpNode.right != null){
                    nodeList.add(tmpNode.right);
                }
            }

            if (node.val != minVal) {
                node.val = minVal;

                nodeList.add(node.right);

                while (!nodeList.isEmpty()){
                    tmpNode = nodeList.remove(0);
                    if (tmpNode.val == node.val){
                        tmpNode.val = rootVal;
                        return false;
                    }
                    if (tmpNode.left != null) {
                        nodeList.add(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        nodeList.add(tmpNode.right);
                    }
                }
            }else recoverTree(node.right);
        }

        return true;
    }
}
