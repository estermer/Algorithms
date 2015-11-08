public class FlippingBits {
  
  static void max1srange(int[] a) {
    int allOnes = getAllOnes(a);

    int cLeft = 0;
    int cSum = 0;
    int rLeft = 0;
    int rRight = 0;
    int rSum = 0;

    for(int i = 0; i < a.length; i++) {
      int iVal = (a[i] == 1) ? -1 : 1;
      if(iVal + cSum >= 0) {
        cSum += iVal;
      } else {
        cSum = 0;
        cLeft = i + 1;
      }
      
      if (cSum > rSum) {
        rSum = cSum;
        rLeft = cLeft;
        rRight = i;
      }
    }
    System.out.println("Result: " + (allOnes + rSum) + " Range: " + rLeft +", "+ rRight);
  }

  private static int getAllOnes(int[] a) {
    int sum = 0;
    for(int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] t1 = {1, 0, 0, 1, 0, 0, 1, 0};
    int[] t2 = {1, 1, 1, 1, 1, 1, 1, 1};
    int[] t3 = {1, 1, 1, 0, 1, 1, 1, 1};
    max1srange(t1);
    max1srange(t2);
    max1srange(t3);
  }
}
