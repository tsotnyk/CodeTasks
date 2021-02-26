Given an array of integers, sort it.

Example

For items = [2, 4, 1, 5], the output should be
bubbleSort(items) = [1, 2, 4, 5].

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer items

Guaranteed constraints:
1 ≤ items.length ≤ 15,
-100 ≤ items[i] ≤ 100.

[output] array.integer


Source code for redevelopment:

int[] bubbleSort(int[] items) {

  class SwapClass {
    void swap(int[] items, int firstIndex, int secondIndex) {
      int temp = items[firstIndex];
      items[firstIndex] = items[secondIndex];
      items[secondIndex] = temp;
    }
  }
  SwapClass sw = new SwapClass();

  int len =  ... ;

  for (int i = 0; i < len; i++) {
    for (int j = 0, stop = len - i; j < stop - 1; j++) {
      if (items[j] > items[j + 1]) {
        sw.swap(items, j, j + 1);
      }
    }
  }

  return items;
}