import java.util.ArrayList;

public class Permutations {

  public static ArrayList<String> permute(String s) {
    if(s == null) 
      return null;

    ArrayList<String> permutations = new ArrayList<String>();
    if(s.length() == 0) {
      permutations.add("");
      return permutations;
    }

    char first = s.charAt(0);
    String remainder = s.substring(1);
    ArrayList<String> words = permute(remainder);
    for(String word : words) {
      for(int i = 0; i <= word.length(); i++) {
        String str = insertCharAt(word, first, i);
        permutations.add(str);
      }
    }
    return permutations;
  }

  private static String insertCharAt(String word, char c, int pos) {
    String front = word.substring(0, pos);
    String end = word.substring(pos);
    return front + c + end;
  }

  public static void main(String[] args) {
    ArrayList<String> permutations = permute("hel");   
    for(String s : permutations) {
      System.out.println(s);
    }
  }
}
