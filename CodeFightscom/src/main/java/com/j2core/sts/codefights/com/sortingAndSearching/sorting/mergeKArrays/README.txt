Given K sorted arrays, return their sorted concatenation.

Example

For arrays = [[1, 3, 5], [2, 3], [2, 3, 5, 8]], the output should be
mergeKArrays(arrays) = [1, 2, 2, 3, 3, 3, 5, 5, 8].

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer arrays

An array of K one-dimensional sorted arrays.

Guaranteed constraints:
3 ≤ arrays.length ≤ 10,
0 ≤ arrays[i].length ≤ 5,
-100 ≤ arrays[i][j] ≤ 100.

[output] array.integer


Source code for redevelopment:

ArrayList<Integer> mergeKArrays(int[][] arrays) {
  int[] firstUnused = new int[arrays.length];
  ArrayList<Integer> result = new ArrayList<>();
  int n = 0;
  for (int i = 0; i < arrays.length; i++) {
    n += arrays[i].length;
  }
  for (int i = 0; i < n; i++) {
    int minIndex = -1,
        minValue = 0;
    for (int j = 0; j < arrays.length; j++) {
      if (firstUnused[j] < arrays[j].length) {
        if (...) {
          minIndex = j;
          minValue = arrays[j][firstUnused[j]];
        }
      }
    }
    result.add(minValue);
    firstUnused[minIndex]++;
  }
  return result;
}