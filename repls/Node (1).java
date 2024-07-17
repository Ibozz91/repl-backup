class Node{
  private Node leftNode;
  private Node rightNode;
  private int value;
  public Node(int v){
    value = v;
  }
  public Node leftNode(){
    return leftNode;
  }
  public Node rightNode(){
    return rightNode;
  }
  public void setleftNode(Node tosetleft){
    leftNode = tosetleft;
  }
  public void setrightNode(Node tosetright){
    rightNode = tosetright;
  }
  public int getValue(){
    return value;
  }
  public String toString(){
    return Integer.toString(value);
  }
}