public class FlightGraph {
  public static void main(String[] args) {
    Graph<String> routeMap = new Graph<String>();
    buildFlightRoute(routeMap);

    System.out.println(routeMap.getDFSPath("BOS", "LAX"));
    System.out.println(routeMap.getDFSPath("BOS", "LAX"));
  
  }

  public static void buildFlightRoute(Graph<String> g) {
    g.addVertex("BOS");
    g.addVertex("LAX");
    g.addVertex("JFK");
    g.addVertex("ORD");
    g.addVertex("MIA");
    g.addVertex("DFW");
    g.addVertex("SFO");
    
    g.addEdge("MIA", "LAX", 1);
    g.addEdge("MIA", "DFW", 1);
    g.addEdge("JFK", "MIA", 1);
    g.addEdge("JFK", "SFO", 1);
    g.addEdge("JFK", "BOS", 1);
    g.addEdge("ORD", "DFW", 1);
    g.addEdge("DFW", "ORD", 1);
    g.addEdge("DFW", "SFO", 1);
    g.addEdge("DFW", "LAX", 1);
    g.addEdge("DFW", "JFK", 1);
    g.addEdge("LAX", "ORD", 1);
    g.addEdge("BOS", "MIA", 1);
    g.addEdge("BOS", "JFK", 1);  
  }
}
