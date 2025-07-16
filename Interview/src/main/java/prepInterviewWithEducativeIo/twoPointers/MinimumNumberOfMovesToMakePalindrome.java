package prepInterviewWithEducativeIo.twoPointers;

// TODO need repeat it later
public class MinimumNumberOfMovesToMakePalindrome {

    public int minMovesToMakePalindromeBase(String s) {
        // Convert string to list for easier manipulation
        char[] chars = s.toCharArray();

        // Counter to keep track of the total number of swaps
        int moves = 0;

        // Loop to find a character from the right (s[j]) that
        // matches with a character from the left (s[i])
        for (int i = 0, j = chars.length - 1; i < j; ++i) {
            int k = j;
            for (; k > i; --k) {
                // If a matching character is found
                if (chars[i] == chars[k]) {
                    // Move the matching character to the correct position on the right
                    for (; k < j; ++k) {
                        // Swap characters
                        char temp = chars[k];
                        chars[k] = chars[k + 1];
                        chars[k + 1] = temp;
                        // Increment count of swaps
                        ++moves;
                    }
                    // Move the right pointer inwards
                    --j;
                    break;
                }
            }
            // If no matching character is found, it must be moved to the center of palindrome
            if (k == i) {
                moves += chars.length / 2 - i;
            }
        }
        return moves;
    }
}
