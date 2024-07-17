import java.util.ArrayList;
class AdjacencyMatrix{
  private ArrayList<String> names = new ArrayList<String>();
  private ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
  public AdjacencyMatrix(){
    
  }
  public void addNode(String name){
    names.add(name);
    for(int i = 0; i < paths.size(); i++){
      paths.get(i).add(-1);
    }
    paths.add(new ArrayList<Integer>());
    for(int i = 0; i < names.size(); i++){
      paths.get(paths.size()-1).add(-1);
    }
  }
  public void addLink(String name, String othername, int weight){
    int a = names.indexOf(name);
    int b = names.indexOf(othername);
    if(a != b && a != -1 && b != -1){
      paths.get(a).set(b,weight);
      paths.get(b).set(a,weight);
    }
  }
  public String toString(){
    String s = "  ";
    for(int i = 0; i < names.size(); i++){
      s+=names.get(i)+" ";
    }
    s+="\n";
    for(int i = 0; i < paths.size(); i++){
      s+=names.get(i)+" ";
      for(int j = 0; j < paths.get(i).size(); j++){
        if(i==j){
          s+="S ";
        }
        else if(paths.get(i).get(j)==-1){
          s+="\\ ";
        }
        else{
          s+=paths.get(i).get(j)+" ";
        }
      }
      s+="\n";
    }
    return s;
  }
  public void removeNode(String name){
    int a = names.indexOf(name);
    names.remove(a);
    for(int i = 0; i < paths.size(); i++){
      paths.get(i).remove(a);
    }
    paths.remove(a);
  }
  public void removeLink(String a, String b){
    addLink(a, b, -1);
  }
  public boolean isConnected(String a, String b){
    int ai = names.indexOf(a); 
    int bi = names.indexOf(b);
    return paths.get(ai).get(bi)!=-1;
  }
  public int getCost(String a, String b){
    int ai = names.indexOf(a); 
    int bi = names.indexOf(b);
    return paths.get(ai).get(bi);
  }
  public ArrayList<String> getNeighbors(String s){
    int aaaa = names.indexOf(s);
    ArrayList<String> als = new ArrayList<String>();
    for(int i = 0; i < names.size(); i++){
      if(paths.get(aaaa).get(i)!=-1){
        als.add(names.get(i));
      }
    }
    return als;
  }
  public ArrayList<Integer> dijkstra(String s){
    ArrayList<Integer> queue = new ArrayList<Integer>();
    int h = names.indexOf(s);
    queue.add(h);
    ArrayList<Integer> stuff = new ArrayList<Integer>();
    for(int i = 0; i < names.size(); i++){
      stuff.add(Integer.MAX_VALUE);
    }
    int index = 0;
    while(index!=queue.size()){
      if(queue.get(index)==h){
        stuff.set(queue.get(index),0);
        ArrayList<String> pp = getNeighbors(names.get(queue.get(index)));
        for(int i = 0; i < pp.size(); i++){
          int y = names.indexOf(pp.get(i));
          stuff.set(y,paths.get(h).get(y));
          queue.add(y);
        }
      }
      else{
        ArrayList<String> pp = getNeighbors(names.get(queue.get(index)));
        for(int i = 0; i < pp.size(); i++){
          int y = names.indexOf(pp.get(i));
          if(stuff.get(y)==Integer.MAX_VALUE){
            queue.add(y);
          }
          else{
            if(stuff.get(y)+paths.get(queue.get(index)).get(y)<stuff.get(queue.get(index))){
              stuff.set(queue.get(index),stuff.get(y)+paths.get(queue.get(index)).get(y));
            }
          }
        }
      }
      index++;
    }
    return stuff;
  }
}