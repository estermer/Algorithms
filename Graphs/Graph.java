import java.util.*;

public class Graph<V> implements IGraph<V> {

  private Map<V, List<Edge<V>>> adjacencyList;
  private Map<V, VertexInfo<V>> vertexInfo;

  public Graph() {
    adjacencyList = new HashMap<V, List<Edge<V>>>();
    vertexInfo = new HashMap<V, VertexInfo<V>>();
  }

  private void checkIfNull(Object o) {
    if(o == null)
      throw new NullPointerException("Argument must not be null");
  }

  private void checkEdgeVertices(V from, V to) {
    // check if the nodes are null
    checkIfNull(from);
    checkIfNull(to);

    // check if the nodes are present in adjacencyList
    if(!adjacencyList.containsKey(from))
      throw new IllegalArgumentException("Vertex " + from + "not found in graph");
    if(!adjacencyList.containsKey(to))
      throw new IllegalArgumentException("Vertex " + to + "not found in graph");
  }

  public void addVertex(V v) {
    checkIfNull(v);
    adjacencyList.put(v, new ArrayList<Edge<V>>());
    vertexInfo.put(v, new VertexInfo<V>(v));
  }

  public void addEdge(V from, V to, int weight) {
    checkEdgeVertices(from, to);  
    Edge<V> edge = new Edge<V>(from, to, weight);
    adjacencyList.get(from).add(edge);
  }

  public Edge<V> getEdge(V from, V to) {
    checkEdgeVertices(from, to);  

    List<Edge<V>> edges = adjacencyList.get(from);
    for(Edge<V> edge : edges) {
      if(edge.to.equals(to))  
        return edge;
    }
    return null;
  }

  public boolean hasEdge(V from, V to) {
    return getEdge(from, to) != null;
  }

  public boolean hasPath(V from, V to) {
    return getDFSPath(from, to).isEmpty(); 
  }

  public List<V> getDFSPath(V from, V to) {
    checkEdgeVertices(from, to);
    clearVisited();
    
    List<V> path = new ArrayList<V>();
    return getDFSPath(from, to, path);
  }

  private void clearVisited() {
    for(VertexInfo v : vertexInfo.values()) {
      // clear visited flag
      v.clear();
    }
  }

  private List<V> getDFSPath(V v1, V v2, List<V> path) {
    path.add(v1);
    vertexInfo.get(v1).visited = true;

    if(v1.equals(v2)) {
      return path;
    }

    List<Edge<V>> edges = adjacencyList.get(v1);
    for(Edge<V> edge : edges) {
      if(vertexInfo.get(edge.to).visited) 
        continue;
      if(getDFSPath(edge.to, v2, path) != null)
        return path;
    }
    path.remove(path.size() - 1);
    return null;
  }

  public String toString() {
    Set<V> keys = adjacencyList.keySet();
    String str = "";

    for(V v : keys) {
      str += v + ": ";
      List<Edge<V>> edges = adjacencyList.get(v);
      for(Edge<V> edge : edges) {
        str += edge + " ";  
      }
      str += "\n";
    }
    return str;
  }
}
