import java.util.ArrayList;
class Queue{
  private ArrayList<Integer> q = new ArrayList<Integer>();
  public Queue(int firstelement){
    q.add(firstelement);
  }
  public Queue(){
  }
  public void add(int element){
    q.add(element);
  }
  public int next(){
    if(q.size()>0){
      int thej = q.get(0);
      q.remove(0);
      return thej;
    }
    else{
      return -1;
    }
  }
  public void remove(int value){
    if(q.indexOf(value)!=-1){
      q.remove(q.indexOf(value));
    }
  }
  public String toString(){
    String s = "";
    for(int i = 0; i < q.size(); i++){
      s+=q.get(i);
      s+="\n";
    }
    return s;
  }
  public String q(){
    return "q";
  }
}