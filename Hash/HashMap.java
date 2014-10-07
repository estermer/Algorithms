public class HashMap {

  private static final int tablesize = 128;

  HashEntry[] hashtable;

  HashMap() {
    hashtable = new HashEntry[tablesize];
    for(int i = 0; i < tablesize; i++) {
      hashtable[i] = null;
    }
  }

  public int get(int key) {
    // find slot within hash table
    int hash = (key % tablesize);
    int count = 0;
    // check if the slot is empty
    while(hashtable[hash] != null && hashtable[hash].getKey() != key) {
      // keep incrementing till we find an empty slot
      hash = (hash + 1) % tablesize;
      count++;
      if(count > 128) {
        break;
      }
    }
    // return -1 if the value is null
    if(hashtable[hash] == null) {
      return -1;
    }
    return hashtable[hash].getValue();
  }

  public boolean put(int key, int value) {
    int hash = (key % tablesize);
    int count = 0;
    while(hashtable[hash] != null && hashtable[hash].getKey() != key) {
      hash = (hash + 1) % tablesize;
      count++;
      if(count > 128) {
        return false;
      }
    }
    hashtable[hash] = new HashEntry(key, value);
    return true;
  }

  public static void main(String[] args) {
    HashMap h = new HashMap();
    System.out.println(h.get(10));
    System.out.println(h.get(138));
    System.out.println(h.put(10, 100));
    System.out.println(h.put(138, 13800));
    System.out.println(h.get(10));
    System.out.println(h.get(138));
  }
}
