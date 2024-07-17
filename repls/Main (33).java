import java.util.Scanner;
import java.util.stream.*;
class Main {
  public static void main(String[] args) {
    int row=0;
    Scanner Scan = new Scanner(System.in);
    int[] rows={3,5,7};
    int turn=1;
    while(IntStream.of(rows).sum()>0){
      for(int i = 0; i<rows.length; i++){
        System.out.print("Row "+(i+1)+": ");
        for(int ii=0; ii<rows[i]; ii++){
          System.out.print("| ");
        }
        System.out.println();
      }
      boolean x = false;
      while(!x){
        System.out.println("Select a row player "+turn);
        row = Scan.nextInt();
        Scan.nextLine();
        if(row>0 && row<4 && rows[row-1]>0){
          x = true;
        }
      }
      while(x){
        System.out.println("How many to remove?");
        int num = Scan.nextInt();
        if(num>0 && num<=rows[row-1]){
          rows[row-1]-=num;
          x = false;
        }
      }
      turn=3-turn;
    }
    System.out.println("Congrats player "+turn+" you won a solved game are you happy");
  }
}