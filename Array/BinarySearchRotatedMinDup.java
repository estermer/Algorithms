public class BinarySearchRotatedMinDup {

  public int findMin(int[] num, int low, int high) {
    if(low > high)
      return num[0];
    if(high == low)
      return num[low];
    int mid = low + (high - low) / 2;
    if(mid < high && num[mid] > num[mid + 1])
      return num[mid + 1];
    if(num[low] == num[mid] && num[mid] == num[high])
      return Math.min(findMin(num, low, mid - 1), findMin(num, mid + 1, high));
    if(mid > low && num[mid] < num[mid - 1])
      return num[mid];
    if(num[mid] <= num[high])
      return findMin(num, low, mid - 1);
    return findMin(num, mid + 1, high);
  }

  public static void main(String[] args) {
    BinarySearchRotatedMinDup b = new BinarySearchRotatedMinDup();
    int[] arr1 = {4, 5, 6, 7, 8, 0, 1, 2, 3};
    int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    int[] arr4 = {8, 0, 1, 2, 3, 4, 5, 6, 7};
    System.out.println(b.findMin(arr1, 0, arr1.length - 1));
    System.out.println(b.findMin(arr2, 0, arr2.length - 1));
    System.out.println(b.findMin(arr3, 0, arr3.length - 1));
    System.out.println(b.findMin(arr4, 0, arr4.length - 1));
  }
}
