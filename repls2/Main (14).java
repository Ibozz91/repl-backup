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
    System.out.println("Enter some characters");
    String characters = scan.nextLine();
    ArrayList<String> listt = new ArrayList<String>();
    for(int i = 0; i < characters.length(); i++){
      listt.add(characters.substring(i, i+1));
    }
    scan.close();
    for(int i = 0; i < Words.size(); i++){
      ArrayList<String> Another = new ArrayList<String>();
      for(int isp = 0; isp<listt.size(); isp++){
        Another.add(listt.get(isp));
      }
      boolean h = true;
      for(int inf = 0; inf < Words.get(i).length(); inf++){
        if(Another.contains(Words.get(i).substring(inf, inf+1))){
          Another.remove(Words.get(i).substring(inf, inf+1));
        }
        else{
          h=false;
        }
      }
      if(h){
        System.out.println(Words.get(i));
      }
    }
  }
}