public class PrintLexi {

  public void lexi(int num) {
    lexiPrint(num, 1); 
  }

  public void lexiPrint(int num, int k) {
    if(k > num)
      return;
    
    for(int i = 0; i < 10; i++) {
      if(k <= num) {
        System.out.println(k + " ");
        k = k * 10;
        lexiPrint(num, k);
        k = k / 10;
        k++;
        if(k % 10 == 0) return;
      }
    }
  }

  public static void main(String[] args) {
    PrintLexi pl = new PrintLexi();
    System.out.println("> 5");
    pl.lexi(5);
    System.out.println("--------");
    System.out.println("> 10");
    pl.lexi(10);
    System.out.println("--------");
    System.out.println("> 20");
    pl.lexi(20);
    System.out.println("--------");
    System.out.println("> 75");
    pl.lexi(75);
    System.out.println("--------");
    System.out.println("> 105");
    pl.lexi(105);
    System.out.println("--------");
  }
}
