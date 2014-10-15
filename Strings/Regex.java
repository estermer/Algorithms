public class Regex {
    public boolean isMatch(String s, String p) {
 
        if(p.length() == 0)
            return s.length() == 0;

        if(p.length() == 1 && p.charAt(0) == '*' && s.length() > 0)
          return true;
 
        //p's length 1 is special case    
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));    
 
        }else{
            int len = s.length();
 
            int i = -1; 
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        } 
    }

    public static void main(String[] args) {
      Regex x = new Regex();

      System.out.println(x.isMatch("abc", "a*"));
      System.out.println(x.isMatch("aaaa", "*"));
      System.out.println(x.isMatch("aaaaa", "a*"));
      System.out.println(x.isMatch("abc", "**a"));
      System.out.println(x.isMatch("abc", ".*a"));
      System.out.println(x.isMatch("abc", "..c"));
    }
}
