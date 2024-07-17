import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
 
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
        String Allowed = "Oo0Ii1ZzEeHhSs5Gg9LlBb86";
        String maxword = "";
        for(int i = 0; i < Words.size(); i++){
          boolean h = true;
          for(int thej = 0; thej < Words.get(i).length(); thej++){
            if(!(Allowed.contains(Words.get(i).substring(thej, thej+1)))){
              h=false;
            }
          }
          if(h && Words.get(i).length() > maxword.length()){
            maxword = Words.get(i);
          }
        }
        System.out.println(maxword);
    }
 
}