import java.math.BigInteger;

public class robot
{
    static BigInteger countPath(int x, int y, int xhigh, int yhigh, BigInteger[][] a)
        {
              if (x == xhigh && y == yhigh)
                      return new BigInteger("1");

                  if (x > xhigh || y > yhigh)
                          return new BigInteger("0");

                      if (a[x+1][y].intValue() == -1)
                          a[x+1][y] = countPath(x+1, y, xhigh, yhigh, a);
                      if (a[x][y+1].intValue() == -1)
                          a[x][y+1] = countPath(x, y+1, xhigh, yhigh, a);

                              return a[x+1][y].add(a[x][y+1]);
                                }

      static BigInteger makeMatrix(int x, int y)
          {
                BigInteger[][] a = new BigInteger[x+2][y+2];
                    for (int i = 0 ; i < x+2 ; i++)
                            for (int j = 0 ; j < y+2 ; j++)
                                      a[i][j] = new BigInteger("-1");

                        return countPath(0, 0, x, y, a);
                          }

        public static void main(String[] args)
            {
                  BigInteger count = makeMatrix(50, 62);

                      System.out.println("Total no. of path : "+ count);
                        }
}
