import java.util.ArrayList;
class Player{
  private ArrayList<Card> Cards;
  private String name;
  public Player(String use){
    name=use;
    for(int i=0; i<7; i++){
      Cards.add(new Card());
    }
  }
  public ArrayList<Card> Hand(){
    return Cards;
  }
  public String getname(){
    return name;
  }
}