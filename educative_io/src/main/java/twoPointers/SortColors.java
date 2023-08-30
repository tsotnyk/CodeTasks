package twoPointers;

import org.testng.annotations.Test;

public class SortColors {

    public static int[] sortColors(int[] colors) {

        int red = 0;
        int white = 0;
        int blue = colors.length - 1;

        while (white <= blue) {

            // If the white pointer is pointing to red
            if (colors[white] == 0) {

                // Swap the values if the red pointer is not pointing to red
                if (colors[red] != 0) {
                    int temp = colors[red];
                    colors[red] = colors[white];
                    colors[white] = temp;
                }

                // Increment both the red and white pointers
                white++;
                red++;
            }

            // If the white pointer is pointing to white, no swapping is required
            // Just increment the white pointer
            else if (colors[white] == 1) {
                white++;
            }

            // If the white pointer is pointing to blue
            else {

                // Swap the values if the blue pointer is not pointing to blue
                if (colors[blue] != 2) {
                    int temp = colors[white];
                    colors[white] = colors[blue];
                    colors[blue] = temp;
                }

                // Decrement the blue pointer
                blue--;
            }
        }

        return colors;
    }

    public static int[] sortColors1 (int[] colors) {

        // Write your code here

        int left = 0;
        int right = colors.length-1;

        while (left < colors.length && colors[left] == 0) left++;
        while (right > -1 && colors[right] == 2) {
            right--;
        }

        if (left >= colors.length || right < 0) return colors;

        int index = left;
        while (index <= right){
            if (colors[index] == 1){
                index++;
                continue;
            }
            int tmp = colors[index];
            if (tmp == 2){
                colors[index] = colors[right];
                colors[right--] = tmp;
                continue;
            }
            colors[index] = colors[left];
            colors[left++] = tmp;
            if (left > index) index = left;
        }

        return colors;
    }

    @Test
    public void test(){

        int[] array3 = new int[]{2,1,1,0,0};

        sortColors(array3);

        int[] array2 = new int[]{2,2};

        sortColors(array2);

        int[] array = new int[]{1,2,0,1,1,2,0,2,0,2,1,2};

        sortColors(array);

        System.out.println(array.toString());

    }


}
