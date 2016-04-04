public class MaxSubMatrix {

  public static int[][] maxSubMatrixFinder(int[][] in) {
    int rLength = in.length;
    int cLength = in[0].length;
    System.out.println("rowLen " + rLength + " colLen " + cLength);
    int[][] result = new int[rLength][cLength];
    /** Initialize row and column */
    for (int i = 0; i < rLength; i++) {
      result[i][0] = in[i][0];
    } 
    for (int j = 0; j < cLength; j++) {
      result[0][j] = in[0][j];
    } 

    /** 
     * Core function 
     * If the current value is 0 then dont care as the matrix is not complete.
     * If value is 1 then check if any of top diagonal left were 1 if yes then
     * increment the current by 1.
     * */
    for (int i = 1; i < rLength; i++) {
      for (int j = 1; j < cLength; j++) {
        if (in[i][j] == 1) {
          result[i][j] = Math.min(result[i][j - 1], 
              Math.min(result[i - 1][j], result[i - 1][j - 1])) + 1;
        } else {
          result[i][j] = 0;  
        }
      }
    }
    
    return result;
  }

  public static void printMaxSubMatrix(int[][] in, int[][] result) {
    int rLength = in.length;
    int cLength = in[0].length;

    int maxValue = result[0][0];
    int maxI = 0;
    int maxJ = 0;
    for (int i = 0; i < rLength; i++) {
      for (int j = 0; j < cLength; j++) {
        if (maxValue < result[i][j]) {
          maxValue = result[i][j];
          maxI = i;
          maxJ = j;
        }
      }
    }

    System.out.println("maxI : " + maxI);
    System.out.println("maxJ : " + maxJ);

    for (int i = maxI; i > maxI - maxValue; i--) {
      for (int j = maxJ; j > maxJ - maxValue; j--) {
        System.out.print(in[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] input = {{0, 1, 1, 0, 1}, 
                     {1, 1, 0, 1, 0}, 
                     {0, 1, 1, 1, 0},
                     {1, 1, 1, 1, 0},
                     {1, 1, 1, 1, 1},
                     {0, 0, 0, 0, 0}};

    printMaxSubMatrix(input, maxSubMatrixFinder(input));
  }
}
