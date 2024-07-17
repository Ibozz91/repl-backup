class Main {
  public static void main(String[] args) {
    for(int i = 3000; i >= 1; i--){
      System.out.println(RMN(i));
    }
  }
  public static String RMN(int h){
    String numeral = "";
    int thousands = h/1000;
    for(int i = 0; i < thousands; i++){
      numeral+="M";
    }
    String[] hund = place("C", "D", "M");
    String[] tens = place("X", "L", "C");
    String[] ones = place("I", "V", "X");
    return numeral+hund[(h%1000)/100]+tens[(h%100)/10]+ones[h%10];
  }
  public static String[] place(String a, String b, String c){
    return new String[]{"", a, a+a, a+a+a, a+b, b, b+a, b+a+a, b+a+a+a, a+c};
  }
}