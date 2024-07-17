import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    if(!(input(scan)=="lol let me test pls")){
      System.exit(0);
    }
  }
  public static String input(Scanner scan){
    System.out.println("This is not finished yet! Enter password to continue");
    return scan.next();
  }
}