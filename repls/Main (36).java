import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("What is the width?");
    int width = scan.nextInt();
    scan.nextLine();
    int height = width/3;
    for(int i = 0; i < height; i++){
      for(int j = 0; j < width; j++){
        Complex point = new Complex(((j*3.0)/width)-2, ((i*2.0)/height)-1);
        Complex change = point;
        String q = " ";
        for(int k = 0; Math.abs(change.getReal())<=10 && Math.abs(change.getFake())<=10; k++){
          if(k==1000){
            q = "*";
            break;
          }
          change=change.multiply(change).add(point);
        }
        System.out.print(q);
      }
      System.out.println();
    }
  }
}