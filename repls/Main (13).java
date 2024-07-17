import java.util.Scanner;
import java.util.Random;
class Main {
  public static void main(String[] args) {
    int flagcount=0;
    Scanner Scan = new Scanner(System.in);
    Random r = new Random();
    System.out.println("You are standing in the middle of a field. Suddenly, you see a sign; it says: 'YOU MUST REMOVE ALL LANDMINES.' You suddenly realized that *enemy of your home country* has placed these mines here, and a battle with *your home country* will happpen soon. Next to the sign is a landmine tracking device. It asks you the length/width of the field. PUT IT IN. Keep in mind that fields are usually 16x16 with 40 mines.");
    int lenwid = Scan.nextInt();
    Scan.nextLine();
    String[][] field1 = new String[lenwid][lenwid];
    for(int weu = 0; weu < lenwid; weu++){
      for(int i = 0; i < lenwid; i++){
        field1[weu][i]="_";
      }
    }
    String[][] field2 = new String[lenwid][lenwid];
    for(int weu = 0; weu < lenwid; weu++){
      for(int i = 0; i < lenwid; i++){
        field2[weu][i]="_";
      }
    }
    System.out.println("Now it wants to know how many mines there are.");
    int mines = Scan.nextInt();
    Scan.nextLine();
    for(int i = 0; i < mines; i++){
      while(true){
        int l = r.nextInt(lenwid);
        int w = r.nextInt(lenwid);
        if(field2[l][w]=="_"){
          field2[l][w]="B";
          break;
        }
      }
    }
    while(true){
      if(mines==flagcount){
        boolean booland = true;
        for(int i = 0; i < lenwid; i++){
          for(int in = 0; in < lenwid; in++){
            if(field1[i][in]=="F" && field2[i][in]!="B"){
              booland=false;
            }
          }
        }
        if(booland){
          System.out.println("You win!");
          System.exit(0);
        }
      }
      System.out.print("    ");
      for(Integer i = 0; i < lenwid; i++){
        System.out.print(i.toString().substring(i.toString().length()-1, i.toString().length())+" ");
      }
      System.out.println("");
      Integer col = 0;
      for(String[] String1: field1){
        System.out.print("\n"+col.toString().substring(col.toString().length()-1, col.toString().length())+"   ");
        col++;
        for(String String2: String1){
          System.out.print(String2+" ");
        }
      }
      System.out.println("\nF to flag/unflag, U to uncover.");
      String lol = Scan.nextLine();
      if(lol.equalsIgnoreCase("U")){
        System.out.println("Row?");
        int ro = Scan.nextInt();
        Scan.nextLine();
        System.out.println("Column?");
        int c = Scan.nextInt();
        Scan.nextLine();
        uncover(field1, field2, ro, c);
      }
      else if(lol.equalsIgnoreCase("F")){
        System.out.println("Row?");
        int ro = Scan.nextInt();
        Scan.nextLine();
        System.out.println("Column?");
        int c = Scan.nextInt();
        Scan.nextLine();
        if(field1[ro][c]=="_"){
          field1[ro][c]="F";
          flagcount++;
        }
        else if(field1[ro][c]=="F"){
          field1[ro][c]="_";
          flagcount--;
        }
      }
    }
  }
  public static void uncover(String[][] board, String[][] otherboard, int a, int b){
    if(board[a][b]!="_"){
      return;
    }
    if(otherboard[a][b]=="B"){
      System.out.println("Oof you blew up.");
      System.exit(0);
    }
    int h = 0;
    for(int i=a-1; i<a+2; i++){
      for(int in=b-1; in<b+2; in++){
        try{
          if(otherboard[i][in]=="B"){
            h++;
          }
        }
        catch(Exception ArrayIndexOutOfBoundsException){

        }
      }
    }
    board[a][b]=Integer.toString(h);
    if(h==0){
      for(int i=a-1; i<a+2; i++){
        for(int in=b-1; in<b+2; in++){
          try{
            uncover(board, otherboard, i, in);
          }
          catch(Exception ArrayIndexOutOfBoundsException){

          }
        }
      }
    }
  }
}