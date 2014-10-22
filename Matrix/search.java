public class search
{
  /*
   * This is a vertical and horizontal sorted matrix
   *  1 04 07 08
   *  2 09 10 11
   *  3 12 13 14
   *  4 17 19 20
   */
  static int maxMatrixR(int[][] a, int low, int high, int key)
  {
     if (low > high)
       return 0;
      
     int mid = (int)(low + high)/2;
     System.out.println("\nMid = "+a[mid][mid]+"key = "+key);
     
     if (a[mid][mid] == key)
     {
       System.out.println("Here");
       return 1;
     }
     else if (a[mid][mid] > key)
       maxMatrixR(a, low, mid-1, key);
     else 
       maxMatrixR(a, mid+1, high, key);

     return 0;
  }
  
  static int searchR(int[][] a, int x, int y, int key)
  {
    for (int i = 0; i < x; i++)
    {
      if (a[i][y] == key)
        return i+y;
    }

    for (int i = 0; i < y ; i++)
    {
      if (a[x][i] == key)
        return i+x;
    }

    return -1;
  }

  static int maxMatrixI(int[][] a, int low, int high, int key)
  {
    int mid;
    while (low <= high)
    {
      mid = (int)(low + high)/2;
      if (a[mid][mid] > key)
      {
        high = mid-1;
      }
      else if (a[mid][mid] < key)
      {
        if (key < a[mid+1][mid+1])
        {
          return searchR(a, mid+1, mid+1, key);
        }
        low = mid+1;
      }
      else
        return mid;
    }
    return -1;
  }

  public static void main(String[] args)
  {
    int[][] a = {{00, 01, 02, 03},
                 {10, 11, 12, 13},
                 {20, 21, 22, 23},
                 {30, 31, 32, 33}};

    int res = maxMatrixI(a, 0, 3, 21);

    if (res == -1)
      System.out.println("Element not found\n");
    else
      System.out.println("Element found at "+ res);
  }
}
