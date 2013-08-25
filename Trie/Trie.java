public class Trie {
  public static int ALPH = 26;
  Trie[] child;
  boolean isWord;
  
  public Trie() {
    child = new Trie[ALPH];
    isWord = false;
  }

  public void insert(String s) {
    Trie trie = this;
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';
      if (trie.child[index] == null)
        trie.child[index] = new Trie();
      trie = trie.child[index];
    }
    trie.isWord = true;
  }

  public boolean search(String s) {
    Trie trie = this;
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';
      if (trie.child[index] == null)
        return false;
      trie = trie.child[index];
    }
    return trie.isWord;
  }

  public static void main(String[] args) {
    Trie t = new Trie();
    String s = "hello";
    String w = "hel";
    String q = "waste";
    System.out.println("Insert");
    t.insert(s);
    System.out.println("Searching ..." + t.search(s));
    System.out.println("Searching ..." + t.search(w));
    System.out.println("Searching ..." + t.search(q));
  }
}
