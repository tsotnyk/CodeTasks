package com.j2core.sts.codefights.com.codeInterview.sofi;

public class Test {


    public static void main(String[] args) {

        System.out.print("*******************");
        System.out.println(recursivefib(43));

        System.out.print("______________________");
        System.out.println(nonrecursivefib(43));
    }

    static long recursivefib(int n){
        if (n <= 0) return 0L;
        else if(n == 1) return 1L;
        else return recursivefib(n-1)+recursivefib(n-2);
    }

    static long nonrecursivefib(int n){
        if (n <= 0) return 0L;
        else if(n == 1) return 1L;
        else {
            long value0 = 0L;
            long value1 = 1L;
            long value2 = 1L;
            for (int i = 0; i < n-1; i++){
                value2 = value0+value1;
                value0 = value1;
                value1 = value2;
            }
            return value2;
        }
    }
}
