public class SumContiguousSubArray {
  
  // Does not work when all elements are negative
  // Can add another for loop to check if all elements are negative
  public static int contiguousSum(int[] arr) {
    int current_sum = 0;
    int final_sum = 0;

    for (int i = 0 ; i < arr.length ; i++) {
      current_sum = current_sum + arr[i];
      if (current_sum < 0) {
        current_sum = 0;
      }
      else if (current_sum > final_sum) {
        final_sum = current_sum;
      }
    }
    return final_sum;
  }

  public static int max(int a, int b) {
    return (a > b)? a : b;
  }

  public static int contiguousSum2(int[] arr) {
    int current_sum = arr[0];
    int final_sum = arr[0];

    for (int i = 1 ; i < arr.length; i++) {
      current_sum = max(arr[i], current_sum + arr[i]);
      final_sum = max(current_sum, final_sum);
    }
    return final_sum;
  }

  public static void main(String[] args) {
    //int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
    int[] arr = {-2, -3, -4, -1, -2, -1, -5, -3};

    System.out.println(contiguousSum(arr));
    System.out.println(contiguousSum2(arr));
  }
}
