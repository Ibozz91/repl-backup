import java.util.Random;
class Card{
  private String color;
  private int number;
  private Random r = new Random();
  private String[] colors = {"Red", "Blue", "Yellow", "Green"};
  public Card(){
    number = r.nextInt(15);
    if(number==14){
      color = "Undecided";
    }
    else{
      color = colors[r.nextInt(4)];
    }
  }
  public String Cardname(){
    if(number==14){
      return color+" wild";
    }
    else if(number==13){
      return color+" +4";
    }
    else if(number==12){
      return color+" +2";
    }
    else if(number==11){
      return color+" reverse";
    }
    else if(number==10){
      return color+" skip";
    }
    else{
      return color+number;
    }
  }
  public boolean compatibilitytest(Card anothercard){
    if(number==anothercard.numb()){
      return true;
    }
    else if(color.equals(anothercard.colorr())){
      return true;
    }
    else if(color.equals("Undecided")){
      return true;
    }
    else if(anothercard.colorr().equals("Undecided")){
      return true;
    }
    return false;
  }
  public void changecolor(String col){
    color=col;
  }
  public int numb(){
    return number;
  }
  public String colorr(){
    return color;
  }
}