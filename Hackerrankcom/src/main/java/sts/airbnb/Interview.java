package sts.airbnb;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Interview {

        public static int findSmallestNumOfUserForBonus(int[][] matrix){

            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for(int i = 0; i < matrix.length; i++){
                List<Integer> list = new LinkedList<>();
                for( int j = 0; j < matrix.length; j++){
                    if(matrix[i][j] == 1 && i != j){
                        list.add(j);
                    }
                }
                map.put(i, list);
            }

            int counter = 0;
            boolean[] visitUser = new boolean[matrix.length];
            Stack<Integer> userStack = new Stack<>();

            int user = unVisitedUser(visitUser);
            while (user >= 0){

                if(!visitUser[user]){
                    List<Integer> list = map.get(user);
                    if(list.isEmpty()){
                        counter++;
                    }else{
                        userStack.addAll(list);
                    }
                    visitUser[user] = true;
                }

                if (userStack.isEmpty()) {
                    user = unVisitedUser(visitUser);
                }else {
                    user = userStack.pop();
                }
            }
            return counter;
        }

        private static int unVisitedUser(boolean[] visitUser){

            for(int i = 0; i < visitUser.length; i++){
                if(!visitUser[i]){
                    return i;
                }
            }

            return -1;
        }

        @Test
    public void test(){

            int[][] matrix = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0}};
            Assert.assertEquals(findSmallestNumOfUserForBonus(matrix), 3);
        }

    }
//1. User i may follow user j, but user j may not follow user i.
//2. We want to send referral bonus to a subset of users to ask them to broadcast a new feature such that all N users will know this feature in the end.
//3. We assume that if user i sends a tweet, all the users following i will be notified and all of these followers will broadcast to its' followers and so on.
//4. We want to find the minimum number of users we want to send referral bonus such that all N users will be notified about this new feature.//

/*
if  entry (i, j) = 1, user *j *follows user *i*.

matrix.length == matrix[0].length;

input =
  0 , 1, 2, 3, 4, 5, 6, 7, 8, 9
[[0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 0
 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 1
 [0, 0, 0, 0, 0, 0, 0, 0, 0, 1], 2 (2, 9)  9 --> 2
 [0, 0, 0, 1, 0, 1, 0, 1, 0, 0], 3  (3, )
 [0, 0, 0, 0, 0, 0, 0, 0, 1, 0], 4
 [0, 0, 0, 0, 0, 0, 0, 0, 1, 0], 5
 [0, 0, 0, 0, 0, 0, 1, 0, 0, 0], 6
 [0, 0, 0, 0, 1, 0, 0, 0, 0, 0], 7
 [0, 0, 0, 0, 0, 0, 0, 1, 0, 0],8
 [0, 0, 0, 1, 0, 0, 1, 0, 0, 0]] 9

counter

 0, ();  counter++;
 1 ();   counter++;
 2 (9);  continios;
 3 (5,7); continios;
 4 (8) continios;
 5 (8)continios;
 6 () counter++;
 7 (4); continios;
 8(7); continios;
 9 (3, 6) continios;

 ======
                100  (N)  or (10^2) n +  10 n
 return counter; O(N (amount value in matrix) (n^2) (n - amount user)+ n)  N is number of users in total

 n - amount users

*/

