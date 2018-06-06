package com.j2core.sts.codefights.com.dataStructures.linkedLists.rearrangeLastN;

public class ListNode<T> {

    T value;
    ListNode<T> next;

    public ListNode(T x) {
        this.value = x;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
