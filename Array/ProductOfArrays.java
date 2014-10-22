/*
 * @Author - Nitish
 * @Description - Product of every other integer excluding the current index
 */

import java.math.BigInteger;

public class ProductOfArrays {

  /*
   * @Description - Function takes array as input and computes the product of
   * every other integer excluding current index
   * @Example - 
   * Original array: [2 3 4]
   * Compute       : [1        1*2  (1*2)*3]
   *                 [(1*4)*3  1*4        1]
   *               = [4*3      2*4      2*3]
   * For the above computation can be done in constant O(1) temp space as we
   * we can have two pointers to array moving from l to r and r to l at the
   * same time. Time complexity is O(N) to traverse the array and O(N) space
   * for output array
   * @param - integer array
   * @param - length of array
   * @Exception - ArithmeticException in case of integer overflow
   * @Output - integer array
   */
  static int[] calProductInt(int[] orig, int len) throws ArithmeticException {
    
    int i = 0;
    int j = len - 1;

    int temp1 = 1;
    int temp2 = 1;

    int[] result = new int[len];

    for(int k = 0; k < len; k++) {
      result[k] = 1;
    }

    while(i < len && j >= 0) {
      // Use secureMultiply function to prevent overflows, in case of overflow
      // throw ArithmeticException
      result[i] = secureMultiply(result[i], temp1);
      result[j] = secureMultiply(result[j], temp2);

      // l to r
      temp1 = temp1 * orig[i++];
      // r to l
      temp2 = temp2 * orig[j--];
    }

    return result;
  }

  /*
   * @Description - This function works the same way as calProductInt but uses
   * BigInteger to compute product as it does not overflow and produces
   * numerically correct result.
   * This function is invoked only when the above function overflow (throws)
   * arithmetic exception
   * Theoritically the time and space complexity of below function same as the
   * above primitive function but BigInteger takes much more time and space as
   * BigInteger stores the data in an integer array and creates a new object 
   * everytime as class java.math.BigInteger is immutable
   * But since we need numerically correct result for any size of input we need
   * to use BigInteger
   */
  static BigInteger[] calProductBig(int[] orig, int len) {

    int i = 0;
    int j = len - 1;

    BigInteger temp1 = BigInteger.ONE;
    BigInteger temp2 = BigInteger.ONE;
    BigInteger[] result = new BigInteger[len];

    // initialize BigInteger array, additional O(N)
    for(int k = 0; k < len; k++) {
      result[k] = BigInteger.ONE;
    }

    while(i < len && j >= 0) {
      result[i] = result[i].multiply(temp1);
      result[j] = result[j].multiply(temp2);

      // l to r
      temp1 = temp1.multiply(BigInteger.valueOf(orig[i++]));
      // r to l
      temp2 = temp2.multiply(BigInteger.valueOf(orig[j--]));
    }

    return result;
  }

  /*
   * @Description - Function takes to integers and checks if the product will
   * overflow or not. It upcast int to long so that the value does not change
   * and compare with integer min and max
   * @param - integer
   * @param - integer
   * @Output - product of integers
   * @Exception - Arithmetic Exception in case of integer overflow
   */
  static int secureMultiply(int a, int b) {

    // upcast to long
    long product = ((long)a) * ((long)b);
    if((product < Integer.MIN_VALUE) || (product > Integer.MAX_VALUE)) {
      throw new ArithmeticException();
    }
    // Safely downcast back to int
    return (int)product;
  }


  /*
   * @Description - Controller function, invokes primitive int array function
   * if overflow occurs promotes to BigInteger function to achieve correct
   * result for large inputs
   */
  static void calProductOfArrays(int[] testcase, int len) {
    
    try {
      int[] result = calProductInt(testcase, len);
      displayInt(testcase, result, len);
    }
    catch(ArithmeticException ae) {
      // Overlfow occured, promoting to BigInteger
      BigInteger[] result = calProductBig(testcase, len);
      displayBig(testcase, result, len);
    }
  }

  // Print integer array to console
  static void displayInt(int[] old, int[] result, int len) {

    for(int i = 0; i < len; i++) {
      System.out.println(String.format("%-11s : %2s", old[i], result[i]));
    }
  }

  // Print BigInteger array to console
  static void displayBig(int[] old, BigInteger[] result, int len) {

    for(int i = 0; i < len; i++) {
      System.out.println(String.format("%-11s : %2s", old[i], result[i]));
    }
  }

  static void usage() {
    System.out.println("Usage: java ProductOfArrays [OPTION]");
    System.out.println("  OPTION");
    System.out.println("    1  Execute default test case");
    System.out.println("    2  MIN_VAUE<int> MAX_VALUE<int>, Execute testcase including numbers from MIN to MAX, +ve ints only");
    System.out.println("  Examples");
    System.out.println("    java ProductOfArrays 1          :  Executes default test case");
    System.out.println("    java ProductOfArrays 2 100 200  :  Executes custom test case, using numbers from 100 to 200");

  }

  static void setHeader() {

    System.out.println(String.format("%-11s : %2s", "Old Val", "New Val"));
    System.out.println("-----------------------");
  }

  static void defaultTestCase() {

    setHeader();
    int len1 = 4;
    int[] testcase1 = {4, 3, 2, 8};
    int[] testcase2 = {-4, -3, -2, -8};
    int[] testcase3 = {4, 0, 2, 8};
    int[] testcase4 = {4, 0, 0, 8};
    int[] testcase5 = {-4, 3, 2, -8};

    int len2 = 20;

    int[] testcase6 = new int[len2];
    for(int i = 0; i < len2; i++) {
      testcase6[i] = i+1;
    }

    System.out.println("TestCase1"); calProductOfArrays(testcase1, len1);
    System.out.println("TestCase2"); calProductOfArrays(testcase2, len1);
    System.out.println("TestCase3"); calProductOfArrays(testcase3, len1);
    System.out.println("TestCase4"); calProductOfArrays(testcase4, len1);
    System.out.println("TestCase5"); calProductOfArrays(testcase5, len1);
    System.out.println("TestCase6"); calProductOfArrays(testcase6, len2);
  }

  static void customTestCase(int MIN_VAL, int MAX_VAL) {
    setHeader();
    int len = MAX_VAL - MIN_VAL + 1;
    int[] testcase = new int[len];
    for(int i = 0; i < len; i++) {
      testcase[i] = MIN_VAL + i;
    }
    calProductOfArrays(testcase, len);
  }

  public static void main(String[] args) {

    try {
      int arguments = args.length;

      if(arguments == 0) {
        usage();
        return;
      }

      int param = Integer.parseInt(args[0]);

      switch(param) {
        case 1:
          defaultTestCase();
          break;
        case 2:
          int min = Integer.parseInt(args[1]);
          int max = Integer.parseInt(args[2]);
          if(min < 0 || max < 0)
            throw new NumberFormatException();
          customTestCase(min, max);
          break;
        default: usage(); break;
      }
    }
    catch(NumberFormatException nfe) {
      System.out.println("Parameters seem to be incorrect, check usage example\n");
      usage();
    }
    catch(Exception e) {
      usage();
    }
  }
}
