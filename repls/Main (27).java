import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[][][][] board = new String[3][3][3][3];
    String[][] won = {
    {"_", "_", "_"},
    {"_", "_", "_"},
    {"_", "_", "_"}};
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        for(int k = 0; k < 3; k++){
          for(int l = 0; l < 3; l++){
            board[i][j][k][l]="_";
          }
        }
      }
    }
    int forcedrow = -1;
    int forcedcol = -1;
    int row = -1;
    int col = -1;
    boolean b = true;
    String turn = "X";
    boolean gamecontinue = true;
    while(gamecontinue){
      System.out.println("It is "+turn+"'s turn! "+(forcedrow==-1?"You may play anywhere you want.":("You are playing in row "+(forcedrow+1)+" column "+(forcedcol+1)+"."))+"\n");
      for(int i = 0; i < 3; i++){
        for(int k = 0; k < 3; k++){
          for(int j = 0; j < 3; j++){
            for(int l = 0; l < 3; l++){
              System.out.print(board[i][j][k][l]+" ");
            }
            System.out.print(" ");
          }
          System.out.println();
        }
        System.out.println();
      }
      System.out.println("Big boards won:\n");
      for(String[] t: won){
        for(String tt: t){
          System.out.print(tt+" ");
        }
        System.out.println();
      }
      System.out.println();
      b = true;
      if(forcedrow==-1){
        while(b){
          System.out.println("Select row on the big board");
          forcedrow=scan.nextInt()-1;
          scan.nextLine();
          System.out.println("Select column on the big board");
          forcedcol=scan.nextInt()-1;
          scan.nextLine();
          if(forcedrow<0 || forcedrow>2 || forcedcol<0 || forcedcol>2){
            System.out.println("Please select an inbounds area");
          }
          else if(!won[forcedrow][forcedcol].equals("_")){
            System.out.println("Please select an unfinished board");
          }
          else{
            b=false;
          }
        }
      }
      b = true;
      while(b){
        System.out.println("Select row on the small board");
        row=scan.nextInt()-1;
        scan.nextLine();
        System.out.println("Select column on the small board");
        col=scan.nextInt()-1;
        scan.nextLine();
        if(row<0 || row>2 || col<0 || col>2){
          System.out.println("Please select an inbounds area");
        }
        else if(!board[forcedrow][forcedcol][row][col].equals("_")){
          System.out.println("Please select a blank space");
        }
        else{
          b=false;
        }
      }
      board[forcedrow][forcedcol][row][col]=turn;
      won[forcedrow][forcedcol]=winner(board[forcedrow][forcedcol]);
      String gamestate = winner(won);
      if(gamestate.equals("#")){
        System.out.println("The game is a draw.");
        gamecontinue = false;
      }
      else if(gamestate.equals("X") || gamestate.equals("O")){
        System.out.println(gamestate+" won!");
        gamecontinue = false;
      }
      else{
        if(won[row][col].equals("_")){
          forcedrow = row;
          forcedcol = col;
        }
        else{
          forcedrow = -1;
          forcedcol = -1;
        }
      }
      if(turn.equals("X")){
        turn="O";
      }
      else{
        turn="X";
      }
    }
  }
  public static boolean isWinner(String tester, String[][]board){
    for(int i=0; i<3; i++){
      for(int n=0; n<3; n++){
        if((i==0 && n==0 && board[0][0]==tester && board[1][1]==tester && board[2][2]==tester) || (i==0 && board[i][n]==tester && board[i+1][n]==tester && board[i+2][n]==tester) || (n==0 && board[i][n]==tester && board[i][n+1]==tester && board[i][n+2]==tester) || (i==0 && n==2 && board[0][2]==tester && board[1][1]==tester && board[2][0]==tester)){
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
    if(isWinner("X", board)){
      return "X";
    }
    if(isWinner("O", board)){
      return "O";
    }
    if(full(board)){
      return "#";
    }
    return "_";
  }
}