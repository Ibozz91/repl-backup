class Main {
  public static void main(String[] args) {
    HashMap hm = new HashMap();
    hm.add(4,5);
    hm.add(5,6);
    hm.add(1,47);
    for(int i = 0; i < 47; i++){
      System.out.println(hm.emoji());
    }
  }
}