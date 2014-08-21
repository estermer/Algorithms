public class SingleSellProfit
{
  public static int calculateSingleSellProfit(int[] stockPrice)
  {
    int len = stockPrice.length;

    if (len < 0)
      return 0;

    if (len == 1)
      return 0;

    int cheapest = stockPrice[0];
    int profit = 0;

    for (int i = 1 ; i < len ; i++)
    {
      cheapest = Math.min(cheapest, stockPrice[i]);
      profit = Math.max(profit, stockPrice[i] - cheapest);
    }

    return profit;
  }
  
  public static void main(String[] args)
  {
    int[] stock = {2, 7, 1, 8, 2, 8, 4, 5, 9, 0, 4, 5};

    System.out.println(calculateSingleSellProfit(stock));
  }
}
