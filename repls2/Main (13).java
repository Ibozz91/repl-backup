import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) throws FileNotFoundException,IOException{
    
    Random ran = new Random();
   File names = new File("names.txt");
   ArrayList<String> Words = new ArrayList<String>();
   BufferedReader in = new BufferedReader(new FileReader(names));
    String line;
    while ((line = in.readLine()) != null) {
      Words.add(line);
    }

    String[] crew = {"red", "blue", "green", "yellow", "black", "white","orange","cyan","pink"};
 
  
    int taskscomp=8;
    int lifecount=10;
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Welcome to Among Us by bradyeldredge31! (Original game by Innersloth)");
    System.out.println("This is an older version of https://repl.it/@bradyeldredge31/amongus?embed=1&output=1.");
    
    System.out.println("Let's start the game.");
    int role = ran.nextInt(5);
       boolean crewmategame = true;
     while (crewmategame = true){
       System.out.println("Crewmate");
        System.out.println("There is one Impostor among us...");
        int x = ran.nextInt(9);
        String impostor = crew[x];
        String impname = Words.get(ran.nextInt(Words.size()));
        System.out.println("You are in the cafeteria. Everyone heads off in different directions."); 
      boolean bool = true;
        while(bool == true){
        if(lifecount<2){
          System.out.println("Defeat");
          System.out.println("The impostor killed enough crewmates.");
          System.out.println("The impostor's color was "+impostor+".");
          System.exit(0);
        }
       System.out.println("Would you like to attempt any tasks?"); 
        String task=scan.next();

    
      if (task.equalsIgnoreCase("yes")){
        int taskormeeting = ran.nextInt(2);
        if (taskormeeting == 0){

        
        System.out.println("Alright, it's task time! Unscramble the word below.");
        int unscramble = ran.nextInt(10);
        if (unscramble == (0)){
          System.out.println("sweri");
        }
        if (unscramble == (1)){
             System.out.println("nogxye");
        }
        if (unscramble == (2)){
             System.out.println("mcsom");
        }
        
        if (unscramble == (3)){
             System.out.println("imadn");
        }
        if (unscramble == (4)){
             System.out.println("wdnldooa");
        }
        if (unscramble == (5)){
             System.out.println("upldao");
        }
        if (unscramble == (6)){
             System.out.println("aembdy");
        }
        if (unscramble == (7)){
             System.out.println("aweopsn");
        }
        if (unscramble == (8)){
            System.out.println("aavtiniog");
        }
        if (unscramble == (9)){
             System.out.println("rrcatoe");
        }


        String answer = scan.next();
        if (answer.equalsIgnoreCase("wires")|| answer.equalsIgnoreCase("oxygen")|| answer.equalsIgnoreCase("upload")||answer.equalsIgnoreCase("navigation")||answer.equalsIgnoreCase("download")||answer.equalsIgnoreCase("weapons")||answer.equalsIgnoreCase("admin")||answer.equalsIgnoreCase("medbay")||answer.equalsIgnoreCase("comms")||answer.equalsIgnoreCase("reactor")){
          System.out.println("Good Job! One task completed! "+taskscomp+" tasks remaining!");
          taskscomp-=1;
             if(taskscomp==-1){
               System.out.print("You won! good job!");
               bool= false;
               System.exit(0);
             }
             else{
              System.out.println("The crewmates has not finished their tasks yet.");
            }
           
        }
        else{
          System.out.println("That task is to hard for you. Better luck next time.");
        }
        }
      

          
        if (taskormeeting == 1){
            System.out.println("meeting time!");
            int dead = ran.nextInt(3);
            System.out.println(dead+" crewmates have been killed this round.");
            lifecount = lifecount - dead; 
            System.out.println(lifecount+" crewmates are alive");
            
            int sus = ran.nextInt (3);
            if (sus == 2){ 
               Words.get(ran.nextInt(Words.size()));
               
              System.out.println("the crew wants to vote out a suspicious player. You have the deciding vote. would you like to vote them out? type Yes or No");
              String voting = scan.next();
              if (voting.equalsIgnoreCase("Yes")){
              int ran_eject = ran.nextInt(9);
              
              if (crew[ran_eject].equals(impostor)){
               
                System.out.println(Words.get(ran.nextInt(Words.size())) +" was the Impostor.");
                bool = false;
                System.exit(0);
           
              }
              else{
                System.out.println(Words.get(ran.nextInt(Words.size())) +" was not the Impostor.");
                lifecount-=1;
            }
            }
            
            if (voting.equalsIgnoreCase("No")){
            System.out.println("Vote Skipped.");
            }
            }
            if (sus == 1){
              Words.get(ran.nextInt(Words.size()));
              System.out.println("the crew wants to vote out a suspicious player. They vote them out.");
               int ran_eject = ran.nextInt(5);
              
             if (crew[ran_eject].equals(impostor)){
               
               System.out.println(Words.get(ran.nextInt(Words.size())) +" was the Impostor.");
                bool = false;
                System.exit(0);
           
              }
              else{
                System.out.println(Words.get(ran.nextInt(Words.size())) +" was not the Impostor.");
                lifecount-=1;
              }
              

              
              }
            
          
        if (sus == 0){
          System.out.println("The vote is skipped.");

        }
            
        
        
         
            
            

            
        
        }
      }
        
      

      else if (task.equalsIgnoreCase("no")){
        System.out.println("you decide to take on the role of the detective. After checking security,  admin panel, and generally snooping around you find");

        int detect = ran.nextInt(4);
        if (detect == 0){
          System.out.println("a body! ");
          lifecount--;
          int bodysuspect = ran.nextInt(2);
           if(bodysuspect == 1){
            System.out.println("you reported it, but you had no leads.");  
            }
            if(bodysuspect == 0){
            System.out.println("You saw the Impostor kill him!");
            int belive = ran.nextInt(2);
            if(belive == 1){
            System.out.println("They didn't believe you. ");
            }     
            else {
              System.out.println("They believed you! Good job! The Impostor was ejected. "); 
              bool = false;
              System.exit(0);

            }
          }
           }
              
         
         
      
        if (detect == 1){
          System.out.println("nothing yet.");

          }
        
        if (detect == 2){
          System.out.println("someone is following you. would you like to ignore?");
           String ignore=scan.next();
           if(ignore.equalsIgnoreCase("yes")){
              int kill = ran.nextInt(2);
              if(kill == 1){
                System.out.println("you were killed by "+impostor+"!");
                if (taskscomp <= 2){
                  System.out.println("The crewmates still won! VICTORY");
                  bool = false;
                  System.exit(0);
                }
                   else{
                  System.out.println("The Impostor won.");
                  System.exit(0);
                }
                
              }
                if (kill == 0){
                  System.out.print("You ignore them, and nothing happens to you.");
                }
           }

            if (ignore.equalsIgnoreCase("no")){
              System.out.println("you decide to stay away from them. You call a meeting and tell them to not follow you. You are safe. This wasted some time, though.");
              taskscomp+=1;
            }
              }
              

           

        
          if (detect == 3){
            System.out.println("meeting time!");
            int dead1 = ran.nextInt(3);
            System.out.println(dead1+" crewmates have been killed this round."); 
            lifecount = lifecount - dead1; 
             System.out.println(lifecount+" crewmates are alive.");
           
            int sus1 = ran.nextInt (3);
            if (sus1 == 2){ 
              System.out.println("the crew wants to vote out a suspicious player. You have the deciding vote. would you like to vote them out or skip? type Yes or No");
              String voting = scan.next();
              if (voting.equalsIgnoreCase("Yes")){ 
              int ran_eject = ran.nextInt(9);
              
              if (crew[ran_eject].equals(impostor)){
               
               System.out.println(Words.get(ran.nextInt(Words.size())) +" was the Impostor.");
                bool = false;
                System.exit(0);
           
              }
              else{
               System.out.println(Words.get(ran.nextInt(Words.size())) +" was not the Impostor.");
                lifecount-=1;
              }
            }
            
            if (voting.equalsIgnoreCase("No")){
            System.out.println("Vote Skipped.");
            }
            }
            if (sus1 == 1){
              System.out.println("the crew wants to vote out a suspicious player. They vote them out.");
             int ran_eject = ran.nextInt(5);
              if (crew[ran_eject].equals(impostor)){
               System.out.println(Words.get(ran.nextInt(Words.size())) +" was the Impostor.");
                bool = false;
                System.exit(0);
           
              }
              else{
               System.out.println(Words.get(ran.nextInt(Words.size())) +" was not the Impostor.");
                lifecount-=1;
              }
              

              
              }
               
        if (sus1 == 0){
          System.out.println("the vote is skipped.");
        }
          } 

           if (detect == 4){
           System.out.println("you were killed by "+impostor+"!");
                if (taskscomp <= 2){
                  System.out.println("The crewmates still won! VICTORY");
                  bool = false;
                  System.exit(0);
                }
                   else{
                  System.out.println("The Impostor won.");
                  
                  System.exit(0);
                }
                
              }
           
          }
        
       }
     }
    }
   
        
  }