public class LCS2 {
  
  int lcs(String s1, String s2) {
    int s1Len = s1.length();
    int s2Len = s2.length();
    int[][] result = new int[s1Len + 1][s2Len + 1];

    for(int i = 1; i <= s1Len; i++) {
      for(int j = 1; j <= s2Len; j++) {
        result[i][j] = result[i - 1][j - 1];

        if(s1.charAt(i - 1) == s2.charAt(j - 1))
          result[i][j] += 1;
        else
          result[i][j] = Math.max(result[i - 1][j - 1], Math.max(result[i][j - 1], result[i - 1][j]));
      }
    }
    return result[s1Len][s2Len];
  }

  public static void main(String[] args) {
    String s1 = "ABCBDAB";
    String s2 = "BDCABA";

    LCS2 l = new LCS2();
    System.out.println(l.lcs(s1, s2));
  }
}
