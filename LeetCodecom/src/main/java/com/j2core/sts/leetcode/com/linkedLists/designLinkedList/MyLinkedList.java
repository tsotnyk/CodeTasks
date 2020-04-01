package com.j2core.sts.leetcode.com.linkedLists.designLinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyLinkedList {

    Node head;
    Node tail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {

        head = null;
        tail = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if (index >= size) return -1;
        if (index == 0) return head.val;
        if (index == size-1) return tail.val;

        Node tmp;
        int stepsBack = size-index-1;
        if (stepsBack < index){
            tmp = tail;
            while (stepsBack > 0){
                tmp = tmp.prev;
                stepsBack--;
            }
        }else {
            tmp = head;
            while (index > 0){
                tmp = tmp.next;
                index--;
            }
        }
        return tmp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null){
            head = new Node(val);
        }else {
            Node newHead = new Node(val);
            newHead.next = head;
            head = newHead;
            head.next.prev = newHead;

            if (tail == null) {
                tail = head.next;
                tail.prev = head;
            }

        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null){
            tail = new Node(val);
            tail.prev = head;
            head.next = tail;
        }else {
            Node newTail = new Node(val);
            newTail.prev = tail;
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0){
            addAtHead(val);
        }else if (index >= size){
            addAtTail(val);
        }else {
            Node tmp;
            Node newNode = new Node(val);
            int stepsBack = size-index-1;
            if (stepsBack < index){
                tmp = tail;
                while (stepsBack > 0){
                    tmp = tmp.prev;
                    stepsBack--;
                }
                newNode.prev = tmp.prev;
                tmp.prev.next = newNode;
                newNode.next = tmp;
                tmp.prev = newNode;
            }else {
                tmp = head;
                while (index > 1){
                    tmp = tmp.next;
                    index--;
                }
                tmp.next.prev = newNode;
                newNode.next = tmp.next;
                newNode.prev = tmp;
                tmp.next = newNode;
            }
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index == 0){
            head = head.next;
            size--;
        }else if (index == size-1){
            tail = tail.prev;
            tail.next = null;
            size--;
        }else if (index < size){
            Node tmp;
            int stepsBack = size-index-2;
            if (stepsBack < index-1){
                tmp = tail;
                while (stepsBack > 0){
                    tmp = tmp.prev;
                    stepsBack--;
                }
                tmp.prev = tmp.prev.prev;
                tmp.prev.next = tmp;
            }else {
                tmp = head;
                while (index > 1){
                    tmp = tmp.next;
                    index--;
                }
                tmp.next = tmp.next.next;
                tmp.next.prev = tmp;
            }
            size--;
        }

    }

    @Test
    public static void test(){

        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(7);
//        linkedList.addAtHead(2);
//        linkedList.addAtHead(1);
//        linkedList.addAtIndex(3,0);
//        linkedList.deleteAtIndex(2);
//        linkedList.addAtHead(6);
//        linkedList.addAtTail(4);
//        int num = linkedList.get(4);
//        linkedList.addAtHead(4);
//        linkedList.addAtIndex(5,0);
//        linkedList.addAtHead(6);
//
//        Assert.assertEquals(linkedList.size, 8);

//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(2);
//        linkedList.deleteAtIndex(1);
//        linkedList.addAtHead(2);
//        linkedList.addAtHead(7);
//        linkedList.addAtHead(3);
//        linkedList.addAtHead(2);
//        linkedList.addAtHead(5);
//        linkedList.addAtTail(5);
//        int num = linkedList.get(5);
//        linkedList.deleteAtIndex(6);
//        linkedList.deleteAtIndex(4);
//
        linkedList.addAtHead(84);
        linkedList.addAtTail(2);
        linkedList.addAtTail(39);
        int one = linkedList.get(3);
        System.out.println(one);
        int two = linkedList.get(1);
        System.out.println(two);
        linkedList.addAtTail(42);
        linkedList.addAtIndex(1,80);
        linkedList.addAtHead(14);
        linkedList.addAtHead(1);
        linkedList.addAtTail(53);
        linkedList.addAtTail(98);
        linkedList.addAtTail(19);
        linkedList.addAtTail(12);
        int three = linkedList.get(2);
        System.out.println(three);
        linkedList.addAtHead(16);
        linkedList.addAtHead(33);
        linkedList.addAtIndex(4,17);
        linkedList.addAtIndex( 6,8);
        linkedList.addAtHead(37);
        linkedList.addAtTail(43);
        linkedList.deleteAtIndex(11);
        linkedList.addAtHead(80);
        linkedList.addAtHead(31);
        linkedList.addAtIndex(13,23);
        linkedList.addAtTail(17);
        int four = linkedList.get(4);
        System.out.println(four);
        linkedList.addAtIndex(10,0);
        linkedList.addAtTail(21);
        linkedList.addAtHead(73);
        linkedList.addAtHead(22);
        linkedList.addAtIndex(24, 37);
        linkedList.addAtTail(14);
        linkedList.addAtHead(97);
        linkedList.addAtHead(8);
        int five = linkedList.get(6);
        System.out.println(five);
        linkedList.deleteAtIndex(17);
        linkedList.addAtTail(50);
        linkedList.addAtTail(28);
        linkedList.addAtHead(76);
        linkedList.addAtTail(79);
        int six = linkedList.get(18);
        System.out.println(six);
        linkedList.deleteAtIndex(30);
        linkedList.addAtTail(5);
        linkedList.addAtHead(9);
        linkedList.addAtTail(83);
        linkedList.deleteAtIndex(3);
        linkedList.addAtTail(40);
        linkedList.deleteAtIndex(26);
        linkedList.addAtIndex(20, 90);
        linkedList.deleteAtIndex(30);
        linkedList.addAtTail(40);
        linkedList.addAtHead(56);
        linkedList.addAtIndex(15, 23);
        linkedList.addAtHead(51);
        linkedList.addAtHead(21);
        int seven = linkedList.get(26);
        System.out.println(seven);
        linkedList.addAtHead(83);
        int next = linkedList.get(30);
        System.out.println(next);
        linkedList.addAtHead(12);
        linkedList.deleteAtIndex(8);
        int next1 = linkedList.get(4);
        System.out.println(next1);
        linkedList.addAtHead(20);
        linkedList.addAtTail(45);
        int next2 = linkedList.get(10);
        System.out.println(next2);
        linkedList.addAtHead(56);
        int next3 = linkedList.get(18);
        System.out.println(next3);
        linkedList.addAtTail(33);
        int next4 = linkedList.get(2);
        System.out.println(next4);
        linkedList.addAtTail(70);
        linkedList.addAtHead(57);
        linkedList.addAtIndex(31,24);
        linkedList.addAtIndex(16,92);
        linkedList.addAtHead(40);
        linkedList.addAtHead(23);
        linkedList.deleteAtIndex(26);
        int next5 = linkedList.get(1);
        System.out.println(next5);
        linkedList.addAtHead(92);
        linkedList.addAtIndex(3,78);
        linkedList.addAtTail(42);
        int next6 = linkedList.get(18);
        System.out.println(next6);
        linkedList.addAtIndex(39,9);
        int next7 = linkedList.get(13);
        System.out.println(next7);
        linkedList.addAtIndex(33, 17);
        int next8 = linkedList.get(51);
        System.out.println(next8);
        linkedList.addAtIndex(18,95);
        linkedList.addAtIndex(18,33);
        linkedList.addAtHead(80);
        linkedList.addAtHead(21);
        linkedList.addAtTail(7);
        linkedList.addAtIndex(17,46);
        int next9 = linkedList.get(33);
        System.out.println(next9);
        linkedList.addAtHead(60);
        linkedList.addAtTail(26);
        linkedList.addAtTail(4);
        linkedList.addAtHead(9);
        int next10 = linkedList.get(45);
        System.out.println(next10);
        linkedList.addAtTail(38);
        linkedList.addAtHead(95);
        linkedList.addAtTail(78);
        int next11 = linkedList.get(54);
        System.out.println(next11);
        linkedList.addAtIndex(42,86);


        Assert.assertNotNull(linkedList);
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

class Node{

    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }
}
