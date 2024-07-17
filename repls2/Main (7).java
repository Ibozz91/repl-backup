import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    String[][] board = {
    {"_", "_", "_"},
    {"_", "_", "_"},
    {"_", "_", "_"}};
    //for(int i = 0; i < 3; i++){
      //for(int n = 0; n < 3; n++){
        //board[i][n]="_";
      //}
    //}
    String turn = "X";
    boolean run = true;
    int row=0;
    int column=0;
    Scanner scan = new Scanner(System.in);
    while(run){
      for(String[] i: board){
        for(String n: i){
          System.out.print(n+" ");
        }
        System.out.println("");
      }
      if(!(winner(board)=="-")){
        System.out.println(winner(board)+" wins!");
        run=false;
        continue;
      }
      System.out.println("It is "+turn+"'s turn");
      System.out.println("Enter said row");
      row=scan.nextInt()-1;
      System.out.println("Enter said column");
      column=scan.nextInt()-1;
      if(row<0 || row>2 || column<0 || column>2 || (!board[row][column].equals("_"))){
        System.out.println("Said move is invalid");
        continue;
      }
      board[row][column]=turn;
      if(turn=="X"){
        turn="O";
      }
      else{
        turn="X";
      }
    }
  }
  public static boolean swinner(String tester, String[][]board){
    for(int i=0; i<3; i++){
      for(int n=0; n<3; n++){
        if((i==0 && n==0 && board[i][n]==tester && board[i+1][n+1]==tester && board[i+2][n+2]==tester) || (i==0 && board[i][n]==tester && board[i+1][n]==tester && board[i+2][n]==tester) || (n==0 && board[i][n]==tester && board[i][n+1]==tester && board[i][n+2]==tester)){
          return true;
        }
      }
    }
    return false;
  }
  public static boolean full(String[][] board){
    for(String[] i: board){
      for(String n: i){
        if(n.equals("_")){
          return false;
        }
      }
    }
    return true;
  }
  public static String winner(String[][] board){
    if(swinner("X", board)){
      return "X";
    }
    if(swinner("O", board)){
      return "O";
    }
    if(full(board)){
      return "Nobody";
    }
    return "-";
  }
}