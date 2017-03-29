import java.util.Scanner;

class Horse {
 static int numberOfDirections = 8;
 static int numberOfDimensions = 2;
 static int totalRoutes = 0;

 static int[][] direction = {{-1,-1,-2,-2,2,2,1,1}, {-2,2,1,-1,1,-1,2,-2}};

 public static  boolean checkInBoard(int m, int n, int startm, int startn)
 {
  if (startm >= 0 && startm < m && startn >= 0 && startn < n)
  {
	  return true;
  }
  return false;
 }

 public static void traverseRoutes(int[][] chessboard, int m, int n, int startm, int startn, int currm, int currn)
 {
  int nextm, nextn;

  chessboard[currm][currn] = 1;

  for (int i = 0 ; i < numberOfDirections ; ++i)
  {
    nextm = currm + direction[0][i];
    nextn = currn + direction[1][i];

    if (checkInBoard(m, n, nextm, nextn) && chessboard[nextm][nextn] == 0)
    {
      traverseRoutes(chessboard, m, n, startm, startn, nextm, nextn);
    }
    else if (nextm == startm && nextn == startn)
    {
      ++totalRoutes;
    }
  }
  chessboard[currm][currn] = 0;
 }

 public static int horseRouteTraversal(int m, int n, int startm, int startn)
 {
  int[][] chessboard = new int[m][n];
  int noOfRoutes = 0;

  noOfRoutes = 0;

  traverseRoutes(chessboard, m, n, startm, startn, startm, startn);

  return noOfRoutes;
 }


 public static void main(String[] args)
 {
  int m, n, startm, startn;

  Scanner in = new Scanner(System.in);

  System.out.println("Enter chess board size m, n");
  do {
    m = in.nextInt();
    n = in.nextInt();
  } while(m < 0 && n < 0);

  System.out.println("Enter starting position startm, startn");
  do {
    startm = in.nextInt();
    startn = in.nextInt();
  } while(!checkInBoard(m, n, startm, startn));

  horseRouteTraversal(m, n, startm, startn);

  System.out.println("No of routes: "+totalRoutes);
 }
}
