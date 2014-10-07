public class StringToInt {

  public static int stringToInt(String s) {
    // s = "-123"
    boolean isNeg = false;
    int strLen = s.length();
    int num = 0;
    int start = 0;

    if(s.charAt(0) == '-') {
      isNeg = true;
      // if negative then start from next index
      start = 1;
    }

    for(int i = start; i < strLen; i++) {
      num = num * 10 + (s.charAt(i) - '0');
    }
    
    if(isNeg)
      num = -num;
    return num;
  }

  public static String intToString(int num) {
    boolean isNeg = false;
    if(num < 0) {
      isNeg = true;
      num = -num;
    }

    StringBuilder sb = new StringBuilder();
    int rem = 0;
    int val = 0;
    while(num != 0) {
      rem = num % 10;
      // convert int to char, so mention char in the start
      sb.insert(0, rem);
      num = num / 10;
    }
    
    if(isNeg)
      sb.insert(0, '-');

    return sb.toString();
  }

  public static void main(String[] args) {
    String s1 = "123";
    String s2 = "-123";

    System.out.println(stringToInt(s1));
    System.out.println(stringToInt(s2));

    System.out.println(intToString(123));
    System.out.println(intToString(-123));
  }
}
