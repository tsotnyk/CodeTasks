package sts.facebook.codingPractice.string.rotationalCipher;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        if (input == null) return null;
        if (rotationFactor == 0) return input;

        StringBuilder builder = new StringBuilder();

        for (char symbol : input.toCharArray()){
            if (Character.isLetter(symbol)){
                if (Character.isUpperCase(symbol)){
                    builder.append(rotateUpperLetter(symbol, rotationFactor));
                }else {
                    builder.append(rotateLowerLetter(symbol, rotationFactor));
                }
            }else if (Character.isDigit(symbol)){
                builder.append(rotateDigit(symbol, rotationFactor));
            } else {
                builder.append(symbol);
            }
        }

        return builder.toString();
    }

    private char rotateDigit(char symbol, int rotationFactor){
        int zero = '0';
        int nine = '9';
        rotationFactor = rotationFactor%10;
        if (rotationFactor == 0) return symbol;

        int newSymbol = (int) symbol + rotationFactor;
        if (newSymbol > nine) {
            newSymbol = zero + (newSymbol-nine-1);
        }
        return (char) newSymbol;
    }

    private char rotateUpperLetter(char symbol, int rotationFactor){
        int upperA = 'A';
        int upperZ = 'Z';
        rotationFactor = rotationFactor%26;
        if (rotationFactor == 0) return symbol;
        int newSymbol = (int) symbol + rotationFactor;
        if (newSymbol > upperZ){
            newSymbol = upperA + (newSymbol-upperZ-1);
            return (char) newSymbol;
        }
        return (char) newSymbol;
    }

    private char rotateLowerLetter(char symbol, int rotationFactor){
        int lowerA = 'a';
        int lowerZ = 'z';
        rotationFactor = rotationFactor%26;
        if (rotationFactor == 0) return symbol;
        int newSymbol = (int) symbol + rotationFactor;
        if (newSymbol > lowerZ){
            newSymbol = lowerA + (newSymbol-lowerZ-1);
            return (char) newSymbol;
        }
        return (char) newSymbol;
    }

    String rotationalCipherOneMethod(String input, int rotationFactor) {

        if (input == null) return null;
        int zero = '0';
        int nine = '9';
        int lowerA = 'a';
        int lowerZ = 'z';
        int upperA = 'A';
        int upperZ = 'Z';
        int letterRotationFactor = rotationFactor%26;
        int digitRotationFactor = rotationFactor%10;

        if (rotationFactor == 0) return input;

        StringBuilder builder = new StringBuilder();

        for (char symbol : input.toCharArray()){
            if (Character.isLetter(symbol)){
                int newSymbol = (int) symbol + letterRotationFactor;
                if (Character.isUpperCase(symbol)){
                    if (newSymbol > upperZ){
                        newSymbol = upperA + (newSymbol-upperZ-1);
                    }
                }else {
                    if (newSymbol > lowerZ){
                        newSymbol = lowerA + (newSymbol-lowerZ-1);
                    }
                }
                builder.append((char) newSymbol);
            }else if (Character.isDigit(symbol)){
                if (digitRotationFactor == 0){
                    builder.append(symbol);
                }else {
                    int newSymbol = (int) symbol + digitRotationFactor;
                    if (newSymbol > nine) {
                        newSymbol = zero + (newSymbol - nine - 1);
                    }
                    builder.append((char) newSymbol);
                }
            } else {
                builder.append(symbol);
            }
        }

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(rotationalCipher("Zz", 1), "Aa");

        Assert.assertNull(rotationalCipher(null, 10));
        Assert.assertEquals(rotationalCipher("abcd", 0), "abcd");
        Assert.assertEquals(rotationalCipher("abc!123", 1), "bcd!234");
        Assert.assertEquals(rotationalCipher("Zebra-493", 3), "Cheud-726");
        Assert.assertEquals(rotationalCipher("abc123?", 260), "abc123?");
        Assert.assertEquals(rotationalCipher("@abc123", 261), "@bcd234");

        Assert.assertEquals(rotationalCipherOneMethod("Zz", 1), "Aa");

        Assert.assertNull(rotationalCipherOneMethod(null, 10));
        Assert.assertEquals(rotationalCipherOneMethod("abcd", 0), "abcd");
        Assert.assertEquals(rotationalCipherOneMethod("abc!123", 1), "bcd!234");
        Assert.assertEquals(rotationalCipherOneMethod("Zebra-493", 3), "Cheud-726");
        Assert.assertEquals(rotationalCipherOneMethod("abc123?", 260), "abc123?");
        Assert.assertEquals(rotationalCipherOneMethod("@abc123", 261), "@bcd234");
    }
}
