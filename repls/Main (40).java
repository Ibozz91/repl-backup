class Main {
  public static void main(String[] args) {
    Stack s = new Stack(3);
    s.overflow();
    s.add(4);
    s.add(5);
    s.add(6);
    s.remove(3);
    s.remove(5);
    System.out.println(s);
  }
}