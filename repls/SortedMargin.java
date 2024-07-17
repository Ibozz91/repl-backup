public class SortedMargin{
  private int cand1;
  private int cand2;
  private int outcome;
  public void SortedMargin(int c1, int c2, int o){
    cand1=c1; cand2=c2; outcome=o;
  }
  public int outco(){
    return outcome;
  }
  public int[] cands(){
    int[] cndts = {cand1,cand2};
    return cndts;
  }
}