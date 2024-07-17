import java.util.ArrayList;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] cards = new String[13];
    for(int i = 2; i < 11; i++){
      cards[i-2]=Integer.toString(i);
    }
    cards[9]="Jack";
    cards[10]="Queen";
    cards[11]="King";
    cards[12]="Ace";
    ArrayList<String> deck = new ArrayList<String>();
    for(String a: cards){
      for(String b: suits){
        deck.add(a+" of "+b);
      }
    }
    ArrayList<String> tempdeck = new ArrayList<String>();
    tempdeck.addAll(deck);
    System.out.println("*throws cards on floor* Pick 'em up!\nThis is case sensitive, name cards like \"2 of Clubs\" or \"King of Spades\"\ntype \"rem\" to view all remaining cards");
    Scanner scan = new Scanner(System.in);
    while(tempdeck.size()>0){
      String n = scan.nextLine();
      if(n.equals("rem")){
        for(int i = 0; i < tempdeck.size(); i++){
          System.out.println(tempdeck.get(i));
        }
      }
      else if(tempdeck.contains(n)){
        tempdeck.remove(n);
        System.out.println(n+" picked up.");
      }
      else{
        if(deck.contains(n)){
          System.out.println("This card was already picked up!");
        }
        else{
          System.out.println("That's not a card!");
        }
      }
    }
    System.out.println("You have picked them up. Get out.");
  }
}