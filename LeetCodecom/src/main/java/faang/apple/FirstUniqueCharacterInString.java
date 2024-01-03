package faang.apple;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {

        int[] array = new int[26];
        char[] str = s.toCharArray();

        for (char sym : str){

            int index = sym - 'a';
            array[index] += 1;
        }

        for (int i = 0; i < str.length; i++){

            int index = str[i] - 'a';

            if (array[index] == 1) return i;
        }

        return -1;
    }
}
