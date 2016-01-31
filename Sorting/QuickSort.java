import java.util.*;

public class QuickSort {
  
  public static void main(String[] args) {
    Integer[] a = {5, 4, 3, 1, 2};
    quickSort(a);
    System.out.println(Arrays.toString(a));
  }

  public static void quickSort(Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int low, int high) {
    int pivot = low + (high - low) / 2;
    int left = low;
    int right = high;

    while (left <= right) {
      while(a[left].compareTo(a[pivot]) < 0) {
        left++;
      }

      while (a[right].compareTo(a[pivot]) > 0) {
        right--;
      }

      if (left <= right) {
        Comparable temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        left++;
        right--;
      }
    }

    if (low < right) {
      sort(a, low, right);
    }
    if (high > left) {
      sort(a, left, high);
    } 
  }
}
