public class Solution {
  
  public String isPalindrome(String s) {
    String[] str = s.split(" ");
    int strLen = str.length;

    int i = 0;
    int j = strLen - 1;

    while(i < j) {
      if(!compare(str[i], str[j]))
        return "FAILED";

      i++;
      j--;
    }
    return "PASSED";
  }

  public boolean compare(String s1, String s2) {
    s1 = s1.replaceAll("[^\\w]", "");
    s2 = s2.replaceAll("[^\\w]", "");

    if(s1.equalsIgnoreCase(s2))
      return true;
    return false;
  }

  public static void main(String[] args) {
    Solution p = new Solution();
    System.out.println(p.isPalindrome("one for all and all for one"));
    System.out.println(p.isPalindrome("one for all and all for one!"));
    System.out.println(p.isPalindrome("one all and all for one!"));
    System.out.println(p.isPalindrome("on1e for all and all for on1e!"));
    System.out.println(p.isPalindrome("1234 1234!"));
    System.out.println(p.isPalindrome("1234 1243!"));
    System.out.println(p.isPalindrome("ab_c ab_c!"));
  }
}
