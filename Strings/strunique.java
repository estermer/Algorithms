public class strunique{

public static boolean isUnique(String str)
{
  boolean[] char_set = new boolean[256];
  int val = 0;

  for(int i = 0 ; i < str.length() ; i++)
  {
    val = str.charAt(i);
    
    if(char_set[val])
      return false;
    char_set[val] = true;
  }
  return true;
}
  
public static void main(String[] args)
{
  if(isUnique(args[0]))
    System.out.println("true");
  else
    System.out.println("false");
}
}
