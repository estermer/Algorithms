import java.util.*;

public class KthSmallest {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Integer[] a = {5, 4, 2, 3, 10, 1, 100, 10};
    Integer kth = kthSmallest(a, in.nextInt() - 1);
    System.out.println(a[kth]);
  }

  public static Integer kthSmallest(Integer[] a, int k) {
    return quickSelect(a, 0, a.length - 1, k);
  }

  public static Integer quickSelect(Integer[] a, int low, int high, int k) {
    if (low >= high) {
      return low;
    }

    int selectedPivot = low + (high - low) / 2;
    swap(a, low, selectedPivot);

    int currPivotIndex = partition(a, low, high, k);

    int len = currPivotIndex - low;

    if (k < len) {
      return quickSelect(a, low, currPivotIndex - 1, k);
    } 
    if (k > len) {
      return quickSelect(a, currPivotIndex + 1, high, k - len - 1);
    } 
    return currPivotIndex;
  }

  private static Integer partition(Integer[] a, int left, int right, int k) {
    int l = left;
    int r = right;
    int pivotValue = a[left];

    while (l < r) {
      while (a[l] <= pivotValue && l < r) {
        l++;
      }
      while (a[r] > pivotValue) {
        r--;
      }
      if (l < r) {
        swap(a, l, r);
      }
    }

    swap(a, left, r);
    return r;
  }

  private static void swap(Integer[] a, int i, int j) {
    Integer temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
