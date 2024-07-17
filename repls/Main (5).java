import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int num = 0;
    while (true) {
      System.out.println("Next number?");
      int inum = scan.nextInt();
      if (inum != num + 1) {
        System.out.println("O O F your score was " + num);
        num = -1;
      }
      num++;
    }
  }
}