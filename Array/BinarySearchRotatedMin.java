public class BinarySearchRotatedMin {

  public int findMin(int[] num) {
    int low = 0;
    int high = num.length - 1;

    if(num.length == 1) {
      return num[0];
    }
    if(num.length == 2) {
      return Math.min(num[0], num[1]);
    }
    if(num[low] < num[high])
      return num[low];

    while(low <= high) {
      if(high == low)
        return num[low];
      int mid = low + (high - low) / 2;
      if(mid < high && num[mid] > num[mid + 1])
        return num[mid + 1];
      if(mid > low && num[mid] < num[mid - 1])
        return num[mid];
      if(num[high] > num[mid])
        high = mid - 1;
      else
        low = mid + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    BinarySearchRotatedMin b = new BinarySearchRotatedMin();
    int[] arr1 = {4, 5, 6, 7, 8, 0, 1, 2, 3};
    int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    int[] arr4 = {8, 0, 1, 2, 3, 4, 5, 6, 7};
    System.out.println(b.findMin(arr1));
    System.out.println(b.findMin(arr2));
    System.out.println(b.findMin(arr3));
    System.out.println(b.findMin(arr4));
  }
}
