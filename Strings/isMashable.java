public class isMashable
{

  static void initiate(String s)
  {
    mash("", s);
  }

  static void mash(String prefix, String s)
  {
    int N = s.length();
    String subs = "";

    if (!((s.trim()).equals("")))
      System.out.println(s);

    for (int i = 0 ; i < N ; i++)
    {
      subs = s.substring(0, i) + s.substring(i+1, N);
      //if (subs.equals("pet")||subs.equals("bc")||subs.equals("c")||subs.equals("a"))
        mash("" + s.charAt(i), subs);
    }
  }

  public static void main(String[] args)
  {
    String s = "planet";
    initiate(s);
  }
}
