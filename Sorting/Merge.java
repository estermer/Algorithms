/*
 * Merge two sorted arrays
 */

public class Merge {
  
  public int[] merge(int[] a, int[] b) {
    int aLen = a.length;
    int bLen = b.length;
    int[] merged = new int[aLen + bLen];

    int i = 0;
    int j = 0;
    int k = 0;
    while(i < aLen && j < bLen) {
      if(a[i] < b[j]) {
        merged[k] = a[i];
        i++;
      }
      else if (b[j] < a[i]) {
        merged[k] = b[j];
        j++;
      }
      else if (a[i] == b[i]) {
        merged[k] = a[i];
        k++;
        merged[k] = b[j];
        i++;
        j++;
      }
      k++;
    }
    while (i < aLen) {
      merged[k] = a[i];
      i++;
    }
    while (j < bLen) {
      merged[k] = b[j];
      j++;
    }
    return merged;
  }

  public int[] mergeN(int[]... args) {
    int noOfArrays = args.length; 
    int finalArrSize = 0;
    for (int i = 0; i < noOfArrays; i++) {
      finalArrSize = finalArrSize + args[i].length; 
    }
    int[] finalMergedArr = new int[finalArrSize];
    
    int[] merged = args[0];
    for (int i = 1; i < noOfArrays; i++) {
      int[] temp = merge(merged, args[i]);
      merged = null;
      merged = temp;
    }
    return merged;
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 3, 4, 8};
    int[] b = new int[] {2, 3, 6, 7, 9};
    int[] c = new int[] {5, 4, 9, 11, 2, 1};
    Merge m = new Merge();
    int[] mergedArray = m.mergeN(a, b, c);

    //System.out.println("Args:"+ mergeN(a, b));

    for (int i = 0; i < mergedArray.length; i++) {
      System.out.println(mergedArray[i]);
    }
  }
}
