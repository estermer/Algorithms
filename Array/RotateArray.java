public class RotateArray {

  public static void rotateArray(int[] a, int count) {
    if (a == null || count < 0) {
      throw new IllegalArgumentException("Illegal argument");
    }

    int order = count % a.length;

    // split array
    int half = a.length - order;

    reverse(a, 0, half - 1);
    reverse(a, half, a.length - 1 );
    reverse(a, 0, a.length - 1);
  }

  private static void reverse(int[] a, int left, int right) {
    if (a == null || a.length == 1) {
      return;
    }

    while (left < right) {
      int temp = a[left];
      a[left] = a[right];
      a[right] = temp;
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    int[] t1 = {1, 2, 3, 4, 5, 6, 7};
    rotateArray(t1, 3);

    for (int i = 0; i < t1.length; i++) {
      System.out.print(t1[i] + " ");
    }
  }
}
