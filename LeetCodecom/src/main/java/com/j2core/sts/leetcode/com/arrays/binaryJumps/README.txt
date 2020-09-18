In a revised game of hopscotch a child is trying to cross a line of tiles with a binary string painted on it. Consider the line of tiles to be like 1D array, where each tile has either a 1 or a 0, and a consecutive series of tiles makes the whole string. The game starts with the child standing in front of the leftmost character of the string.

    All jumps to reach the end of the string can only be on tiles with 0 or only be in the tiles with 1.
    The game is won if the child can reach at the end of the string, taking jumps with minimum required power. The power of a jump is given by the number of tiles in the path of a jump as indicated in the diagram below. In 10101, the power of the jump from beginning to the first tile is 1 but from the first tile to the third tile is 2, and so on

Find the minimum power the child's jump should have in order to win the game for different binary strings. Note: The value on the last tile determines which tiles to jump on. This is because all tiles landed on mush have the same value and the child must land on the last tile to complete the fame. In one jump, the child can jump to the right, any distance from 1 to the value of the power of her jump.

BinaryJumpsExample

Constraints

    1 <= Length of game <= 100000

    s[i] contains either "1" or "0"

      Sample Input 0:
      11111
      Sample Output 0:
      1


      Sample Input 1:
      10101
      Sample output 1:
      2

