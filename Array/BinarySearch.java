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
  
  public static int decIncSearch(int[] a)
  {
    int low = 0;
    int mid = 0;
    int high = a.length - 1;
    
    if(low > 0)
      return a[low];

    if (low == high && low > 0)
      return 0;

    if (high < 0)
      return -1;

    while (low <= high)
    {
      mid = low + (high - low)/2;
      if (a[mid] > a[mid - 1] && a[mid - 1] < 0 && a[mid] > 0)
        return a[mid];
      else if (a[mid] > a[mid - 1] && a[mid - 1] > 0)
        high = mid - 1;
      else
        low = mid + 1; 
    }
    return -1;
  }

  public static void main(String[] args)
  {
    int[] arr = {1,2,3,4,5,6,7};
    int[] arr2 = {-5,-2,-3,-7,-8,-10,15}; 
    //System.out.println(sortedSearch(arr, 7));
    System.out.println(decIncSearch(arr2)); 
  }
}
