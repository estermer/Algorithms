public class Sorting
{
  /* Selection Sort */
  public static int[] selectionSort(int arr[])
  {
    int n = arr.length;

    for (int i = 0 ; i < n ; i++)
    {
      int min = i;
      for (int j = i + 1 ; j < n ; j++)
      {
        if (arr[j] < arr[min])
        {
          min = j;
        }
      }
      int temp = arr[min];
      arr[min] = arr[i];
      arr[i] = temp;
    }
    return arr;
  }

  public static int[] insertionSort(int arr[])
  {
    int j, val;
    int n = arr.length;
    for (int i = 2 ; i <= n-1 ; i++)
    {
      val = arr[i];
      j = i;

      while (j>=1 && val < arr[j-1])
      {
        arr[j] = arr[j-1];
        j--;
      }
      arr[j] = val;
    }
    return arr;
  }

  public static void main(String[] args)
  {
    int[] arr = {3,5,2,3,0,9,8,5};
    int[] arr2 = {6,8,1,4,5,3,7,2};
    //int[] sorted = selectionSort(arr);
    int[] sorted = insertionSort(arr);

    for (int i = 0 ; i < sorted.length ; i++)
    {
      System.out.print(sorted[i]+ " ");
    }
  }
}
