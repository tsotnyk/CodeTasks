package com.j2core.sts.leetcode.com.tmp;

public class Solution {

    public static void main(String[] args) {

        SuperClass superClass = new SuperClass();
        superClass.print();

        SuperClass subClass = new SubClass();
        subClass.print();

        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void newPrint() {
                System.out.println("new print");
            }
        };

        abstractClass.print();
        abstractClass.newPrint();

        ImplInterface implInterface = new ImplInterface();
        implInterface.print();
    }
}

class SuperClass{

    public void print(){

        System.out.println("SuperClass");
    }
}

class SubClass extends SuperClass{

    public void print(){

        System.out.println("SubClass");
    }
}

abstract class AbstractClass{

    public void print(){

        System.out.println("Abstract class");
    }

    abstract public void newPrint();
}

interface InterfaceClass{

    public static String name = "First interface";

    public void print();
}

class ImplInterface implements InterfaceClass{

    public void print(){
        System.out.println(name);
    }
}
