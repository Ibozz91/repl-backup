//Wikipedia article here: https://en.wikipedia.org/wiki/Kalah
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    //Create the variables
    int[] p1row={4,4,4,4,4,4};
    int[] p2row={4,4,4,4,4,4};
    int p1store=0;
    int p2store=0;
    boolean turn=true;
    boolean gamerun=true;
    Scanner thescan=new Scanner(System.in);
    while(gamerun){
      boolean changeturn=true;
      boolean endgame1=true;
      boolean endgame2=true;
      //Print the board while checking if the game has ended
      System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.print("  ");
      for(int i:p2row){
        System.out.print(i+" ");
        if(i<10){
          System.out.print(" ");
        }
        if(!(i==0)){
          endgame2=false;
        }
      }
      System.out.print("\n"+p2store);
      if(p2store<10){
        System.out.print(" ");
      }
      System.out.print("                ");
      if(p1store<10){
        System.out.print(" ");
      }
      System.out.println(p1store);
      System.out.print("  ");
      for(int i:p1row){
        System.out.print(i+" ");
        if(i<10){
          System.out.print(" ");
        }
        if(!(i==0)){
          endgame1=false;
        }
      }
      System.out.println("");
      if(endgame1 || endgame2){
        //Game has ended, see who won
        if(endgame1){
          for(int i=0; i<6; i++){
            p2store=p2store+p2row[i];
            p2row[i]=0;
          }
        }
        else{
          for(int i=0; i<6; i++){
            p1store=p1store+p1row[i];
            p1row[i]=0;
          }
        }
        if(p1store>p2store){
          System.out.println("Player 1 wins!");
        }
        else if(p2store>p1store){
          System.out.println("Player 2 wins!");
        }
        else{
          System.out.println("It's tied!");
        }
        System.out.println("The score was "+p1store+" for Player 1, and "+p2store+" for Player 2.");
        gamerun=false;
      }
      else if(turn){
        //Player 1 turn
        System.out.println("It is thy turn of thy first player");
        System.out.println("Select a store using numbers 1-6 (6 being the closest to your store)");
        int select=thescan.nextInt();
        if(select<1 || select>6 || p1row[select-1]==0){
          //Illegal move, restart turn
          continue;
        }
        int whereat=select+1;
        int mem=p1row[select-1];
        p1row[select-1]=0;
        //move the piece
        for(int i = 0; i<mem; i++){
          if(whereat==7){
            p1store++;
            if(i==(mem-1)){
              changeturn=false;
              continue;
            }
          }
          else if(whereat<7 && whereat>=1){
            p1row[whereat-1]++;
            if(p2row[whereat-1]>0 && p1row[whereat-1]==1 && i==mem-1){
              p1store=p1store+p1row[whereat-1]+p2row[whereat-1];
              p1row[whereat-1]=0;
              p2row[whereat-1]=0;
            }
          }
          else if(whereat>7){
            p2row[13-whereat]++;
          }
          if(whereat==13){
            whereat=1;
          }
          else{
            whereat++;
          }
        }
      }
      else{
        //Player 2 turn
        System.out.println("It is thy turn of thy second player");
        System.out.println("Select a store using numbers 1-6 (6 being the farthest away from your store)");
        int select=thescan.nextInt();
        if(select<1 || select>6 || p2row[select-1]==0){
          //Illegal move, restart turn
          continue;
        }
        int whereat=(7-(select))+1;
        int mem=p2row[select-1];
        p2row[select-1]=0;
        //move the piece
        for(int i = 0; i<mem; i++){
          if(whereat==7){
            p2store++;
            if(i==(mem-1)){
              changeturn=false;
              continue;
            }
          }
          else if(whereat<7 && whereat>=1){
            p2row[6-whereat]++;
            if(p1row[6-whereat]>0 && p2row[6-whereat]==1 && i==mem-1){
              p2store=p2store+p2row[6-whereat]+p1row[6-whereat];
              p2row[6-whereat]=0;
              p1row[6-whereat]=0;
            }
          }
          else if(whereat>7){
            p1row[whereat-8]++;
          }
          if(whereat==13){
            whereat=1;
          }
          else{
            whereat++;
          }
        }
      }
      if(changeturn){
        turn=!turn;
      }
    }
  }
}