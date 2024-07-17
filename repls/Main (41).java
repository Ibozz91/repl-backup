class Main {
  public static void main(String[] args) {
    Queue q = new Queue(5);
    q.add(6);
    q.add(67);
    q.remove(6);
    q.remove(500);
    System.out.println(q);
  }
}