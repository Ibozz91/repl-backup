import java.util.Random;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    String[] Answers = {"Yes", "No", "Maybe", "Ask again later", "Do not ask again"}; 
    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    System.out.println("Ask a question");
    sc.nextLine();
    sc.close();
    System.out.println(Answers[r.nextInt(Answers.length)]);
  }
}