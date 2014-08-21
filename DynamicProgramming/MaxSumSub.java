import java.util.Scanner;

class MaxSumSeq
{
   static int calculateMaxSubSum(int[] a)
  {
    int maxSum = 0;
    int currMaxSum = 0;

  for (int i = 0, j = 0 ; j < a.length ; j++)
    {
      currMaxSum += a[j];

      if (currMaxSum > maxSum)
      {
        maxSum = currMaxSum;
      }
      else if (currMaxSum < 0)
      {
        currMaxSum = 0;
      }
    }

    return maxSum;
  }

  public static void main(String[] args)
  {
    int[] a = new int[5];

    Scanner in = new Scanner(System.in);

    for (int i = 0 ; i < 5 ; i++)
    {
      a[i] = in.nextInt();  
    }

    System.out.println("\nMax Sum Seq : "+ calculateMaxSubSum(a));
  }
}
