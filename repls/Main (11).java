import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    Random r = new Random();
    Scanner scan = new Scanner(System.in);
    String pDirection = "s";
    String[][] board = new String[11][11];
    ArrayList<Integer[]> Snake = new ArrayList<Integer[]>();
    Snake.add(new Integer[]{0,0});
    Integer[] apple = {10, 10};
    for(int s = 0; s<11; s++){
      for(int st = 0; st<11; st++){
        board[s][st]="_";
      }
    }
    board[0][0]="H";
    board[10][10]="A";
    while(true){
      for(String[] s: board){
        for(String st: s){
          System.out.print(st+" ");
        }
        System.out.println("");
      }
      System.out.println("Enter a direction (w, a, s, d)");
      String Direction = scan.next();
      if(Direction.equalsIgnoreCase("w")){
        Snake.add(new Integer[]{Snake.get(Snake.size()-1)[0]-1, Snake.get(Snake.size()-1)[1]});
        pDirection=Direction;
      }
      else if(Direction.equalsIgnoreCase("s")){
        Snake.add(new Integer[]{Snake.get(Snake.size()-1)[0]+1, Snake.get(Snake.size()-1)[1]});
        pDirection=Direction;
      }
      else if(Direction.equalsIgnoreCase("a")){
        Snake.add(new Integer[]{Snake.get(Snake.size()-1)[0], Snake.get(Snake.size()-1)[1]-1});
        pDirection=Direction;
      }
      else if(Direction.equalsIgnoreCase("d")){
        Snake.add(new Integer[]{Snake.get(Snake.size()-1)[0], Snake.get(Snake.size()-1)[1]+1});
        pDirection=Direction;
      }
      else if(pDirection.equalsIgnoreCase("w")){
        Snake.add(new Integer[]{Snake.get(Snake.size()-1)[0]-1, Snake.get(Snake.size()-1)[1]});
      }
      else if(pDirection.equalsIgnoreCase("s")){
        Snake.add(new Integer[]{Snake.get(Snake.size()-1)[0]+1, Snake.get(Snake.size()-1)[1]});
      }
      else if(pDirection.equalsIgnoreCase("a")){
        Snake.add(new Integer[]{Snake.get(Snake.size()-1)[0], Snake.get(Snake.size()-1)[1]-1});
      }
      else if(pDirection.equalsIgnoreCase("d")){
        Snake.add(new Integer[]{Snake.get(Snake.size()-1)[0], Snake.get(Snake.size()-1)[1]+1});
      }
      if(Snake.get(Snake.size()-1)[0]==apple[0] && Snake.get(Snake.size()-1)[1]==apple[1]){
        if(Snake.size()==121){
          System.out.println("You have done it. You have finally escaped your eternal punishment of growing by eating apples only to die and go back to your cage. You can go see your family again, stop eating apples, and live life. Score: 121. Good job.\nCredits:\nDesigner: I don't know\nrepl.it by: repl.it\nProgrammed by: Ibozz91\nJava by: Oracle\nBeat on probably final version: 1.2\nThanks for playing!");
          System.exit(0);
        }
        while(true){
          apple[0]=r.nextInt(11);
          apple[1]=r.nextInt(11);
          if(!(containz(Snake, apple))){
            break;
          }
        }
      }
      else{
        Snake.remove(0);
      }
      ArrayList<Integer[]> Check = new ArrayList<Integer[]>();
      for(int i = 0; i < Snake.size(); i++){
        if(containz(Check, Snake.get(i))){
          System.out.println("You hit yourself! Your score was: "+Snake.size());
          System.exit(0);
        }
        Check.add(Snake.get(i));
      }
      for(int i = 0; i<Snake.size(); i++){
        for(int in: Snake.get(i)){
          if(in>10 || in<0){
            System.out.println("You hit the wall! Your score was: "+Snake.size());
            System.exit(0);
          }
        }
      }
      for(int s = 0; s<11; s++){
        for(int st = 0; st<11; st++){
          board[s][st]="_";
        }
      }
      board[apple[0]][apple[1]]="A";
      board[Snake.get(Snake.size()-1)[0]][Snake.get(Snake.size()-1)[1]]="H";
      for(int i = 1; i < Snake.size(); i++){
        board[Snake.get(i-1)[0]][Snake.get(i-1)[1]]="S";
      }
    }
  }
  public static boolean containz(ArrayList<Integer[]> Check, Integer[] list){
    for(int in = 0; in < Check.size(); in++){
      if(Arrays.equals(Check.get(in), list)){
        return true;
      }
    }
    return false;
  }
}