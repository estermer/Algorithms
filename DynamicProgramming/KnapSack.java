public class KnapSack {

  int knapSack(int[] weight, int[] value, int N, int C) {
    int[][] K = new int[N + 1][C + 1];
    
    for(int i = 0; i <= N; i++) {
      for(int w = 0; w <= C; w++) {
        if(i == 0 || w == 0)
          K[i][w] = 0;
        else if(weight[i - 1] <= w)
          K[i][w] = Math.max(K[i - 1][w], K[i - 1][w - weight[i - 1]] + value[i - 1]);
        else
          K[i][w] = K[i - 1][w];
      }
    }
    return K[N][C];
  }

  public static void main(String[] args) {
    KnapSack k = new KnapSack();
    int[] value = new int[] {60, 100, 120}; 
    int[] weight = new int[] {10, 20, 30};
    int C = 50;
    int N = value.length;
    System.out.println(k.knapSack(weight, value, N, C));
  }
}
