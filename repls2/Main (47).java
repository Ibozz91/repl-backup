import java.util.ArrayList;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner Scan = new Scanner(System.in);
    ArrayList<Integer> one = new ArrayList<Integer>();
    for(int i = 1; i < 8; i++){
      one.add(i);
    }
    ArrayList<Integer> two = new ArrayList<Integer>();
    for(int i = 1; i < 8; i++){
      two.add(i);
    }
    ArrayList<Integer> three = new ArrayList<Integer>();
    while(true){
      boolean b = true;
      if(two.size()==7){
        for(Integer i = 1; i < 8; i++){
          if(two.get(i-1)!=i){
            b = false;
          }
        }
        if(b){
          System.out.println("You win! GG.");
          break;
        }
      }
      b = true;
      if(three.size()==7){
        for(Integer i = 1; i < 8; i++){
          if(three.get(i-1)!=i){
            b = false;
          }
        }
        if(b){
          System.out.println("You win! GG.");
          break;
        }
      }
      System.out.print("First stand: ");
      for(int i = 0; i < one.size(); i++){
        System.out.println(one.get())
      }
    }
  }
}