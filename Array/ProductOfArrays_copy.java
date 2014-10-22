import java.math.BigInteger;

//ERROR in with division function in case of zeroes

public class ProductOfArrays {

  static int[] calculateProductWithoutDivision(int[] orig, int len) {
    
    int i = 0;
    int j = len - 1;

    //int[] temp1 = new int[len];
    //int[] temp2 = new int[len];
    int temp1 = 1;
    int temp2 = 1;

    int[] result = new int[len];

    for(int k = 0; k < len; k++) {
      result[k] = 1;
    }

    //temp1[i++] = 1;
    //temp2[j--] = 1;

    while(i < len && j >= 0) {
      //temp1[i] = temp1[i-1] * orig[i-1];    
      //temp2[j] = temp2[j+1] * orig[j+1];
      //i++;
      //j--;
      result[i] = result[i] * temp1;
      result[j] = result[j] * temp2;

      temp1 = temp1 * orig[i++];
      temp2 = temp2 * orig[j--];
    }

    //for(int k = 0; k < len; k++) {
      //result[k] = temp1[k] * temp2[k]; 
    //}

    return result;
  }

  static BigInteger[] calculateProductWithoutDivisionBig(BigInteger[] orig, int len) {
    int i = 0;
    int j = len - 1;

    BigInteger[] temp1 = new BigInteger[len];
    BigInteger[] temp2 = new BigInteger[len];
    BigInteger[] result = new BigInteger[len];

    temp1[i++] = BigInteger.ONE;
    temp2[j--] = BigInteger.ONE;

    while(i < len && j >= 0) {
      temp1[i] = temp1[i-1].multiply(orig[i-1]);
      temp2[j] = temp2[j+1].multiply(orig[j+1]);
      i++;
      j--;
    }

    for(int k = 0; k < len; k++) {
      result[k] = temp1[k].multiply(temp2[k]);
    }
    
    return result;
  }

  static BigInteger[] calculateProductWithDivisionBig(BigInteger[] orig, int len) {
    
    BigInteger product = BigInteger.ONE;
    int zeroCount = 0;
    int zeroIndex = 0;
    BigInteger[] result = new BigInteger[len];

    for(int i = 0; i < len; i++) {
      if(orig[i].equals(BigInteger.ZERO)) {
        zeroCount++;
        zeroIndex = i;
        if(zeroCount == 1)
          continue;
        else if(zeroCount > 1)
          break;
      }
      product = product.multiply(orig[i]); 
    }

    switch(zeroCount) {
      case 1:
        for(int i = 0; i < len; i++) {
          if(i == zeroIndex)
            result[i] = product;
          result[i] = BigInteger.ZERO;
        }
        break;
      case 2:
        for(int i = 0; i < len; i++) {
          result[i] = BigInteger.ZERO;
        }
        break;
      default:
        for(int i = 0; i < len; i++) {
          result[i] = product.divide(orig[i]);
        }
        break;
    }
    return result;
  }

  static int[] calculateProductWithDivision(int[] orig, int len) {
    
    int product = 1;
    int zeroCount = 0;
    int zeroIndex = 0;
    int[] result = new int[len];

    for(int i = 0; i < len; i++) {
      if(orig[i] == 0) {
        zeroCount++;
        zeroIndex = i;
        if(zeroCount == 1)
          continue;
        else if(zeroCount > 1)
          break;
      }
      product = product * orig[i]; 
    }

    switch(zeroCount) {
      case 1:
        for(int i = 0; i < len; i++) {
          if(i == zeroIndex)
            result[i] = product;
          result[i] = 0;
        }
        break;
      case 2:
        for(int i = 0; i < len; i++) {
          result[i] = 0;
        }
        break;
      default:
        for(int i = 0; i < len; i++) {
          result[i] = product / orig[i];
        }
        break;
    }
    return result;
  }

  public static void main(String[] args) {

    int len = 50;
    int[] sample1 = new int[len];
    for (int i = 0; i < len; i++) {
      sample1[i] = i+1;
    }

    BigInteger[] sample2 = new BigInteger[len];
    for (int i = 0; i < len; i++) {
      sample2[i] = BigInteger.valueOf(i+1);
    }

    long start;
    long timeTaken;

    start = System.nanoTime();
    int[] result1 = calculateProductWithoutDivision(sample1, len);
    timeTaken = System.nanoTime() - start;

    System.out.println("TimeTakenWithoutDivisionPrimitive - " + timeTaken);

    start = System.nanoTime();
    BigInteger[] result2 = calculateProductWithoutDivisionBig(sample2, len);
    timeTaken = System.nanoTime() - start;

    System.out.println("TimeTakenWithoutDivision - " + timeTaken);

    start = System.nanoTime();
    BigInteger[] result3 = calculateProductWithDivisionBig(sample2, len);
    timeTaken = System.nanoTime() - start;

    System.out.println("TimeTakenWithDivisionBig - " + timeTaken);

    start = System.nanoTime();
    int[] result4 = calculateProductWithDivision(sample1, len);
    timeTaken = System.nanoTime() - start;

    System.out.println("TimeTakenWithDivision - " + timeTaken);

    for(int i = 0; i < len; i++) {
      System.out.println(result1[i] + ":" + result2[i] + ":" + result3[i] + ":" + result4[i]);
    }
  }
}
