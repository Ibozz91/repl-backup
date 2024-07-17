import java.util.ArrayList;
class HashMap{
  private ArrayList<Integer> keys = new ArrayList<Integer>();
  private ArrayList<Integer> vals = new ArrayList<Integer>();
  public HashMap(){
    
  }
  public void add(int key, int value){
    keys.add(key);
    vals.add(value);
  }
  public int get(int key){
    if(keys.indexOf(key)==-1){
      return -1;
    }
    return vals.get(keys.indexOf(key));
  }
  public boolean contains(int key){
    return keys.contains(key);
  }
  public int length(){
    return keys.size();
  }
  public String emoji(){
    return "#️⃣🗺️";
  }
}