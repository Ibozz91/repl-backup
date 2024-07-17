//█▒
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[][] board={{"█","▒","▒","_","_","_","_","_","_","_"},
                      {"_","█","▒","_","_","_","_","_","_","_"},
                      {"_","_","█","█","█","_","_","_","_","_"},
                      {"_","_","_","█","_","█","_","_","_","_"},
                      {"_","_","_","_","_","_","█","_","_","_"},
                      {"_","_","_","_","_","_","_","█","_","_"},
                      {"_","_","_","_","_","_","_","_","_","_"},
                      {"_","_","_","_","_","_","_","_","_","_"},
                      {"_","_","_","_","_","_","_","_","_","_"},
                      {"_","_","_","_","_","_","_","_","_","_"}};
    while(true){
      for(String[] i: board){
        for(String j: i){
          System.out.print(j+" ");
        }
        System.out.println();
      }
      board=briansbrain(board);
      System.out.println("Press ENTER to continue.");
      scan.nextLine();
    }
  }
  public static String[][] briansbrain(String[][] initial){
    String[][] newboard = new String[initial.length][initial[0].length];
    for(int i = 0; i < initial.length; i++){
      for(int j = 0; j < initial[0].length; j++){
        if(initial[i][j].equals("_")){
          int h = 0;
          for(int ib=i-1; ib<i+2; ib++){
            for(int in=j-1; in<j+2; in++){
              try{
                if(initial[ib][in].equals("█")){
                  h++;
                }
              }
              catch(Exception ArrayIndexOutOfBoundsException){
    
              }
            }
          }
          if(h==2){
            newboard[i][j]="█";
          }
          else{
            newboard[i][j]="_";
          }
        }
        else if(initial[i][j].equals("▒")){
          newboard[i][j]="_";
        }
        else if(initial[i][j].equals("█")){
          newboard[i][j]="▒";
        }
      }
    }
    return newboard;
  }
}