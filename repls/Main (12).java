import java.util.ArrayList;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
      ArrayList<Integer[]> Snake = new ArrayList<Integer[]>();
      Snake.add(new Integer[]{0,0});
      Snake.add(new Integer[]{0,0});
      Snake.add(new Integer[]{0,0});
      Snake.add(new Integer[]{0,0});
      ArrayList<Integer[]> Check = new ArrayList<Integer[]>();
      for(int i = 0; i < Snake.size(); i++){
        if(containz(Check, Snake.get(i))){
          System.out.println("You hit yourself! Your score was: "+Snake.size());
          System.exit(0);
        }
        Check.add(Snake.get(i));
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