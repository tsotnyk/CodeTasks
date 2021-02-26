package com.j2core.sts.leetcode.com.tmp.mockInterview;

import java.util.ArrayList;

public class ApplePISolution2 {

    public int[] sortArrayByParity(int[] A) {

        int i = 0;
        int j = A.length-1;

        while (i < j){

            if (A[i] %2 == 0){
                i++;
            }else if (A[j]%2 != 0){
                j--;
            }else {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
                j--;
            }
        }

        return A;
    }

    class ProductOfNumbersV1 {

        ArrayList<Integer> list;

        public ProductOfNumbersV1() {

            this.list = new ArrayList<>();
        }

        public void add(int num) {

            this.list.add(num);
        }

        public int getProduct(int k) {

            int sum = 1;

            for (int i = this.list.size()-1; i >= this.list.size()-k; i--){
                sum *= this.list.get(i);
            }

            return sum;
        }
    }

    class ProductOfNumbers {

        ArrayList<Integer> list;
        int sum = 1;
        public ProductOfNumbers() {

            this.list = new ArrayList<>();
        }

        public void add(int num) {

            this.list.add(num);
            this.sum *= num;
        }

        public int getProduct(int k) {

            if (sum == 0 || this.list.size()-k >= k) {
                int sum = 1;

                for (int i = this.list.size() - 1; i >= this.list.size() - k; i--) {
                    sum *= this.list.get(i);
                }

                return sum;
            }

            int sum = this.sum;
            for (int i = 0; i < this.list.size()-k; i++){
                sum /= this.list.get(i);
            }
            return sum;
        }
    }
}
