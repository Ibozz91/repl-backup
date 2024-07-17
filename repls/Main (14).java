import java.io.IOException;
import java.util.TimeZone;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
class Main {
  public static void main(String[] args) throws InterruptedException, IOException{
    Scanner Scan = new Scanner(System.in);
    System.out.println("What time zone do you live in?");
    String yuiguk = new String(Scan.next());
    SimpleDateFormat googleform = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
    googleform.setTimeZone(TimeZone.getTimeZone(yuiguk));
    while(true){
      TimeUnit.SECONDS.sleep(1);
      System.out.print("\033[H\033[2J");
      System.out.flush();
      String hhh = googleform.format(new Date());
      System.out.println(hhh);
    }
  }
}