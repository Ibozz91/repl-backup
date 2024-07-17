import java.util.Scanner;
import java.util.ArrayList;
public class Main {
  public static void main(String[] args) {
    Scanner scamme=new Scanner(System.in);
    System.out.println("Welcome to hangman!");
    System.out.println("Player 1, please choose a word.");
    String Word = scamme.nextLine();
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
      for(int i=0; i<100; i++){
        System.out.println("");
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
        System.out.println("Player 2, guess a letter.");
        String guess=scamme.next();
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
}