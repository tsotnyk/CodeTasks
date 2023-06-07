package chapter4;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyDirectedNode {

    int value;
    List<MyDirectedNode> children;

    public MyDirectedNode(int value, List<MyDirectedNode> children) {
        this.value = value;
        this.children = children;
    }

    public List<MyDirectedNode> getChildren() {
        return children;
    }

    public void setChildren(List<MyDirectedNode> children) {
        this.children.addAll(children);
    }

    public MyDirectedNode(int value) {
        this.value = value;
        this.children = new LinkedList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDirectedNode that = (MyDirectedNode) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
