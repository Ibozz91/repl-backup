import java.net.URL;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
class Main {
  public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(System.in);
    System.out.println("What website do you want to visit?");
    String x = new String(scan.next());
    try{
      URL y = new URL(x);

      BufferedReader in = new BufferedReader(new InputStreamReader(y.openStream()));
             
      String line;
      while ((line = in.readLine()) != null) {
        System.out.println(line);
      }
      in.close();
    }
    catch(MalformedURLException e){
      System.out.println("That's not a website!");
      System.exit(0);
    }
  }
}