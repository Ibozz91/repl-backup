import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    int num=0;
    boolean turn=true;
    Scanner s = new Scanner(System.in);
    while(true){
      if(turn){
        System.out.println("It is Player 1's turn");
      }      
      else{
        System.out.println("It is Player 2's turn");
      }
      System.out.println("The number is "+num);
      System.out.println("What number do you want to add?");
      int add=s.nextInt();
      if(add<1 || add>4){
        System.out.println("Illegal Move\n");
      }
      else{
        num=num+add;
        if(num>20){
          if(turn){
            System.out.println("Player 2 wins");
          }
          else{
            System.out.println("Player 1 wins");
          }
          s.close();
          System.exit(0);
        }
        if(turn){
          turn=false;
        }
        else{
          turn=true;
        }
        System.out.println("");
      }
    }
  }
}