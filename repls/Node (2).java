class Node{
  private int value;
  private Node nextnode;
  public Node(int v, Node nn){
    value = v;
    nextnode = nn;
  }
  public Node(int v){
    value = v;
  }
  public int getValue(){
    return value;
  }
  public Node getNextNode(){
    return nextnode;
  }
  public void setValue(int toset){
    value = toset;
  }
  public void setNode(Node tosetnn){
    nextnode = tosetnn;
  }
  public Node copy(){
    //deep copy of current variable
    System.out.println(value+" J");
    if(nextnode==null){
      return new Node(value);
    }
    else{
      return new Node(value, nextnode);
    }
  }
  public String toString(){
    return Integer.toString(value);
  }
}