A project manager wants to look at employee attendance data. Given that m employees are working on the project,
and the manager has the record of the employees present on n days of the project, help him find the maximum number
of consecutive days on which all employees were present and working on the project.

As an example there are m = 3 employees and n = 5 workdays to analyze.
The attendance data strings, data = [YYY, YYY, YNN, YYN, YYN].
There are only two days at the beginning of the period , where all worker are present.
Using zero indexing for employees, employees 1 and 2 are absent on the third day, and employee 2 is also out on the forth and fifth days.
The maximum streak occurs at the beginning and is 2 days long.

Function Description Complete the maxStrak function in the editor below. The function must return an integer denoting the maximum number of consecutive days where all the employees of the project are present.

maxStreak has the following parameters: m: an integer denoting the number of employees working on the project. data: an array of n strings, where the value of each element data[i] is a string where data[i][j] denotes the j-th employee is present on the i-th day.

Constraints

    1 <= m <= 10

    1 <= n <= 100000

    Each data[i][j] belongs {"Y", "N"}

      Sample Input 0:
      2
      2
      YN
      NN
      Sample Output 0:
      0


      Sample Input 1:
      3
      1
      NYY
      Sample output 1:
      0

      Sample Input 2:
      4
      5
      YNYY
      YYYY
      YYYY
      YYNY
      NYYN
      Sample Output 2:
      2

