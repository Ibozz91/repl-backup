public class Player{
  private int score;
  private String username;
  public Player(String us){
    score=0;
    username=us;
  }
  public int readscore(){
    return score;
  }
  public void addscore(){
    score++;
  }
  public String rusername(){
    return username;
  }
}