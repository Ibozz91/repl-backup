import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    while(true){
      Scanner scan=new Scanner(System.in);
      System.out.print("Convert ");
      long nnn=scan.nextLong();
      System.out.print("To base ");
      int base=scan.nextInt();
      System.out.println(BaseConverter(base, nnn));
      System.out.println("Do you want to run again?");
      String again=scan.next();
      if(again.equalsIgnoreCase("n") || again.equalsIgnoreCase("no")){
        System.exit(0);
      }
      else if(!(again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y"))){
        System.out.println("Um... Hmm... You know what? I'll just continue for you.");
      }
    }
  }
  public static long BaseConverter(int base, long n){
    if(base<2 || n<1 || base>10){
      return -1;
    }
    long totalnum=0;
    for(int i=0; i<n; i++){
      totalnum=AddOneToBase(base, totalnum);
    }
    return totalnum;
  }
  public static long AddOneToBase(int base, long num){
    if(String.valueOf(num).length()==1){
      if(num==(base-1)){
        return 10;
      }
      else{
        return num+1;
      }
    }
    else{
      if(Long.parseLong(String.valueOf(num).substring(String.valueOf(num).length()-1))==base-1){
        num -= base-1;
        return AddOneToBase(base, num/10)*10;
      }
      else{
        return num+1;
      }
    }
  }
}