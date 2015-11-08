public class BinarySearchRotatedKey {

  public int findKey(int[] a, int key) {
    int low = 0;
    int high = a.length - 1;

    while(low <= high) {
      int mid = low + (high - low)/2;
      if(a[mid] == key)
        return mid;
      if(a[low] <= a[mid]) {
        if(key >= a[low] && key < a[mid])
          high = mid - 1;
        else
          low = mid + 1;
      }
      else {
        if(key >= a[mid] && key < a[high])
          low = mid + 1;
        else
          high = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    BinarySearchRotatedKey b = new BinarySearchRotatedKey();
    int[] arr1 = {4, 5, 6, 7, 8, 0, 1, 2, 3};
    int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    int[] arr4 = {8, 0, 1, 2, 3, 4, 5, 6, 7};
    System.out.println(b.findKey(arr1, 0));
    System.out.println(b.findKey(arr2, 0));
    System.out.println(b.findKey(arr3, 0));
    System.out.println(b.findKey(arr4, 0));
  }
}
