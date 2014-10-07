public class VertexInfo<V> {

  public V v;
  public boolean visited;

  public VertexInfo(V v) {
    this.v = v;
    clear();
  }

  public void clear() {
    visited = false;
  }
}
