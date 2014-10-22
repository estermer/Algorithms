import java.util.ArrayList;
import java.util.HashMap;

public class findSum
{
  static void checkSum(ArrayList arr, Integer sum)
  {
    HashMap<Integer, Integer> arrHash = new HashMap<Integer, Integer>();
    
    for (int i = 0 ; i < arr.size() ; i++)
    {
      Integer val = arrHash.get(sum - (Integer)arr.get(i));
      if (val == null)
      {
        arrHash.put(((Integer)arr.get(i)), new Integer(i));
      }
      else
      {
        System.out.println("Start :"+ i +"End :"+ val +"\n");
      }
    }
  }

  public static void main(String[] args)
  {
    ArrayList<Integer> a = new ArrayList<Integer>();
    a.add(new Integer(1));
    a.add(new Integer(6));
    a.add(new Integer(5));
    a.add(new Integer(10));
    checkSum(a, new Integer(11));
  }
}
