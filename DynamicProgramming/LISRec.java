public class LISRec
{

  static void printsubseq(int[] arr, int index, int large)
  {
    if (index < arr.length)
    {
      if (arr[index] >= large)
      {
        System.out.print(arr[index]+" ");
        printsubseq(arr, index+1, arr[index]);
      }
      else
        printsubseq(arr, index+1, large); 
    }
  }

  static void printseq(int[] arr, int index)
  {
    if (index < arr.length)
    {
      printsubseq(arr, index, arr[index]);
      System.out.println(" ");
      printseq(arr, index+1);
    }
  }

  public static void main(String[] args)
  {
    int[] arr = {9,1,7,3,6,9,5,6,3,6,4,8,5,2,1,0};  
    printseq(arr, 0);
  }
}
