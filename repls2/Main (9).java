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
        int turn = 0;
        String word = "";
        System.out.println("Done!");
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to know the rules first before playing?");
        String rules = scan.next();
        if(rules.equalsIgnoreCase("y") || rules.equalsIgnoreCase("yes")){
          System.out.println("Okay, this is a multiplayer word game, so get some friends,\n-Players take turns adding to a word fragment, trying to make it start a word but not be a word.\n-The word must be at least 4 letters long for a play to lose.\n-If a player loses, they get one added to their score.\n-If your score is 5, you're out!");
        }
        System.out.println("Select an amount of players");
        int Players = scan.nextInt();
        if(Players == 1){
          System.out.println("You are missing one requirement for this game - friends. Please, make some friends and come back here.");
          System.exit(0);
        }
        else if(Players == 2){
          System.out.println("Come on, you could only find ONE friend?! You just wanted to do the bare minimum.");
        }
        else if(Players == 3){
          System.out.println("Three. Huh. I thought two and four would give more attention to you. But you decided to choose three. Huh.");
        }
        else if(Players == 4){
          System.out.println("aight bois its time to play ghost battle royale edition with four players who will win");
        }
        else if(Players > 4){
          System.out.println("Woah. You have a lot of friends. Maybe you could try a tournament?");
          System.exit(0);
        }
        else if(Players == 0){
          System.out.println("You know, I thought that someone was at this computer. But I guess I'm wrong!");
          System.out.println("Let's play!");
          System.out.println("We're done!");
          System.out.println("Nobo- no wait, everybody won! Good job!");
          System.exit(0);
        }
        else if(Players < 0){
          System.out.println("How is that even possible? Oh wait, it isn't.");
          System.exit(0);
        }
        System.out.println("Alright, setup's almost complete!");
        ArrayList<Player> People = new ArrayList<Player>();
        for(int i = 0; i < Players; i++){
          System.out.println("Player "+(i+1)+", select a username for yourself.");
          String usern = scan.next();
          People.add(new Player(usern));
        }
        while(true){
          if(People.size()==1){
            System.out.println(People.get(0).rusername()+" wins! Good job.");
            System.exit(0);
          }
          System.out.println(People.get(turn).rusername()+", it is your turn. The word so far is "+word+". Choose a letter wisely.");
          String add = scan.next();
          word += add.substring(0, 1);
          boolean j = true;
          System.out.println("Checking...");
          for(int i = 0; i<Words.size(); i++){
            if(Words.get(i).equalsIgnoreCase(word) && word.length()>3){
              System.out.println("Sorry, but that is a valid english word. Your score is at "+(People.get(turn).readscore()+1));
              word="";
              People.get(turn).addscore();
              j=false;
              break;
            }
            if(Words.get(i).length()>word.length() && Words.get(i).substring(0, word.length()).equalsIgnoreCase(word) && Words.get(i).length()>3){
              j=false;
            }
          }
          if(j){
            System.out.println("This does not start any word. Your score is "+(People.get(turn).readscore()+1));
            word="";
            People.get(turn).addscore();
          }
          if(People.get(turn).readscore()==5){
            System.out.println("And it's one, two, three, four, five strikes you're out, at the old, ghost, game!");
            People.remove(turn);
          }
          if(turn==People.size()-1){
            turn=0;
          }
          else{
            turn++;
          }
        }
    }
 
}