import java.util.*;

public interface IGraph<V> {

  public void addVertex(V v);
  public void addEdge(V from, V to, int weight);
  public boolean hasEdge(V from, V to);
  public Edge<V> getEdge(V from, V to);
  public boolean hasPath(V from, V to);
  public List<V> getDFSPath(V from, V to);
  public String toString();
}
