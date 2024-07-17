/*





Hello!







Press the Run button to run the program.


























*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class Main {
  public static void main(String[] args) throws MalformedURLException, IOException {
    String theurl = "";
    Scanner scamme=new Scanner(System.in);
    System.out.println("Would you like to use a custom word list to replace \"All words\"?\n1:Yes\n2:No");
    int shh = scamme.nextInt();
    scamme.nextLine();
    if(shh==1){
      System.out.println("Please link to the plain text word list (words are seperated by a new line)");
      theurl=scamme.nextLine();
    }
    else{
      theurl = "https://raw.githubusercontent.com/dwyl/english-words/master/words.txt";
    }
    System.out.println("Setting up... (Please wait)");
    ArrayList<String> Words = new ArrayList<String>();
    URL url = new URL (theurl);

    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

    String line;
    while ((line = in.readLine()) != null) {
      Words.add(line.toLowerCase());
    }
    System.out.println("More than halfway done! Setting up common words...");
    ArrayList<String> CommonWords = new ArrayList<String>();
    URL url2 = new URL ("https://splasho.com/upgoer5/phpspellcheck/dictionaries/1000.dicin");

    BufferedReader in2 = new BufferedReader(new InputStreamReader(url2.openStream()));

    String line2;
    while ((line2 = in2.readLine()) != null) {
      CommonWords.add(line2);
    }
    in2.close();
    Random randy = new Random();
    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    HashMap<String, Integer> hmm = new HashMap<String, Integer>();
    ArrayList<String> RemWords = new ArrayList<String>();
    System.out.println("Welcome to hangman!");
    System.out.println("Select:\n1: For a human being\n2: For an AI");
    String Word = "";
    boolean aiguess = false;
    int h = scamme.nextInt();
    scamme.nextLine();
    if(h==1){
      System.out.println("Player 1, please choose a word.");
      Word = scamme.nextLine();
      boolean b = true;
      for(int i = 0; i < Words.size(); i++){
        if(Words.get(i).equalsIgnoreCase(Word)){
          b = false;
        }
      }
      if(b){
        System.out.println("Hey wait, that's not a word!");
        System.exit(0);
      }
    }
    else{
      System.out.println("Do you want the AI to:\n1: Choose, or\n2: Guess");
      int cog = scamme.nextInt();
      scamme.nextLine();
      if(cog==1){
        System.out.println("Do you want it to choose from:\n1: Common Words (recommended)\n2: All Words");
        int chofro = scamme.nextInt();
        scamme.nextLine();
        if(chofro==1){
          Word = CommonWords.get(randy.nextInt(CommonWords.size()));
        }
        else{
          Word = Words.get(randy.nextInt(Words.size()));
        }
      }
      else{
        aiguess = true;
        CreateHashmap(hmm, alphabet);
        System.out.println("Okay, choose a word.");
        Word = scamme.next();
        boolean b = true;
        for(int i = 0; i < Words.size(); i++){
          if(Words.get(i).equalsIgnoreCase(Word)){
            b = false;
          }
        }
        if(b){
          System.out.println("Hey wait, that's not a word!");
          System.exit(0);
        }
        for(int i = 0; i < Words.size(); i++){
          RemWords.add(Words.get(i));
        }
      }
    }
    for(int i=0; i<100; i++){
      System.out.println("");
    }
    String[] Lines = new String[Word.length()];
    ArrayList<String> IncorrectGuesses=new ArrayList<String>();
    for(int i=0; i<Word.length(); i++){
      if(Word.substring(i, i+1).equalsIgnoreCase("a") || Word.substring(i, i+1).equalsIgnoreCase("b") || Word.substring(i, i+1).equalsIgnoreCase("c") || Word.substring(i, i+1).equalsIgnoreCase("d") || Word.substring(i, i+1).equalsIgnoreCase("e") || Word.substring(i, i+1).equalsIgnoreCase("f") || Word.substring(i, i+1).equalsIgnoreCase("g") || Word.substring(i, i+1).equalsIgnoreCase("h") || Word.substring(i, i+1).equalsIgnoreCase("i") || Word.substring(i, i+1).equalsIgnoreCase("j") || Word.substring(i, i+1).equalsIgnoreCase("k") || Word.substring(i, i+1).equalsIgnoreCase("l") || Word.substring(i, i+1).equalsIgnoreCase("m") || Word.substring(i, i+1).equalsIgnoreCase("n") || Word.substring(i, i+1).equalsIgnoreCase("o") || Word.substring(i, i+1).equalsIgnoreCase("p") || Word.substring(i, i+1).equalsIgnoreCase("q") || Word.substring(i, i+1).equalsIgnoreCase("r") || Word.substring(i, i+1).equalsIgnoreCase("s") || Word.substring(i, i+1).equalsIgnoreCase("t") || Word.substring(i, i+1).equalsIgnoreCase("u") || Word.substring(i, i+1).equalsIgnoreCase("v") || Word.substring(i, i+1).equalsIgnoreCase("w") || Word.substring(i, i+1).equalsIgnoreCase("x") || Word.substring(i, i+1).equalsIgnoreCase("y") || Word.substring(i, i+1).equalsIgnoreCase("z")){
        Lines[i]="_";
      }
      else{
        Lines[i]=Word.substring(i, i+1);
      }
    }
    boolean poiop=true;
    while(poiop==true){
      if(aiguess){
        ClearHashmap(hmm, alphabet);
      }
      else{
        for(int i=0; i<100; i++){
          System.out.println("");
        }
      }
      boolean yo=true;
      for(String i: Lines){
        System.out.print(" "+i);
        if(i.equals("_")){
          yo=false;
        }
      }
      System.out.print("\n\nIncorrect Guesses:");
      for(String i: IncorrectGuesses){
        System.out.print(" "+i);
      }
      System.out.println("");
      if(yo){
        System.out.println("Player 2 won by guessing the word!");
        poiop=false;
      }
      else if(IncorrectGuesses.size()>5){
        System.out.println("Player 1 won by having Player 2 make 6 incorrect guesses! The word was "+Word+".");
        poiop=false;
      }
      else{
        boolean invalidmove=false;
        String guess = "";
        if(aiguess){
          System.out.println("The ai (Player 2) is thinking...");
          removeinv(Lines, RemWords, IncorrectGuesses, alphabet);
          tally(RemWords, hmm, alphabet);
          guess=CompareHashmap(hmm, alphabet);
          System.out.println("The ai guessed "+guess+" between "+RemWords.size()+" words with "+((hmm.get(guess)*100)/RemWords.size())+"% confidence.\n\n");
          hmm.remove(guess);
        }
        else{
          System.out.println("Player 2, guess a letter.");
          guess=scamme.next();
        }
        System.out.println("");
        if(!(guess.equalsIgnoreCase("a") || guess.equalsIgnoreCase("b") || guess.equalsIgnoreCase("c") || guess.equalsIgnoreCase("d") || guess.equalsIgnoreCase("e") || guess.equalsIgnoreCase("f") || guess.equalsIgnoreCase("g") || guess.equalsIgnoreCase("h") || guess.equalsIgnoreCase("i") || guess.equalsIgnoreCase("j") || guess.equalsIgnoreCase("k") || guess.equalsIgnoreCase("l") || guess.equalsIgnoreCase("m") || guess.equalsIgnoreCase("n") || guess.equalsIgnoreCase("o") || guess.equalsIgnoreCase("p") || guess.equalsIgnoreCase("q") || guess.equalsIgnoreCase("r") || guess.equalsIgnoreCase("s") || guess.equalsIgnoreCase("t") || guess.equalsIgnoreCase("u") || guess.equalsIgnoreCase("v") || guess.equalsIgnoreCase("w") || guess.equalsIgnoreCase("x") || guess.equalsIgnoreCase("y") || guess.equalsIgnoreCase("z"))){
          invalidmove=true;
        }
        for(String i: Lines){
          if(guess.equalsIgnoreCase(i)){
            invalidmove=true;
          }
        }
        for(String i: IncorrectGuesses){
          if(guess.equalsIgnoreCase(i)){
            invalidmove=true;
          }
        }
        if(!invalidmove){
          boolean incorrect=true;
          for(int i=0; i<Word.length(); i++){
            if(Word.substring(i, i+1).equalsIgnoreCase(guess)){
              incorrect=false;
              Lines[i]=guess;
            }
          }
          if(incorrect){
            IncorrectGuesses.add(guess);
          }
        }
      }
    }
    scamme.close();
  }
  public static void ClearHashmap(HashMap<String, Integer> map, String[] alpha){
    for(String s: alpha){
      if(map.containsKey(s)){
        map.replace(s, 0);
      }
    }
  }
  public static void CreateHashmap(HashMap<String, Integer> map, String[] alpha){
    for(String s: alpha){
      map.put(s, 0);
    }
  }
  public static String CompareHashmap(HashMap<String, Integer> map, String[] alpha){
    int letterval = -1;
    String letter = "error";
    for(String s: alpha){
      if(map.containsKey(s) && map.get(s)>letterval){
        letterval=map.get(s);
        letter=s;
      }
    }
    return letter;
  }
  public static void removeinv(String[] SoFar, ArrayList<String> RemWords, ArrayList<String> IncGuesses, String[] alpha){
    int add = 1;
    for(int i = 0; i<RemWords.size(); i+=add){
      add = 1;
      if(RemWords.get(i).length()!=SoFar.length){
        RemWords.remove(i);
        add=0;
      }
      else{
        boolean removed = false;
        for(int in = 0; in < IncGuesses.size(); in++){
          if((!removed) && RemWords.get(i).contains(IncGuesses.get(in))){
            RemWords.remove(i);
            add=0;
            removed = true;
          }
        }
        if(!removed){
          ArrayList<String> CorrectGuesses = new ArrayList<String>();
          for(int intt = 0; intt < SoFar.length; intt++){
            if(SoFar[intt]!="_"){
              CorrectGuesses.add(SoFar[intt]);
            }
          }
          for(int intt = 0; intt < SoFar.length; intt++){
            if(!(SoFar[intt]=="_" || RemWords.get(i).substring(intt, intt+1).equalsIgnoreCase(SoFar[intt])) || (SoFar[intt] == "_" && (CorrectGuesses.contains(RemWords.get(i).substring(intt, intt+1)) || !Arrays.asList(alpha).contains(RemWords.get(i).substring(intt, intt+1))))){
              RemWords.remove(i);
              add=0;
              break;
            }
          }
        }
      }
    }
  }
  public static void tally(ArrayList<String> RemWords, HashMap<String, Integer> hashm, String[] alphab){
    for(String s: alphab){
      if(hashm.containsKey(s)){
        for(int i = 0; i < RemWords.size(); i++){
          if(RemWords.get(i).contains(s)){
            hashm.replace(s, hashm.get(s)+1);
          }
        }
      }
    }
  }
}