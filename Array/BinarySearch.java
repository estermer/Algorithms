public class BinarySearch
{

  public static int sortedSearch(int[] a, int key)
  {
    int low = 0;
    int high = a.length - 1;
    int mid; 

    if (key < a[low] || key > a[high])
      return -1;

    while (low <= high)
    {
      mid = (low + high)/2;

      if (key == a[mid])
        return mid;
      else if (key < a[mid])
        high = mid - 1;
      else
        low = mid + 1;
    }

    return -1;
  }
  
  public static int incDecSearch(int[] a) {
    int low = 0;
    int high = a.length - 1;
    
    while(low <= high) {
      if(low == high)
        return a[low];
      if(low == high - 1)
        return Math.max(a[low], a[high]);

      int mid = low + (high - low)/2;
      if(a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
        return a[mid];
      else if(a[mid] > a[mid - 1] && a[mid] < a[mid + 1])
        low = mid + 1;
      else if(a[mid] < a[mid - 1] && a[mid] > a[mid + 1])
        high = mid - 1;
    }
    return -1;
  }

  public static void main(String[] args)
  {
    int[] arr = {1,2,3,4,5,6,7};
    int[] arr2 = {10, 11, 12, 13, 9, 8, 7, 4};
    //System.out.println(sortedSearch(arr, 7));
    System.out.println(incDecSearch(arr2)); 
  }
}
