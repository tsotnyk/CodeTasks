package mockAssessments.adobe.online;

public class Solution1 {

    public boolean isOneBitCharacter(int[] bits) {

        if (bits.length < 3) return true;

        if (bits.length > 3) return false;

        return bits[bits.length-2] == 0;
    }
}
