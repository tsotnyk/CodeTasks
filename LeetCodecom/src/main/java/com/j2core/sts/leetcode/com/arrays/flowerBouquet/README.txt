A person can create a flower bouquet with either 3 roses (cost of bouquet = p) or 1 rose and 1 lily (cost = q)
In an array of flowers, the person has to select contiguous set of flowers i.e. 2 or 3 to gain maximum cost.

Input format: A string of 0(denotes rose) and 1(denotes lily).
Output : Maximum cost.

Examples:


Input: p = 2, q = 3, s = 0001000
Output: 5


/////

Lara owns a flower shop, where she sells only two types of flower bouquets:

    Type 1: the first type of bouquet contains three roses and costs p dollars.
    Type 2: The second type of bouquet contains one cosmos and one rose and costs q dollars.

Lara grows these flowers in her own garden in a single tow. Consider the row as a one-dimensional array, here each cell either contains a rose or a cosmos. For example array 001101011, here 0 indicates rose and 1 indicates cosmos.

FlowerBouquets

Lara follows an important rule when she makes the bouquets: she makes each bouquet with only consecutive flowers from the array.
For example in a bouquet, the flower from consecutive (i, i+1, and i+2) in the array can be present, but not from non-consecutive indices (i and i+2) in the array above, Lara can not make any bouquets of type 1 but she can make 3 bouquets of type 2

Now she wonder what is the maximum profit she can make if she makes these bouquets optimally. You are given a binary string representing her garden row. calculate the maximum profit Lara can make. Remember that it is not necessary to use every flower

Function Description:

Complete the flowerBouquets function in the editor below. The function must return an integer that denotes the maximum profit Lara can make if she makes her bouquet optimally.

flowerBouqets has three parameters:

    p: integer denoting the cost of a bouquet of type 1.
    q: integer denoting the cost of a bouquet of type 2.
    s: string denoting the garden pattern, where zero indicated rose and on indicates cosmos

Constraints:

    1 <= p,q <= 1000

    1 <= |s| <= 100000

      Sample Input 0:
      2

      3
      0001000
      Sample Output 0:
      5

      Explanation 0
      Lara can make two bouquets of three roses by the corresponding indexes: [0, 1, 2] and [4, 5, 6] and can earn 2+2 = 4 profit.
      **OR**
      Lara can make one bouquet of three roses by the corresponding indexes: [0, 1, 2] and one bouquet of one rose and one cosmos by corresponding indexes (3, 4) and can earn 2+3 = 5 profit.
      5 i greater than 4 so print 5

