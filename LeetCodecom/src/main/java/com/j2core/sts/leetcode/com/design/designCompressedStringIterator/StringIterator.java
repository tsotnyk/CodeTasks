package com.j2core.sts.leetcode.com.design.designCompressedStringIterator;

public class StringIterator {

    String compressString;
    char symbol;
    int counter;

    public StringIterator(String compressedString) {
        this.compressString = compressedString;
        getNextSymbol();
    }

    public char next() {
        if (this.counter == 0){
            getNextSymbol();
        }
        this.counter -= 1;
        return this.symbol;
    }

    public boolean hasNext() {
        if (this.counter == 0) getNextSymbol();
        return this.symbol != ' ';
    }

    private void getNextSymbol(){

        if (this.compressString == null || this.compressString.length() < 1){
            this.symbol = ' ';
            this.counter = 100;
            return;
        }
        this.symbol = this.compressString.charAt(0);
        int index = 1;

        while (index < this.compressString.length() && Character.isDigit(this.compressString.charAt(index))){
            index++;
        }

        this.counter = Integer.parseInt(this.compressString.substring(1, index));
        if (index == this.compressString.length()){
            this.compressString = null;
        }else {
            this.compressString = this.compressString.substring(index);
        }
    }

}

class Main1{

    public static void main(String[] args) {

        StringIterator myStringIterator = new StringIterator("L1e2t1C1o1d1e1");

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
