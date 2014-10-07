public class Edge<V> {
  
  public V from;
  public V to;
  public int weight;

  public Edge(V from, V to) {
    this(from, to, 1);
  }

  public Edge(V from, V to, int weight) {
    if(from == null || to == null) {
      throw new IllegalArgumentException("null");
    }
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  public String toString() {
    return "( " + from + " -- " + weight + " --> " + to + " )";
  }
}
