Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track her ranking. The game uses Dense Ranking, so its leaderboard works like this:
• The player with the highest score is ranked number 1 on the leaderboard.
• Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
For example, the four players on the leaderboard have high scores of 100, 90, 90 and 80. Those players will have ranks 1, 2, 2 and 3, respectively. If Alice's scores are 70, 80 and 105, her rankings after each game are 4th , 3rd and 1st .

Input Format
The first line contains an integer , the number of players on the leaderboard.
The next line contains space-separated integers , the leaderboard scores in decreasing order.
The next line contains an integer, , denoting the number games Alice plays.
The last line contains space-separated integers , the game scores.

Input 1:

7
100 100 50 40 40 20 10
leadeeboard = [1,1,2,3,3,4,5]
4
5 25 50 120


Output 1:

6
4
2
1

Input 2:
6
100 90 90 80 75 60
leadeeboard = [1,2,2,3,4,5]

5
50 65 77 90 102

Output 2:
6
5
4
2
1