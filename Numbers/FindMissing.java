public class FindMissing {

  public static int findMissing(int[] a) {
    int x = a[0];
    for (int i = 1; i < a.length; i++) {
      x = x ^ a[i]; 
    }
    for (int i = 1; i <= a.length + 1 ; i++) {
      x = x ^ i; 
    }
    return x;
  }
   public static void main(String[] args) {
    int[] a = new int[] {4, 1, 2, 5};
    System.out.println(findMissing(a));
   }
}
