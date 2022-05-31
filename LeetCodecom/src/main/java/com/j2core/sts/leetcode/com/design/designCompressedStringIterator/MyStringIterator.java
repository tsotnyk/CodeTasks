package com.j2core.sts.leetcode.com.design.designCompressedStringIterator;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class MyStringIterator {

    LinkedList<CompressedChar> charList;

    public MyStringIterator(String compressedString) {

        this.charList = new LinkedList<>();
        int symIndex = 0;
        int digIndex = 1;

        while (symIndex < compressedString.length()){
            while (digIndex < compressedString.length() && Character.isDigit(compressedString.charAt(digIndex))){
                digIndex++;
            }
            String tmp = compressedString.substring(symIndex+1, digIndex);
            int counter = Integer.parseInt(tmp);
            this.charList.add(new CompressedChar(compressedString.charAt(symIndex), counter));
            symIndex = digIndex;
            digIndex = symIndex+1;
        }
    }

    public char next() {
        if (this.charList.isEmpty()) return ' ';
        Character symbol = this.charList.getFirst().getSymbol();
        if (symbol == null){
            this.charList.removeFirst();
            return next();
        }
        return symbol;
    }

    public boolean hasNext() {
        if (this.charList.isEmpty()) return false;
        if (this.charList.getFirst().count > 0) return true;
        this.charList.removeFirst();
        return hasNext();
    }

    @Test
    public static void test(){

        MyStringIterator stringIterator = new MyStringIterator("L1e2t1C1o1d1e1");

        Assert.assertEquals(stringIterator.next(), 'L');
        Assert.assertEquals(stringIterator.next(), 'e');
        Assert.assertEquals(stringIterator.next(), 'e');
        Assert.assertEquals(stringIterator.next(), 't');
        Assert.assertEquals(stringIterator.next(), 'c');
        Assert.assertEquals(stringIterator.next(), 'o');
        Assert.assertTrue(stringIterator.hasNext());
        Assert.assertEquals(stringIterator.next(), 'd');
        Assert.assertTrue(stringIterator.hasNext());
    }
}

class Main{

    public static void main(String[] args) {

        MyStringIterator myStringIterator = new MyStringIterator("L1e2t1C1o1d1e1");

        System.out.println(myStringIterator.next());
        System.out.println(myStringIterator.next());
        System.out.println(myStringIterator.next());
        System.out.println(myStringIterator.next());
        System.out.println(myStringIterator.next());
        System.out.println(myStringIterator.next());
        System.out.println(myStringIterator.hasNext());
        System.out.println(myStringIterator.next());
        System.out.println(myStringIterator.hasNext());


    }
}



class CompressedChar{
    char symbol;
    int count;

    public CompressedChar(char symbol, int count) {
        this.symbol = symbol;
        this.count = count;
    }

    public Character getSymbol() {
        if (count == 0) return null;
        this.count -= 1;
        return this.symbol;
    }
}
