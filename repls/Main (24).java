import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner Scammer = new Scanner(System.in);
    String[][] board = {{"X","X","X","-","-","-","-","-","X","X"},{"X","-","-","-","-","-","-","-","-","X"},{"X","-","-","-","-","-","-","-","-","X"},{"X","X","-","-","-","-","-","X","X","X"}};
    Round[] RPieces = {new Round(-1,-1,true), new Round(-1,-1,true), new Round(-1,-1,false), new Round(-1,-1,false)};
    Square[] SPieces = {new Square(-1,-1,true), new Square(-1,-1,true), new Square(-1,-1,true), new Square(-1,-1,false), new Square(-1,-1,false), new Square(-1,-1,false)};
    System.out.println("PUSH FIGHT\nPlayer 1, What is your name?");
    String name1 = Scammer.nextLine();
    System.out.println("Player 2, what is your name?");
    String Name2 = Scammer.nextLine();
    System.out.println("Time for white to place pieces");
    for(int i=1; i<=3; i++){
      for(String[] SSS: board){
        for(String S: SSS){
          System.out.print(S+" ");
        }
        System.out.println();
      }  
      System.out.println("Which row do you want to put this square piece?");
      
    }
  }
}