public class LevensteinDistance {

  public static int levenstein(String str1, String str2) {
    int str1Len = str1.length();
    int str2Len = str2.length();

    int N = str1Len + 1;
    int M = str2Len + 1;

    int[][] distance = new int[N][M];

    for(int i = 0; i < N; i++) {
      distance[i][0] = i;
    }
    for(int j = 0; j < M; j++) {
      distance[0][j] = j;
    }

    for(int i = 1; i < N; i++) {
      for(int j = 1; j < M; j++) {
        distance[i][j] = minimum(
              distance[i - 1][j] + 1,
              distance[i][j - 1] + 1,
              distance[i - 1][j - 1] + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1)
            );
      }
    }
    return distance[N - 1][M - 1];
  }

  private static int minimum(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }

  public static void main(String[] args) {
    System.out.println("Levenstein Distance"); 
    System.out.println(levenstein("hello", "hello"));
    System.out.println(levenstein("hello", "jello"));
    System.out.println(levenstein("divergent", "insurgent"));
  }
}
