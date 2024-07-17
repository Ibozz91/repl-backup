import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    boolean space=true;
    String addtoend="";
    String Stringz="";
    String[] alph = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
    String[] vowels = {"a", "e", "i", "o", "u"};
    Scanner scan = new Scanner(System.in);
    System.out.println("Type something to translate into pig latin");
    String h = scan.nextLine()+" ";
    for(int i=0; i<h.length(); i++){
      if(Arrays.asList(alph).contains(h.substring(i,i+1))){
        if(space){
          if(Arrays.asList(vowels).contains(h.substring(i,i+1))){
            Stringz+=h.substring(i,i+1);
            addtoend="";
          }
          else{
            addtoend=h.substring(i,i+1);
          }
          space=false;
        }
        else{
          Stringz+=h.substring(i,i+1);
        }
      }
      else{
        space=true;
        Stringz+=addtoend+"ay"+h.substring(i,i+1);
      }
    }
    System.out.println(Stringz);
  }
}