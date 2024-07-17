import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    int row = -1;
    int col = -1;
    Scanner scan = new Scanner(System.in);
    String[][] board = {{"p", "p", "p"},
                        {"_", "_", "_"},
                        {"P", "P", "P"}};
    boolean gamecontinue = true;
    String turn = "P";
    while(gamecontinue){
      System.out.println("It is "+(turn.equals("P")?"White":"Black")+"'s turn!");
      for(String[] f: board){
        for(String s: f){
          System.out.print(s+" ");
        }
        System.out.println();
      }
      boolean x = true;
      while(x){
        System.out.println("Select a row");
        row = scan.nextInt()-1;
        System.out.println("Select a column");
        col = scan.nextInt()-1;
        if(row < 0 || col < 0 || row > 2 || col > 2){
          System.out.println("Please select an inbounds area");
        }
        else if(board[row][col].equals(turn)){
          x = false;
        }
        else{
          System.out.println("Please select a space with "+(board[row][col].equals("_")?"a":"YOUR")+" piece on it");
        }
      }
      int i = 0;
      while(!x){
        if(i==3){
          System.out.println("You get nothing! You lose! Good day sir!");
          System.exit(0);
        }
        System.out.println("You have "+(3-i)+" chances left.\nSelect a row to move to");
        int mrow = scan.nextInt()-1;
        System.out.println("Select a column to move to");
        int mcol = scan.nextInt()-1;
        if(mrow < 1 || mcol < 1 || mrow > 3 || mcol > 3){
          System.out.println("Please select an inbounds area");
        }
        else if(Math.abs(mrow-row)!=1 || Math.abs(mcol-col)==2){
          System.out.println("Please select a valid move");
        }
        else{
            if((mrow-row)!=(turn.equals("P")?-1:1)){
              System.out.println("Wrong direction");
            }
            else{
              if(board[mrow][mcol].equals("_")){
                if(mcol==col){
                  board[row][col]="_";
                  board[mrow][mcol]=turn;
                  x = true;
                }
                else{
                  System.out.println("Cannot move normally diagonally");
                }
              }
              else if(board[mrow][mcol].equals(oppoturn(turn))){
                if(mcol!=col){
                  board[row][col]="_";
                  board[mrow][mcol]=turn;
                  x = true;
                }
                else{
                  System.out.println("Cannot capture orthogonally");
                }
              }
              else{
                System.out.println("No friendly fire");
              }
            }
        }
        i++;
      }
      boolean win = false;
      for(String s: board[turn.equals("P")?0:2]){
        if(s.equals(turn)){
          win = true;
        }
      }
      if(win){
        System.out.println((turn.equals("P")?"White":"Black")+" won!");
        gamecontinue = false;
      }
      turn=oppoturn(turn);
    }
  }
  public static String oppoturn(String turn){
    if(turn.equals("P")){
      return "p";
    }
    else{
      return "P";
    }
  }
}