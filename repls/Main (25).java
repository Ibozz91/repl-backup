import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    Integer[] piece = null;
    Integer[] space = null;
    Integer[] space2 = null;
    Scanner scan=new Scanner(System.in);
    String[][] board={{"_","_","_","B","_","_","B","_","_","_"},
                        {"_","_","_","_","_","_","_","_","_","_"},
                        {"_","_","_","_","_","_","_","_","_","_"},
                        {"B","_","_","_","_","_","_","_","_","B"},
                        {"_","_","_","_","_","_","_","_","_","_"},
                        {"_","_","_","_","_","_","_","_","_","_"},
                        {"W","_","_","_","_","_","_","_","_","W"},
                        {"_","_","_","_","_","_","_","_","_","_"},
                        {"_","_","_","_","_","_","_","_","_","_"},
                        {"_","_","_","W","_","_","W","_","_","_"}};
    String[] letters={"a","b","c","d","e","f","g","h","i","j"};
    String turn="W";
    boolean gamecontinue=true;
    while(gamecontinue){
      gamecontinue=false;
      ArrayList<Integer[]> legalpieces=new ArrayList<Integer[]>();
      System.out.print("  ");
      for(int i=0; i<10; i++){
        System.out.print(letters[i]+" ");
      }
      for(int i1=0; i1<10; i1++){
        if(i1==0){
          System.out.print("\n0 ");
        }
        else{
          System.out.print((10-i1)+" ");
        }
        for(int i2=0; i2<10; i2++){
          System.out.print(board[i1][i2]+" ");
          if(board[i1][i2]==turn){
            for(int t1=i1-1; t1<i1+2; t1++){
              for(int t2=i2-1; t2<i2+2; t2++){
                try{
                  if(board[t1][t2]=="_"){
                    gamecontinue=true;
                    legalpieces.add(new Integer[]{i1,i2});
                    t1=999;
                    t2=999;
                    break;
                  }
                }
                catch(Exception ArrayIndexOutOfBoundsException){

                }
              }
            }
          }
        }
        System.out.println();
      }
      if(!gamecontinue){
        System.out.println("You have lost. "+(turn.equals("W")?"Black":"White")+" has won");
        continue;
      }
      boolean x = true;
      while(x){
        System.out.println("It is "+(turn.equals("W")?"white":"black")+"'s turn");
        System.out.println("Select a legal piece to move");
        String g = scan.nextLine();
        piece = coordinates(g, letters);
        if(acontains(legalpieces, piece)){
          x = false;
        }
        else{
          System.out.println("Please select a movable piece of your color");
        }
      }
      while(!x){
        System.out.println("Select a space to move the piece to");
        String g = scan.nextLine();
        space = coordinates(g, letters);
        Integer[] vector=vectorfromdespicableme(piece, space);
        if((vector[0]==0 && vector[1]==0) || (!(board[space[0]][space[1]].equals("_")))){
          System.out.println("You may not move your piece there");
        }
        else{
          x=true;
          Integer[] increment=new Integer[2];
          increment[0]=piece[0];
          increment[1]=piece[1];
          while(increment[0]!=space[0] || increment[1]!=space[1]){
            increment[0]+=vector[0];
            increment[1]+=vector[1];
            if(!(board[increment[0]][increment[1]].equals("_"))){
              System.out.println("You may not move your piece there");
              x=false;
              break;
            }
          }
        }
      }
      board[space[0]][space[1]]=turn;
      board[piece[0]][piece[1]]="_";
      System.out.print("  ");
      for(int i=0; i<10; i++){
        System.out.print(letters[i]+" ");
      }
      for(int i1=0; i1<10; i1++){
        if(i1==0){
          System.out.print("\n0 ");
        }
        else{
          System.out.print((10-i1)+" ");
        }
        for(int i2=0; i2<10; i2++){
          System.out.print(board[i1][i2]+" ");
        }
        System.out.println();
      }
      while(x){
        System.out.println("Select a space to fire the burning arrow to");
        String g = scan.nextLine();
        space2 = coordinates(g, letters);
        Integer[] vector=vectorfromdespicableme(space, space2);
        if((vector[0]==0 && vector[1]==0) || (!(board[space2[0]][space2[1]].equals("_")))){
          System.out.println("You may not move your piece there");
        }
        else{
          x=false;
          Integer[] increment=new Integer[2];
          increment[0]=space[0];
          increment[1]=space[1];
          while(increment[0]!=space2[0] || increment[1]!=space2[1]){
            increment[0]+=vector[0];
            increment[1]+=vector[1];
            if(!(board[increment[0]][increment[1]].equals("_"))){
              System.out.println("You may not move your piece there");
              x=true;
              break;
            }
          }
        }
      }
      board[space2[0]][space2[1]]="X";
      if(turn.equals("W")){
        turn="B";
      }
      else{
        turn="W";
      }
    }
  }
    public static Integer[] coordinates(String s, String[] alpha){
      if(s.length()==3){
        if(s.substring(1,3).equals("10")){
          return coordinates(s.substring(0,1)+"0", alpha);
        }
        else{
          return new Integer[]{-1, -1};
        }
      }
      else if(s.length()==2){
        Integer[] rt = new Integer[2];
        if(s.substring(1,2).equals("0")){
          rt[0]=0;
        }
        else{
          rt[0]=10-Integer.parseInt(s.substring(1,2));
        }
        if(Arrays.asList(alpha).contains(s.substring(0,1))){
          rt[1]=Arrays.asList(alpha).indexOf(s.substring(0,1));
          return rt;
        }
        else{
          return new Integer[]{-1, -1};
        }
      }
      else{
        return new Integer[]{-1, -1};
      }
    }
    public static void printall(Integer[] p){
      for(int i: p){
        System.out.println("\n"+i);
      }
    }
  public static boolean acontains(ArrayList<Integer[]> a, Integer[] b){
    for(int i = 0; i < a.size(); i++){
      if(a.get(i)[0]==b[0] && a.get(i)[1]==b[1]){
        return true;
      }
    }
    return false;
  }
  public static Integer[] vectorfromdespicableme(Integer[] fromhere, Integer[] tohere){
    Integer[] result = {0,0};
    //same x, dif y
    if(fromhere[0]==tohere[0] && fromhere[1]!=tohere[1]){
      if(tohere[1]-fromhere[1]>0){
        result[1]=1;
      }
      else{
        result[1]=-1;
      }
    }
    //dif x, same y
    else if(fromhere[1]==tohere[1] && fromhere[0]!=tohere[0]){
      if(tohere[0]-fromhere[0]>0){
        result[0]=1;
      }
      else{
        result[0]=-1;
      }
    }
    //same direction x and y
    else if(tohere[0]-fromhere[0]==tohere[1]-fromhere[1] && tohere[0]!=fromhere[0]){
      if(tohere[0]-fromhere[0]>0){
        result[0]=1;
        result[1]=1;
      }
      else{
        result[0]=-1;
        result[1]=-1;
      }
    }
    //x is the opposite direction as y
    else if(tohere[0]-fromhere[0]==fromhere[1]-tohere[1] && tohere[0]!=fromhere[0]){
      if(tohere[0]-fromhere[0]>0){
        result[0]=1;
        result[1]=-1;
      }
      else{
        result[0]=-1;
        result[1]=1;
      }
    }
    return result;
  }
}