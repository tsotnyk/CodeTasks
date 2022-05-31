You will be given a list of 32 bit unsigned integers. Flip all the bits ( and ) and return the result as an unsigned integer.

Example

. We're working with 32 bits, so:



Return .

Function Description

Complete the flippingBits function in the editor below.

flippingBits has the following parameter(s):

int n: an integer
Returns

int: the unsigned decimal integer result
Input Format

The first line of the input contains , the number of queries.
Each of the next  lines contain an integer, , to process.

Constraints



Sample Input 0

3
2147483647
1
0
Sample Output 0

2147483648
4294967294
4294967295
Explanation 0







Sample Input 1

2
4
123456
Sample Output 1

4294967291
4294843839
Explanation 1





Sample Input 2

3
0
802743475
35601423
Sample Output 2

4294967295
3492223820
4259365872
Explanation 2







