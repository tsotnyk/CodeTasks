package com.j2core.sts.codefights.com.math.counting.differentPlayList;

public class Solution {

    int differentPlaylists(int n, int k, int l) {

        int modulo = 1000000007;
        int delta = 1;
        long result = n;

        int loop = k < l ? k + 1 : l;

        while (delta < loop){

            result = (result * (n-delta)) % modulo;
            delta++;

        }

        if(l - k > 100){

            int amount = n - delta + 1;
            long secondPart = exponentiationNumber(amount, modulo, l - k - 1);

            result = (result * secondPart) % modulo;


        }else {

            for (int i = 1; i < l - k; i++) {

                result = (result * (n - delta + 1)) % modulo;

            }
        }
        return (int)result;
    }


    private long exponentiationNumber(long amountSong, int modulo, int exp) {

        long result = amountSong;
        exp = exp-1;

        int tmp = 0;
        long tmpAmount = amountSong / 10;
        while (tmpAmount > 1){

            tmp++;
            tmpAmount = tmpAmount / 10;
        }

        long[] valueArray = new long[tmp+1];
        int[] expArray = new int[tmp + 1];

        valueArray[0] = amountSong;
        expArray[0] = 1;

        for (int i = 1; i < tmp + 1; i++){

            valueArray[i] = exponentiation(valueArray[i-1], modulo);
            expArray[i] = expArray[i-1] * 10;

        }

        int index = tmp;
        while (index > -1){

            if (exp >= expArray[index]){

                result = (result * valueArray[index]) % modulo;
                exp = exp - expArray[index];

            }else {
                index--;
            }

        }

        return result;

    }

    private long exponentiation(long number, int modulo){

        long result = number;

        for (int i = 1; i < 10; i++) {

            result = (result * number) % modulo;

        }

        return result;

    }

}
