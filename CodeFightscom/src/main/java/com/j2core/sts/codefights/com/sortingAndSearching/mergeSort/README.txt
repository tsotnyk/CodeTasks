Sort an array of integers.

Example

For sequence = [3, 6, 1, 5, 3, 6], the output should be
mergeSort(sequence) = [1, 3, 3, 5, 6, 6].

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer sequence

Guaranteed constraints:
1 ≤ sequence.length ≤ 100,
-100 ≤ sequence[i] ≤ 100.

[output] array.integer

sequence sorted in non-decreasing order.


Source code for redevelopment:

void merge(int[] sequence, int left, int middle, int right) {
  int[] result = new int[right - left];
  int i, j;
  int k = 0;

  for (i = left, j = middle; i < middle && j < right; ) {
    if (sequence[i] < sequence[j]) {
      result[k++] = sequence[i];
      i++;
    }
    else {
      result[k++] = sequence[j];
      j++;
    }
  }

  while (i < middle) {
    result[k++] = sequence[i];
    i++;
  }

  while (j < right) {
    result[k++] = sequence[j];
    j++;
  }

  for (i = left; i < right; i++) {
    sequence[i] = result[i - left];
  }
}

void split(int[] sequence, int left, int right) {
  ...
  int middle = (left + right) / 2;
  split(sequence, left, middle);
  split(sequence, middle, right);
  merge(sequence, left, middle, right);
}

int[] mergeSort(int[] sequence) {
  split(sequence, 0, sequence.length);

  return sequence;
}