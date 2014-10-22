public class Partition {
  
  private int max(int a, int b) {
    return (a > b)? a : b;
  }

  private int min(int a, int b) {
    return (a < b)? a : b;
  }

  public int findPivot(int[] numbers) {
    int n = numbers.length;
    int[] max_array = new int[n];
    int[] min_array = new int[n];

    // Initialize first and last element in respective arrays
    max_array[0] = numbers[0];
    min_array[n - 1] = numbers[n - 1];

    for (int i = 1; i < n; i++) {
      max_array[i] = max(max_array[i - 1], numbers[i]);
      min_array[n - 1 - i] = min(min_array[n - 1 - i + 1], numbers[n - 1 - i]);
    }

    for (int i = 1; i < n - 1; i++) {
      if (numbers[i] >= max_array[i - 1] && numbers[i] <= min_array[i + 1]) {
        return numbers[i];
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Partition p = new Partition();
    int[] num1 = new int[] {5, 4, 6, 9, 8};
    int[] num2 = new int[] {5, 4, 6, 2, 9, 8};
    System.out.println("Pivot: "+ p.findPivot(num1));
    System.out.println("Pivot: "+ p.findPivot(num2));
  }
}
