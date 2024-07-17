import java.util.Scanner;
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    Scanner Scan = new Scanner(System.in);
    ArrayList<Integer> Array = new ArrayList<Integer>();
    Array.add(1);
    Array.add(1);
    while(true){
      System.out.println("Which lie in the lie sequence would you like to see?");
      int wlie = Scan.nextInt();
      System.out.println(fib(wlie-1, Array));
    }
  }
  public static void addntoarraylist(ArrayList<Integer> aaa, int Int){
    for(int i = 0; i < Int; i++){
      aaa.add(-1);
    }
  }
  public static int fib(int h, ArrayList<Integer> ha){
    if(h >= ha.size() || ha.get(h)==-1){
      addntoarraylist(ha, h-ha.size()+1);
      ha.set(h-1, fib(h-1, ha));
      ha.set(h-2, fib(h-2, ha));
      ha.set(h, ha.get(h-1)+ha.get(h-2));
      return ha.get(h);
    }
    else{
      return ha.get(h);
    }
  }
}