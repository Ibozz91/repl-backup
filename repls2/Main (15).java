import java.util.Scanner;
import java.util.Random;
class Main {
  public static void main(String[] args){
    int difficulty;
    Scanner scan = new Scanner(System.in);
    boolean boo = false;
    String[] Punishments = {"Placeholder punishment I probably won't delete for humorous purposes", "Sing (veeery loudly)", "Moths", "Play the game in high contrast mode (ctrl-magnifying glass-h on a Chromebook)", "Steal your friend’s lunch and blame it on a 'time traveling cow that feasts on (insert name of lunch)'", "Jump out a window, If a window isn't available, jump over something and say it's a window.", "exploding sheeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeep", "say as many memes as you know in 10 seconds", "hey! Your heart stopped!", "You have an assignment due at midnight. You haven't done it yet and it's 11:59. Do it NOW!", "go raid the treasure trove that is your bathroom", "become a clickbait youtuber", "QWERTYUIOPASDFGHJKLZXCVBNMMNBVCXZLKJHGFDSAPOIUYTREWQZAQXSWCDEVFRBGTNHYMJUKILOPOLIKUJMYHNTGBRFVEDCWSXQAZ", "spin around until you feel nauseous", "speak", "say a word until it sounds weird, then use that word in every sentence", "Rickroll everybody", "Yell 'H!' at the top of your lungs and then continue your previous punishment", "Take a break from punishments", "Watch the grubhub ad that we all hate", "NARF, THE MUSICAL (sing about NARF)", "It's a me, Mario! Talka like me! YAHOO!", "you can only answer questions with more questions", "eat something", "why", "sing an annoying song", "talk like an 3p1c g@m3r bro", "do the opposite of this punishment: punch your face", "talk in a boring monotone voice", "remember why you decided to play this game in the first place", "spin around until something happens", "do a 3:00 AM CHALLENGE (NOT CLICKBAIT OMG)", "instead of a punishment for you, tell someone else to punch themselves in the face", "fill in the blank: I am a _____ who got stuck with this dumb __________ and now they are alll looking at __", "ask google how to win at Not A Random Fact (you must use the full title, not N.A.R.F)", "you're getting rickrolled! Never gonna give you up, never gonna let you down, never gonna run around and desert you, never gonna make you cry, never gonna say goodbye, never gonna tell a lie and hurt you!", "^* : _{}>:{?>:, }|_ /^&&%^*^%%&%", "Become the bone pharoah", "METTATON NO! METTATON YES!", "experience extreme deja vu", "H", "            no punishment here ._.", "go on an adventure!... to nowhere", "become 3p!( H@(k3r M@ns", "SanS UnDeRtAlE cHaLlAnGe At 3 Am GonE wRoNg No ClIcKbAiT!1!!!!!!11!!1!1!!!", "exxxperiance eextremme laaaaaggg *error, shutting down*", "Do T pose", "UH OH MY CAPS LOCK IS STUCK", "Have you been fingerprinted yet? It's fun, and it's free.", "Make a parody of star wars", "don't do vegetables", "No", "floor", "start screaming in monotone", "re-enact steamed hams", "drink the 'huckleberry juice' that my brother made, if you don’t have it, imagine you are drinking one, kudos if you don’t throw up", "this punishment was the last one written, what should it be…, oh, I know, PUNCH YOUR FACE IN THE FAAAAAAAAAAAACE!"};
    Question[] TrueFalseQuestions = {new Question("X-Rays can see through metal.", new String[]{"True", "False"}, 2), new Question("Mechanical waves can travel through vacuums.", new String[]{"True", "False"}, 2), new Question("Light waves are an example of mechanical waves.", new String[]{"True", "False"}, 2), new Question("Sound waves carry sound mechanically", new String[]{"True", "False"}, 1), new Question("There are many kinds of waves", new String[]{"True", "False"}, 1), new Question("People once thought that the eye shot lasers of light to see", new String[]{"True", "False"}, 1), new Question("An electromagnetic pulse is an electromagnetic wave", new String[]{"True", "False"}, 1), new Question("The speed of sound is 1000 mph", new String[]{"True", "False"}, 2), new Question("An electromagnetic wave can travel through space without a medium", new String[]{"True", "False"}, 1), new Question("There are two waves to an earthquake", new String[]{"True", "False"}, 1), new Question("A wave can be a combination of being transverse and longitudinal", new String[]{"True", "False"}, 1), new Question("Light is electromagnetic", new String[]{"True", "False"}, 1), new Question("We can't see gamma rays", new String[]{"True", "False"}, 1), new Question("Humans have 3 color sensors", new String[]{"True", "False"}, 1), new Question("The sea of tranquility has ocean waves", new String[]{"True", "False"}, 2), new Question("Microwaves are what microwaves use to heat up your food", new String[]{"True", "False"}, 1), new Question("The trough of the wave is pronounced 'troff'", new String[]{"True", "False"}, 1), new Question("X-rays can't pass through metal or bone", new String[]{"True", "False"}, 1), new Question("Electromagnetic waves do not need a medium to travel", new String[]{"True", "False"}, 1), new Question("The refraction of a wave is the bending of it", new String[]{"True", "False"}, 1), new Question("Tsunamis can be caused by a landslide", new String[]{"True", "False"}, 1), new Question("Sound travels fastest through gas", new String[]{"True", "False"}, 2), new Question("Amplitude affects wavelength", new String[]{"True", "False"}, 2), new Question("We can see all of the electromagnetic spectrum", new String[]{"True", "False"}, 2), new Question("Wavelengths are the difference between two troughs", new String[]{"True", "False"}, 1), new Question("The speed of light in a vacuum is constant", new String[]{"True", "False"}, 1), new Question("Light can be seen as a ray or a wave", new String[]{"True", "False"}, 1), new Question("There is no such thing as a sand wave", new String[]{"True", "False"}, 2), new Question("Ocean waves are mechanical", new String[]{"True", "False"}, 1), new Question("The color red has the shortest visible wavelength", new String[]{"True", "False"}, 2), new Question("The arecibo telescope is dead", new String[]{"True", "False"}, 1), new Question("Amplitude is 3/4 of the maximum displacement", new String[]{"True", "False"}, 2), new Question("A two-way radio uses far infrared light to communicate", new String[]{"True", "False"}, 2), new Question("A wave has a wattage", new String[]{"True", "False"}, 1)};
    Question[] MulQuestions = {new Question("The eye sees things...", new String[]{"Right side up", "Upside down", "Rotated left", "Rotated right"}, 2), new Question("Waves are chains of ____ molecules.", new String[]{"Still", "Fast", "Vibrating", "Slow"}, 3), new Question("The Krakatoa Volcano eruption in Indonesia made a 310 decibel sound wave that was heard as far as Antananarivo in Africa on which island east of the Mozambique Channel?", new String[]{"Sao Tome", "Cyprus", "Easter Island", "Madagascar"}, 4), new Question("Wave interactions can be...", new String[]{"Constructive", "Destructive", "Both 1 and 2", "None of these"}, 3), new Question("The longer the wavelength the ____ the color.", new String[]{"Redder", "Greener", "Purpler", "Oranger"}, 1), new Question("How many waves does an earthquake have?", new String[]{"1", "2", "3", "4"}, 2), new Question("How do longitudinal waves transport energy?", new String[]{"Going up and down", "Going left and right", "In a straight line"}, 3), new Question("The sun emits what type of light that we need sunscreen to stop us from getting sunburned?", new String[]{"UV", "UAV", "Sun-light", "H-light"}, 1), new Question("What is the measurement for frequency in transverse waves?", new String[]{"Newtons", "Freqs", "Watts", "Hertz"}, 4), new Question("Which famous tourist attraction in France has a lot of big radio antennae used to broadcast stuff around the world?", new String[]{"The Lovure", "Eiffel Tower", "French Riviera", "Côte d Azur"}, 2), new Question("Which of these waves need a medium to travel through?", new String[]{"Sound waves", "Seismic waves", "Water waves", "All of the above"}, 4), new Question("Wifi is what type of wave?", new String[]{"Seismic", "Radio", "Gamma", "Infrared", "None of the above"}, 2), new Question("Electrical outlets in your home have what type of wave?", new String[]{"AC", "DC", "Transverse", "Longitudinal"}, 3), new Question("How do tsunamis contrast from regular ocean waves?", new String[]{"They're generally much flatter", "They're generally much wider", "They extend deeper underneath the water's surface", "They contain much more debris"}, 3), new Question("What wave is bluetooth?", new String[]{"Radio UHF", "Radio ULF", "Microwave"}, 1), new Question("What is the highest wifi band?", new String[]{"9ghz", "2.4ghz", "5hz", "7ghz", "5.7ghz", "5ghz", "2.4hz"}, 6), new Question("Infrared was discovered on ____.", new String[]{"Purpose", "Accident", "A mix of both"}, 2), new Question("What is a normal human hearing range?", new String[]{"20hz-20khz", "100hz-100khz", "150khz-15000khz", "60hz-60khz"}, 1), new Question("Sound waves are...", new String[]{"Natural waves", "Mechanical waves", "Brain waves", "Spiritual waves"}, 2), new Question("Dogs can hear up to how many hertz?", new String[]{"1", "100,000", "1 million", "45,000"}, 4), new Question("What is the longest wavelength of any electromagnetic wave?", new String[]{"100,000 kilometers", "1 mile", "1 kilometer", "1 millimeter"}, 1), new Question("Birds see what type of light to hunt rodents down?", new String[]{"UV", "Visible light", "Infrared", "Gamma ray"}, 3), new Question("The human eye sees blue, red, and what other color?", new String[]{"Purple", "Green", "Orange", "Black"}, 2), new Question("Which electromagnetic wave has the shortest wavelength?", new String[]{"Gamma-ray", "Radio", "X-ray", "H-light"}, 1), new Question("The Tohoku tsunami and earthquake in 2011 caused what nuclear disaster?", new String[]{"Chernobyl", "Tohoku", "Fukushima", "Hokkiado"}, 3), new Question("Which cold current (aka a period of less thermal radiation from electromagnetic waves because they are colder) goes up the western coast of South America and brings penguins to the galapagos?", new String[]{"Benguela", "Chile", "Peru", "Gulf Stream"}, 3), new Question("William Röentgen found which type of wave that could go through human flesh but not bone?", new String[]{"X-ray", "Gamma ray", "Radio wave", "Infrared"}, 1), new Question("Which type of tsunami is usually caused by a large mass of rock falling into the ocean?", new String[]{"Bigtsunamis", "Rocktsunamis", "Landslidetsunamis", "Megatsunamis"}, 4), new Question("Sound waves move the fastest through which medium?", new String[]{"Solid", "Liquid", "Gas", "Air"}, 1), new Question("Why is it called an X-ray?", new String[]{"They were unknown to humans until recently", "X is a nice letter", "X is used as a variable in math", "All of the above"}, 1), new Question("What is the speed of light?", new String[]{"24567876545678765456789 m/s", "42745724392 m/s", "299792458 m/s", "1294561493 m/s"}, 3), new Question("What are the plates that meet in subduction zones?", new String[]{"Collections of debris from the ocean", "Huge slabs of concrete", "Chunks of lava from volcanoes", "Pieces of the earth's crust"}, 4), new Question("The higher the amplitude, the higher the what?", new String[]{"Energy", "Hertz", "Wavelength", "H-light"}, 1), new Question("Ocean waves are caused by tides, which are caused by which extraterrestrial body?", new String[]{"Jupiter", "Sun", "Moon", "Mars"}, 3), new Question("Why was the 2004 Indian Ocean Tsunami so powerful?", new String[]{"Lack of sensors", "Huge earthquake", "The sun heated the water", "Everybody though it was a hoax"}, 1)};
    FreeQuestion[] FreeForm = {new FreeQuestion("What is the measure for volume?", "Decibels"), new FreeQuestion("What type of wave is sound having to do with the energy and matter flow?", "Compressional"), new FreeQuestion("What is the lowest point on a wave?", "Trough"), new FreeQuestion("How many waves pass a given point in a period of time is what?", "Frequency"), new FreeQuestion("What is the most common measure for frequency?", "Hertz"), new FreeQuestion("What is another name for an expansion in a compressional wave?", "Rarefaction"), new FreeQuestion("Frequency is 1 over what?", "Period"), new FreeQuestion("Speed is frequency times what?", "Wavelength"), new FreeQuestion("What is the higest point on a wave?", "Crest"), new FreeQuestion("The wavelength can be measured by findng the distance between two crests or two of what?", "Trough"), new FreeQuestion("Tsunamis are usually caused by what event under the sea?", "Earthquake"), new FreeQuestion("Pitch is based on what?", "Frequency"), new FreeQuestion("Some animals in which biome can see more of the electromagnetic spectrum?", "Coral reef"), new FreeQuestion("Which electromagnetic wave has the longest wavelength?", "Radio"), new FreeQuestion("Mechanical waves need to travel through what?", "Medium"), new FreeQuestion("Matter goes in the same direction as energy in which type of wave?", "Compressional"), new FreeQuestion("How many continents have earthquakes been recorded in?", "7"), new FreeQuestion("What type of wave do analog devices use?", "Sine"), new FreeQuestion("Earthquake waves are the P-Wave and what?", "S-Wave"), new FreeQuestion("What type of wave do digital devices use?", "Square"), new FreeQuestion("Digital waves are interpreted as _____.", "1s and 0s"), new FreeQuestion("The difference between analog and digital is the type of what?", "Wave"), new FreeQuestion("Displacement is double the what?", "Amplitude"), new FreeQuestion("8-Tracks use what storage type?", "Analog"), new FreeQuestion("Most modern technology uses what storage type?", "Digital"), new FreeQuestion("Sound is what type of 'storage'?", "Analog"), new FreeQuestion("A microphone converts sound into what type of signal?", "Electrical"), new FreeQuestion("What type of wave has a longer wavelength than Gamma Rays, but a shorter one than UV?", "X-ray"), new FreeQuestion("Tsunami waves are like electromagnetic waves because they carry a lot of what?", "Energy"), new FreeQuestion("What type of wave is perceived for humans as heat?", "Far infrared"), new FreeQuestion("If you were on a boat in the ocean, why might it be hard to detect a tsunami?", "Gravity"), new FreeQuestion("Satellites use infrared to detect what?", "Weather"), new FreeQuestion("Colors depend on the structure of what?", "Molecules"), new FreeQuestion("Light can be seen as a wave or what?", "Ray"), new FreeQuestion("A sine wave is made using what mathematical function?", "Sin")};
    String[] board = new String[100];
    board[0] = "_";
    board[99] = "_";
    Random r = new Random();
    String[] types = {"B", "B", "_", "_", "_", "_"};
    System.out.println("You're in the kingdom of punishments, locked in the dungionment (hey a hybrid word!) you must escape the punishment master, his assistants are waiting at every punishment space, and he is very, very, very, very, very, very, very cruel. (he made us drink ‘huckleberry juice’) his kingdom looks like a large board (because he saw it in a board game and decided to use it), it's also turn based, anyway, ESCAPE! IF NOT YOU GOTTA DRINK MORE 'HUCKLEBERRY JUICE’! NOOOO HE’S TAKING ME BACK TO THE DUNGIONMENT TO DRINK THE JUICE! ESCAAAAAAAAAPE! Oh yeah he also asks questions about waves.\n");
    System.out.println("Welcome to N.A.R.F! (Not A Random Fact)\nDo you want to:\n\n1: Play the game\n2: Do not play the game :(\n3: Read the credits\n\n");
    int x = scan.nextInt();
    scan.nextLine();
    if(x==1){
      System.out.println("\nLet's go!\n");
    }
    else if(x==2){
      System.out.println("I had a really good game ready for you, but I guess you don't want to play it. :(");
      System.exit(0);
    }
    else if(x==3){
      System.out.println("\nGame programmmed by:\nIan Bozzuto\n\nGame designed by:\nEverett Walsh\n\nQuestions by:\nIan Bozzuto, Everett Walsh, Roman Gagliardi, and Nathan Hu\n");
    }
    System.out.println("Do you want to turn on the punishment wheel? (Recommended)");
    String punish = scan.nextLine();
    if(punish.equalsIgnoreCase("upupdowndownleftrightleftrightbastart")){
      System.out.println("Congratulations! You win nothing.");
    }
    System.out.println("How many players will be playing today?");
    int players = scan.nextInt();
    scan.nextLine();
    if(players==0){
      System.out.println("You're done!");
      System.exit(0);
    }
    else if(players<0){
      System.out.println("You know, I was planning to just make a joke and end the program if you type a negative number. But, if you really want me to...");
      String s = scan.nextLine();
      if(!s.equalsIgnoreCase("yes")){
        System.exit(0);
      }
      System.out.println("Remember, you brought this upon yourself.");
    }
    Player[] Plyrs = new Player[players];
    if(punish.equalsIgnoreCase("yes")){
      types[0] = "P";
    }
    for(int i = 1; i < 99; i++){
      board[i] = types[r.nextInt(types.length)];
    }
    for(int i = 1; i <= players; i++){
      System.out.println("What will be the name or username of Player " + i + "?");
      Plyrs[i-1]=new Player(scan.nextLine());
    }
    int turn = 0;
    while(true){
      System.out.println("It is "+Plyrs[turn].rusername()+"'s turn!");
      for(int i = 0; i<100; i++){
        if(i==Plyrs[turn].readboard()){
          System.out.print("Y ");
        }
        else{
          System.out.print(board[i]+" ");
        }
        if((((i+1)/10)*10)==(i+1) && i!=0){
          System.out.println("");
        }
      }
      System.out.println("Type literally anything and press enter to roll the dice");
      scan.nextLine();
      int roll = r.nextInt(3)+1;
      System.out.println("You rolled "+roll+". Time to answer a question!");
      System.out.println("What difficulty question do you want to select?\n1: True/False\n2: Multiple choice\n3: Free Form");
      difficulty = scan.nextInt();
      scan.nextLine();
      if(difficulty==1){
        boo = AnswerQuestion(TrueFalseQuestions[r.nextInt(TrueFalseQuestions.length)], scan);
      }
      else if(difficulty==2){
        boo = AnswerQuestion(MulQuestions[r.nextInt(MulQuestions.length)], scan);
      }
      else{
        difficulty=3;
        boo = AnswerFreeQuestion(FreeForm[r.nextInt(FreeForm.length)], scan);
      }
      if(boo){
        Plyrs[turn].changeboard(roll*(difficulty+1));
        if(Plyrs[turn].readboard()>=99){
          System.out.println(Plyrs[turn].rusername()+" wins! gg.");
          System.exit(0);
        }
        System.out.println("You got it right!");
      }
      else{
        Plyrs[turn].changeboard(roll);
        if(Plyrs[turn].readboard()>=99){
          System.out.println(Plyrs[turn].rusername()+" wins! gg.");
          System.exit(0);
        }
        if(punish.equalsIgnoreCase("yes")){
          System.out.println("Punishment time! Do this task (or read this weird phrase):\n"+Punishments[r.nextInt(Punishments.length)]);
        }
      }
      for(int i = 0; i<100; i++){
        if(i==Plyrs[turn].readboard()){
          System.out.print("Y ");
        }
        else{
          System.out.print(board[i]+" ");
        }
        if((((i+1)/10)*10)==(i+1) && i!=0){
          System.out.println("");
        }
      }
      boolean h = true;
      while(h){
        if(board[Plyrs[turn].readboard()].equals("P")){
          System.out.println("You are on a Punishment space!\nPunishment time! Do this task (or read this weird phrase):\n"+Punishments[r.nextInt(Punishments.length)]);
        }
        else if(board[Plyrs[turn].readboard()].equals("B")){
          int advance = r.nextInt(10)+1;
          System.out.println("You are going forward "+advance+" spaces.");
          System.out.println("Type something and press enter to continue.");
          scan.nextLine();
          Plyrs[turn].changeboard(advance);
          if(Plyrs[turn].readboard()>=99){
            System.out.println(Plyrs[turn].rusername()+" wins! gg.");
            System.exit(0);
          }
          for(int i = 0; i<100; i++){
            if(i==Plyrs[turn].readboard()){
              System.out.print("Y ");
            }
            else{
              System.out.print(board[i]+" ");
            }
            if((((i+1)/10)*10)==(i+1) && i!=0){
              System.out.println("");
            }
          }
          continue;
        }
        else{
          System.out.println("You are on a boring old space.");
        }
        h=false;
      }
      System.out.println("Type something and press enter to continue.");
      scan.nextLine();
      if(turn==Plyrs.length-1){
        turn=0;
      }
      else{
        turn++;
      }
      System.out.println("\n\n\n\n");
    }
  }
  public static boolean AnswerQuestion(Question quess, Scanner scan){
    System.out.println(quess.quest()+"\n");
    for(int i = 1; i < quess.answ().length+1; i++){
      System.out.println(i+": "+quess.answ()[i-1]);
    }
    if(scan.nextInt()==quess.corans()){
      scan.nextLine();
      return true;
    }
    scan.nextLine();
    System.out.println("Sorry, the correct answer was "+quess.corans());
    return false;
  }
  public static boolean AnswerFreeQuestion(FreeQuestion aqu, Scanner scan){
    System.out.println(aqu.gq());
    if(scan.nextLine().equalsIgnoreCase(aqu.ga())){
      return true;
    }
    else{
      System.out.println("The correct answer was "+aqu.ga()+". Do you want to override?");
      if(scan.nextLine().equalsIgnoreCase("yes")){
        return true;
      }
      else{
        return false;
      }
    }
  }
}