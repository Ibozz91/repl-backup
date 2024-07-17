import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    BinaryTree thej = new BinaryTree(new Node(5));
    /*
    thej.addNode(236);
    thej.addNode(5);
    thej.addNode(3265);
    thej.addNode(47);
    thej.addNode(2);
    thej.addNode(1);
    thej.addNode(564);
    thej.addNode(13);
    System.out.println(thej.headNode().rightNode().leftNode().rightNode().leftNode());
    /*
    System.out.println(thej.headNode());
    System.out.println(thej.headNode().rightNode());
    System.out.println(thej.headNode().rightNode().leftNode());
    System.out.println(thej.headNode().rightNode().leftNode().rightNode())
    System.out.println(thej.depth(thej.headNode()));
    */
    thej.addNode(11);
    thej.addNode(3);
    thej.addNode(10);
    thej.addNode(12);
    thej.addNode(16);
    thej.addNode(15);
    thej.addNode(13);
    thej.addNode(19);
    thej.addNode(6);
    thej.addNode(17);
    thej.addNode(8);
    thej.addNode(2);
    thej.addNode(14);
    thej.addNode(1);
    thej.addNode(20);
    thej.addNode(7);
    thej.addNode(4);
    thej.addNode(9);
    thej.addNode(18);
    thej.addNode(999);
    System.out.println(thej);
    System.out.println(thej.path(3));
    System.out.println(thej.path(6));
    System.out.println(thej.isBalanced());
    ArrayList<Integer> free = thej.allnodes();
    for(int i = 0; i < free.size(); i++){
      System.out.println(free.get(i));
    }
    thej.balance();
    System.out.println(thej);
  }
}