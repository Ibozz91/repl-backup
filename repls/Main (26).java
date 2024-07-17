import java.util.Scanner;
import java.util.Random;
import org.apache.commons.lang3.time.*;
class Main {
  public static void main(String[] args) {
    StopWatch thewatchisstopped = new StopWatch();
    boolean fc=true;
    int flagcount=0;
    Scanner Scan = new Scanner(System.in);
    Random r = new Random();
    System.out.println("Minesweeper\n1: Beginner\n2: Intermediate\n3: Expert\n4: Custom");
    int choice = Scan.nextInt();
    Scan.nextLine();
    int len=-1;
    int wid=-1;
    int mines=-1;
    if(choice==1){
      len=9;
      wid=9;
      mines=10;
    }
    else if(choice==2){
      len=16;
      wid=16;
      mines=40;
    }
    else if(choice==3){
      len=16;
      wid=30;
      mines=99;
    }
    else{
      System.out.println("Select height.");
      len=Scan.nextInt();
      Scan.nextLine();
      System.out.println("Select width.");
      wid=Scan.nextInt();
      Scan.nextLine();
      System.out.println("Select amount of mines.");
      mines=Scan.nextInt();
      Scan.nextLine();
      if(mines<=0){
        System.out.println("Congration! The board is already solved!");
        System.exit(0);
      }
      else if(mines==len*wid){
        System.out.println("Impossible (google first click protection)");
        String newresponsejustdropped = Scan.nextLine();
        if(newresponsejustdropped.equalsIgnoreCase("holy hell")){
          System.out.println("Are you kidding ??? What the **** are you talking about man ? You are a biggest looser i ever seen in my life ! You was doing PIPI in your pampers when i was beating boards much more stronger then this! You are not proffesional, because proffesionals knew how to lose and congratulate mines, you are like a girl crying after you blew up! Be brave, be honest to yourself and stop this trush talkings!!! Everybody know that i am very good minesweeper player, i can win any custom board in single game! And \"b\"ill \"g\"ates is nobody for me, just a player who are crying every single time when loosing, ( remember what you say about 8 tile ) !!! Stop playing with my name, i deserve to have a good name during whole my minesweeper carrier, I am Officially inviting you to Arena match with the Prize fund! Both of us will invest 5000 minecoins and winner takes it all! I suggest all other people who's intrested in this situation, just take a look at my results in the previous seasons, and that should be enough… No need to listen for every crying babe, Smiley Face is always play Fair ! And if someone will continue Officially talk about me like that, we will meet in Court! God bless with true! True will never die ! Liers will kicked off...");
        }
        System.exit(0);
      }
      else if(mines>len*wid){
        System.out.println("The additional mines could not be placed so they are shoved down your throat");
        System.exit(0);
      }
    }
    String[][] field1 = new String[len][wid];
    for(int weu = 0; weu < len; weu++){
      for(int i = 0; i < wid; i++){
        field1[weu][i]="_";
      }
    }
    String[][] field2 = new String[len][wid];
    for(int weu = 0; weu < len; weu++){
      for(int i = 0; i < wid; i++){
        field2[weu][i]="_";
      }
    }
    for(int i = 0; i < mines; i++){
      while(true){
        int l = r.nextInt(len);
        int w = r.nextInt(wid);
        if(field2[l][w]=="_"){
          field2[l][w]="B";
          break;
        }
      }
    }
    while(true){
      boolean booland = true;
      for(int i = 0; i < len; i++){
        for(int in = 0; in < wid; in++){
          if((field1[i][in]=="_" || field1[i][in]=="F") && field2[i][in]=="_"){
              booland=false;
            }
          }
        }
        if(booland){
          thewatchisstopped.stop();
          long result = thewatchisstopped.getTime();
          System.out.println("You win! It took a total of "+(result/1000.0)+" seconds.");
          for(String[] String1: field1){
            for(String String2: String1){
              if(String2.equals("_")){
                System.out.print("F ");
              }
              else{
                System.out.print(String2+" ");
              }
            }
            System.out.println();
          }
          System.exit(0);
        }
      System.out.print("    ");
      for(Integer i = 0; i < wid; i++){
        System.out.print(i.toString().substring(i.toString().length()-1, i.toString().length())+" ");
      }
      System.out.println("");
      Integer col = 0;
      for(String[] String1: field1){
        System.out.print("\n"+col.toString().substring(col.toString().length()-1, col.toString().length())+"   ");
        col++;
        for(String String2: String1){
          System.out.print(String2+" ");
        }
      }
      System.out.println("\n"+(mines-flagcount)+" mines remaining. F to flag/unflag, U to uncover, C to chord.");
      String lol = Scan.nextLine();
      if(lol.equalsIgnoreCase("U")){
        System.out.println("Row?");
        int ro = Scan.nextInt();
        Scan.nextLine();
        System.out.println("Column?");
        int c = Scan.nextInt();
        Scan.nextLine();
        if(fc){
          thewatchisstopped.start();
        }
        uncover(field1, field2, ro, c, fc);
        fc=false;
      }
      else if(lol.equalsIgnoreCase("F")){
        System.out.println("Row?");
        int ro = Scan.nextInt();
        Scan.nextLine();
        System.out.println("Column?");
        int c = Scan.nextInt();
        Scan.nextLine();
        if(field1[ro][c]=="_"){
          field1[ro][c]="F";
          flagcount++;
        }
        else if(field1[ro][c]=="F"){
          field1[ro][c]="_";
          flagcount--;
        }
      }
      else if(lol.equalsIgnoreCase("C")){
        System.out.println("Row?");
        int ro = Scan.nextInt();
        Scan.nextLine();
        System.out.println("Column?");
        int c = Scan.nextInt();
        Scan.nextLine();
        if(!(field1[ro][c]=="_" || field1[ro][c]=="F")){
          int hi = 0;
          for(int i=ro-1; i<ro+2; i++){
            for(int in=c-1; in<c+2; in++){
              try{
                if(field1[i][in]=="F"){
                  hi++;
                }
              }
              catch(Exception ArrayIndexOutOfBoundsException){

              }
            }
          }
          if(Integer.parseInt(field1[ro][c])==hi){
            for(int i=ro-1; i<ro+2; i++){
              for(int in=c-1; in<c+2; in++){
                try{
                  uncover(field1, field2, i, in, false);
                }
                catch(Exception ArrayIndexOutOfBoundsException){
                  
                }
              }
            }
          }
        }
      }
    }
  }
  public static void uncover(String[][] board, String[][] otherboard, int a, int b, boolean firstclick){
    if(board[a][b]!="_"){
      return;
    }
    if(otherboard[a][b]=="B"){
      if(firstclick){
        Random r = new Random();
        while(true){
          int l = r.nextInt(board.length);
          int w = r.nextInt(board[0].length);
          if(otherboard[l][w]=="_"){
            otherboard[l][w]="B";
            otherboard[a][b]="_";
            break;
          }
        }
      }
      else{
        System.out.println("You blew up.");
        System.exit(0);
      }
    }
    firstclick=false;
    int h = 0;
    for(int i=a-1; i<a+2; i++){
      for(int in=b-1; in<b+2; in++){
        try{
          if(otherboard[i][in]=="B"){
            h++;
          }
        }
        catch(Exception ArrayIndexOutOfBoundsException){

        }
      }
    }
    board[a][b]=Integer.toString(h);
    if(h==0){
      for(int i=a-1; i<a+2; i++){
        for(int in=b-1; in<b+2; in++){
          try{
            uncover(board, otherboard, i, in, false);
          }
          catch(Exception ArrayIndexOutOfBoundsException){

          }
        }
      }
    }
  }
}