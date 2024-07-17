import java.util.ArrayList;
//I think that I should abandon this; save data numbers seem like a gimmick.
class Main {
  public static void main(String[] args) {
    ArrayList<Integer> test = new ArrayList<Integer>();
    System.out.println(SaveNumber("a",0,test,0,0,0,0));
  }
  public static String SaveNumber(String name, int cash, ArrayList<Integer> items, int weapon, int health, int maxhealth, int loc){
    String num="";
    num=num+String.valueOf(Integer.parseInt(StringtoHex(name), 16));
    num=num+String.valueOf(cash);
    num=num+String.valueOf(items.size());
    for(int i: items){

    }
    return num;
  }
  public static String StringtoHex(String str){
    StringBuffer sb = new StringBuffer();
    //Converting string to character array
    char ch[] = str.toCharArray();
    for(int i = 0; i < ch.length; i++) {
      String hexString = Integer.toHexString(ch[i]);
      sb.append(hexString);
    }
    String result = sb.toString();
    return result;
  }
  public static String HextoString(String str){
    String result = new String();
    char[] charArray = str.toCharArray();
    for(int i = 0; i < charArray.length; i=i+2) {
      String st = ""+charArray[i]+""+charArray[i+1];
      char ch = (char)Integer.parseInt(st, 16);
      result = result + ch;
    }
    return result;
  }
}