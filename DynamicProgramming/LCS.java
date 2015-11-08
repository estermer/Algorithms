public class LCS
{
  static void LCSLength(String x, String y)
  {
     int m = x.length();
     int n = y.length();
     int[][] a = new int[m+1][n+1];

     for (int i = m-1 ; i >= 0 ; i--)
     {
      for (int j = n-1 ; j >= 0 ; j--)
      {
        if (x.charAt(i) == y.charAt(j))
          a[i][j] = 1 + a[i+1][j+1];
        else
          a[i][j] = Math.max(a[i + 1][j + 1], Math.max(a[i+1][j], a[i][j+1]));
      }
     }
     System.out.println("Longest length: "+a[0][0]+"\n");

     int i = 0, j = 0;

     while (i < m && j < n)
     {
      if (x.charAt(i) == y.charAt(j))
      { 
        System.out.println(x.charAt(i) + " ");
        i++;
        j++;
      }
      else if (a[i+1][j] > a[i][j+1])
        i++;
      else
        j++;
     }
  }

  public static void main(String[] args)
  {
    LCSLength(args[0], args[1]);
  }
}
