import java.util.HashMap;
public class Ballot{
  private HashMap<String, Integer> candranks;
  public Ballot(HashMap<String, Integer> CandRanks){
    candranks=CandRanks;
  }
  public int Pairwise(String c1, String c2){
    if(candranks.get(c1)==candranks.get(c2)){
      return 0;
    }
    else if (candranks.get(c1)<candranks.get(c2)){
      return 1;
    }
    else{
      return -1;
    }
  }
  public void Drop(String c){
    candranks.remove(c);
  }
}