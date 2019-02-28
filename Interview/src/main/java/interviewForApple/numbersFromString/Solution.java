package interviewForApple.numbersFromString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/*
IDEA

Do NOT do recursion!!!!!!!!!!!!!! AVOID recursion!!!!!! Use memoization or iterative approach.

We are doing iterative approach.

COMPLEXITY

Exact solution: n + n-1 + n-2 + n-3 ... + 1 which is triangle(n) or !n. Or by Gauss theorem (https://i.stack.imgur.com/9gIAq.png) (n^2+n)/2

Standard answer O(n)=n^2
*/
public class Solution {

    private final int RANDOMIZED_TESTS_COUNT = 100;

    public boolean check(String string){

        // return false if string is null
        if (string == null){
            return false;
        }

        int length = string.length();

        // return false if string length smaller than 3 (can not be pattern N = N1 + N2)
        if (length < 3){
            return false;
        }

        for (int i = 1; i < length-i; i++) {

            for (int j = 1; j <= i && i < 9; j++) {

                //parse substring from 0 to j for get first number
                long firstElement = Long.parseLong(string.substring(0, j));
                //parse substring from j+1 to  J+1 + first number's length, because have pattern sum >= second number >= first number
                long secondElement = Long.parseLong(string.substring(j, i + j));

                if (secondElement >= firstElement) {

                    StringBuilder builder = new StringBuilder();

                    builder.append(firstElement).append(secondElement);

                    if (builder.length() < length) {
                        while (builder.length() < length) {

                            // calculate sum and save result in stringBuilder
                            long sum = firstElement + secondElement;
                            builder.append(sum);
                            firstElement = secondElement;
                            secondElement = sum;
                        }
                        if (string.equals(builder.toString())) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }


    @Test
    void checkFalseNegative() {

        for (int i = 1; i< RANDOMIZED_TESTS_COUNT; i++) {
            Assert.assertTrue(check(testHelperTestSymbols(Arrays.toString(generateRandomTestSequence()))));
        }
    }

    @Test
    void checkFalsePositiveWithPermutations() {

        for (int i = 1; i< RANDOMIZED_TESTS_COUNT; i++) {
            Assert.assertFalse(check(testHelperTestSymbols(Arrays.toString(mutateSequence(generateRandomTestSequence())))));
        }
    }

    @Test
    void checkFalsePositiveWithDamaged() {

        for (int i = 1; i< RANDOMIZED_TESTS_COUNT; i++) {
            Assert.assertFalse(check(testHelperTestSymbols(Arrays.toString(damageSequence(generateRandomTestSequence())))));
        }
    }

    @Test
    public void testNegativeCaseShortLength(){

        Assert.assertFalse(check(testHelperTestSymbols("1")));
    }

    @Test
    public void testPositiveCase1(){

        Assert.assertTrue(check(testHelperTestSymbols("1 2 3")));

    }

    @Test
    public void testNegativeCase(){

        Assert.assertFalse(check(testHelperTestSymbols("1 2 3 4 5")));

    }

    @Test
    public void testNegativeCasePermutation(){

        Assert.assertFalse(check(testHelperTestSymbols("2 1 3")));
    }

    @Test
    public void testPositiveCase2(){

        Assert.assertTrue(check(testHelperTestSymbols("2 35 37")));
    }

    @Test
    public void testPositiveExample1(){

        Assert.assertTrue(check(testHelperTestSymbols("2 2 4 6 10")));
    }

    @Test
    public void testPositiveExample2(){

        Assert.assertTrue(check(testHelperTestSymbols("1112233558")));
    }

    @Test
    public void testPositiveExample3(){

        Assert.assertTrue(check(testHelperTestSymbols("1 101 102 203")));
    }

    private String testHelperTestSymbols(String string){

        String result = string.replaceAll("]", "");
        if (result.charAt(0) == '['){
            result = result.substring(1);
        }

        result = result.replaceAll("]", "");
        result = result.replaceAll(",", "");

        return result.replaceAll(" ", "");

    }

    private long[] generateRandomTestSequence(){

        Random random = new Random();
        long first = random.nextInt(1000000);
        long second = random.nextInt( 1000000);
        int gens = random.nextInt( 5)+3;
        int index = 0;
        long[] array = new long[gens+2];
        array[index++] = first;
        array[index++] = second;

        while (gens > 0){
            long sum = first + second;
            array[index++] = sum;

            first = second;
            second = sum;

            gens--;
        }

        return array;
    }

    private long[] mutateSequence(long[] sequence){

        Random random = new Random();
        int randomFirstIndex = random.nextInt(sequence.length);
        int randomSecondIndex = random.nextInt(sequence.length);

        if (randomFirstIndex == randomSecondIndex){
            if (randomFirstIndex > 1){
                randomFirstIndex--;
            }else {
                randomFirstIndex++;
            }
        }

        long tmp = sequence[randomFirstIndex];
        sequence[randomFirstIndex] = sequence[randomSecondIndex];
        sequence[randomSecondIndex] = tmp;

        return sequence;
    }

    private long[] damageSequence(long[] sequence){

        Random random = new Random();
        int randomIndex = random.nextInt(sequence.length-1);

        sequence[randomIndex] = sequence[randomIndex]+1;

        return sequence;
    }


}
