import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner Scan = new Scanner(System.in);
    boolean b = true;
    System.out.println("Enter a number");
    int num = Scan.nextInt();
    for(int i = 0; i < num; i++){
      b=!b;
    }
    if(b){
      System.out.println("Even");
    }
    else{
      System.out.println("Odd");
    }
  }
}