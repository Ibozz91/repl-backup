import java.util.ArrayList;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scam = new Scanner(System.in);
    ArrayList<String> Players = new ArrayList<String>();
    ArrayList<Integer> Rankings = new ArrayList<Integer>();
    Players.add("Carlsen");
    Players.add("Caruana");
    Players.add("Ding");
    Players.add("Nepomniachtchi");
    Players.add("Aronian");
    Players.add("Giri");
    Players.add("Grischuk");
    Players.add("Mamedyarov");
    Players.add("So");
    Players.add("Radjabov");
    Rankings.add(2847);
    Rankings.add(2820);
    Rankings.add(2799);
    Rankings.add(2792);
    Rankings.add(2781);
    Rankings.add(2780);
    Rankings.add(2776);
    Rankings.add(2770);
    Rankings.add(2770);
    Rankings.add(2765);
    while(true){
      System.out.println("Do you want to search a ranking or add a ranking?");
      String x = scam.nextLine();
      if(x.equalsIgnoreCase("search")){
        System.out.println("Of whom shall it be?!?!?!?!?!");
        String search = scam.nextLine();
        int y = Players.lastIndexOf(search);
        if(y==-1){
          System.out.println("Where is this person from? WONDERLAND? CUZ HE DOESN'T EXIST! Add him or DO A REAL PERSON!");
        }
        else{
          System.out.println(Rankings.get(y));
        }
      }
      else if(x.equalsIgnoreCase("add")){
        System.out.println("Who is it?");
        Players.add(scam.nextLine());
        System.out.println("What is his elo ranking?");
        Rankings.add(scam.nextInt());
        scam.nextLine();
      }
    }
  }
}