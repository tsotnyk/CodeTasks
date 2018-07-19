package com.j2core.sts.codefights.com.dataStructures.treesBasic.isTreeSymmetric;

public class Tree<T> {

    T value;
    Tree<T> left;
    Tree<T> right;

    Tree(T x){

        value = x;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Tree<T> getLeft() {
        return left;
    }

    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public Tree<T> getRight() {
        return right;
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }
}
