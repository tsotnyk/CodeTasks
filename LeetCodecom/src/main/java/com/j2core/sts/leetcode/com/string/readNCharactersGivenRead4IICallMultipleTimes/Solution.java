package com.j2core.sts.leetcode.com.string.readNCharactersGivenRead4IICallMultipleTimes;

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */

public class Solution extends Reader4 {

    int length = 0;
    char[] tmpBuf = new char[4];

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {

        if (n > length) {
            int count = 0;
            if (length > 0){
                System.arraycopy(tmpBuf, 0, buf, 0, length);
                tmpBuf = new char[4];
                count = length;
                length = 0;
            }

            length = read4(tmpBuf);
            while (length != 0 && count + length < n){
                System.arraycopy(tmpBuf, 0, buf, count, length);
                count += length;
                tmpBuf = new char[4];
                length = read4(tmpBuf);
            }

            if (length == 0) return count;

            if (count+length < n){
                System.arraycopy(tmpBuf, 0, buf, count, length);
                tmpBuf = new char[4];
                count += length;
                length = 0;
            }else if (count+length == n){
                System.arraycopy(tmpBuf, 0, buf, count, length);
                count += length;
                tmpBuf = new char[4];
                length = 0;
            }else {
                int delta = n - count;
                System.arraycopy(tmpBuf, 0, buf, count, delta);
                count = n;
                length -= delta;
                System.arraycopy(tmpBuf, delta, tmpBuf, 0, 4-delta);
            }
            return count;
        }else {
            System.arraycopy(tmpBuf, 0, buf, 0, n);
            length -= n;
            if (length > 0) {
                System.arraycopy(tmpBuf, n, tmpBuf, 0, length);
            }else {
                tmpBuf = new char[4];
            }
            return n;
        }
    }

//    char[] temp;
//    int charsinhand = 0, j = 0;
//
//    public int read(char[] buf, int n) {
//
//        int ptr = 0;
//
//        while(ptr != n){
//
//            if(charsinhand == 0){
//                temp = new char[4];
//                charsinhand = read4(temp);
//                j = 0;
//            }
//
//            if(charsinhand == 0) break;
//
//            buf[ptr++] = temp[j++];
//            charsinhand--;
//
//        }
//
//        return ptr;
//
//    }

}
