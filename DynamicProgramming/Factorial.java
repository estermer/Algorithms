public class Factorial {
  
  int[] fact;

  int factorial(int n) {
    if (n == 0 || n == 1)
      return 1;
    else if (fact[n] != 0)
      return fact[n];
    else
      return fact[n] = n * factorial(n-1);
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    Factorial obj = new Factorial();
    obj.fact = new int[n+1];
    System.out.println(obj.factorial(n));
  }
}
