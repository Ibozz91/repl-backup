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
      if(turn==2){
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
      }
      else{
        int[] list = nim(rows);
        System.out.println(list[1]+" stick(s) removed from row "+(list[0]+1));
        rows[list[0]]-=list[1];
      }
      turn=3-turn;
    }
    if(turn==1){
      System.out.println("Keep going I believe in you");
    }
    else{
      System.out.println("""
#     # ### #     #     #####  #     #    #    #     # ######  
##    #  #  ##   ##    #     # #     #   # #   ##   ## #     # 
# #   #  #  # # # #    #       #     #  #   #  # # # # #     # 
#  #  #  #  #  #  #    #       ####### #     # #  #  # ######  
#   # #  #  #     #    #       #     # ####### #     # #       
#    ##  #  #     #    #     # #     # #     # #     # #       
#     # ### #     #     #####  #     # #     # #     # #       """);
    }
  }
  public static int[] nim(int[] rows){
    int zerocount = 0;
    for(int i = 0; i < rows.length; i++){
      if(rows[i]==0){
        zerocount++;
      }
    }
    if(zerocount==2){
      for(int i = 0; i < rows.length; i++){
        if(rows[i]>1){
          return new int[]{i, rows[i]-1};
        }
      }
    }
    int[] rows2 = new int[3];
    for(int i = 0; i < rows.length; i++){
      for(int ii = 1; ii <= rows[i]; ii++){
        for(int iii = 0; iii < 3; iii++){
          rows2[iii]=rows[iii];
        }
        rows2[i]-=ii;
        boolean bo = false;
        for(int k: rows2){
          if(k>1){
            bo=true;
          }
        }
        if(bo){
          if((rows2[0]^rows2[1]^rows2[2])==0){
            return new int[]{i, ii};
          }
        }
        else{
          int num1 = 0;
          for(int k: rows2){
            if(k==1){
              num1++;
            }
          }
          if(num1%2==1){
            return new int[]{i, ii};
          }
        }
      }
    }
    for(int i = 0; i < 3; i++){
      if(rows[i]>0){
        return new int[]{i,1};
      }
    }
    return new int[]{-1, -1};
  }
}