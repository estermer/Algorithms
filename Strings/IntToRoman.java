public class IntToRoman {

  enum Roman {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
    int weight;

    Roman(int weight) {
     this.weight = weight;
    }
  };

  public static String intToRoman(long n) {
    if(n <= 0)
      throw new IllegalArgumentException("Invalid value of n");

    StringBuilder sb = new StringBuilder();

    Roman[] roman = Roman.values();
    for(int i = roman.length - 1; i >= 0; i--) {
      while(n >= roman[i].weight) {
        sb.append(roman[i]);
        n = n - roman[i].weight;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(intToRoman(1999));
    System.out.println(intToRoman(25));
    System.out.println(intToRoman(944));
    System.out.println(intToRoman(0));
  }
}
