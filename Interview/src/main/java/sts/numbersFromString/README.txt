Write a program in Java to assess a given string whether it complies with following patterns.
Return true if a given string complies with these patterns else false.



N = N1 + N2

N>= N1 >= N2



where N is the Nth element in the string or element at Nth position;

      N1 is the (N-1) element in the string & N2 is the (N-2) element in the string.



Example 1: 224610

Elements in this string are 2, 2, 4, 6, 10.

First Set:     2+2=4 (N2=2; N1=2 & N= 4);

Second Set: 2+4=6 (N2=2; N1=4 & N=6);

Third Set:    4+6=10 (N2=4; N1=6 & N= 10)



Example 2: 1112233558

Elements in this string are 1, 11, 12, 23, 35, 58

Example 3: 1101102203

Elements in this string are 1, 101, 102, 203.

This is a simple problem of recursion, which includes determination of this elements programmatically and running these patterns.


-------------------------------------------------------------------------------------
!!!!!!!!!!!!!!!!!!!!! NON-FATAL MISTAKE IN TASK DESCRIPTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!

Task examples contains mistake which most people don't see!!!

> Example 2: 1112233558
> Elements in this string are 1, 11, 12, 23, 35, 58

                                ^^^^^^^^^^^^^^^^^  THIS IS WRONG !!!!!!!!!!
                                It should be 11 12 23 35 58.

                                For 1,11,12,23,58 sequence must be 11112233558

-------------------------------------------------------------------------------------