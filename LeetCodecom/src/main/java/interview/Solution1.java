package interview;


public class Solution1 {

    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public void setLeft(TreeNode node) {
            this.left = node;
        }

        public void setRight(TreeNode node) {
            this.right = node;
        }

        public TreeNode getLeft() {
            return this.left;
        }

        public TreeNode getRight() {
            return this.right;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static boolean isTreeBalansed1(TreeNode root){

        int left = countLevel1(root.left);
        if (left < 0) return false;
        int right = countLevel1(root.right);

        return Math.abs(left-right) < 2;
    }

    public static boolean isTreeBalansed2(TreeNode root){

        int left = countLevel2(root.left);
        if (left < 0) return false;
        int right = countLevel2(root.right);

        return Math.abs(left-right) < 2;
    }

    private static int countLevel1(TreeNode root){

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = countLevel1(root.left);
        if (left < 0) return -1;
        int right = countLevel1(root.right);
        if (right < 0) return -1;
        int result = Math.abs(left - right);
        return result < 2 ? Math.max(left, right)+1: -1;
    }

    private static int countLevel2(TreeNode root){

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = countLevel2(root.left);
        int right = countLevel2(root.right);
        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);


        // balanced tree

        rootNode.setLeft(node2);
        rootNode.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
        node6.setRight(node7);


        System.out.println("First");
        System.out.println(isTreeBalansed1(rootNode));
        System.out.println("Second");
        System.out.println(isTreeBalansed2(rootNode));


        // make it unbalanced

        TreeNode node8 = new TreeNode(8);
        node7.setLeft(node8);
        System.out.println("First");
        System.out.println(isTreeBalansed1(rootNode));
        System.out.println("Second");
        System.out.println(isTreeBalansed2(rootNode));

        TreeNode node10 = new TreeNode(10);
        node4.setLeft(node10);
        System.out.println("First with 10");
        System.out.println(isTreeBalansed1(rootNode));
        System.out.println("Second with 10");
        System.out.println(isTreeBalansed2(rootNode));
    }


}
