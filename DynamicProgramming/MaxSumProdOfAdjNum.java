/*
 * Maximum sum of product of adjacent numbers
 * Explanation - http://stackoverflow.com/questions/11068275/maximize-the-sum-of-product-of-adjacent-numbers
 */
public class MaxSumProdOfAdjNum {
  
  // array a is sorted
  public static int maxSum(int[] a) {
    int n = a.length;
    int sum = a[n-1]*a[n-2];
    
    for (int i = n-3; i >=0; i--) {
      sum = sum + (a[i] * a[i+2]);
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 2, 3};
    int[] b = new int[] {1, 2, 3, 4};
    System.out.println(maxSum(a));
    System.out.println(maxSum(b));
  }
}
