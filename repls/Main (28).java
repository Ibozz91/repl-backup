import java.util.Scanner;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[][] board = {{"_", "_", "_", "_", "_", "_"},
                        {"_", "_", "_", "_", "_", "_"},
                        {"_", "_", "_", "_", "_", "_"},
                        {"_", "_", "_", "_", "_", "_"},
                        {"_", "_", "_", "_", "_", "_"},
                        {"_", "_", "_", "_", "_", "_"}};
    boolean turn = true;
    boolean gamecontinue = true;
    while(gamecontinue){
      System.out.print("  ");
      for(int i=0; i<6; i++){
        System.out.print(i+" ");
      }
      for(int i1=0; i1<6; i1++){
        if(i1==0){
          System.out.print("\n0 ");
        }
        else{
          System.out.print(i1+" ");
        }
        for(int i2=0; i2<6; i2++){
          System.out.print(board[i1][i2]+" ");
        }
        System.out.println();
      }
      System.out.println("It is "+(turn?"Order's":"ChA0s'")+" turn");
      String place = "";
      boolean x = true;
      System.out.println("Select which piece to place (X or O)");
      while(x){
        x=false;
        String piece = scan.nextLine();
        if(piece.equalsIgnoreCase("x")){
          place = "X";
        }
        else if(piece.equalsIgnoreCase("o")){
          place = "O";
        }
        else{
          System.out.println("Please select a valid piece");
          x=true;
        }
      }
      int row = -1;
      int column = -1;
      while(!x){
        System.out.println("Select the row");
        row = scan.nextInt();
        scan.nextLine();
        System.out.println("Select the column");
        column = scan.nextInt();
        scan.nextLine();
        if(row<0 || row>5 || column < 0 || column > 5){
          System.out.println("Please select an inbounds area");
        }
        else if(!board[row][column].equals("_")){
          System.out.println("There is already a piece in that space");
        }
        else{
          x=true;
        }
      }
      board[row][column] = place;
      boolean win = false;
      //Horizontal and vertical check
      for(int i = 0; i < 6; i++){
        for(int ii = 0; ii < 2; ii++){
          if(!board[i][ii].equals("_")){
            boolean hor = true;
            for(int iii = 1; iii < 5; iii++){
              if(!board[i][ii+iii].equals(board[i][ii])){
                hor = false;
              }
            }
            if(hor){
              win = true;
            }
          }
          if(!board[ii][i].equals("_")){
            boolean ver = true;
            for(int iii = 1; iii < 5; iii++){
              if(!board[ii+iii][i].equals(board[ii][i])){
                ver = false;
              }
            }
            if(ver){
              win = true;
            }
          }
        }
      }
      //Left diagonal check
      for(int i = 0; i < 2; i++){
        for(int ii = 0; ii < 2; ii++){
          if(!board[i][ii].equals("_")){
            boolean ldia = true;
            for(int iii = 1; iii < 5; iii++){
              if(!board[i+iii][ii+iii].equals(board[i][ii])){
                ldia = false;
              }
            }
            if(ldia){
              win = true;
            }
          }
        }
      }
      //Right diagonal check
      for(int i = 4; i < 6; i++){
        for(int ii = 0; ii < 2; ii++){
          if(!board[i][ii].equals("_")){
            boolean rdia = true;
            for(int iii = 1; iii < 5; iii++){
              if(!board[i-iii][ii+iii].equals(board[i][ii])){
                rdia = false;
              }
            }
            if(rdia){
              win = true;
            }
          }
        }
      }
      if(win){
        System.out.println("Order has won.");
        gamecontinue = false;
      }
      else{
        boolean w1N = true;
        for(String[] s: board){
          if(Arrays.asList(s).contains("_")){
            w1N=false;
          }
        }
        if(w1N){
          System.out.println("ChA0s HAs hda DONE WONNNN!!!!!!!!!!!!!!11!!!!111!4747");
          gamecontinue = false;
        }
      }
      turn=!turn;
    }
  }
}