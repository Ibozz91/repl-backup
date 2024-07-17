import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    boolean pass = false;
    String turn = "b";
    Scanner scan = new Scanner(System.in);
    String[][] board = new String[8][8];
    for(int i = 0; i < 8; i++){
      for(int tni = 0; tni < 8; tni++){
        board[i][tni]="_";
      }
    }
    board[3][3]="b";
    board[4][4]="b";
    board[3][4]="w";
    board[4][3]="w";
    System.out.println("Welcome to Reversi!");
    while(true){
      printboard(board);
      System.out.println("It is "+turn+"'s turn!");
      int bcount=0;
      int wcount=0;
      boolean noblnkspacs=true;
      for(String[] i: board){
        for(String s: i){
          if(s=="_"){
            noblnkspacs=false;
          }
          else if(s=="b"){
            bcount++;
          }
          else{
            wcount++;
          }
        }
      }
      if(noblnkspacs){
        if(bcount>wcount){
          System.out.println("The winner is the b emoji");
        }
        else if(wcount>bcount){
          System.out.println("The winner is the letter w");
        }
        else{
          System.out.println("Noone won");
        }
      }
      System.exit(0);
    }
  }
  public static void printboard(String[][] board){
    for(String[] i: board){
      for(String s: i){
        System.out.print(s+" ");
      }
      System.out.println("");
    }
  }
}