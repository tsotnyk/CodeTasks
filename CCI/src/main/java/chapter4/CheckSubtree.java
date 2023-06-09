package chapter4;

public class CheckSubtree {

    public boolean isSubtree(MyTree root, MyTree subtree){

        if (root == null || subtree == null) throw new IllegalArgumentException();

        MyTree newRoot = findNode(root, subtree);

        return newRoot != null && comparingTree(newRoot, subtree);
    }

    private MyTree findNode(MyTree root, MyTree subtree){

        if (root == null) return null;

        if (root.equals(subtree)) return root;

        MyTree newRoot = findNode(root.left, subtree);

        if (newRoot != null) return newRoot;
        return findNode(root.right, subtree);
    }

    private boolean comparingTree(MyTree first, MyTree second){

        if (first == null && second == null) return true;
        if (first == null || second == null || first.value != second.value) return false;

        if (!comparingTree(first.left, second.left)) return false;

        return comparingTree(first.right, second.right);
    }
}
