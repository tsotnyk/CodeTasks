package com.j2core.sts.leetcode.com.hackerrank;

interface BaseI{

    void method();
}

 class BaseC {

    public void method(){
        System.out.println("Yes!!!!");
    }
}

class Impl extends BaseC implements BaseI{

    public static void main(String[] s){

        (new Impl()).method();
    }
}
