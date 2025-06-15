package prepInterviewGoogle;

import java.util.Arrays;

public class MaximumProductOfTwoDigits {

    public int maxProduct(int n) {

        int[] array = new int[String.valueOf(n).length()];

        int index = 0;
        while (n > 0){
            array[index++] = n%10;
            n = n/10;
        }

        Arrays.sort(array);

        return array[array.length-1] * array[array.length-2];
    }
}
