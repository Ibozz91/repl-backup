import java.util.ArrayList;
class Stack{
  private ArrayList<Integer> s = new ArrayList<Integer>();
  public Stack(int f){
    s.add(f);
  }
  public Stack(){
    
  }
  public void add(int t){
    s.add(0, t);
  }
  public int next(){
    if(s.size()==0){
      return -1;
    }
    else{
      int g = s.get(0);
      s.remove(0);
      return g;
    }
  }
  public void remove(int val){
    s.remove(s.indexOf(val));
  }
  public String toString(){
    String st = "";
    for(int i = 0; i < s.size(); i++){
      st+=s.get(i);
      st+="\n";
    }
    return st;
  }
  public void overflow(){
    overflow();
  }
}