package com.j2core.sts.leetcode.com.string.readNCharactersGiverRead4;

public class Solution extends Reader4{

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {

        char[] curBuf = new char[4];
        int index = 0;
        int curBufIndex = 0;
        int readSymbols = read4(curBuf);
        while (readSymbols > 0 && index < n){
            buf[index++] = curBuf[curBufIndex++];
            if (curBufIndex == readSymbols) {
                readSymbols = read4(curBuf);
                curBufIndex = 0;
            }
        }

        return Math.min(index, n);
    }
}
