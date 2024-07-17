import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    AdjacencyMatrix am = new AdjacencyMatrix();
    am.addNode("a");
    am.addNode("b");
    am.addNode("c");
    am.addNode("d");
    am.addNode("e");
    am.addNode("f");
    am.addLink("a", "b", 2);
    am.addLink("a", "f", 6);
    am.addLink("b", "c", 3);
    am.addLink("b", "d", 5);
    am.addLink("c", "f", 3);
    am.addLink("c", "d", 1);
    am.addLink("c", "e", 4);
    am.addLink("d", "e", 4);
    ArrayList<Integer> h = am.dijkstra("a");
    for(int i = 0; i < h.size(); i++){
      System.out.println(h.get(i));
    }
  }
}