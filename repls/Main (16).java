import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scam = new Scanner(System.in);
    System.out.println("ax2+bx+c\nWhat is a?");
    double a = scam.nextDouble();
    System.out.println("What is b?");
    double b = scam.nextDouble();
    System.out.println("What is c?");
    double c = scam.nextDouble();
    System.out.println((((-b)+Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a))+", "+(((-b)-Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a)));
  }
}