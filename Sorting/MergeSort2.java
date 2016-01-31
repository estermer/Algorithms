import java.util.*;

public class MergeSort2 {

  public static void main(String[] args) {
    Integer[] a = {4, 5, 3, 1, 2};
    mergeSort(a);
    System.out.println(Arrays.toString(a));
  }

  public static void mergeSort(Comparable[] a) {
    Comparable[] temp = new Comparable[a.length];
    mergeSort(a, temp, 0, a.length - 1);
  }

  private static void mergeSort(Comparable[] a, Comparable[] temp, int left, int right) {
    if (left < right) {
      int center = (left + right) / 2;
      mergeSort(a, temp, left, center);
      mergeSort(a, temp, center + 1, right);
      merge(a, temp, left, center + 1, right);
    }
  }

  private static void merge(Comparable[] a, Comparable[] temp, int left, int right, int rightEnd) {
    int leftEnd = right - 1;
    int l = left;
    int num = rightEnd - left + 1;

    while (left <= leftEnd && right <= rightEnd) {
      if (a[left].compareTo(a[right]) <= 0) {
        temp[l++] = a[left++];
      } else {
        temp[l++] = a[right++];
      }
    }

    while (left <= leftEnd) {
      temp[l++] = a[left++];
    }

    while (right <= rightEnd) {
      temp[l++] = a[right++];
    }

    for (int i = 0; i < num; i++, rightEnd--) {
      a[rightEnd] = temp[rightEnd];
    }
  }
}
