public class shuffle
{
  
  static void swap(int[] a, int i, int r)
  {
    int temp = a[i];
    a[i] = a[r];
    a[r] = temp;
  }

  static int[] shuffle_numbers(int[] a)
  {
    int N = a.length;

    for (int i = 0 ; i < N ; i++)
    {
      int r = i + (int)(Math.random() * (N-i));
      swap(a, i, r);
    }
    return a;
  }

  public static void main(String[] args)
  {
    int[] a = {1,2,3,4,5};

    int[] b = shuffle_numbers(a);

    for (int i = 0 ; i < b.length ; i++)
      System.out.println(b[i]);
  }
}
