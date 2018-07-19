Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from 1 to 100
for three categories: problem clarity, originality, and difficulty.

We define the rating for Alice's challenge to be the triplet A = (a[0], a[1], a[2]), and the rating for Bob's challenge to be the triplet
B = (b[0], b[1], b[2]).

Your task is to find their comparison points by comparing  a[0] with b[0], a[1] with b[1], and a[2] with b[2].

if a[i] > b[i], then Alice is awarded 1 point.

if a[i] < b[i], then Bob is awarded 1 point.

if a[i] == b[i], then neither person receives a point.

Comparison points is the total points a person earned.
Given  A and B, can you compare the two challenges and print their respective comparison points?


Input Format

The first line contains 3 space-separated integers, a[0], a[1], and a[2], describing the respective values in triplet A.
The second line contains  space-separated integers, b[0], b[1], and b[2], describing the respective values in triplet B.

Constraints

1 <= a[i] <= 100
1 <= b[i] <= 100

Output Format

Return an array of two integers denoting the respective comparison points earned by Alice and Bob.


Sample Input 0

5 6 7
3 6 10

Sample Output 0

1 1

Explanation 0
In this example:

A = (a[0], a[1], a[2]) = (5, 6, 7)

B = (b[0], b[1], b[2]) = (3, 6, 10)

Now, let's compare each individual score:

a[0] > b[0], then Alice is awarded 1 point.

a[1] == b[1], then neither person receives a point.

a[2] < b[2], then Bob is awarded 1 point.

Alice's comparison score is 1, and Bob's comparison score is 1. Thus, we print 1 1 (Alice's comparison score followed by Bob's comparison score) on a single line.