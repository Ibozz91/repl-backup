import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
class Main {
  public static void main(String[] args) {
    Card topcard = new Card();
    Scanner Scan = new Scanner(System.in);
    boolean clockwise = true;
    int turn = 0;
    System.out.println("Welcome to Jeden!");
    System.out.println("Select an amount of players");
    int pamount = Scan.nextInt();
    Scan.nextLine();
    Player[] Players = new Player[pamount];
    for(int i = 0; i < pamount; i++){
      System.out.println("What will be the name or username of player "+(i+1)+"?");
      Players[i] = (new Player(Scan.nextLine()));
    }
    while(true){
      System.out.println("It is "+Players[turn]+"'s turn!");
      if(topcard.Cardname().contains("+4")){
        for(int i = 0; i<4; i++){
          Players[turn].Hand().add(new Card());
        }
      }
      else if(topcard.Cardname().contains("+2")){
        for(int i = 0; i<2; i++){
          Players[turn].Hand().add(new Card());
        }
      }
      for(Player i: Players){
        System.out.println(i.getname()+": "+i.Hand().size());
      }
      System.out.println("The next player's turn is "+Players[nextturn(clockwise, turn, pamount)].getname());
      System.out.println("Your cards:");
      boolean b = true;
      for(int i = 0; i < Players[turn].Hand().size(); i++){
        System.out.println(i+": "+Players[turn].Hand().get(i).Cardname());
        if(Players[turn].Hand().get(i).compatibilitytest(topcard)){
          b = false;
        }
      }
      System.out.println("The top card is "+topcard.Cardname());
      if(Players[turn].Hand().size()==1){
        System.out.println("You have one card! Jeden!");
      }
      if(b){
        System.out.println("None of your cards can be played. Drawing a card...");
        Players[turn].Hand().add(new Card());
        System.out.println("You got a "+Players[turn].Hand().get(Players[turn].Hand().size()-1).Cardname());
        if(Players[turn].Hand().get(Players[turn].Hand().size()-1).compatibilitytest(topcard)){
          System.out.println("You can play this card!");
          playcard(Players[turn].Hand().get(Players[turn].Hand().size()-1), topcard, Scan);
          if(topcard.Cardname().contains("skip")){
            turn=nextturn(clockwise, turn, pamount);
          }
        }
      }

    }
  }
  public static int nextturn(boolean cw, int trn, int pl){
    if(cw){
      if(trn==pl-1){
        return 0;
      }
      else{
        return trn+1;
      }
    }
    else{
      if(trn==0){
        return pl-1;
      }
      else{
        return trn-1;
      }
    }
  }
  public static void playcard(Card cardtoplay, Card topcard, Scanner scan){
    if(cardtoplay.colorr()=="Undecided"){
      System.out.println("Which color would you like to make your wild card?\n1: Red\n2: Blue\n3: Yellow\n4: Green");
      int coloo = scan.nextInt();
      scan.nextLine();
      if(coloo==1){
        cardtoplay.changecolor("Red");
      }
      else if(coloo==2){
        cardtoplay.changecolor("Blue");
      }
      else if(coloo==3){
        cardtoplay.changecolor("Yellow");
      }
      else{
        cardtoplay.changecolor("Green");
      }
      topcard=cardtoplay;
      return;
    }
    else{
      topcard=cardtoplay;
      return;
    }
  }
}