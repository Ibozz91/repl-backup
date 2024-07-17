import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
  public static void main(String[] args) throws MalformedURLException, IOException {  
    System.out.println("Setting up... (Please wait)");
    ArrayList<String> Words = new ArrayList<String>();
    URL url = new URL ("https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt");
    // read text returned by server
    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    while ((line = in.readLine()) != null) {
      Words.add(line);
    }
    in.close();
    System.out.println("Done!");
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter height");
    int h = scan.nextInt();
    scan.nextLine();
    System.out.println("Enter width");
    int w = scan.nextInt();
    scan.nextLine();
    String[][] thething = new String[h][w];
    for(int i = 0; i < h; i++){
      for(int j = 0; j < w; j++){
        System.out.println("Row "+(i+1)+" Column "+(j+1)+". Enter 0 for empty space.");
        String thej = scan.nextLine();
        thething[i][j]=thej.toLowerCase();
      }
    }
    scan.close();
    for(int i = 0; i<Words.size(); i++){
      if(checkifworks(thething,Words.get(i),-1,-1)){
        System.out.println(Words.get(i));
      }
    }
  }
  public static boolean checkifworks(String[][] board, String word, int c, int d, ArrayList<Integer[]>){
    if(word.length()==0){
      return true;
    }
    if(c==-1){
      for(int i = 0; i<board.length; i++){
        for(int j = 0; j<board[0].length; j++){
          if(word.substring(0,board[i][j].length()).equals(board[i][j])){
            if(checkifworks(board,word.substring(board[i][j].length(),word.length()),i,j)){
              return true;
            }
          }
        }
      }
    }
    else{
      for(int i=c-1; i<c+2; i++){
        for(int j=d-1; j<d+2; j++){
          try{
            if(word.substring(0,board[i][j].length()).equals(board[i][j])){
              if(checkifworks(board,word.substring(board[i][j].length(),word.length()),i,j)){
                return true;
              }
            }
          }
          catch(Exception ArrayIndexOutOfBoundsException){

          }
        }
      }
    }
    return false;
  }
}