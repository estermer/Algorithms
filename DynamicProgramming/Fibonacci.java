public class Fibonacci {

  int[] fibo;

  int fibonacci(int n) {
    if(n == 0) return 0;
    if(n == 1) return 1;
    if(fibo[n] != 0) return fibo[n];
    fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    return fibo[n];
  }

  public static void main(String[] args) {
    Fibonacci f = new Fibonacci();
    int n = 6;
    f.fibo = new int[n + 1];
    System.out.println(f.fibonacci(n));
  }
}
