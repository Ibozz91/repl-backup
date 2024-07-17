import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    String[] Questions = new String[20];
    String[] Answers = new String[20];
    Scanner Scan = new Scanner(System.in);
    System.out.println("Enter a thing");
    String Thing = Scan.nextLine();
    for(int i = 0; i < 1000; i++){
      System.out.println("");
    }
    for(int i = 0; i < 20; i++){
      for(int is = 0; is < 1000; is++){
        System.out.println("");
      }
      System.out.println("Question #"+(i+1)+"\n");
      for(int in = 0; in < i; in++){
        System.out.println((in+1)+". "+Questions[in]+"        "+Answers[in]);
        if(Answers[in].equalsIgnoreCase("you win")){
          System.out.println("You win! GG.");
          System.exit(0);
        }
      }
      System.out.println("Ask a question");
      Questions[i] = Scan.nextLine();
      for(int is = 0; is < 1000; is++){
        System.out.println("");
      }
      System.out.println("Answer this question about the thing, or type you win if they guessed it");
      System.out.println(Questions[i]);
      Answers[i] = Scan.nextLine();
    }
    System.out.println("You lose! The thing was "+Thing+".");
    System.exit(0);
  }
}