public class Player{
  private int boardloc;
  private String username;
  public Player(String us){
    boardloc=0;
    username=us;
  }
  public int readboard(){
    return boardloc;
  }
  public void changeboard(int changeby){
    boardloc+=changeby;
  }
  public String rusername(){
    return username;
  }
}