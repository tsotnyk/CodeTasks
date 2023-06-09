package chapter4;

import java.util.Objects;

public class MyTree {

    int value;
    MyTree left;
    MyTree right;

    public MyTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTree myTree = (MyTree) o;
        return value == myTree.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
