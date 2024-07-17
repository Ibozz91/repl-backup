class Main {
  public static void main(String[] args) {
    LinkedList ll = new LinkedList(new Node(1));
    ll.addNode(1234);
    ll.addNode(265872);
    System.out.println(ll.firstNode()+" "+ll.lastNode()+" "+ll.findNode(1234)+" "+ll.findNode(265872)+" "+ll.findNode(47)+" "+ll.get(0)+" "+ll.get(1)
                      +" "+ll.get(2)+" "+ll.get(3));
    ll.removeNode();
    ll.addNode(1, 47691337);
    ll.addNode(0, 666);
    ll.addNode(2, 1231321);
    ll.addNode(2, 217643874);
    ll.addNode(3, 323232);
    for(int i = 0; i < 8; i++){
      System.out.println(ll.get(i));
    }
    ll.removeNode(0);
    ll.removeNode(2);
    ll.removeNode(4);
    for(int i = 0; i < 8; i++){
      System.out.println(ll.get(i));
    }
  }
}