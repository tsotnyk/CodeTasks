package faang.apple;

public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int index1 = 0, index2 = 0;
        int wordIndex1 = 0, wordIndex2 = 0;

        while (index1 < word1.length && index2 < word2.length) {

            if (word1[index1].charAt(wordIndex1++) !=
                    word2[index2].charAt(wordIndex2++)) {
                return false;
            }
            if (wordIndex1 == word1[index1].length()) {
                index1++;
                wordIndex1 = 0;
            }
            if (wordIndex2 == word2[index2].length()) {
                index2++;
                wordIndex2 = 0;
            }
        }
        return index1 == word1.length && index2 == word2.length;

    }
}
