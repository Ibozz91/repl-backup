import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("What is the repeating part?");
    int repeat = scan.nextInt();
    scan.nextLine();
    int denom=(int)Math.pow(10,Integer.toString(repeat).length())-1;
    int gcf = gcf(repeat,denom);
    System.out.println(repeat/gcf+"/"+denom/gcf);
  }
  public static int gcf(int a, int b){
    if(a==b){
      return a;
    }
    else if(a>b){
      return gcf(a-b, b);
    }
    else{
      return gcf(a, b-a);
    }
  }
}